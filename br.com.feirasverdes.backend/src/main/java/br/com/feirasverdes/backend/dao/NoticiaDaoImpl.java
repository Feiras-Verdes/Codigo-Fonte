package br.com.feirasverdes.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.feirasverdes.backend.entidade.Estande;

public class NoticiaDaoImpl extends BaseDaoImpl<Noticia, Long> implements NoticiaDao, Serializable {

	private static final long serialVersionUID = 7563299862856045128L;

	@Override
	public Noticia pesquisarPorId(Long id, Session sessao) throws HibernateException {
		return (Noticia)sessao.get(Noticia.class, id);		
	}

	@Override
	public List<Noticia> listarTodos(Session sessao) throws HibernateException {
		Query<Noticia> consulta = sessao.createQuery("from Noticia", Noticia.class);
		List<Noticia> noticias = consulta.list();
		return  noticias;
	}

	@Override
	public List<Noticia> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		Query<Noticia> consulta = sessao.createQuery("from Noticia where nome like :nome ", Noticia.class);
		consulta.setParameter("nome", "%" + nome + "%");
        List<Noticia> noticias = consulta.list();	
		return noticias;
	}
}