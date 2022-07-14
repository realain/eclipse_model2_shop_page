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
import model2_shop.com.vo.CateVo;

@WebServlet("/cate/update.do")
public class CateUpdate extends HttpServlet {
	CateDao cateDao= new CateDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		CateVo cate=new CateVo();
		cate.setCate_num(Integer.parseInt(req.getParameter("cate_num")));
		cate.setName(req.getParameter("name"));
		cate.setSub(Integer.parseInt(req.getParameter("sub")));
		boolean update=false;
		try {
			update=cateDao.update(cate);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(update) {
			resp.sendRedirect("./list.do?updateConfirm=true");
		}else {
			resp.sendRedirect("./modify.do?cate_num="+cate.getCate_num()+"&updateConfirm=false");
		}
	}
}
