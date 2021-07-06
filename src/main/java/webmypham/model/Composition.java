package webmypham.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="composition")
public class Composition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column(name="namecomposition")
	private String nameComposition;
	
	
	@OneToMany(mappedBy = "compositions" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product_Composition> products;
	
	
	public Composition(int id, String nameComposition, List<Product_Composition> products) {
		super();
		this.id = id;
		this.nameComposition = nameComposition;
		this.products = products;
	}
	public Composition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameComposition() {
		return nameComposition;
	}
	public void setNameComposition(String nameComposition) {
		this.nameComposition = nameComposition;
	}
	public List<Product_Composition> getProducts() {
		return products;
	}
	public void setProducts(List<Product_Composition> products) {
		this.products = products;
	}
	
	
	
	
	
}
