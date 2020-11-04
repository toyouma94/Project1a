package project1.ver08;

public class PhoneCompanyInfo extends PhoneInfo{
	String CompanyName;
	
	public PhoneCompanyInfo(String name, String phoneNumber,String CompanyName) {
		super(name, phoneNumber);
		this.CompanyName=CompanyName;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getInfo() {
		return super.getInfo()+String.format("회사명:%s", CompanyName);
	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.print(","+"회사명:"+CompanyName);
	}
}
