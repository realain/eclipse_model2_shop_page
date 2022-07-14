package model2_shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2_shop.com.dao.ItemDao;
import model2_shop.com.vo.ItemVo;

@WebServlet("/item/modify.do")
public class ItemModify extends HttpServlet {
	ItemDao itemDao=new ItemDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String item_num=req.getParameter("item_num");
		ItemVo item=new ItemVo();
		try {
			item=itemDao.detail(Integer.parseInt(item_num));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("item", item);
		req.getRequestDispatcher("./modify.jsp").forward(req, resp);
	}
}
