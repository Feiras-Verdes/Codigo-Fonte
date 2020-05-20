package br.com.feirasverdes.backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.feirasverdes.backend.entidade.Feirante;

public interface FeiranteDao extends BaseDao<Feirante, Long>{

	List<Feirante>pesquisarPorNome(String nome, Session sessao)throws HibernateException;
	
}
