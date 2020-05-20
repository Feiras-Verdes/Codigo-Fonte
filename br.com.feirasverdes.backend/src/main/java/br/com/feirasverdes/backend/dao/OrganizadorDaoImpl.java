package br.com.feirasverdes.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.feirasverdes.backend.entidade.Organizador;
import br.com.feirasverdes.backend.entidade.Produto;


public class OrganizadorDaoImpl extends BaseDaoImpl<Organizador, Long> implements OrganizadorDao, Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6795131044793208056L;

	@Override
	public Organizador pesquisarPorId(Long id, Session sessao) throws HibernateException {
		return (Organizador)sessao.get(Organizador.class, id);	
	}

	@Override
	public List<Organizador> listarTodos(Session sessao) throws HibernateException {
		Query<Organizador> consulta = sessao.createQuery("from Organizador", Organizador.class);
		List<Organizador> organizadores = consulta.list();
		return  organizadores;
	}
	
	@Override
	public List<Organizador> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		Query<Organizador> consulta = sessao.createQuery("from Organizador where nome like :nome ", Organizador.class);
		consulta.setParameter("nome", "%" + nome + "%");
        List<Organizador> organizadores = consulta.list();	
		return organizadores;
	}

}
