package vo;

public class SearchVO {
	private int getWritingStart;
	private int getWritingEnd;
	private String searchExpr;
	public int getGetWritingStart() {
		return getWritingStart;
	}
	public int getGetWritingEnd() {
		return getWritingEnd;
	}
	public String getSearchExpr() {
		return searchExpr;
	}
	public void setGetWritingStart(int getWritingStart) {
		this.getWritingStart = getWritingStart;
	}
	public void setGetWritingEnd(int getWritingEnd) {
		this.getWritingEnd = getWritingEnd;
	}
	public void setSearchExpr(String searchExpr) {
		this.searchExpr = searchExpr;
	}
}
