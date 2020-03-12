package vo;

public interface ReviewVO {
	int review_id = 0;
	int post_id = 0;
	String review_userid = "";
	String review_comment = "";
	String review_date = "";
	float review_rate = 0;
	public int getReview_id();
	public void setReview_id(int review_id);
	public int getPost_id();
	public void setPost_id(int post_id);
	public String getReview_userid();
	public void setReview_userid(String review_userid);
	public String getReview_comment();
	public void setReview_comment(String review_comment);
	public float getReview_rate();
	public void setReview_rate(float review_rate); 
	public String getReview_date();
	public void setReview_date(String review_date);
}
