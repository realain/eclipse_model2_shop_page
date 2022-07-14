package model2_shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import model2_shop.com.vo.ItemVo;

public interface ItemDaoAble {
//////////////////////////������///////////////////////////
	public List<ItemVo> list(int page) throws ClassNotFoundException, SQLException; //������ ������ ����Ʈ, ��ǰ ����Ʈ(����), ��ٱ���(����)
	public ItemVo detail(int item_num) throws ClassNotFoundException, SQLException; //������ ������ ����������, ��ǰ ��(����)
	public boolean insert(ItemVo item) throws ClassNotFoundException, SQLException; //������ ������ ���
	public boolean update(ItemVo item) throws ClassNotFoundException, SQLException; //������ ������ ����
	public boolean delete(int item_num) throws ClassNotFoundException, SQLException; //������ ������ ���� => ���� �ܷ�Ű�� �����ϴ� ���̺��� ���� ������
	public boolean delete(int [] item_num) throws ClassNotFoundException, SQLException; //������ ������ ���� (�迭)
//////////////////////////�Ǹ���//////////////////////////
	public List<ItemVo> list(int page,String writer) throws ClassNotFoundException, SQLException; //������ ������ ����Ʈ, ��ǰ ����Ʈ(����), ��ٱ���(����)
	public ItemVo detail(int item_num,String writer) throws ClassNotFoundException, SQLException; //�Ǹ��� ������ ����������, ��ǰ ��(����)
	public boolean delete(int item_num,String writer) throws ClassNotFoundException, SQLException; //�Ǹ��� ������ ���� => ���� �ܷ�Ű�� �����ϴ� ���̺��� ���� ������
	public boolean delete(int [] item_num,String writer) throws ClassNotFoundException, SQLException; //�Ǹ��� ������ ���� (�迭)
////////////////////////��ٱ���//////////////////////////
	public List<ItemVo> sale_list(int page) throws ClassNotFoundException, SQLException; //��ǰ ����Ʈ(����) //�Ǹ� �Ⱓ ���ǹ� �ʿ� (���� �Ǹ����� �͸� ���)
	
}
