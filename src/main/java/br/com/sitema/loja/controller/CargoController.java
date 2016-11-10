package br.com.sitema.loja.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitema.loja.bo.CargoBO;
import br.com.sitema.loja.model.Cargo;

@Named
@ConversationScoped
public class CargoController extends Controller<Cargo> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CargoBO cargoBO;

	private List<Cargo> cargos;

	private Cargo cargo;

	public String salvar() {
		if (validarDescricaoCargo()) {
			cargo = cargoBO.salvar(cargo);
			if (cargo != null) {
				messages.addInfoMessage("Registro salvo com sucesso!");
			} else {
				messages.addInfoMessage("Erro ao salvar!");
			}

		}
		return "";
	}

	private boolean validarDescricaoCargo() {

		if ("".equals(cargo.getDescricao())) {
			messages.addErrorMessage("O campo descrição é obrigatório. Favor Preencher!");
			return false;
		}

		return true;
	}

	public String editar() {
		return "";
	}

	public String excluir() {
		return "";
	}

	public String novo() {
		cargo = new Cargo();
		return "/restrito/cargoForm";
	}

	public List<Cargo> getCargos() {
		return cargoBO.consultarTodos();
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
