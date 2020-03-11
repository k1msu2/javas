package vo;

public class JobadVO {
	private int post_id;
	private String mem_userid;
	private String mem_username;
	private String post_title;
	private String post_content;
	private String post_writedate;
	private int post_hit;
	private String post_location;
	private int post_payment;
	private String post_phone;
	private int post_review_count;
	public int getPost_id() {
		return post_id;
	}
	public String getMem_userid() {
		return mem_userid;
	}
	public String getMem_username() {
		return mem_username;
	}
	public String getPost_title() {
		return post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public String getPost_writedate() {
		return post_writedate;
	}
	public int getPost_hit() {
		return post_hit;
	}
	public String getPost_location() {
		return post_location;
	}
	public int getPost_payment() {
		return post_payment;
	}
	public String getPost_phone() {
		return post_phone;
	}
	public int getPost_review_count() {
		return post_review_count;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public void setMem_userid(String mem_userid) {
		this.mem_userid = mem_userid;
	}
	public void setMem_username(String mem_username) {
		this.mem_username = mem_username;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public void setPost_writedate(String post_writedate) {
		this.post_writedate = post_writedate;
	}
	public void setPost_hit(int post_hit) {
		this.post_hit = post_hit;
	}
	public void setPost_location(String post_location) {
		this.post_location = post_location;
	}
	public void setPost_payment(int post_payment) {
		this.post_payment = post_payment;
	}
	public void setPost_phone(String post_phone) {
		this.post_phone = post_phone;
	}
	public void setPost_review_count(int post_review_count) {
		this.post_review_count = post_review_count;
	}
	@Override
	public String toString() {
		return "JobadVO [post_id=" + post_id + ", mem_userid=" + mem_userid + ", post_title=" + post_title
				+ ", post_content=" + post_content + ", post_writedate=" + post_writedate + ", post_hit=" + post_hit
				+ ", post_location=" + post_location + ", post_payment=" + post_payment + ", post_phone=" + post_phone
				+ ", post_review_count=" + post_review_count + "]";
	}
	
}
