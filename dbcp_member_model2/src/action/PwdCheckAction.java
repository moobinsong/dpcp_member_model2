package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

public class PwdCheckAction implements Action {
	
	private String path;	

	public PwdCheckAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//pwdcheck.jsp에서 id와 password 가져오기
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		//회원정보를 가져와야 하는지 회원탈퇴를 해야 하는지 정보 가져오기
		String cmd=req.getParameter("cmd");
		
		
		//아이디랑 비밀번호 확인한 후 일치하면 해당 아이디의 정보를 리턴하는 DAO 메소드 필요	
		
		//password가 일치하면 해당 사람의 정보를 얻어오기	
		//얻어온 정보를 request에 담고
		//페이지 이동
		MemberDAO dao=new MemberDAO();
		MemberVO vo=dao.pwdCheck(userid, password);
		
		//cmd가 check이면 그대로 진행
		//cmd가 leave 이면 탈퇴 진행		
		
		//password가 일치하지 않으면
		//비밀번호 확인 메세지 띄운후 pwdcheck.jsp로 돌아가기
		if(vo!=null && cmd.equals("check")) {
			req.setAttribute("vo", vo);
			return new ActionForward(path,false);
		}else if(vo!=null && cmd.equals("leave")) {
			//탈퇴 작업하기 
			//dao 메소드 생성
			//세션 해제
			//index.jsp로 이동
			int result=dao.member_leave(userid);
			if(result>0) {
				HttpSession session=req.getSession(false);
				session.invalidate();
				path="index.jsp";
			}else {
				path="view/pwdcheck.jsp?msg=fail";
			}
			return new ActionForward(path,true);
		}else{
			path="view/pwdcheck.jsp?msg=fail";
			return new ActionForward(path,true);
		}		
	}

}
