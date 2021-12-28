package kr.or.iei.admin.model.service;

import java.util.ArrayList;

import kr.or.iei.admin.model.vo.Admin;
import kr.or.iei.admin.model.vo.HeadOffice;

public interface AdminService {

	Admin selectOneUser(String adminId, String adminPwd);

	ArrayList<Admin> adminAccount();

	ArrayList<HeadOffice> headOffice();

}
