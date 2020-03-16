package dao;

import java.util.List;

import vo.WantReviewVO;

public interface WantReviewDAO {
	public List<WantReviewVO> listAll();
	public List<WantReviewVO> listAll(int id);
	public List<WantReviewVO> listAll(String userid);
	public boolean insert(WantReviewVO vo);
	public boolean delete(WantReviewVO vo);
	public boolean update(WantReviewVO vo);
}
