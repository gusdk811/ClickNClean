package kr.or.iei.company.model.service;

import kr.or.iei.company.model.vo.Company;

public interface CompanyInfoService {
	
	int insertCompanyInfo(Company co, String coId);

	int updateCompanyInfo(Company co, String coId);

	Company SearchCompanyInfo(String coId);

	

}
