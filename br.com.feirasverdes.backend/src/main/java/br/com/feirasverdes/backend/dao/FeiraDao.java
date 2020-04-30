package br.com.feirasverdes.backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.feirasverdes.backend.entidade.Estande;

public interface FeiraDao extends BaseDao <Feira, Long>{

	List<Feira> pesquisarPorNome(String nome,Session sessao)throws HibernateException;
	
}
