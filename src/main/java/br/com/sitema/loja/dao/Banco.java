package br.com.sitema.loja.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public abstract class Banco<T> {

	@Inject
	private EntityManager manager;

	public T salvar(T objeto) {

		try {
			objeto = (T) getSession().merge(objeto);
			getSession().flush();
			return objeto;
		} catch (Exception e) {
			e.printStackTrace();
			if (!getSession().getTransaction().isActive()) {
				getSession().getTransaction().begin();
			}
			getSession().getTransaction();

			return null;
		}

	}

	public T deletar(T objeto) {
		try {
			Object object = getSession().merge(objeto);
			getSession().delete(object);
			getSession().flush();
			return objeto;
		} catch (Exception e) {
			if (!getSession().getTransaction().isActive()) {
				getSession().getTransaction().begin();
			}
			getSession().getTransaction().rollback();
			e.printStackTrace();
			getSession().clear();
			return null;
		}
	}

	public List<T> salvarTodos(List<T> objetos) {
		List<T> list = new ArrayList<T>();
		try {
			for (T objeto : objetos) {
				if (objeto != null) {
					objeto = salvar(objeto);
					list.add(objeto);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	protected Criteria createCriteria() {
		Criteria criteria = getSession()
				.createCriteria((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).setCacheable(false);
		return criteria;
	}

	public T consultarPorId(Integer id) {
		return (T) createCriteria().add(Restrictions.idEq(id)).uniqueResult();
	}

	public T consultarPorObjetoId(Object object) {
		return (T) createCriteria().add(Restrictions.idEq(object)).uniqueResult();
	}

	public List<T> consultarTodos() {
		Criteria criteria;
		try {
			criteria = createCriteria();
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Session getSession() {
		return (Session) manager.getDelegate();
	};

}
