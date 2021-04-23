package co.sungwon.main.member.service;

import java.util.List;

import co.sungwon.main.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); // 전체리스트
	MemberVO memberSelect(MemberVO vo); // 한명 정보
	int memberInsert(MemberVO vo); // 멤버 삽입
	int memberUpdate(MemberVO vo); // 멤버 수정
	int memberDelete(MemberVO vo); // 멤버 삭제
}
