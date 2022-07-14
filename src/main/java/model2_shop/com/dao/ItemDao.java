package model2_shop.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model2_shop.com.vo.ItemVo;

public class ItemDao implements ItemDaoAble{
	private String list_sql="SELECT * FROM ITEM ORDER BY post_time DESC";
	private String detail_sql="SELECT * FROM ITEM WHERE item_num=?";
	private String insert_sql="INSERT INTO ITEM "
			+ "(cate_num, color, count, detail_img, main_img, member_id, model_num, name, price, state, title, sale_time, sale_end_time) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String sale_list_sql="SELECT * FROM ITEM WHERE state=0 && SALE_time>현재날짜"; //실제 사용자가 보는 아이템 리스트
	private String update_sql="UPDATE ITEM SET "
			+ " cate_num=?, "
			+ " price=?, "
			+ " sale_time=?,"
			+ " sale_end_time=?"
			+ " WHERE item_num=? ";
	@Override
	public List<ItemVo> list(int page) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(list_sql);
		ResultSet rs=ps.executeQuery();
		List<ItemVo> item_list=new ArrayList<ItemVo>();
		ItemVo item;
		while(rs.next()) {
			item=new ItemVo();
			item.setItem_num(rs.getInt("item_num"));
			item.setName(rs.getString("name"));
			item.setTitle(rs.getString("title"));
			item.setCount(rs.getInt("count"));
			item.setPrice(rs.getInt("price"));
			item.setColor(rs.getString("color"));
			item.setMain_img(rs.getString("main_img"));
			item.setDetail_img(rs.getString("detail_img"));
			item.setModel_num(rs.getString("model_num"));
			item.setMember_id(rs.getString("member_id"));
			item.setPost_time(rs.getTimestamp("post_time"));
			item.setSale_time(rs.getTimestamp("sale_time"));
			item.setSale_end_time(rs.getTimestamp("sale_end_time"));
			item.setState(rs.getByte("state"));
			item.setCate_num(rs.getInt("cate_num"));
			item_list.add(item);
		}
		return item_list;
	}
	@Override
	public ItemVo detail(int item_num) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(detail_sql);
		ps.setInt(1, item_num);
		ResultSet rs=ps.executeQuery(); //(primary키로 검색해서)1개만 넘어오지만 (mysql은 몇개가 오는지 몰라서) 무조건 배열타입
		ItemVo item=new ItemVo();
		if(rs.next()) {
			item.setItem_num(rs.getInt("item_num"));
			item.setName(rs.getString("name"));
			item.setTitle(rs.getString("title"));
			item.setCount(rs.getInt("count"));
			item.setPrice(rs.getInt("price"));
			item.setColor(rs.getString("color"));
			item.setMain_img(rs.getString("main_img"));
			item.setDetail_img(rs.getString("detail_img"));
			item.setModel_num(rs.getString("model_num"));
			item.setMember_id(rs.getString("member_id"));
			item.setPost_time(rs.getTimestamp("post_time"));
			item.setSale_time(rs.getTimestamp("sale_time"));
			item.setSale_end_time(rs.getTimestamp("sale_end_time"));
			item.setState(rs.getByte("state"));
			item.setCate_num(rs.getInt("cate_num"));
		}
		return item;
	}
	@Override
	public boolean insert(ItemVo item) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(insert_sql);
		ps.setInt(1, item.getCate_num());
		ps.setString(2, item.getColor());
		ps.setInt(3, item.getCount());
		ps.setString(4, item.getDetail_img());
		ps.setString(5, item.getMain_img());
		ps.setString(6, item.getMember_id());
		ps.setString(7, item.getModel_num());
		ps.setString(8, item.getName());
		ps.setInt(9, item.getPrice());
		ps.setByte(10, item.getState());
		ps.setString(11, item.getTitle());
		ps.setTimestamp(12, item.getSale_time());
		ps.setTimestamp(13, item.getSale_end_time());
		int insert=ps.executeUpdate();
		if(insert>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean update(ItemVo item) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(update_sql);
		ps.setInt(1, item.getCate_num());
		ps.setInt(2, item.getPrice());
		ps.setTimestamp(3, item.getSale_time());
		ps.setTimestamp(4, item.getSale_end_time());
		ps.setInt(5, item.getItem_num());
		int update=ps.executeUpdate();
		if(update>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean delete(int item_num) throws ClassNotFoundException, SQLException {
		String delete_sql="DELETE FROM ITEM WHERE item_num=?";
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(delete_sql);
		ps.setInt(1, item_num);
		int delete=ps.executeUpdate();
		if(delete==1) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean delete(int[] item_num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<ItemVo> list(int page, String writer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ItemVo detail(int item_num, String writer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean delete(int item_num, String writer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(int[] item_num, String writer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<ItemVo> sale_list(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		try {
			//System.out.println(new ItemDao().list(0));
			System.out.println(new ItemDao().detail(1004));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
