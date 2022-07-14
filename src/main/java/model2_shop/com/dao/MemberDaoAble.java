package model2_shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import model2_shop.com.vo.MemberVo;

public interface MemberDaoAble {
	public List<MemberVo> list(int page) throws ClassNotFoundException, SQLException; //������ �������Ʈ 
	public MemberVo detail(String id) throws ClassNotFoundException, SQLException; //������ ����,���� ���� ����������,���� ���� ��������, ȸ������ ajax, ȸ����� ajax
	public MemberVo login(String id,String pw) throws ClassNotFoundException, SQLException; //�α��� ����
	public MemberVo emailCheck(String email) throws ClassNotFoundException, SQLException; //ȸ������ ajax, ������ ȸ����� ajax
	public MemberVo phoneCheck(String phone) throws ClassNotFoundException, SQLException; //ȸ������ ajax, ������ ȸ����� ajax
	public boolean insert(MemberVo mem) throws ClassNotFoundException, SQLException; //ȸ�����, ȸ������
	public boolean update(MemberVo mem) throws ClassNotFoundException, SQLException; //ȸ������, ���� ���� ����
	public boolean delete(String id) throws ClassNotFoundException, SQLException; //ȸ������ => �����ϴ� (�ܷ�Ű�� �����ϴ� ���̺��� ���� ������
}
