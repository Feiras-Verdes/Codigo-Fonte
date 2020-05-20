package br.com.feirasverdes.backend.controller;

import java.util.ArrayList;
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

import br.com.feirasverdes.backend.dao.HibernateUtil;
import br.com.feirasverdes.backend.dao.UsuarioDao;
import br.com.feirasverdes.backend.dao.UsuarioDaoImpl;
import br.com.feirasverdes.backend.entidade.Usuario;

@Path("/usuario")
public class UsuarioController {

	@Inject
	private UsuarioDao dao;
	private Session session;

	public void iniciar() {
		dao = new UsuarioDaoImpl();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarCliente(Usuario usuario) {
		session = HibernateUtil.abrirSessao();
		dao.salvarOuAlterar(usuario, session);
		return Response.status(Status.CREATED).entity(usuario).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarCliente(@PathParam("id") long id, @RequestBody Usuario usuario) {
		session = HibernateUtil.abrirSessao();
		Usuario atualizarUsuario = dao.pesquisarPorId(id, session);
		atualizarUsuario = usuario;
		dao.salvarOuAlterar(usuario, session);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response excluir(@PathParam("id") long id) {
		session = HibernateUtil.abrirSessao();
		Usuario usuario = dao.pesquisarPorId(id, session);
        dao.excluir(usuario, session);
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
		List<Usuario> usuarios = dao.pesquisarPorNome(nome, session);
		return Response.ok(usuarios).build();
	}
	
	@GET
	@Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarPorId(@PathParam("id") long id) {
		session = HibernateUtil.abrirSessao();
		Usuario usuario = dao.pesquisarPorId(id, session);
		return Response.ok(usuario).build();
	}
	
	
}
