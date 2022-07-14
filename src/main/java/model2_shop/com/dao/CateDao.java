package model2_shop.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model2_shop.com.vo.CateVo;

public class CateDao implements CateDaoable{
	private String list_sql="SELECT * FROM CATEGORY";
	private String detail_sql="SELECT * FROM CATEGORY WHERE cate_num=?";
	private String update_sql="UPDATE CATEGORY SET name=? WHERE cate_num=?";
	private String insert_sql="INSERT INTO CATEGORY (name,sub) VALUES (?,?)";
	private String delete_sql="DELETE FROM CATEGORY WHERE cate_num=?";
	@Override
	public List<CateVo> list() throws ClassNotFoundException, SQLException {
		List<CateVo> cate_list=new ArrayList<CateVo>();
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(list_sql);
		ResultSet rs=ps.executeQuery();
		CateVo cate;
		while(rs.next()) {
			cate=new CateVo();
			cate.setCate_num(rs.getInt("cate_num"));
			cate.setName(rs.getString("name"));
			cate.setSub(rs.getInt("sub"));
			cate_list.add(cate);
		}
		return cate_list;
	}

	@Override
	public CateVo detail(int cate_num) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(detail_sql);
		ps.setInt(1, cate_num);
		ResultSet rs=ps.executeQuery();
		CateVo cate=new CateVo();
		while(rs.next()) {
			cate.setCate_num(rs.getInt("cate_num"));
			cate.setName(rs.getString("name"));
			cate.setSub(rs.getInt("sub"));
		}
		return cate;
	}
	
	public CateVo namecheck(String name)throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM CATEGORY WHERE name=?");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		CateVo cate=new CateVo();
		while(rs.next()) {
			cate.setName(rs.getString("name"));
		}
		return cate;
	}
	@Override
	public boolean insert(CateVo cate) throws ClassNotFoundException, SQLException {
		//name,sub;
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(insert_sql);
		ps.setString(1, cate.getName());
		ps.setInt(2, cate.getSub());
		int insert=ps.executeUpdate();
		if(insert>0) {
			return true;
		}else {
			return false;			
		}
	}

	@Override
	public boolean update(CateVo cate) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(update_sql);
		ps.setString(1, cate.getName());
		ps.setInt(2, cate.getCate_num());
		int update=ps.executeUpdate();
		if(update>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String cate_num) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(delete_sql);
		ps.setString(1, cate_num);
		int delete=ps.executeUpdate();
		if(delete>0) {
			return true;
		}else {
			return false;			
		}
	}
	@Override
	public String toString() {
		return "CateDao={\"list_sql\": \"" + list_sql + "\", \"detail_sql\": \"" + detail_sql + "\", \"update_sql\": \""
				+ update_sql + "\", \"insert_sql\": \"" + insert_sql + "\", \"delete_sql\": \"" + delete_sql + "\"}";
	}

	
	public static void main(String []args) {
		CateDao dao=new CateDao();
	}


	

	


}
