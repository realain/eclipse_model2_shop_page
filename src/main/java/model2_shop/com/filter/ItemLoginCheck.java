package model2_shop.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/item/*")
public class ItemLoginCheck implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("item/* filter�� ����è");
		//�α����� �ǰ� ����� 1�̻��� ���(0,1)�� ����
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		Object login=session.getAttribute("login");
		Object grade=session.getAttribute("grade");
		String login_msg="������ ���� �������� �α����� �ؾ��մϴ�";
		if(login!=null && (boolean)login) {
			if(grade!=null && (int)grade<2) {
				chain.doFilter(request, response); //���� �����ߴ� ���				
			}else{
				login_msg="������ ������ �� ����� �ƴմϴ�.";
				session.setAttribute("login_msg", login_msg); //�޼��� ����
				res.sendRedirect(req.getContextPath()+"/login.do");
			}
		}else {
			session.setAttribute("login_msg", login_msg);
			res.sendRedirect(req.getContextPath()+"/login.do");
		}
	}
}
