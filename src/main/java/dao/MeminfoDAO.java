package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.MeminfoVO;

public class MeminfoDAO {

	// connection 하는 메서드를 따로 분류해 코딩량을 줄임
	private Connection connectDB() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@70.12.115.164:1521:xe", "javas", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// close 하는 메서드도 따로 분류해 호출하면 되게끔 구현
	private void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			} else if (stmt != null) {
				stmt.close();
			} else if (conn != null) {
				conn.close();
			} else {
				pstmt.close();
			}
		} catch (SQLException e) {

		}
	}

	
	//리스트로 출력해주는 기능? 아마도 내 정보 같은 데에 보여질 듯
	public List<MeminfoVO> listAll() {
		List<MeminfoVO> list = new ArrayList<>();
		String sql = "select mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer from meminfo";
		try (Connection conn = connectDB();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
		MeminfoVO vo;
		while (rs.next()) {
			vo = new MeminfoVO();
			vo.setMem_userid(rs.getString(1));
			vo.setMem_password(rs.getString(2));
			vo.setMem_username(rs.getString(3));
			vo.setMem_email(rs.getString(4));
			vo.setMem_birthday(rs.getString(5));
			vo.setMem_sex(rs.getString(6));
			vo.setMem_phone(rs.getString(7));
			vo.setMem_address(rs.getString(8));
			vo.setMem_register_date(rs.getString(9));
			vo.setMem_photo(rs.getString(10));
			vo.setMem_is_employer(rs.getInt(11));
			list.add(vo);
		}
		close(conn, stmt, null, rs);
		} catch (Exception e) {
			System.err.println("오류 발생 : " + e);
		}
		return list;
	}

	// insert 기능을 하는 메서드
	public boolean insert(MeminfoVO vo) {
		boolean result = true;
		try (Connection conn = connectDB();
				PreparedStatement pstmt = conn.prepareStatement(
						"insert into meminfo values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");) {
			pstmt.setString(1, vo.getMem_userid());
			pstmt.setString(2, vo.getMem_password());
			pstmt.setString(3, vo.getMem_username());
			pstmt.setString(4, vo.getMem_email());
			pstmt.setString(5, vo.getMem_birthday());
			pstmt.setString(6, vo.getMem_sex());
			pstmt.setString(7, vo.getMem_phone());
			pstmt.setString(8, vo.getMem_address());
			pstmt.setString(9, vo.getMem_register_date());
			pstmt.setString(10, vo.getMem_photo());
			pstmt.setInt(11, vo.getMem_is_employer());
			pstmt.executeUpdate();
			close(conn, null, pstmt, null);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	// update 기능을 하는 메서드
	public boolean update(MeminfoVO vo) {
		boolean result = true;
		try (Connection conn = connectDB();
				PreparedStatement pstmt = conn.prepareStatement("update meminfo set " + "mem_password = ?, " 
		                + "mem_username = ?, " + "mem_email = ? " + "mem_birthday = ?"
						+ "mem_sex = ?" + "mem_phone = ?" + "mem_address = ?" + "mem_register_date = ?"
						+ "mem_photo = ?" + "where mem_userid = ?");) {
			pstmt.setString(1, vo.getMem_password());
			pstmt.setString(2, vo.getMem_username());
			pstmt.setString(3, vo.getMem_email());
			pstmt.setString(4, vo.getMem_birthday());
			pstmt.setString(5, vo.getMem_sex());
			pstmt.setString(6, vo.getMem_phone());
			pstmt.setString(7, vo.getMem_address());
			pstmt.setString(8, vo.getMem_register_date());
			pstmt.setString(9, vo.getMem_photo());
			pstmt.setInt(10, vo.getMem_is_employer());
			pstmt.executeUpdate();
			close(conn, null, pstmt, null);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	// delete 기능을 하는 메서드
	public boolean delete(String memUserid) {
		boolean result = true;
		try (Connection conn = connectDB();
				PreparedStatement pstmt = conn.prepareStatement("delete from meminfo where mem_userid=?");) {
			pstmt.setString(1, memUserid);
			pstmt.executeUpdate();
			close(conn, null, pstmt, null);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	// insert, update, delete 기능만 구현. 추후 필요한 기능이 생길 시 추가할 예정
	// SQL 구문이 맞는지 헷갈림...
}
