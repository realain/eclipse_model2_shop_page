package model2_shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2_shop.com.dao.CateDao;
import model2_shop.com.dao.MemberDao;
import model2_shop.com.vo.CateVo;

@WebServlet("/cate/insert.do")
public class CateInsert extends HttpServlet{
	private CateDao cateDao=new CateDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("./insert.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		CateVo cate=new CateVo();
		cate.setName(req.getParameter("name"));
		cate.setSub(Integer.parseInt(req.getParameter("sub")));
		System.out.println(cate);
		CateDao cateDao=new CateDao();
		boolean insert=false;
		try {
			insert=cateDao.insert(cate);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getSession().setAttribute("insert", insert);
		if(insert) {
			resp.sendRedirect("list.do");
		}else {
			resp.sendRedirect("insert.do");
		}
	}
}
