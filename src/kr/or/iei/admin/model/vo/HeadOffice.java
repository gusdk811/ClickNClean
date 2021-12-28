package kr.or.iei.admin.model.vo;

public class HeadOffice {

	private String busNum;
	private String ceoName;
	private String coName;
	private String address;
	private String busType;
	private String siteName;
	private String siteUrl;
	private String siteTel;

	
	
	public HeadOffice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeadOffice(String busNum, String ceoName, String coName, String address, String busType, String siteName,
			String siteUrl, String siteTel) {
		super();
		this.busNum = busNum;
		this.ceoName = ceoName;
		this.coName = coName;
		this.address = address;
		this.busType = busType;
		this.siteName = siteName;
		this.siteUrl = siteUrl;
		this.siteTel = siteTel;
	}
	@Override
	public String toString() {
		return "HeadOffice [busNum=" + busNum + ", ceoName=" + ceoName + ", coName=" + coName + ", address=" + address
				+ ", busType=" + busType + ", siteName=" + siteName + ", siteUrl=" + siteUrl + ", siteTel=" + siteTel
				+ "]";
	}
	public String getBusNum() {
		return busNum;
	}
	public void setBusNum(String busNum) {
		this.busNum = busNum;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteUrl() {
		return siteUrl;
	}
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	public String getSiteTel() {
		return siteTel;
	}
	public void setSiteTel(String siteTel) {
		this.siteTel = siteTel;
	}
	
	
	
}
