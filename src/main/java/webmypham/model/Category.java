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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="namecategory")
	private String namecategory;
	@ManyToOne
	@JoinColumn(name="idtitlecategory")
	private CategoryTitle idtitlecategory;
	
	

	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Category(int id, String namecategory, CategoryTitle idtitlecategory) {
		super();
		this.id = id;
		this.namecategory = namecategory;
		this.idtitlecategory = idtitlecategory;

	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNameCategory(String nameCategory) {
		this.namecategory = nameCategory;
	}
	public String getNamecategory() {
		return namecategory;
	}
	public void setNamecategory(String namecategory) {
		this.namecategory = namecategory;
	}
	public CategoryTitle getIdtitlecategory() {
		return idtitlecategory;
	}
	public void setIdtitlecategory(CategoryTitle idtitlecategory) {
		this.idtitlecategory = idtitlecategory;
	}



	
	
	
}
