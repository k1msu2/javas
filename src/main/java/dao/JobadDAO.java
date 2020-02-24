package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.JobadVO;

@Repository
public class JobadDAO implements JobadDAOInterface{
	final String resource = "resource/mybatis-config.xml";
	@Autowired
	SqlSession session;
	
	public boolean insert(JobadVO vo) {
		System.out.println("miniproject - Jobad - insert");
		String statement = "resource.JobadMapper.insertJobad";
		boolean flag = false;
		if(session.insert(statement, vo)==1) {
			flag = true;
		}
		return flag;
	}
	public boolean update(JobadVO vo) {
		System.out.println("miniproject - Jobad - update");
		String statement = "resource.JobadMapper.updateJobad";
		boolean flag = false;
		if(session.update(statement,vo)==1) {
			flag = true;
		}
		return flag;
	}
	public boolean delete(int post_id) {
		System.out.println("miniproject - Jobad - delete");
		String statement = "resource.JobadMapper.deleteJobad";
		boolean flag = false;
		if(session.delete(statement,post_id)==1) {
			flag = true;
		}
		return flag;
	}
	public List<JobadVO> listAll(){
		System.out.println("miniproject - Jobad - listAll");
		String statement = "resource.JobadMapper.selectAll";
		List<JobadVO> list = session.selectList(statement);
		return list;
	}
	public JobadVO listOne(int post_id) {
		System.out.println("miniproject - Jobad - listOne");
		String statement = "resource.JobadMapper.listOne";
		JobadVO vo = session.selectOne(statement,post_id);
		return vo;
	}
	
	public int getCount() {
		return listAll().size();
	}
	public int getCount(String writer) {
		List<JobadVO> list = listAll();
		int cnt = 0;
		for(JobadVO vo : list) {
			if(vo.getMem_username().equals(writer)) {
				cnt++;
			}
		}
		return cnt;
	}
	public int getCount(String key, String searchType) {
		List<JobadVO> list = listAll();
		int cnt = 0;
		if(searchType.equals("title")) {
			for(JobadVO vo : list) {
				if(vo.getPost_title().equals(key)) {
					cnt++;
				}
			}
		}
		else if(searchType.equals("content")) {
			for(JobadVO vo : list) {
				if(vo.getPost_content().equals(key)) {
					cnt++;
				}
			}
		}
		else {
			for(JobadVO vo : list) {
				if(vo.getPost_content().equals(key) || vo.getPost_title().equals(key)) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	public String getPageLinkList(int curPage,String linkStr,int size) {
		PagingControl page = new PagingControl(10,5,size,curPage);
		StringBuilder buffer = new StringBuilder();
		if(page.isPreData()) {
			buffer.append("<a href='/miniproject/mainpage?pgNum=");
			buffer.append((page.getPageStart()-1)+linkStr+"'>");
			buffer.append("<img src='/miniproject/images/left.png' width='15'></a>");
		}
		for(int i = page.getPageStart();i<=page.getPageEnd();i++) {
			if(i == curPage) {
				buffer.append("<a href='/miniproject/mainpage?pgNum="+i+linkStr+"'"+" style='font-weight:bold;'>"+i+"</a> ");
			}
			else {
				buffer.append("<a href='/miniproject/mainpage?pgNum="+i+linkStr+"'"+">"+i+"</a> ");
			}
		}
		if(page.isNextData()) {
			buffer.append("<a href='/miniproject/mainpage?pgNum=");
			buffer.append((page.getPageEnd()+1)+linkStr+"'>");
			buffer.append(" <img src='/miniproject/images/right.png' width='15'></a>");
		}
		return buffer.toString();
	}
	public List<JobadVO> listAll(int curPage){
		System.out.println("miniproject - Jobad - listAll2");
		String statement = "resource.JobadMapper.selectAllPage";
		PagingControl page = new PagingControl(10,5,getCount(),curPage);
		Map<String,String> map = new HashMap<>();
		map.put("getWritingStart", Integer.toString(page.getWritingStart()));
		map.put("getWritingEnd", Integer.toString(page.getWritingEnd()));
		return session.selectList(statement, map);
	}
	public List<JobadVO> listWriter(String writer,int curPage){
		System.out.println("miniproject - Jobad - listWriter");
		String statement = "resource.JobadMapper.selectWriter";
		PagingControl page = new PagingControl(10,5,getCount(writer),curPage);
		Map<String, String> map = new HashMap<>();
		map.put("writer",writer);
		map.put("getWritingStart", Integer.toString(page.getWritingStart()));
		map.put("getWritingEnd", Integer.toString(page.getWritingEnd()));
		return session.selectList(statement, map);
	}
	public List<JobadVO> listSort(String sortColumn,int curPage){
		System.out.println("miniproject - Jobad - listSort");
		String statement = "resource.JobadMapper.listSort";
		PagingControl page = new PagingControl(10,5,getCount(),curPage);
		Map<String,String> map = new HashMap<>();
		map.put("sortColumn",sortColumn);
		map.put("getWritingStart", Integer.toString(page.getWritingStart()));
		map.put("getWritingEnd", Integer.toString(page.getWritingEnd()));
		return session.selectList(statement,map);
	}
	public List<JobadVO> search(String key,String searchType,int curPage){
		System.out.println("miniproject - Jobad - search");
		String statement = "resource.JobadMapper.searchList";
		PagingControl page = new PagingControl(10,5,getCount(),curPage);
		Map<String, String> map = new HashMap<>();
		map.put("key",key);
		map.put("searchType",searchType);
		map.put("getWritingStart", Integer.toString(page.getWritingStart()));
		map.put("getWritingEnd", Integer.toString(page.getWritingEnd()));
		return session.selectList(statement, map);
	}
}
