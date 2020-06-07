package br.com.feirasverdes.backend.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.feirasverdes.backend.dao.UsuarioDao;
import br.com.feirasverdes.backend.entidade.Usuario;

@RestController
@CrossOrigin
@Path("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDao dao;

	
	@RequestMapping(method = RequestMethod.POST,value = "/cadastrar")
	public ResponseEntity<Usuario>salvarCliente(@RequestBody Usuario usuario) {
		Usuario usuarioSalvo = new Usuario();
		try {
			usuarioSalvo= dao.save(usuario);
          
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(usuarioSalvo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(usuarioSalvo, HttpStatus.OK);
	}
	
	@PUT
	@Path("/")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarCliente(@RequestBody Usuario usuario) {
		dao.save(usuario);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response excluir(@PathParam("id") long id) {
        dao.deleteById(id);
        return Response.ok().build();
    }

	@GET       
//    @Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		return Response.ok(dao.findAll()).build();
	}
	
	@GET
	@Path("{nome}")
//    @Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarPorNome(@PathParam("nome") String nome) {
		List<Usuario> usuarios = dao.pesquisarPorNome(nome);
		return Response.ok(usuarios).build();
	}
	
	@GET
	@Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarPorId(@PathParam("id") long id) {
		Usuario usuario = dao.getOne(id);
		return Response.ok(usuario).build();
	}
	
	
}
