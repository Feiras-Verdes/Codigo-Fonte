package br.com.feirasverdes.backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.feirasverdes.backend.entidade.Estande;

public interface NoticiaDao extends BaseDao <Noticia, Long>{

	List<Noticia> pesquisarPorNome(String nome,Session sessao)throws HibernateException;
	
}