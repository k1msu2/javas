package vo;

import org.springframework.stereotype.Repository;

@Repository
public class PageVO {
	
	private int page;	
	private int totalListNum;	
	private int showListNum;	
	private int showPageNum;
	private int totalPageNum;
	private String rightChar;
	private String leftChar;
	private int pageBeginNum;
	private int pageEndNum;
	private int listBeginNum;
	private int listEndNum;

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalListNum() {
		return totalListNum;
	}
	public void setTotalListNum(int totalListNum) {
		this.totalListNum = totalListNum;
	}
	public int getShowListNum() {
		return showListNum;
	}
	public void setShowListNum(int showListNum) {
		this.showListNum = showListNum;
	}
	public int getShowPageNum() {
		return showPageNum;
	}
	public void setShowPageNum(int showPageNum) {
		this.showPageNum = showPageNum;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public String getRightChar() {
		return rightChar;
	}
	public void setRightChar(String rightChar) {
		this.rightChar = rightChar;
	}
	public String getLeftChar() {
		return leftChar;
	}
	public void setLeftChar(String leftChar) {
		this.leftChar = leftChar;
	}
	public int getPageBeginNum() {
		return pageBeginNum;
	}
	public void setPageBeginNum(int pageBeginNum) {
		this.pageBeginNum = pageBeginNum;
	}
	public int getPageEndNum() {
		return pageEndNum;
	}
	public void setPageEndNum(int pageEndNum) {
		this.pageEndNum = pageEndNum;
	}
	public int getListBeginNum() {
		return listBeginNum;
	}
	public void setListBeginNum(int listBeginNum) {
		this.listBeginNum = listBeginNum;
	}
	public int getListEndNum() {
		return listEndNum;
	}
	public void setListEndNum(int listEndNum) {
		this.listEndNum = listEndNum;
	}
	@Override
	public String toString() {
		return "PageVO [page=" + page + ", totalListNum=" + totalListNum + ", showListNum=" + showListNum
				+ ", showPageNum=" + showPageNum + ", totalPageNum=" + totalPageNum + ", pageBeginNum=" + pageBeginNum
				+ ", pageEndNum=" + pageEndNum + ", listBeginNum=" + listBeginNum + ", listEndNum=" + listEndNum + "]";
	}
	
}
