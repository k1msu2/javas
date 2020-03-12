package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.PageVO;
import vo.WantSearchVO;
import vo.WantadVO;

@Repository
public class WantadDAOImpl implements WantadDAO {

	@Autowired
	SqlSession session = null;

	@Autowired
	PageVO pvo = null;

	@Override
	public List<WantadVO> listAll(PageVO pvo, WantSearchVO svo) {
		String statement = "";
		Map<String, String> hmap = new HashMap<String, String>();
		String key = svo.getKey();
		String searchtype = svo.getSearchtype();
		String userid = svo.getMem_userid();
		List<WantadVO> list = null;
		
		if(key != null && searchtype != null && searchtype.equals("all")){
			statement = "resource.WantadMapper.searchWantadAll";
			hmap.put("key", key);
		} else if(key != null && searchtype != null && searchtype.equals("post_title") || 
				key != null && searchtype != null && searchtype.equals("post_content")) {
			statement = "resource.WantadMapper.searchWantadTitleAndContent";
			hmap.put("key", key);
			hmap.put("searchtype", searchtype);
		} else if(userid != null) {
			statement = "resource.WantadMapper.searchWantaduserid";
			hmap.put("mem_userid", userid);
		} else {
			statement = "resource.WantadMapper.selectWantadPage";
		}
		
		hmap.put("beginNum", String.valueOf(pvo.getListBeginNum()));
		hmap.put("endNum", String.valueOf(pvo.getListEndNum()));
		System.out.println("-dao listall---");
		System.out.println(hmap);
		list = session.selectList(statement, hmap);
		return list;
	}
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
	public int listCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public PageVO pagination(int page, WantSearchVO svo) {
		String statement = "";
		int totalListNum = 0;
		Map<String, String> hmap = new HashMap<String, String>();
		String key = svo.getKey();
		String searchtype = svo.getSearchtype();
		String userid = svo.getMem_userid();
		
		if(key != null && searchtype != null && searchtype.equals("all")){
			statement = "resource.WantadMapper.countWantadsearchall";
			totalListNum = session.selectOne(statement, key);
		} else if(key != null && searchtype != null && searchtype.equals("post_title") || 
				key != null && searchtype != null && searchtype.equals("post_content")) {
			hmap.put("key", key);
			hmap.put("searchtype", searchtype);
			statement = "resource.WantadMapper.countWantadsearch";
			totalListNum = session.selectOne(statement, hmap);
		} else if(userid != null) {
			statement = "resource.WantadMapper.countWantaduserid";
			totalListNum = session.selectOne(statement, userid);
		} else {
			statement = "resource.WantadMapper.countWantad";
			totalListNum = session.selectOne(statement);
		}
		
		System.out.println(statement);
		System.out.println(totalListNum);

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
		return pvo;
	}
	
	@Override
	public PageVO pagination(int page) {
		String statement = "";
		int totalListNum = 0;
		
		statement = "resource.WantadMapper.countWantad";
		totalListNum = session.selectOne(statement);
		
		System.out.println(statement);
		System.out.println(totalListNum);

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
		return pvo;

	}


}
