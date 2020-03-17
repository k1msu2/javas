package vo;

public class WantReviewVO implements ReviewVO{
	private int review_id;
	private int post_id;
	private String review_userid;
	private String review_comment;
	private String review_date;
	private float review_rate;
	
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getReview_userid() {
		return review_userid;
	}
	public void setReview_userid(String review_userid) {
		this.review_userid = review_userid;
	}
	public String getReview_comment() {
		return review_comment;
	}
	public void setReview_comment(String review_comment) {
		this.review_comment = review_comment;
	}
	public float getReview_rate() {
		return review_rate;
	}
	public void setReview_rate(float review_rate) {
		this.review_rate = review_rate;
	}
	public String getReview_date() {
		return review_date;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	@Override
	public String toString() {
		return "WantReviewVO [review_id=" + review_id + ", post_id=" + post_id + ", review_userid=" + review_userid
				+ ", review_comment=" + review_comment + ", review_date=" + review_date + ", review_rate=" + review_rate
				+ "]";
	}
}
