package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.PageVO;
import vo.WantadVO;

@Repository
public class WantadDAOImpl implements WantadDAO {

	@Autowired
	SqlSession session = null;

	@Autowired
	PageVO pvo = null;

	@Override
	public List<WantadVO> listAll(PageVO pvo) {
		// system.out.println("==========dao listAll pagination ===========");
		List<WantadVO> list = null;
		String statement = "resource.WantadMapper.selectWantadPage";
		Map<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("beginNum", pvo.getListBeginNum());
		hmap.put("endNum", pvo.getListEndNum());
		list = session.selectList(statement, hmap);
		return list;

	}

	@Override
	public List<WantadVO> listAll() {
		// system.out.println("==========dao listAll===========");
		List<WantadVO> list = null;
		String statement = "resource.WantadMapper.selectWantad";
		list = session.selectList(statement);
		// system.out.println("dao : " + list);
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
			// system.out.println("count 증가함");
		}
		if (result)
			return vo;
		else
			return null;
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
		// system.out.println(vo);
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
	public List<WantadVO> search(String key, String searchType) {
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

	@Override
	public int listCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageVO pagination(int page) {

		String statement = "resource.WantadMapper.countWantad";
		int totalListNum = session.selectOne(statement);

		pvo.setShowListNum(4);
		pvo.setShowPageNum(5);
		
		pvo.setPage(page);
		pvo.setTotalListNum(totalListNum);
		
		int showPageNum = pvo.getShowPageNum();
		int showListNum = pvo.getShowListNum();
		int totalPageNum = (totalListNum - 1)/showListNum+1;
		
		// 페이지 개수
		pvo.setTotalPageNum(totalPageNum);

		int pageBeginNum = page;
		int pageEndNum = page;
		if (page % showPageNum == 0) {
			pageBeginNum = ((page/showPageNum)-1) * showPageNum + 1;
		} else {
			pageBeginNum = (page/showPageNum) * showPageNum+1;
		}

		if ((pageBeginNum + showPageNum) >= totalPageNum) {
			pageEndNum = totalPageNum;
		} else {
			pageEndNum = pageBeginNum + showPageNum - 1;
		}

		pvo.setPageBeginNum(pageBeginNum);
		pvo.setPageEndNum(pageEndNum);

		if (pageBeginNum == 1) {
			pvo.setLeftChar("");
		} else {
			pvo.setLeftChar("<");
		}

		if (pageEndNum == totalPageNum) {
			pvo.setRightChar("");
		} else {
			pvo.setRightChar(">");
		}

		int listBeginNum = totalListNum - (page - 1) * showListNum;
		int ListEndNum = -1;
		ListEndNum = listBeginNum - showListNum + 1;

		pvo.setListBeginNum(ListEndNum);
		pvo.setListEndNum(listBeginNum);
		
		System.out.println(pvo);
		return pvo;

	}
}
