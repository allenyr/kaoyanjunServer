package Model;

public class NewsBean {
	private int id;
	private String title;
	private String content;
	private String image;
	private int see;
	private String link;
	private String time;
	
	public NewsBean() {
		super();
	}
	
	public NewsBean(String title, String content, String image, int see,String link,String time) {
		super();
		this.title = title;
		this.content = content;
		this.image = image;
		this.see = see;
		this.link = link;
		this.time = time;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getSee() {
		return see;
	}
	public void setSee(int see) {
		this.see = see;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
