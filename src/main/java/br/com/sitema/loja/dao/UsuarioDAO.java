package br.com.sitema.loja.dao;

import java.io.Serializable;

import org.hibernate.Query;

import br.com.sitema.loja.model.Usuario;

public class UsuarioDAO extends Banco<Usuario> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Usuario consultarUsuario(String usuario, String senha) {

		try {

			StringBuilder hql = new StringBuilder();

			hql.append(" SELECT u FROM Usuario u ");
			hql.append(" LEFT JOIN FETCH u.perfil p ");
			hql.append(" WHERE u.usuario = :usuario AND u.senha = :senha ");

			Query query = getSession().createQuery(hql.toString());
			query.setParameter("usuario", usuario);
			query.setParameter("senha", senha);

			return (Usuario) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
