package br.com.feirasverdes.backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.feirasverdes.backend.entidade.Organizador;
import br.com.feirasverdes.backend.entidade.Produto;

public interface OrganizadorDao extends BaseDao <Organizador, Long> {
	
	List<Organizador> pesquisarPorNome(String nome,Session sessao)throws HibernateException;

}
