package webmypham.DTO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import webmypham.model.Account;
import webmypham.model.Products;

public class Like_ProductDTO {
	
	private int id;
	private ProductDTO products;
	private AccountDTO account;
	public Like_ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Like_ProductDTO(int id, ProductDTO products, AccountDTO acount) {
		super();
		this.id = id;
		this.products = products;
		this.account = acount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProductDTO getProducts() {
		return products;
	}
	public void setProducts(ProductDTO products) {
		this.products = products;
	}
	public AccountDTO getAcount() {
		return account;
	}
	public void setAcount(AccountDTO acount) {
		this.account = acount;
	}

	
}
