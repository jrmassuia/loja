package br.com.sitema.loja.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitema.loja.bo.SistemaBO;
import br.com.sitema.loja.model.Usuario;

@Named
@SessionScoped
public class SistemaController extends Controller<Usuario> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private SistemaBO sistemaBO;

	private static Usuario usuarioAtenticado;

	private String usuario;

	private String senha;

	public String autenticar() {

		if (usuario.isEmpty() || senha.isEmpty()) {
			if (usuario.isEmpty()) {
				messages.addErrorMessage("O campo login não está preenchido. Favor preencher.");
			}

			if (senha.isEmpty()) {
				messages.addErrorMessage("O campo Senha não está preenchido. Favor preencher.");
			}
		} else {

			usuarioAtenticado = sistemaBO.consultarUsuario(usuario, senha);

			if (usuarioAtenticado != null && usuarioAtenticado.getId() != null) {
				return "/restrito/home.xhtml?faces-redirect=true";
			} else {
				messages.addErrorMessage("Os dados informados são inválidos. Digite novamente.");
			}

		}

		return "";

	}

	public String sair() {

		usuarioAtenticado = null;

		return "/login.xhml?faces-redirect=true";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static Usuario getUsuarioAtenticado() {
		return usuarioAtenticado;
	}

	public static void setUsuarioAtenticado(Usuario usuarioAtenticado) {
		SistemaController.usuarioAtenticado = usuarioAtenticado;
	}

}
