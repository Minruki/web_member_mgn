package web_member_mgn.dao;

import java.util.List;

import web_member_mgn.dto.Member;

public interface MemberDao {
	Member selectMemberById(Member member);
	int insertMember(Member member);
	List<Member> selectMemberByAll();
	void deleteMember(Member member);
	Member selectMember(Member member);
	void updateMember(Member member);
}
