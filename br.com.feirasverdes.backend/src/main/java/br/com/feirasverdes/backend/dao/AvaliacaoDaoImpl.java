package br.com.feirasverdes.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.feirasverdes.backend.entidade.Estande;

public class AvaliacaoDaoImpl extends BaseDaoImpl<Avaliacao, Long> implements AvaliacaoDao, Serializable {

	private static final long serialVersionUID = 7563299862856045128L;

	@Override
	public Avaliacao pesquisarPorId(Long id, Session sessao) throws HibernateException {
		return (Avaliacao)sessao.get(Avaliacao.class, id);		
	}

	@Override
	public List<Avaliacao> listarTodos(Session sessao) throws HibernateException {
		Query<Avaliacao> consulta = sessao.createQuery("from Avaliacao", Avaliacao.class);
		List<Avaliacao> avaliacoes = consulta.list();
		return  avaliacoes;
	}

	@Override
	public List<Avaliacao> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		Query<Avaliacao> consulta = sessao.createQuery("from Avaliacao where nome like :nome ", Avaliacao.class);
		consulta.setParameter("nome", "%" + nome + "%");
        List<Avaliacao> avaliacoes = consulta.list();	
		return avaliacoes;
	}
}