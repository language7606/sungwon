package co.sungwon.main.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sungwon.main.common.Command;
import co.sungwon.main.member.serviceImpl.MemberDAO;
import co.sungwon.main.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 처리 과정
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = dao.memberLoginCheck(vo);
		
		String viewPage;
		request.setAttribute("member", vo);
		
		if(vo.getMemberName() != null) {
			viewPage = "member/memberLoginSuccess.jsp";
		} else {
			viewPage = "member/memberLoginFail.jsp";
		}
		
		return viewPage;
	}

}
