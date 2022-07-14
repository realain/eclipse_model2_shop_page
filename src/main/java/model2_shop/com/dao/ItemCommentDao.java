package model2_shop.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model2_shop.com.vo.ItemCommentVo;

public class ItemCommentDao implements ItemCommentDaoAble{

	@Override
	public List<ItemCommentVo> list(int item_num, int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemCommentVo detail(int comment_num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(ItemCommentVo Vo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ItemCommentVo Vo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int comment_num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteItemNum(int item_num) throws ClassNotFoundException, SQLException {
		String deleteItemNumSql="DELETE FROM ITEM_COMMENT WHERE item_num=?";
		Connection conn=ShopConnention.getConnection();
		PreparedStatement ps=conn.prepareStatement(deleteItemNumSql);
		ps.setInt(1, item_num);
		int del=ps.executeUpdate();
		return del;
	}
	
}
