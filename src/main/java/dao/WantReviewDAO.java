package dao;

import java.util.List;

import vo.WantReviewVO;

public interface WantReviewDAO {
	public List<WantReviewVO> listAll();
	public List<WantReviewVO> listAll(int id);
	public boolean insert(WantReviewVO vo);
	public boolean delete(int id);
	public boolean update(WantReviewVO vo);
}