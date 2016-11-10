package br.com.sitema.loja.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "tb_funcionario")
@SequenceGenerator(name = "GENERATOR_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATOR_FUNCIONARIO")
	@Column(name = "id_funcionario")
	private Integer id;

	@Column(name = "salario")
	private BigDecimal salario;

	@Column(name = "dependente")
	private Boolean dependente;

	@Column(name = "data_admissao")
	private Date dataAdmissao;

	@Column(name = "situcao")
	private Boolean situcao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo", foreignKey = @ForeignKey(name = "fk_cargo") )
	private Cargo cargo;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", foreignKey = @ForeignKey(name = "fk_usuario") )
	private Usuario usuario;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", foreignKey = @ForeignKey(name = "fk_pessoa") )
	private Pessoa pessoa;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_setor", referencedColumnName = "id_setor", foreignKey = @ForeignKey(name = "fk_setor") )
	private Setor setor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Boolean getDependente() {
		return dependente;
	}

	public void setDependente(Boolean dependente) {
		this.dependente = dependente;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Boolean getSitucao() {
		return situcao;
	}

	public void setSitucao(Boolean situcao) {
		this.situcao = situcao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
