package br.com.feirasverdes.backend.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.feirasverdes.backend.dao.FeiranteDao;
import br.com.feirasverdes.backend.dao.FeiranteDaoImpl;
import br.com.feirasverdes.backend.dao.HibernateUtil;
import br.com.feirasverdes.backend.entidade.Feirante;

@Path("/feirante")
public class FeiranteController {


	@Inject
	private FeiranteDao dao;
	private Session session;

	public void iniciar() {
		dao = new FeiranteDaoImpl();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarFeirante(Feirante feirante) {
		session = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(feirante, session);
		return Response.status(Status.CREATED).entity(feirante).build();
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarFeirante(@PathParam("id") long id, @RequestBody Feirante feirante) {
		session = HibernateUtil.abrirSessao();
		Feirante atualizarFeirante = dao.pesquisarPorId(id, session);
		atualizarFeirante = feirante;
		dao.salvarOuAlterar(feirante, session);
		return Response.ok().build();
	}
	@DELETE
	@Path("/{id}")
	public Response excluir(@PathParam("id") long id) {
		session = HibernateUtil.abrirSessao();
		Feirante feirante = dao.pesquisarPorId(id, session);
        dao.excluir(feirante, session);
        return Response.ok().build();
    }
	@GET       
    @Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		session = HibernateUtil.abrirSessao();
		return Response.ok(dao.listarTodos(session)).build();
	}
	
	@GET
	@Path("{nome}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarPorNome(@PathParam("nome") String nome) {
		session = HibernateUtil.abrirSessao();
		List<Feirante> usuarios = dao.pesquisarPorNome(nome, session);
		return Response.ok(usuarios).build();
	}
	@GET
	@Path("/feirante/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarPorId(@PathParam("id") long id) {
		session = HibernateUtil.abrirSessao();
		Feirante feirante = dao.pesquisarPorId(id, session);
		return Response.ok(feirante).build();
	}
	
	
}
