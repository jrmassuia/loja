package br.com.sitema.loja.controller;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public abstract class Controller<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	protected Messages messages;

	@Inject
	protected Conversation conversation;

	public void iniciarConversacao() {

		if (conversation == null)
			return;
		if (!FacesContext.getCurrentInstance().isPostback() && conversation.isTransient()) {
			conversation.setTimeout(1800000L); // 30 minutos
			conversation.begin();
		}

	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

}
