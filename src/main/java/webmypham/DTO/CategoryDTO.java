package webmypham.DTO;

import webmypham.convert.TitleCategoryClassDTO;
import webmypham.model.CategoryTitle;

public class CategoryDTO {

	private int id;
	private String namecategory;
	private String titlecategory;
	
	public CategoryDTO(int id, String namecategory, String idtitlecategory) {
		super();
		this.id = id;
		this.namecategory = namecategory;
		this.titlecategory = idtitlecategory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamecategory() {
		return namecategory;
	}
	public void setNamecategory(String namecategory) {
		this.namecategory = namecategory;
	}
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitlecategory() {
		return titlecategory;
	}
	public void setTitlecategory(String titlecategory) {
		this.titlecategory = titlecategory;
	}
	
	
	
	 
	
}
