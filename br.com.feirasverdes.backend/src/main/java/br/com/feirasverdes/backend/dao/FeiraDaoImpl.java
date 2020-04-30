package br.com.feirasverdes.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.feirasverdes.backend.entidade.Estande;

public class FeiraDaoImpl extends BaseDaoImpl<Feira, Long> implements FeiraDao, Serializable {

	private static final long serialVersionUID = 7563299862856045128L;

	@Override
	public Feira pesquisarPorId(Long id, Session sessao) throws HibernateException {
		return (Feira)sessao.get(Feira.class, id);		
	}

	@Override
	public List<Feira> listarTodos(Session sessao) throws HibernateException {
		Query<Feira> consulta = sessao.createQuery("from Feira", Feira.class);
		List<Feira> feiras = consulta.list();
		return  feiras;
	}

	@Override
	public List<Feira> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		Query<Feira> consulta = sessao.createQuery("from Feira where nome like :nome ", Feira.class);
		consulta.setParameter("nome", "%" + nome + "%");
        List<Feira> feiras = consulta.list();	
		return feiras;
	}
}

	


