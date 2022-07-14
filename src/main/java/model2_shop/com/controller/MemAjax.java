package model2_shop.com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import model2_shop.com.dao.MemberDao;
import model2_shop.com.vo.MemberVo;

@WebServlet("/mem/ajax.do")
public class MemAjax extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer jb=new StringBuffer();
		String line=null;
		BufferedReader reader =req.getReader();
		while((line=reader.readLine())!=null) {
			jb.append(line);
		}
		JSONObject json=new JSONObject(jb.toString());
		System.out.println(json.get("id"));
		System.out.println(req.getParameter("id"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-DD");
		
		MemberVo mem=new MemberVo();
		mem.setId(json.getString("id"));
		mem.setPw(json.getString("pw"));
		mem.setPhone(json.getString("phone"));
		mem.setEmail(json.getString("email"));
		mem.setName(json.getString("name"));
		mem.setAddress(json.getString("address"));
		mem.setAddress_detail(json.getString("address_detail"));
		try {
			mem.setBirth(sdf.parse(json.getString("birth")));
		} catch (JSONException | ParseException e1) {
			e1.printStackTrace();
		}
		mem.setGrade(Byte.parseByte(json.getString("grade")));
		System.out.println(mem);
		
		boolean insert=false;
		MemberDao memDao=new MemberDao();
		try {
			insert=memDao.insert(mem);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		resp.getWriter().append("{\"insert\":"+insert+"}");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id=req.getParameter("id");
		MemberDao memDao=new MemberDao();
		resp.setContentType("application/json; charset=UTF-8;");
		try {
			if(mem_id==null) {
				resp.getWriter().append(memDao.list(0).toString());
			}else {
				resp.getWriter().append(memDao.detail(mem_id).toString());
			}
		}catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json_str="";
		BufferedReader br=req.getReader();
		String line="";
		while((line=br.readLine())!=null) {
			json_str+=line;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-DD");
		JSONObject json=new JSONObject(json_str);
		MemberVo mem=new MemberVo();
		mem.setId(json.getString("id"));
		mem.setPw(json.getString("pw"));
		mem.setPhone(json.getString("phone"));
		mem.setEmail(json.getString("email"));
		mem.setName(json.getString("name"));
		mem.setAddress(json.getString("address"));
		mem.setAddress_detail(json.getString("address_detail"));
		try {
			mem.setBirth(sdf.parse(json.getString("birth")));
		} catch (JSONException | ParseException e1) {
			e1.printStackTrace();
		}
		mem.setGrade(Byte.parseByte(json.getString("grade")));
		
		boolean update=false;
		MemberDao memDao=new MemberDao();
		try {
			update=memDao.update(mem);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		resp.getWriter().append("{\"update\":"+update+"}");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json_str="";
		BufferedReader br=req.getReader();
		String line="";
		while((line=br.readLine())!=null) {
			json_str+=line;
		}
		JSONObject json=new JSONObject(json_str);
		MemberVo mem=new MemberVo();
		mem.setId(json.getString("id"));
		
		
		boolean delete=false;
		MemberDao memDao= new MemberDao();
		try {
			delete=memDao.delete(mem.getId());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		resp.getWriter().append("{\"delete\":"+delete+"}");
	}
}
