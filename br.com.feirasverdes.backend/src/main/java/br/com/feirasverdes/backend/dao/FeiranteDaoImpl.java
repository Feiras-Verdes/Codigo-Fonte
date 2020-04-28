package br.com.feirasverdes.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.feirasverdes.backend.entidade.Estande;
import br.com.feirasverdes.backend.entidade.Feirante;

public class FeiranteDaoImpl extends BaseDaoImpl<Feirante, Long> implements FeiranteDao, Serializable{

	private static final long serialVersionUID = 3827015114929749677L;

	@Override
	public Feirante pesquisarPorId(Long id, Session sessao) throws HibernateException {
		return (Feirante)sessao.get(Feirante.class, id);
	}

	@Override
	public List<Feirante> listarTodos(Session sessao) throws HibernateException {
		Query<Feirante> consulta = sessao.createQuery("from Feirante", Feirante.class);
		List<Feirante> feirantes = consulta.list();
		return feirantes;
	}

	@Override
	public List<Feirante> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		Query<Feirante> consulta = sessao.createQuery("from Feirante where nome like :nome ", Feirante.class);
		consulta.setParameter("nome", "%" + nome + "%");
        List<Feirante> feirantes = consulta.list();			
        return feirantes;
	} 

}
