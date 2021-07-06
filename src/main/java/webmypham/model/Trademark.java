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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="trademarks")
public class Trademark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	@Column(name="nametrademark")
	private String nametrademark;
	@Column
	private String content;
	
	@OneToMany(mappedBy = "trademark")
	private List<Products> product;

	public Trademark() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trademark(int id, String nametrademark, String content, List<Products> product) {
		super();
		this.id = id;
		this.nametrademark = nametrademark;
		this.content = content;
		this.product = product;
	}

	public String getNametrademark() {
		return nametrademark;
	}
	public void setNametrademark(String nametrademark) {
		this.nametrademark = nametrademark;
	}
	public List<Products> getProduct() {
		return product;
	}
	public void setProduct(List<Products> product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
