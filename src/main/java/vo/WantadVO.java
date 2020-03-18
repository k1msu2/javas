package vo;

//wantad 구직게시판 테이블
public class WantadVO {

 // wantad_id PK
 private int post_id;

 // wantad_id 작성자회원 PK
 private String mem_userid;

 // wantad_title 구직글제목
 private String post_title;

 // wantad_content 구직글내용
 private String post_content;

 // wantad_writedate 작성날짜
 private String post_writedate;

 // wantad_hit 조회수
 private int post_hit;

 // wantad_location 구직희망지역
 private String post_location;

 // wantad_payment 구직희망시급
 private int post_payment;

 // wantad_review_count 리뷰 수
 private int post_review_count;

public int getPost_id() {
	return post_id;
}

public void setPost_id(int post_id) {
	this.post_id = post_id;
}

public String getMem_userid() {
	return mem_userid;
}

public void setMem_userid(String mem_userid) {
	this.mem_userid = mem_userid;
}

public String getPost_title() {
	return post_title;
}

public void setPost_title(String post_title) {
	this.post_title = post_title;
}

public String getPost_content() {
	return post_content;
}

public void setPost_content(String post_content) {
	this.post_content = post_content;
}

public String getPost_writedate() {
	return post_writedate;
}

public void setPost_writedate(String post_writedate) {
	this.post_writedate = post_writedate;
}

public int getPost_hit() {
	return post_hit;
}

public void setPost_hit(int post_hit) {
	this.post_hit = post_hit;
}

public String getPost_location() {
	return post_location;
}

public void setPost_location(String post_location) {
	this.post_location = post_location;
}

public int getPost_payment() {
	return post_payment;
}

public void setPost_payment(int post_payment) {
	this.post_payment = post_payment;
}

public int getPost_review_count() {
	return post_review_count;
}

public void setPost_review_count(int post_review_count) {
	this.post_review_count = post_review_count;
}

@Override
public String toString() {
	return "WantadVO [post_id=" + post_id + ", mem_userid=" + mem_userid + ", post_title=" + post_title
			+ ", post_content=" + post_content + ", post_writedate=" + post_writedate + ", post_hit=" + post_hit
			+ ", post_location=" + post_location + ", post_payment=" + post_payment + ", post_review_count="
			+ post_review_count + "]";
}

}
