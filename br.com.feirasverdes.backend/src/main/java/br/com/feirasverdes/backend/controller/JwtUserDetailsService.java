package br.com.feirasverdes.backend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import br.com.feirasverdes.backend.dao.UsuarioDao;
import br.com.feirasverdes.backend.entidade.Usuario;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioDao dao;
	private String logRounds;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = dao.verificarUsuario(username);
		if (user.getEmail().equals(username)) {
			return new User(username, "$2y$12$mnO3HbBnHofBc4lS5LBomOSH5zDpEgrzL1iQh7F.j3BZUHIJw9EWi",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
