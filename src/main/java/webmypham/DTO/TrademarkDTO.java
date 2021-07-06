package webmypham.DTO;

public class TrademarkDTO {

	private int id;
	private String nametrademark;
	private String content;
	
	public TrademarkDTO(int id, String nametrademark, String content) {
		super();
		this.id = id;
		this.nametrademark = nametrademark;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNametrademark() {
		return nametrademark;
	}
	public void setNametrademark(String nametrademark) {
		this.nametrademark = nametrademark;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public TrademarkDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
