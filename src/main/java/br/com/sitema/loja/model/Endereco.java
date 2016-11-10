package br.com.sitema.loja.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco")
@SequenceGenerator(name = "GENERATOR_ENDERECO", sequenceName = "SEQ_ENDERECO", allocationSize = 1)
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATOR_ENDERECO")
	@Column(name = "id_endereco")
	private Integer id;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "cep")
	private Integer cep;

	@Column(name = "telefone_residencial")
	private Integer telefoneResidencial;

	@Column(name = "telefone_celular")
	private Integer telefoneCelular;

	@Column(name = "telefone_comercial")
	private Integer telefoneComercial;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade", foreignKey = @ForeignKey(name = "fk_cidade") )
	private Cidade cidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(Integer telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public Integer getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(Integer telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public Integer getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(Integer telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
