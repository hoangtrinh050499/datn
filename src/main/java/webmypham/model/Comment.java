package webmypham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String title;
	@Column
	private String content;
	@Column
	private int point;
	@Column(name="idProduct")
	private int idPropduct;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int id, String title, String content, int point, int idPropduct) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.point = point;
		this.idPropduct = idPropduct;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getIdPropduct() {
		return idPropduct;
	}
	public void setIdPropduct(int idPropduct) {
		this.idPropduct = idPropduct;
	}
	
	
	
}
