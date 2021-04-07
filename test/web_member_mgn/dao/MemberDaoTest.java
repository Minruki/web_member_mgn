package web_member_mgn.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_member_mgn.JdbcUtil;
import web_member_mgn.dao.impl.MemberDaoImpl;
import web_member_mgn.dto.Member;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTest {
	private static Connection con;
	private MemberDaoImpl dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//MemberDaoTest.java 가 수행되기 전 호출
		con = JdbcUtil.getConnection();
	}

	@Before
	public void setUp() throws Exception {
		//Test method가 호출되기 전에 호출
		dao = MemberDaoImpl.getInstance();
		dao.setCon(con);
	}

	@Test
	public void test1SelectMemberByIdSuccess() {
		System.out.println("test1SelectMemberByIdSuccess()-Success");
		Member member = new Member("1", "1111");
		Member memberLogin = dao.selectMemberById(member);
		System.out.println("memberLogin : " + memberLogin);
//		Assert.assertNotNull(memberLogin);
	}

	@Test
	public void test2SelectMemberByIdFail() {
		System.out.println("test2SelectMemberByIdFail()-Fail");
		Member member = new Member("1", "1112");
		Member memberLogin = dao.selectMemberById(member);
		System.out.println("memberLogin : " + memberLogin);
		
		Assert.assertNull(memberLogin);
	}
	
	@Test
	public void test3InsertMember() {
		System.out.println("test3InsertMember()");
		Member member = new Member("test3", "1111", "test3", 20, "남자", "test3@test.co.kr");
		dao.insertMember(member);
		
		Member memberLogin = dao.selectMemberById(member);
		Assert.assertNotNull(memberLogin);
	}
	@Test
	public void test4updateMember() {
		System.out.println("test4updateMember()");
		Member member = dao.selectMember(new Member("test3"));
		member.setAge(100);
		dao.updateMember(member);
		
		Member updateMember = dao.selectMemberById(member);
		Assert.assertNull(updateMember);
	}
	
	@Test
	public void test5RemoveMember() {
		System.out.println("test5RemoveMember()");
		Member member = new Member("test3");
		dao.deleteMember(member);
		
		Member memberLogin = dao.selectMemberById(member);
		Assert.assertNull(memberLogin);
	}
	
	@Test
	public void test6ListMember() {
		System.out.println("testListMember()");
		List<Member> list = dao.selectMemberByAll();
		Assert.assertNotNull(list);
		
		list.parallelStream().forEach(System.out::println);
	}
}
