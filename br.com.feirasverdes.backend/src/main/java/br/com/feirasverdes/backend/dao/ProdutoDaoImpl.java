package br.com.feirasverdes.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.feirasverdes.backend.entidade.Produto;


public class ProdutoDaoImpl extends BaseDaoImpl<Produto, Long> implements ProdutoDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Produto pesquisarPorId(Long id, Session sessao) throws HibernateException {
		return (Produto)sessao.get(Produto.class, id);	
	}

	@Override
	public List<Produto> listarTodos(Session sessao) throws HibernateException {
		Query<Produto> consulta = sessao.createQuery("from Produto", Produto.class);
		List<Produto> produtos = consulta.list();
		return  produtos;
	}
	
	@Override
	public List<Produto> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		Query<Produto> consulta = sessao.createQuery("from Produto where nome like :nome ", Produto.class);
		consulta.setParameter("nome", "%" + nome + "%");
        List<Produto> produtos = consulta.list();	
		return produtos;
	}

}
