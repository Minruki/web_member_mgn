package web_member_mgn.service;

import java.util.List;

import web_member_mgn.dao.impl.MemberDaoImpl;
import web_member_mgn.ds.JndiDS;
import web_member_mgn.dto.Member;

public class MemberService {
	private MemberDaoImpl dao;
	
	public MemberService() {
		dao = MemberDaoImpl.getInstance();
		dao.setCon(JndiDS.getConnection());
	}
	
	public Member searchMember(Member member) {
		return dao.selectMember(member);
	}
	
	public Member loginMember(Member member) {
		return dao.selectMemberById(member);
	}
	
	public int joinMember(Member member) {
		return dao.insertMember(member);
	}
	
	public List<Member> showList(){
		return dao.selectMemberByAll();
	}
	
	public void removeMember(Member member) {
		dao.deleteMember(member);
	}
	
	public void modifyMember(Member member) {
		dao.updateMember(member);
	}
}
