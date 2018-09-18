package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

public class UpdateAction implements Action {
	private String path;	

	public UpdateAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//userid, password,email 가져오기
		//정보 수정 후 페이지 이동
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		
		MemberDAO dao=new MemberDAO();
		MemberVO vo=new MemberVO();
		vo.setUserid(userid);
		vo.setPassword(password);
		vo.setEmail(email);
		
		int result=dao.update_member(vo);
		if(result>0)
			path+="?msg=success";
		return new ActionForward(path,true);
	}

}
