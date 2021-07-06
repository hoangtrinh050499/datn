package webmypham.DTO;

public class CompositionDTO {

	private int id;
	private String nameComposition;
	
	
	
	public CompositionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompositionDTO(int id, String nameComposition) {
		super();
		this.id = id;
		this.nameComposition = nameComposition;
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
	
	
}
