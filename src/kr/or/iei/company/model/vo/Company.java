package kr.or.iei.company.model.vo;

import java.sql.Date;

public class Company {
	private int coNo;
	private String coId;
	private String coName;
	private String coPwd;
	private String phone;
	private String ceoName;
	private String email;
	private String busNum;
	private String address;
	private Date enrollDate;
	private int team;
	private int career;
	private String grade;
	private char sign_YN;
	private char end_YN;
	private String logo;
	private String coInfo;
	private String meetHour;
	private String workHour;
	private String area;
	private String cleanType;
	private int price;
	private String tel;
	private String roll;
	private int sumScore;
	private int reviewNum;
	
	


	public Company(int coNo, String coId, String coName, String coPwd, String phone, String ceoName, String email,
			String busNum, String address, Date enrollDate, int team, int career, String grade, char sign_YN,
			char end_YN, String logo, String coInfo, String meetHour, String workHour, String area, String cleanType,
			int price, String tel, String roll, int sumScore, int reviewNum) {
		super();
		this.coNo = coNo;
		this.coId = coId;
		this.coName = coName;
		this.coPwd = coPwd;
		this.phone = phone;
		this.ceoName = ceoName;
		this.email = email;
		this.busNum = busNum;
		this.address = address;
		this.enrollDate = enrollDate;
		this.team = team;
		this.career = career;
		this.grade = grade;
		this.sign_YN = sign_YN;
		this.end_YN = end_YN;
		this.logo = logo;
		this.coInfo = coInfo;
		this.meetHour = meetHour;
		this.workHour = workHour;
		this.area = area;
		this.cleanType = cleanType;
		this.price = price;
		this.tel = tel;
		this.roll = roll;
		this.sumScore = sumScore;
		this.reviewNum = reviewNum;
	}



	public int getSumScore() {
		return sumScore;
	}



	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}



	public int getReviewNum() {
		return reviewNum;
	}



	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}



	public String getRoll() {
		return roll;
	}



	public void setRoll(String roll) {
		this.roll = roll;
	}



	public String getCleanType() {
		return cleanType;
	}
	
	

	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public void setCleanType(String cleanType) {
		this.cleanType = cleanType;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Date getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}



	public Company() {
		super();
	}
	public int getCoNo() {
		return coNo;
	}
	public void setCoNo(int coNo) {
		this.coNo = coNo;
	}
	public String getCoId() {
		return coId;
	}
	public void setCoId(String coId) {
		this.coId = coId;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getCoPwd() {
		return coPwd;
	}
	public void setCoPwd(String coPwd) {
		this.coPwd = coPwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBusNum() {
		return busNum;
	}
	public void setBusNum(String busNum) {
		this.busNum = busNum;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	public int getCareer() {
		return career;
	}
	public void setCareer(int career) {
		this.career = career;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public char getSign_YN() {
		return sign_YN;
	}
	public void setSign_YN(char sign_YN) {
		this.sign_YN = sign_YN;
	}
	public char getEnd_YN() {
		return end_YN;
	}
	public void setEnd_YN(char end_YN) {
		this.end_YN = end_YN;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getCoInfo() {
		return coInfo;
	}
	public void setCoInfo(String coInfo) {
		this.coInfo = coInfo;
	}
	public String getMeetHour() {
		return meetHour;
	}
	public void setMeetHour(String meetHour) {
		this.meetHour = meetHour;
	}
	public String getWorkHour() {
		return workHour;
	}
	public void setWorkHour(String workHour) {
		this.workHour = workHour;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
