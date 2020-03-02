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
		//system.out.println("==========dao listAll pagination ===========");
		List<WantadVO> list = null;
		String statement = "resource.WantadMapper.selectWantadPage";
		Map<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("startNum", pvo.getListStartNum());
		hmap.put("endNum", pvo.getListEndNum());
		// hmap.put("startNum", 0);
		// hmap.put("endNum", 0);
		list = session.selectList(statement, hmap);
		//system.out.println(list);
		return list;

	}

	@Override
	public List<WantadVO> listAll() {
		//system.out.println("==========dao listAll===========");
		List<WantadVO> list = null;
		String statement = "resource.WantadMapper.selectWantad";
		list = session.selectList(statement);
		//system.out.println("dao : " + list);
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
			//system.out.println("count 증가함");
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
		//system.out.println(vo);
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
	public PageVO pagination(int page, int left, int right) {
		//system.out.println("page : " + page);
		//system.out.println("left : " + left);
		//system.out.println("right : " + right);

		//PageVO pvo = new PageVO();

		//pvo.setPage(page);

		String statement = "resource.WantadMapper.countWantad";
		int totalListNum = session.selectOne(statement);
		pvo.setTotalListNum(totalListNum);
		//system.out.println("totalListNum: " + totalListNum);

		// 사용자 지정
		pvo.setShowListNum(3);
		pvo.setShowPageNum(2);

		//system.out.println("ShowListNum: " + pvo.getShowListNum());
		//system.out.println("ShowPageNum: " + pvo.getShowPageNum());

		int totalpage = (pvo.getTotalListNum() + 1) / pvo.getShowListNum();
		pvo.setTotalPageNum(totalpage);
		//system.out.println("totalpage: " + totalpage);

		pvo.setPage(page);
		// 첫화면 페이지 구분
		if (page == 1) {
			if (pvo.getTotalPageNum() > pvo.getShowPageNum()) {
				pvo.setRightNum(right + 1);
				pvo.setRightChar(">");
				pvo.setLeftChar("");
			} else {
				pvo.setRightNum(0);
				pvo.setRightChar("");
				pvo.setLeftChar("");
			}
			pvo.setPageStartNum(1);  //1
			pvo.setPageEndNum(pvo.getShowPageNum()); //2
			
		} else {
			// '>' 클릭시
			// 1. endnum + 1
			// 2. '<' or '>' 출력 여부 확인 (데이터가 있는지 여부)
			// 3. 새로운 startnum, endnum
			//System.out.println(page);
			if (page > pvo.getPageEndNum()) {
				pvo.setPage(pvo.getPageEndNum() + 1);
				System.out.println(pvo.getPage());
				pvo.setLeftChar("<");
				pvo.setPageStartNum(pvo.getPageStartNum() + pvo.getShowPageNum());
				int pendnum = pvo.getPageEndNum() + pvo.getShowPageNum();
				if (pendnum > pvo.getTotalPageNum()) {
					pendnum = pvo.getTotalPageNum();
					pvo.setPageEndNum(pendnum);
					pvo.setRightChar("");
				} else {
					pvo.setPageEndNum(pendnum);
					pvo.setRightChar(">");
				}
			}
			// '<' 클릭시
			// 1. startnum - 1
			// 2. '<' or '>' 출력 여부 확인 (데이터가 있는지 여부)
			// 3. 새로운 startnum, endnum
			
			else if(page < pvo.getPageStartNum()) {
				pvo.setPage(pvo.getPageStartNum()-1);
				pvo.setRightChar(">");
				
				if(pvo.getPageStartNum() == pvo.getPageEndNum()) {
					pvo.setPageEndNum(pvo.getPageEndNum()-1);
					pvo.setPageStartNum(pvo.getPageEndNum()-pvo.getShowPageNum()+1);				
				} else {
					pvo.setPageEndNum(pvo.getPageEndNum()-pvo.getShowPageNum());
					pvo.setPageStartNum(pvo.getPageEndNum()-pvo.getShowPageNum()+1);				
				}

				
				if(pvo.getPageStartNum()==1) {
					pvo.setLeftChar("");
				}else {
					pvo.setLeftChar("<");
				}
				
			}
		}

		// 출력할 게시판 글의 시작과 끝 넘버
		int start = (pvo.getPage() - 1) * pvo.getShowListNum() + 1;
		int end = pvo.getPage() * pvo.getShowListNum();
		pvo.setListStartNum(start);
		pvo.setListEndNum(end);

		//system.out.println("start: " + start);
		//system.out.println("end: " + end);

		//system.out.println("right: " + pvo.getRightNum() + ", char:" + pvo.getRightChar());
		//system.out.println("left: " + pvo.getLeftNum() + ", char:" + pvo.getLeftChar());

		return pvo;

	}
}
