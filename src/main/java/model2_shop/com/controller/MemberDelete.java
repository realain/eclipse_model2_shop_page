package model2_shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model2_shop.com.dao.MemberDao;

@WebServlet("/mem/delete.do")
public class MemberDelete extends HttpServlet{
	MemberDao memDao=new MemberDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		boolean delete=false;
		try {
			delete=memDao.delete(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//�����ϸ� session�� ����. �����ϰ� �մ� �������� �����Ǵ� ��ü�� ����(�α���)
		HttpSession session=req.getSession();
		session.setAttribute("delete", delete);
		//����(redirect) -> list ��
		//����(redirect) -> modify?id= ��
		if(delete) {
			resp.sendRedirect("./list.do?page=1");
		}else {
			resp.sendRedirect("./modify.do?id="+id);
		}
	}
}