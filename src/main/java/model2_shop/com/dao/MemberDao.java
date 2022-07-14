package model2_shop.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model2_shop.com.vo.MemberVo;

public class MemberDao implements MemberDaoAble{

	private String list_sql="SELECT * FROM MEMBER";
	private String detail_sql="SELECT * FROM MEMBER WHERE id=?";
	private String update_sql="UPDATE MEMBER SET "
			+ " pw=?,"
			+ " phone=?,"
			+ " email=?,"
			+ " name=?,"
			+ " address=?,"
			+ " address_detail=?,"
			+ " birth=?,"
			+ " grade=?"
			+ " WHERE id=?";
	private String delete_sql="DELETE FROM MEMBER WHERE id=?";
	private String insert_sql="INSERT INTO MEMBER (id,pw,phone,email,name,birth,address,address_detail,grade) VALUES (?,?,?,?,?,?,?,?,?)";
	private String insert_sql2="INSERT INTO MEMBER (id,pw,phone,email,name,address,address_detail,grade) VALUES (?,?,?,?,?,?,?,?)";
	private String email_check_sql="SELECT * FROM MEMBER WHERE email=?";
	private String phone_check_sql="SELECT * FROM MEMBER WHERE phone=?";
	private String login_sql="SELECT * FROM MEMBER WHERE id=? and pw=?";
	@Override
	public List<MemberVo> list(int page) throws ClassNotFoundException, SQLException {
		List<MemberVo> mem_list=new ArrayList<MemberVo>();
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(list_sql);
		ResultSet rs=ps.executeQuery();	
		MemberVo mem;
		while(rs.next()) {
			mem=new MemberVo();
			mem.setId(rs.getString("id"));
			mem.setPw(rs.getString("pw"));
			mem.setPhone(rs.getString("phone"));
			mem.setEmail(rs.getString("email"));
			mem.setName(rs.getString("name"));
			mem.setAddress(rs.getString("address"));
			mem.setAddress_detail(rs.getString("address_detail"));
			mem.setSignup_time(rs.getDate("signup_time"));
			mem.setBirth(rs.getDate("birth"));
			mem.setGrade(rs.getByte("grade"));
			mem_list.add(mem);
		}
		return mem_list;
	}

	@Override
	public MemberVo detail(String id) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(detail_sql);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		MemberVo mem=new MemberVo();
		while(rs.next()) {
			mem.setId(rs.getString("id"));
			mem.setPw(rs.getString("pw"));
			mem.setPhone(rs.getString("phone"));
			mem.setEmail(rs.getString("email"));
			mem.setName(rs.getString("name"));
			mem.setAddress(rs.getString("address"));
			mem.setAddress_detail(rs.getString("address_detail"));
			mem.setSignup_time(rs.getDate("signup_time"));
			mem.setBirth(rs.getDate("birth"));
			mem.setGrade(rs.getByte("grade"));
		}
		return mem;
	}
	public MemberVo emailcheck(String email) throws ClassNotFoundException, SQLException{
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM MEMBER WHERE email=?");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		MemberVo mem=new MemberVo();
		while(rs.next()) {
			mem.setEmail(rs.getString("email"));
		}
		return mem;
	}
	public MemberVo phonecheck(String phone) throws ClassNotFoundException, SQLException{
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM MEMBER WHERE phone=?");
		ps.setString(1, phone);
		ResultSet rs=ps.executeQuery();
		MemberVo mem=new MemberVo();
		while(rs.next()) {
			mem.setPhone(rs.getString("phone"));
		}
		return mem;
	}

	@Override
	public boolean insert(MemberVo mem) throws ClassNotFoundException, SQLException {
		//id,pw,phone,email,name,birth,address,address_detail,grade
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(insert_sql);
		ps.setString(1, mem.getId());
		ps.setString(2, mem.getPw());
		ps.setString(3, mem.getPhone());
		ps.setString(4, mem.getEmail());
		ps.setString(5, mem.getName());
		ps.setString(6,new SimpleDateFormat("yyyy-mm-dd").format(mem.getBirth()));
		ps.setString(7, mem.getAddress());
		ps.setString(8, mem.getAddress_detail());
		ps.setInt(9, mem.getGrade());
		int insert=ps.executeUpdate();
		if(insert>0) {
			return true;
		}else {
			return false;			
		}
	}

	@Override
	public boolean update(MemberVo mem) throws ClassNotFoundException, SQLException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-DD");
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(update_sql);
		ps.setString(1, mem.getPw());
		ps.setString(2, mem.getPhone());
		ps.setString(3, mem.getEmail());
		ps.setString(4, mem.getName());
		ps.setString(5, mem.getAddress());
		ps.setString(6, mem.getAddress_detail());
		ps.setString(7, sdf.format(mem.getBirth()));
		ps.setInt(8, mem.getGrade());
		ps.setString(9, mem.getId());
		int update=ps.executeUpdate();
		if(update>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String id) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(delete_sql);
		ps.setString(1, id);
		int delete=ps.executeUpdate();
		if(delete>0) {
			return true;
		}else {			
			return false;
		}
	}
	@Override
	public MemberVo login(String id, String pw) throws ClassNotFoundException, SQLException {
		MemberVo mem=null;
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(login_sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			mem=new MemberVo();
			mem.setId(rs.getString("id"));
			mem.setPw(rs.getString("pw"));
			mem.setPhone(rs.getString("phone"));
			mem.setEmail(rs.getString("email"));
			mem.setName(rs.getString("name"));
			mem.setAddress(rs.getString("address"));
			mem.setAddress_detail(rs.getString("address_detail"));
			mem.setSignup_time(rs.getDate("signup_time"));
			mem.setBirth(rs.getDate("birth"));
			mem.setGrade(rs.getByte("grade"));
			
		}
		return mem;
	}

	@Override
	public MemberVo emailCheck(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVo phoneCheck(String phone) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	//테스트용 
	public static void main(String[]args) {
//		try {
//			MemberDao dao=new MemberDao();
//			dao.list(1).forEach((MemberVo mem)->{
//				System.out.println(mem);
//			});
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			MemberDao dao=new MemberDao();
//			System.out.println(dao.detail("admin"));
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	
}
