package model2_shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2_shop.com.dao.MemberDao;
import model2_shop.com.vo.MemberVo;

@WebServlet("/mem/update.do") //주소 중복 조심, 꼭 class 에 extends로 Httpservlet 상속
public class MemberUpdate extends HttpServlet {
	MemberDao memDao=new MemberDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MemberVo mem=new MemberVo();
		mem.setId(req.getParameter("id"));
		mem.setPw(req.getParameter("pw"));
		mem.setName(req.getParameter("name"));
		mem.setAddress(req.getParameter("address"));
		mem.setAddress_detail(req.getParameter("address_detail"));
		mem.setEmail(req.getParameter("email"));
		mem.setPhone(req.getParameter("phone"));
		mem.setGrade(Byte.parseByte(req.getParameter("grade")));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-DD");
		try {
			mem.setSignup_time(sdf.parse(req.getParameter("signup_time")));
			mem.setBirth(sdf.parse(req.getParameter("birth")));			
		}catch (ParseException e1) {
			e1.printStackTrace();
		}
		System.out.println(mem);
		boolean update=false;
		try {
			update=memDao.update(mem);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(update) {
			resp.sendRedirect("./list.do?page=1&login=true");			
		}else {
			resp.sendRedirect("./modify.do?id="+mem.getId()+"&login=false");
		}
	}
}
