package br.com.feirasverdes.backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.feirasverdes.backend.entidade.Estande;

public interface AvaliacaoDao extends BaseDao <Avaliacao, Long>{

	List<Avaliacao> pesquisarPorNome(String nome,Session sessao)throws HibernateException;
	
}