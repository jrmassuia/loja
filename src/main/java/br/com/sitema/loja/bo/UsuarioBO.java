package br.com.sitema.loja.bo;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.sitema.loja.dao.UsuarioDAO;
import br.com.sitema.loja.model.Usuario;

public class UsuarioBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;

	public Usuario consultarUsuario(String usuario, String senha) {
		return usuarioDAO.consultarUsuario(usuario, senha);
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioDAO.salvar(usuario);
	}

}
