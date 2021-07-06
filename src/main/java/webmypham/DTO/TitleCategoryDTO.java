package webmypham.DTO;

import java.util.List;

public class TitleCategoryDTO {
	
	private int id;
	private String title;
	
	private List<CategoryDTO> category;

	public TitleCategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TitleCategoryDTO(int id, String title, List<CategoryDTO> category) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<CategoryDTO> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryDTO> category) {
		this.category = category;
	}
	
	
}
