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

@WebServlet("/cate/insert_list.do")
public class CateInsertList extends HttpServlet {
	private CateDao cateDao=new CateDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CateVo> cate_list=new ArrayList<CateVo>();
		resp.setContentType("json/application; charset=UTF-8");	
		try {
			cate_list=cateDao.list();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
