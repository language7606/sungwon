package co.sungwon.main.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.sungwon.main.common.DataSource;
import co.sungwon.main.member.service.MemberService;
import co.sungwon.main.member.vo.MemberVO;

public class MemberDAO implements MemberService {
	private DataSource dataSource = DataSource.getInstance();  // 데이터베이스 연결객체
	private Connection conn;        // 내부에서 DB connection 유지
	private PreparedStatement psmt; // DB에 명령 실행
	private ResultSet rs;			// select 한 결과를 받기 위해
	

	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> list = new ArrayList<MemberVO>(); // 결과 담을 저장소
		MemberVO vo;
		String sql = "select * from member";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberPassword(rs.getString("memberpassword"));
				vo.setMemberAddress(rs.getString("memberaddress"));
				list.add(vo);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return null;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO 회원 입력 로직
		int n = 0;
		String sql = "insert into member values(?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberName());
			psmt.setString(2, vo.getMemberId());
			psmt.setString(3, vo.getMemberPassword());
			psmt.setString(4, vo.getMemberAddress());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO 회원 삭제
		int n = 0;
		String sql = "delete from member where memberid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  vo.getMemberId());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
