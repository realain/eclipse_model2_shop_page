package model2_shop.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout.do")
public class MemberLogout extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�α׾ƿ� ������ login �������� �̵�
		req.getSession().invalidate(); 
		resp.sendRedirect(req.getContextPath()+"/login.do");
	}
}
