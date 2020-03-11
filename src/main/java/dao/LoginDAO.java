package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.LoginVO;

@Repository
public class LoginDAO {
	final String resource = "resource/mybatis-config.xml";
	@Autowired 
	SqlSession session;
	public LoginVO getVO(String mem_userid) {
		String statement = "resource.LoginMapper.getVO";
		LoginVO vo = null;
		vo = session.selectOne(statement,mem_userid);
		return vo;
	}
}
