package dao;

import java.util.List;

import vo.JobadVO;

interface JobadDAOInterface {
	public boolean insert(JobadVO vo);
	public boolean update(JobadVO vo);
	public boolean delete(int brd_id);
	public List<JobadVO> listAll();
	public JobadVO listOne(int brd_id);
	public int getCount();
	public int getCount(String writer);
	public int getCount(String key,String searchType);
	public String getPageLinkList(int curPage,String linkStr,int size);
	public List<JobadVO> listAll(int curPage);
	public List<JobadVO> listWriter(String writer,int curPage);
	public List<JobadVO> listSort(String sortColumn, int curPage);
	public List<JobadVO> search(String key,String searchType,int curPage);
}
