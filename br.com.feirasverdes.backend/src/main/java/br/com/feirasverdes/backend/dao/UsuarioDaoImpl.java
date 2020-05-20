package br.com.feirasverdes.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.feirasverdes.backend.entidade.Estande;
import br.com.feirasverdes.backend.entidade.Usuario;

public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7403200624789058581L;

	@Override
	public void salvarOuAlterar(Usuario entidade, Session sessao) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Usuario entidade, Session sessao) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
		return (Usuario)sessao.get(Usuario.class, id);
	}

	@Override
	public List<Usuario> listarTodos(Session sessao) throws HibernateException {
		Query<Usuario> consulta = sessao.createQuery("from Usuario", Usuario.class);
		List<Usuario> usuarios = consulta.list();
		return  usuarios;
	}

	@Override
	public List<Usuario> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		Query<Usuario> consulta = sessao.createQuery("from Usuario where nome like :nome ", Usuario.class);
		consulta.setParameter("nome", "%" + nome + "%");
        List<Usuario> usuarios = consulta.list();	
		return usuarios;
	}

}
