package webmypham.convert;

import javax.persistence.Column;

public class TitleCategoryClassDTO {
	private int id;

	private String title;

	public TitleCategoryClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TitleCategoryClassDTO(int id, String title) {
		super();
		this.id = id;
		this.title = title;
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
	
	
}
