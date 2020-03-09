package dao;

import java.util.List;

import vo.PageVO;
import vo.WantadVO;

public interface WantadDAO {
	public List<WantadVO> listAll();
	public List<WantadVO> listAll(PageVO pvo);
	public WantadVO listOne(int id);
	public boolean insert(WantadVO vo);
	public boolean delete(int id);
	public boolean update(WantadVO vo);
	public List<WantadVO> listWriter(String writer);
	public List<WantadVO> search(String key, String searchType);
	public List<WantadVO> searchAll(String keyword);
	public int listCount();
	public PageVO pagination(int page);

}
