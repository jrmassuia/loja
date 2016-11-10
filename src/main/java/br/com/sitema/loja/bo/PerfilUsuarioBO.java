package br.com.sitema.loja.bo;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.sitema.loja.model.Usuario;

public class PerfilUsuarioBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioBO usuarioBO;	
	
	public Usuario salvar(Usuario usuario) {		
		return usuarioBO.salvar(usuario);
	}

}
