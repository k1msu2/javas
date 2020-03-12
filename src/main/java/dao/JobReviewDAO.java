package dao;

import java.util.List;

import vo.JobReviewVO;

public interface JobReviewDAO {
	public List<JobReviewVO> listAll();
	public List<JobReviewVO> listAll(int id);
	public boolean insert(JobReviewVO vo);
	public boolean delete(int id);
	public boolean update(JobReviewVO vo);
}
