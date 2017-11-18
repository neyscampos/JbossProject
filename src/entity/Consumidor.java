package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "consumidor")
@NamedQuery(name = "mostra", query = "select c from Consumidor as c")
public class Consumidor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 100)
	private String nome;
	@Column(length = 100, unique = true)
	private String email;
	@Column(length = 25, unique = true)
	private String telefone;
	@Transient
	private Double total = 0.;

	@OneToMany(mappedBy = "consumidor", fetch = FetchType.EAGER)
	private Collection<Consumo> consumos;

	public Collection<Consumo> getConsumos() {
		return consumos;
	}

	public void adicionar(Consumo... consumo) {
		for (Consumo c : consumo) {
			consumos.add(c);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Consumidor() {
		this.consumos = new ArrayList<Consumo>();
	}

	public Consumidor(Integer id, String nome, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.consumos = new ArrayList<Consumo>();
	}

	public void calcularSubtotal() {
		this.total = 0.;
		for (Consumo c : consumos) {
			c.setSubtotal(c.getPreco() * c.getQuantidade());
			this.total += c.getSubtotal();
		}
	}

	@Override
	public String toString() {
		return "Consumidor [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", total=" + total + "]";
	}

}
