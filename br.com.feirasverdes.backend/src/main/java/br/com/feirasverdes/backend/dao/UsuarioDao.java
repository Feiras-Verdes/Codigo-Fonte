package br.com.feirasverdes.backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.feirasverdes.backend.entidade.Usuario;

public interface UsuarioDao extends BaseDao<Usuario,Long>{

	List<Usuario>pesquisarPorNome(String nome,Session sessao)throws HibernateException;
	
}
