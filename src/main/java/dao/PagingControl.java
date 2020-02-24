package dao;

public class PagingControl {
	public int lineCnt = 0;
	public int pageCnt = 0;
	public int postCnt = 0;
	public Integer pgNum = 0;
	PagingControl(){}
	PagingControl(int lineCnt,int pageCnt,int postCnt,int pgNum){
		this.lineCnt = lineCnt;
		this.pageCnt = pageCnt;
		this.postCnt = postCnt;
		this.pgNum = pgNum;
	}
	
	public int getLineCnt() {
		return lineCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public int getPostCnt() {
		return postCnt;
	}
	public int getPgNum() {
		return pgNum;
	}
	public void setLineCnt(int lineCnt) {
		this.lineCnt = lineCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public void setPostCnt(int postCnt) {
		this.postCnt = postCnt;
	}
	public void setPgNum(int pgNum) {
		this.pgNum = pgNum;
	}
	public int getPageCount() {
		return ((postCnt-1)/lineCnt)+1;
	}
	public int getPageStart() {
		return ((pgNum-1)/pageCnt)*pageCnt+1;
	}
	public int getPageEnd() {
		return getPageStart()+pageCnt-1 < getPageCount() ? getPageStart()+pageCnt-1 : getPageCount();
	}
	public boolean isPreData() {
		return getPageStart()!=1;
	}
	public boolean isNextData() {
		return getPageEnd()!=getPageCount();
	}
	public int getWritingStart() {
		return getWritingEnd()-lineCnt+1;
	}
	public int getWritingEnd() {
		return pgNum*lineCnt;
	}
}
