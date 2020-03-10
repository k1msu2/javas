package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.WantReviewVO;

@Repository
public class WantReviewDAOImpl implements WantReviewDAO {
	@Autowired
	SqlSession session = null;

	@Override
	public List<WantReviewVO> listAll() {
		List<WantReviewVO> list = null;
		String statement = "resource.WantReviewMapper.selectWantReview";
		list = session.selectList(statement);
		return list;
	}

	@Override
	public boolean insert(WantReviewVO vo) {
		System.out.println(vo);
		boolean result = false;
		String statement = "resource.WantReviewMapper.insertWantReview";
		if (session.insert(statement, vo) == 1) {
			statement = "resource.WantReviewMapper.updateWantReviewCount";
			if (session.update(statement, vo.getPost_id()) == 1) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		String statement = "resource.WantReviewMapper.deleteWantReview";
		if (session.delete(statement, id) == 1)
			result = true;
		return result;
	}

	@Override
	public boolean update(WantReviewVO vo) {
		boolean result = false;
		String statement = "resource.WantReviewMapper.updateWantReivew";
		if (session.insert(statement, vo) == 1)
			result = true;
		return result;
	}

	@Override
	public List<WantReviewVO> listAll(int id) {
		List<WantReviewVO> list = null;
		String statement = "resource.WantReviewMapper.selectWantReviewById";
		list = session.selectList(statement, id);
		return list;
	}

}
