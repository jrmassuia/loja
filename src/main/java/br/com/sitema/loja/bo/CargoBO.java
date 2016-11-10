package br.com.sitema.loja.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitema.loja.dao.CargoDAO;
import br.com.sitema.loja.model.Cargo;

@Named
@ConversationScoped
public class CargoBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CargoDAO cargoDAO;

	public List<Cargo> consultarTodos() {
		return cargoDAO.consultarTodos();
	}

	public Cargo salvar(Cargo cargo) {
		return cargoDAO.salvar(cargo);
	}

}
