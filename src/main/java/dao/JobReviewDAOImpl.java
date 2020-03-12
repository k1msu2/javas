package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.JobReviewVO;

@Repository
public class JobReviewDAOImpl implements JobReviewDAO {
	@Autowired
	SqlSession session = null;

	@Override
	public List<JobReviewVO> listAll() {
		List<JobReviewVO> list = null;
		String statement = "resource.JobReviewMapper.selectJobReview";
		list = session.selectList(statement);
		return list;
	}

	@Override
	public boolean insert(JobReviewVO vo) {
		//System.out.println(vo);
		boolean result = false;
		String statement = "resource.JobReviewMapper.insertJobReview";
		if (session.insert(statement, vo) == 1) {
			 // wantad table review_count ++
			statement = "resource.JobReviewMapper.updateJobReviewCount";
			if (session.update(statement, vo.getPost_id()) == 1) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		String statement = "resource.JobReviewMapper.deleteJobReview";
		if (session.delete(statement, id) == 1) {
			// wantad table review_count --
			statement = "resource.JobReviewMapper.updateJobReviewCount2"; 
			if (session.update(statement, id) == 1) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean update(JobReviewVO vo) {
		boolean result = false;
		String statement = "resource.JobReviewMapper.updateJobReivew";
		if (session.insert(statement, vo) == 1)
			result = true;
		return result;
	}

	@Override
	public List<JobReviewVO> listAll(int id) {
		List<JobReviewVO> list = null;
		String statement = "resource.JobReviewMapper.selectJobReviewById";
		list = session.selectList(statement, id);
		return list;
	}

}