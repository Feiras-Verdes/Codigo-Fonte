package br.com.feirasverdes.backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.feirasverdes.backend.entidade.Produto;

public interface ProdutoDao extends BaseDao <Produto, Long> {
	
	List<Produto> pesquisarPorNome(String nome,Session sessao)throws HibernateException;

}
