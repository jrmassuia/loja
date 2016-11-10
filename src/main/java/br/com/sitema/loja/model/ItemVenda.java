package br.com.sitema.loja.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "tb_item_venda")
@SequenceGenerator(name = "GENERATOR_ITEM_VENDA", sequenceName = "SEQ_ITEM_VENDA", allocationSize = 1)
public class ItemVenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATOR_ITEM_VENDA")
	@Column(name = "id_item_venda")
	private Integer id;

	@Column(name = "quantidade ")
	private BigDecimal quantidade;

	@Column(name = "valor_unitario ")
	private BigDecimal valorUnitario;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item", referencedColumnName = "id_item", foreignKey = @ForeignKey(name = "fk_item") )
	private Item item;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_venda", referencedColumnName = "id_venda", foreignKey = @ForeignKey(name = "fk_venda") )
	private Venda venda;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
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
		ItemVenda other = (ItemVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
