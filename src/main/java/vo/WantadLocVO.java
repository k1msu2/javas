package vo;

//wantad 구직게시판 테이블
public class WantadLocVO {

 // wantad_id PK
 private int post_id;

  // wantad_location 구직희망지역
 private String post_location;

public int getPost_id() {
	return post_id;
}

public void setPost_id(int post_id) {
	this.post_id = post_id;
}

public String getPost_location() {
	return post_location;
}

public void setPost_location(String post_location) {
	this.post_location = post_location;
}


}
