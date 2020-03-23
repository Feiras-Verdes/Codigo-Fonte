package br.com.feirasverdes.backend.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface BaseDao<T, ID> {

	void salvarOuAlterar(T entidade, Session sessao) throws HibernateException;

	void excluir(T entidade, Session sessao) throws HibernateException;

	T pesquisarPorId(Long id, Session sessao) throws HibernateException;

	List<T> listarTodos(Session sessao) throws HibernateException;
}
