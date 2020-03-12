package dao;

import java.util.List;

import vo.PageVO;
import vo.WantSearchVO;
import vo.WantadVO;

public interface WantadDAO {
	public List<WantadVO> listAll();
	public List<WantadVO> listAll(PageVO pvo);
	public List<WantadVO> listAll(PageVO pvo, WantSearchVO svo);
	public WantadVO listOne(int id);
	public boolean insert(WantadVO vo);
	public boolean delete(int id);
	public boolean update(WantadVO vo);
	public int listCount();
	public PageVO pagination(int page, WantSearchVO svo);
	public PageVO pagination(int page);
}
