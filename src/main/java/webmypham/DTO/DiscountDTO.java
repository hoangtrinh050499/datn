package webmypham.DTO;

import javax.persistence.Column;

public class DiscountDTO {

	private int id;
	private int level;
	public DiscountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiscountDTO(int id, int level) {
		super();
		this.id = id;
		this.level = level;
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
