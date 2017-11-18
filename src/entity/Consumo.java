package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "consumo")
public class Consumo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsumo;
	@Column(length = 50)
	private String nomeProduto;
	@Column
	private Double preco;
	@Column
	private Integer quantidade;
	@Transient
	private Double subtotal = 0.;
	@ManyToOne
	@JoinColumn(name = "fkidConsumidor")
	private Consumidor consumidor;

	public Consumo() {
		super();
	}

	public Consumo(Integer idConsumo, String nomeProduto, Double preco, Integer quantidade) {
		super();
		this.idConsumo = idConsumo;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Consumo [idConsumo=" + idConsumo + ", nomeProduto=" + nomeProduto + ", preco=" + preco + ", quantidade="
				+ quantidade + ", subtotal=" + subtotal + "]";
	}

	public Integer getIdConsumo() {
		return idConsumo;
	}

	public void setIdConsumo(Integer idConsumo) {
		this.idConsumo = idConsumo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void main(String[] args) {
		Consumidor c = new Consumidor(10, "firmino", "firmino@gmail.com", "3333");
		Consumo c1 = new Consumo(101, "refrigerante", 7., 8);
		Consumo c2 = new Consumo(102, "redbull", 14., 3);
		Consumo c3 = new Consumo(103, "pizza maracana", 55., 5);

		c.adicionar(c1, c2, c3);
		c.calcularSubtotal();

		System.out.println(c);
		System.out.println(c.getConsumos());

	}

}
