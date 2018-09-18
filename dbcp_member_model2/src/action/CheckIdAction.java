package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class CheckIdAction implements Action {	
	private String path;	
	public CheckIdAction(String path) {
		super();
		this.path = path;
	}
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//.jsp에서 사용자가 입력한 값 가져오기
		String userid=req.getParameter("userid");		
		//db 확인
		MemberDAO dao=new MemberDAO();
		boolean result=dao.checkId(userid);			
		if(result) {//사용중인 것
			req.setAttribute("result", "false");
		}else {
			req.setAttribute("result", "true");
		}				
		return new ActionForward(path,false);	
	}
}








