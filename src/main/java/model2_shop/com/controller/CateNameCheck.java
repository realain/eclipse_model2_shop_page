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

@WebServlet("/cate/name_check.do")
public class CateNameCheck extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		resp.setContentType("json/application; charset=UTF-8");		
		CateDao cateDao=new CateDao();
		CateVo cate=null;
		try {
			cate=cateDao.namecheck(name);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(cate.getName()==null) {
			resp.getWriter().append("{\"name_check\":true}");
		}else {
			resp.getWriter().append("{\"name_check\":false}");
		}
	}
}
