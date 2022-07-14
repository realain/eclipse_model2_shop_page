package model2_shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import model2_shop.com.vo.CateVo;

public interface CateDaoable {
	public List<CateVo> list() throws ClassNotFoundException, SQLException;
	public CateVo detail(int cate_num) throws ClassNotFoundException, SQLException; 
	public boolean insert(CateVo cate) throws ClassNotFoundException, SQLException;
	public boolean update(CateVo cate) throws ClassNotFoundException, SQLException;
	public boolean delete(String cate_num) throws ClassNotFoundException, SQLException;
	
}
