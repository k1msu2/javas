package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.WantadVO;

@Repository
public class WantadMybatisDAO implements WantadDAO{
	
	@Autowired
	SqlSession session = null;
	
	public List<WantadVO> listAll(){
		System.out.println("==========dao listAll===========");
		List<WantadVO> list = null;
		String statement = "resource.WantadMapper.selectWantad";
		list = session.selectList(statement);
		System.out.println("dao : " + list);
		return list;
	}
	
	public WantadVO listOne(int id) {
		return null;
	}
	
	public boolean insert(WantadVO vo) {
		return false;
	}

	public boolean delete(int id) {
		return false;
	}
	
	public boolean update(WantadVO vo) {
		return false;
	}

	public List<WantadVO> listWriter(String writer) {
		return null;
	}
	
	public List<WantadVO> search(String keyword){
		return null;
	}
	
	public List<WantadVO> searchAll(String key) {
		return null;
	}
	

}
