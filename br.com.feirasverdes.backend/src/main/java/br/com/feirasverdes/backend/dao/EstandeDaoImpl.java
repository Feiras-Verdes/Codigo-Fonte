package br.com.feirasverdes.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.feirasverdes.backend.entidade.Estande;

public class EstandeDaoImpl extends BaseDaoImpl<Estande, Long> implements EstandeDao, Serializable {

	private static final long serialVersionUID = 7563299862856045128L;

	@Override
	public Estande pesquisarPorId(Long id, Session sessao) throws HibernateException {
		return (Estande)sessao.get(Estande.class, id);		
	}

	@Override
	public List<Estande> listarTodos(Session sessao) throws HibernateException {
		Query<Estande> consulta = sessao.createQuery("from Estande", Estande.class);
		List<Estande> estandes = consulta.list();
		return  estandes;
	}

	@Override
	public List<Estande> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		Query<Estande> consulta = sessao.createQuery("from Estande where nome like :nome ", Estande.class);
		consulta.setParameter("nome", "%" + nome + "%");
        List<Estande> estandes = consulta.list();	
		return estandes;
	}
}

	


