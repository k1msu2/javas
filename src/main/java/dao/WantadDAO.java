package dao;

import java.util.List;

import vo.WantadVO;

public interface WantadDAO {
	public List<WantadVO> listAll();
	public boolean insert(WantadVO vo);
	public List<WantadVO> search(String keyword);
	public boolean delete(int id);
	public boolean update(WantadVO vo);
	public WantadVO listOne(int id);
}
