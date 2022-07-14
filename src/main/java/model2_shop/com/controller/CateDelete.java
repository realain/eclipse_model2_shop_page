package model2_shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model2_shop.com.dao.CateDao;

@WebServlet("/cate/delete.do")
public class CateDelete extends HttpServlet{
	CateDao cateDao=new CateDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate_num=req.getParameter("cate_num");
		boolean delete=false;
		try {
			delete=cateDao.delete(cate_num);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		HttpSession session=req.getSession();
		session.setAttribute("delete", delete);
		if(delete) {
			resp.sendRedirect("./list.do");
		}else {
			resp.sendRedirect("./modify.do?cate_num="+cate_num);
		}
	}
}
