package model2_shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import model2_shop.com.vo.MemberVo;

public interface MemberDaoAble {
	public List<MemberVo> list(int page) throws ClassNotFoundException, SQLException; //관리자 멤버리스트 
	public MemberVo detail(String id) throws ClassNotFoundException, SQLException; //관리자 수정,개인 정보 수정페이지,개인 정보 상세페이지, 회원가입 ajax, 회원등록 ajax
	public MemberVo login(String id,String pw) throws ClassNotFoundException, SQLException; //로그인 구현
	public MemberVo emailCheck(String email) throws ClassNotFoundException, SQLException; //회원가입 ajax, 관리자 회원등록 ajax
	public MemberVo phoneCheck(String phone) throws ClassNotFoundException, SQLException; //회원가입 ajax, 관리자 회원등록 ajax
	public boolean insert(MemberVo mem) throws ClassNotFoundException, SQLException; //회원등록, 회원가입
	public boolean update(MemberVo mem) throws ClassNotFoundException, SQLException; //회원수정, 개인 정보 수정
	public boolean delete(String id) throws ClassNotFoundException, SQLException; //회원삭제 => 위험하다 (외래키로 참조하는 테이블이 많기 때문에
}
