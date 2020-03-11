package dao;

import java.util.List;

import vo.PageVO;
import vo.WantSearchVO;
import vo.WantadVO;

public interface WantadDAO {
	public List<WantadVO> listAll();
	public List<WantadVO> listAll(PageVO pvo);
	public WantadVO listOne(int id);
	public boolean insert(WantadVO vo);
	public boolean delete(int id);
	public boolean update(WantadVO vo);
	public List<WantadVO> listUserid(PageVO pvo, WantSearchVO svo);
	public List<WantadVO> search(PageVO pvo, WantSearchVO svo);
	public List<WantadVO> searchAll(PageVO pvo, WantSearchVO svo);
	public int listCount();
	public PageVO pagination(int page, WantSearchVO svo);

}
