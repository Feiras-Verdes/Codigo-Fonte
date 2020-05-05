package br.com.feirasverdes.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.feirasverdes.backend.entidade.Estande;

public class EnderecoDaoImpl extends BaseDaoImpl<Endereco, Long> implements EnderecoDao, Serializable {

	private static final long serialVersionUID = 7563299862856045128L;

	@Override
	public Endereco pesquisarPorId(Long id, Session sessao) throws HibernateException {
		return (Endereco)sessao.get(Endereco.class, id);		
	}

	@Override
	public List<Endereco> listarTodos(Session sessao) throws HibernateException {
		Query<Endereco> consulta = sessao.createQuery("from Endereco", Endereco.class);
		List<Endereco> enderecos = consulta.list();
		return  enderecos;
	}

	@Override
	public List<Endereco> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
		Query<Endereco> consulta = sessao.createQuery("from Endereco where nome like :nome ", Endereco.class);
		consulta.setParameter("nome", "%" + nome + "%");
        List<Endereco> enderecos = consulta.list();	
		return enderecos;
	}
}

	


