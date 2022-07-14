package model2_shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2_shop.com.dao.CateDao;
import model2_shop.com.vo.CateVo;
@WebServlet("/cate/modify.do")
public class CateModify extends HttpServlet{
	CateDao cateDao=new CateDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("cate_num");
		CateVo cate=new CateVo();
		try {
			cate=cateDao.detail(Integer.parseInt(id));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("cate", cate);
		req.getRequestDispatcher("./modify.jsp").forward(req, resp);
		
	}
}
