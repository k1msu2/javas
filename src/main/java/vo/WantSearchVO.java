package vo;

import org.springframework.stereotype.Repository;

@Repository
public class WantSearchVO {
	private String searchtype;
	private String key;
	private String mem_userid;
	
	public String getSearchtype() {
		return searchtype;
	}
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getMem_userid() {
		return mem_userid;
	}
	public void setMem_userid(String mem_userid) {
		this.mem_userid = mem_userid;
	}


	
	
}
