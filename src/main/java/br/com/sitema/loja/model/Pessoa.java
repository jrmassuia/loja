package br.com.sitema.loja.model;

import java.io.Serializable;
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
@Table(name = "tb_pessoa")
@SequenceGenerator(name = "GENERATOR_PESSOA", sequenceName = "SEQ_PESSOA", allocationSize = 1)
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATOR_PESSOA")
	@Column(name = "id_pessoa")
	private Integer id;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column(name = "estado_civil")
	private String estadoCivil;

	@Column(name = "orgao_emissor_rg")
	private String orgaoEmissorRG;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cnpj")
	private Integer cnpj;

	@Column(name = "razao_social")
	private String razaoSocial;

	@Column(name = "tipo_pessoa")
	private String tipoPessoa;

	@Column(name = "cpf")
	private Integer cpf;

	@Column(name = "rg")
	private Integer rg;

	@Column(name = "uf_emissao_rg")
	private String ufEmissaoRG;

	@Column(name = "inscricao_estadual")
	private Integer inscricaoEstadual;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco", foreignKey = @ForeignKey(name = "fk_endereco") )
	private Endereco endereco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getOrgaoEmissorRG() {
		return orgaoEmissorRG;
	}

	public void setOrgaoEmissorRG(String orgaoEmissorRG) {
		this.orgaoEmissorRG = orgaoEmissorRG;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public String getUfEmissaoRG() {
		return ufEmissaoRG;
	}

	public void setUfEmissaoRG(String ufEmissaoRG) {
		this.ufEmissaoRG = ufEmissaoRG;
	}

	public Integer getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(Integer inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
