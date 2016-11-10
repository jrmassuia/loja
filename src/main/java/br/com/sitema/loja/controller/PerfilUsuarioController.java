package br.com.sitema.loja.controller;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitema.loja.bo.PerfilUsuarioBO;
import br.com.sitema.loja.model.Usuario;

@Named
@ConversationScoped
public class PerfilUsuarioController extends Controller<Usuario> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PerfilUsuarioBO perfilUsuarioBO;

	private String senha;

	private String novaSenha;

	private String confirmarSenha;

	private Usuario usuario;

	public PerfilUsuarioController() {
		usuario = SistemaController.getUsuarioAtenticado();
	}

	public String salvar() {

		if (!validarCampoVazio() && !validarSenha()) {

			usuario.setSenha(novaSenha);
			usuario = perfilUsuarioBO.salvar(usuario);

			messages.addInfoMessage("Senha alterada com sucesso!");

		}

		return "";
	}

	private boolean validarSenha() {

		boolean validar = false;

		if (!senha.equals(usuario.getSenha())) {
			messages.addErrorMessage("A Senha não corresponde com a Senha Atual!");
			validar = true;

		} else if (!novaSenha.equals(confirmarSenha)) {
			messages.addErrorMessage("A Nova Senha não corresponde com o Confirmar Senha!");
			validar = true;
		}

		return validar;
	}

	private boolean validarCampoVazio() {

		boolean validar = false;

		if (senha.isEmpty()) {
			messages.addErrorMessage("O campo Senha não está preenchido. Favor preencher.");
			validar = true;
		}

		if (novaSenha.isEmpty()) {
			messages.addErrorMessage("O campo Nova Senha não está preenchido. Favor preencher.");
			validar = true;
		}

		if (confirmarSenha.isEmpty()) {
			messages.addErrorMessage("O campo Confirmar Senha não está preenchido. Favor preencher.");
			validar = true;
		}

		return validar;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
