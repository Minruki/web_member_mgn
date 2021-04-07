package web_member_mgn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_member_mgn.dao.MemberDao;
import web_member_mgn.dto.Member;

public class MemberDaoImpl implements MemberDao {
	private static final MemberDaoImpl instance = new MemberDaoImpl();

	public static MemberDaoImpl getInstance() {
		return instance;
	}

	private Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public Member selectMemberById(Member member) {
		String sql = "select id, name, age, gender, email " + "   from member "
				+ "  where id = ? and passwd = password(?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			
//			System.out.println(pstmt);
			
			try (ResultSet rs = pstmt.executeQuery();){
				if (rs.next()) {
					return getMember(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Member getMember(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		int age = rs.getInt("age");
		String gender = rs.getString("gender");
		String email = rs.getString("email");
		return new Member(id, name, age, gender, email);
	}

	@Override
	public int insertMember(Member member) {
		//(1, password('1111'), '김상건', 40, '여자', 'test@test.co.kr');
		String sql = "insert into member values "
	              +  "(?, password(?), ?, ?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public List<Member> selectMemberByAll() {
		String sql = "select id, name, age, gender, email from member "
				+    "where id != 'admin'";
		try (PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			List<Member> list = new ArrayList<Member>();
			while(rs.next()) {
				list.add(getMember(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteMember(Member member) {
		//(1, password('1111'), '김상건', 40, '여자', 'test@test.co.kr');
		String sql = "delete from member "
	              +  "where id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Member selectMember(Member member) {
		String sql = "select id, name, age, gender, email from member "
				+ "  where id = ? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getId());
			
			try (ResultSet rs = pstmt.executeQuery();){
				if (rs.next()) {
					return getMember(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateMember(Member member) {
		//id, name, age, gender, email
		String sql = "update member "
				   + "   set name=?, age=?, gender=?, email=?"
				   + " where id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member.getName());
			pstmt.setInt(2, member.getAge());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
