package kr.or.iei.contract.model.vo;

import java.sql.Date;

public class Contract {

	private int contractNo;
	private int conditionNo;
	private String userId;
	private String coId;
	private int price;
	private char reqContractYN;
	private Date reqContractDate;
	private char coCheckYN;
	private Date coCheckDate;
	private char contractYN;
	private Date contractFinDate;
	private char cleanYN;
	private Date cleanDate;
	private String cleanType;
	private String houseType;
	private String area;
	private int houseSize;
	private Date reqDate;
	
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(int contractNo, int conditionNo, String userId, String coId, int price, char reqContractYN,
			Date reqContractDate, char coCheckYN, Date coCheckDate, char contractYN, Date contractFinDate, char cleanYN,
			Date cleanDate) {
		super();
		this.contractNo = contractNo;
		this.conditionNo = conditionNo;
		this.userId = userId;
		this.coId = coId;
		this.price = price;
		this.reqContractYN = reqContractYN;
		this.reqContractDate = reqContractDate;
		this.coCheckYN = coCheckYN;
		this.coCheckDate = coCheckDate;
		this.contractYN = contractYN;
		this.contractFinDate = contractFinDate;
		this.cleanYN = cleanYN;
		this.cleanDate = cleanDate;
	}

	public Contract(int conditionNo, String userId, String cleanType, String houseType, String area, int houseSize,
			Date reqDate) {
		super();
		this.conditionNo = conditionNo;
		this.userId = userId;
		this.cleanType = cleanType;
		this.houseType = houseType;
		this.area = area;
		this.houseSize = houseSize;
		this.reqDate = reqDate;
	}

	public int getContractNo() {
		return contractNo;
	}

	public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}

	public int getConditionNo() {
		return conditionNo;
	}

	public void setConditionNo(int conditionNo) {
		this.conditionNo = conditionNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public char getReqContractYN() {
		return reqContractYN;
	}

	public void setReqContractYN(char reqContractYN) {
		this.reqContractYN = reqContractYN;
	}

	public Date getReqContractDate() {
		return reqContractDate;
	}

	public void setReqContractDate(Date reqContractDate) {
		this.reqContractDate = reqContractDate;
	}

	public char getCoCheckYN() {
		return coCheckYN;
	}

	public void setCoCheckYN(char coCheckYN) {
		this.coCheckYN = coCheckYN;
	}

	public Date getCoCheckDate() {
		return coCheckDate;
	}

	public void setCoCheckDate(Date coCheckDate) {
		this.coCheckDate = coCheckDate;
	}

	public char getContractYN() {
		return contractYN;
	}

	public void setContractYN(char contractYN) {
		this.contractYN = contractYN;
	}

	public Date getContractFinDate() {
		return contractFinDate;
	}

	public void setContractFinDate(Date contractFinDate) {
		this.contractFinDate = contractFinDate;
	}

	public char getCleanYN() {
		return cleanYN;
	}

	public void setCleanYN(char cleanYN) {
		this.cleanYN = cleanYN;
	}

	public Date getCleanDate() {
		return cleanDate;
	}

	public void setCleanDate(Date date) {
		this.cleanDate = date;
	}

	public String getCleanType() {
		return cleanType;
	}

	public void setCleanType(String cleanType) {
		this.cleanType = cleanType;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getHouseSize() {
		return houseSize;
	}

	public void setHouseSize(int houseSize) {
		this.houseSize = houseSize;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	@Override
	public String toString() {
		return "Contract [contractNo=" + contractNo + ", conditionNo=" + conditionNo + ", userId=" + userId + ", coId="
				+ coId + ", price=" + price + ", reqContractYN=" + reqContractYN + ", reqContractDate="
				+ reqContractDate + ", coCheckYN=" + coCheckYN + ", coCheckDate=" + coCheckDate + ", contractYN="
				+ contractYN + ", contractFinDate=" + contractFinDate + ", cleanYN=" + cleanYN + ", cleanDate="
				+ cleanDate + ", cleanType=" + cleanType + ", houseType=" + houseType + ", area=" + area
				+ ", houseSize=" + houseSize + ", reqDate=" + reqDate + "]";
	}
	
	
}
