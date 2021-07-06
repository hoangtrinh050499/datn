package webmypham.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="discount")
public class Discount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private int level;
	

	@OneToMany(mappedBy = "discount" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product_Discount> products;
	
	
	
	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Discount(int id, int level, List<Product_Discount> products) {
		super();
		this.id = id;
		this.level = level;
		this.products = products;
	}





	public List<Product_Discount> getProducts() {
		return products;
	}





	public void setProducts(List<Product_Discount> products) {
		this.products = products;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}
	
	

}
