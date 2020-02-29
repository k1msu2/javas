package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.WantadVO;

@Repository
public class WantadDAOImpl implements WantadDAO{
	
	@Autowired
	SqlSession session = null;
	
	@Override
	public List<WantadVO> listAll(){
		System.out.println("==========dao listAll===========");
		List<WantadVO> list = null;
		String statement = "resource.WantadMapper.selectWantad";
		list = session.selectList(statement);
		System.out.println("dao : " + list);
		return list;
	}
	
	@Override
	public WantadVO listOne(int id) {
		WantadVO vo = null;
		boolean result = false;
		String statement = "resource.WantadMapper.selectWantad1";
		vo = session.selectOne(statement, id);
		
		statement = "resource.WantadMapper.updateWantadView";
		if (session.update(statement, id) == 1) {
			result = true;
			System.out.println("count 증가함");
		}
		if(result) return vo;
		else return null;
	}
	
	@Override
	public boolean insert(WantadVO vo) {
		boolean result = false;
		String statement = "resource.WantadMapper.insertWantad";
		if (session.insert(statement, vo) == 1)
			result = true;
		return result;
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
			String statement = "resource.WantadMapper.deleteNews";
		if (session.delete(statement, id) == 1)
			result = true;
		return result;
	}
	
	@Override
	public boolean update(WantadVO vo) {
		boolean result = false;
		String statement = "resource.WantadMapper.updateNews";
		System.out.println(vo);
		if (session.insert(statement, vo) == 1)
			result = true;
		return result;
	}

	@Override
	public List<WantadVO> listWriter(String writer) {
		List<WantadVO> list = null;
		String statement = "resource.WantadMapper.searchWantad1";
		list = session.selectList(statement, writer);
		return list;
	}
	
	@Override
	public List<WantadVO> search(String key, String searchType){
		List<WantadVO> list = null;
		String statement = "resource.WantadMapper.searchWantadTitleAndContent";
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("key", key);
		hmap.put("searchtype", searchType);
		list = session.selectList(statement, hmap);
		return list;
	}
	
	@Override
	public List<WantadVO> searchAll(String key) {

		List<WantadVO> list = null;
		String statement = "resource.WantadMapper.searchWantadAll";
		list = session.selectList(statement, key);
		return list;
	}	
	

}
