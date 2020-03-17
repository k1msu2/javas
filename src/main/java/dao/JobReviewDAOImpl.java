package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.JobReviewVO;
import vo.JobadVO;

@Repository
public class JobReviewDAOImpl{
	@Autowired
	SqlSession session;
	public List<JobReviewVO> listAll(int post_id){
		String statement = "resource.JobReviewMapper.listAllJobReview";
		return session.selectList(statement, post_id);
	}
	public int getCount() {
		String statement = "resource.JobReviewMapper.getCountJobReview";
		return session.selectList(statement).size();
	}
	public String getPageLinkList(int curPage,String linkStr,int size) {
		PagingControl page = new PagingControl(5,5,size,curPage);
		StringBuilder buffer = new StringBuilder();
		if(page.isPreData()) {
			buffer.append("<a href='/javas/jobreview?pgNum=");
			buffer.append((page.getPageStart()-1)+linkStr+"'>");
			buffer.append("<img src='/javas/resources/images/left.png' width='15'></a> ");
		}
		for(int i = page.getPageStart();i<=page.getPageEnd();i++) {
			if(i == curPage) {
				buffer.append("<a href='/javas/jobreview?pgNum="+i+linkStr+"'"+" style='font-weight:bold;'>"+i+"</a> ");
			}
			else {
				buffer.append("<a href='/javas/jobreview?pgNum="+i+linkStr+"'"+">"+i+"</a> ");
			}
		}
		if(page.isNextData()) {
			buffer.append("<a href='/javas/jobreview?pgNum=");
			buffer.append((page.getPageEnd()+1)+linkStr+"'>");
			buffer.append(" <img src='/javas/resources/images/right.png' width='15'></a>");
		}
		return buffer.toString();
	}
	public boolean insert(JobReviewVO vo) {
		String statement = "resource.JobReviewMapper.insertJobReview";
		boolean flag = false;
		if((session.insert(statement,vo))==1) {
			statement = "resource.JobReviewMapper.pluscountJobad";
			if (session.update(statement, vo.getPost_id()) == 1) {
				flag = true;
			}
		}
		return flag;
	}
	public boolean update(JobReviewVO vo) {
		String statement = "resource.JobReviewMapper.updateJobReview";
		boolean flag = false;
		if((session.update(statement,vo))==1) {
			flag = true;
		}
		return flag;
	}
	public boolean delete(int review_id) {
		String statement = "resource.JobReviewMapper.getPostId";
		int post_id = session.selectOne(statement,review_id);
		statement = "resource.JobReviewMapper.deleteJobReview";
		boolean flag = false;
		if((session.delete(statement,review_id))==1) {
			statement = "resource.JobReviewMapper.minuscountJobad";
			if((session.update(statement, post_id))==1) {
				flag = true;
			}
		}
		return flag;
	}
}
