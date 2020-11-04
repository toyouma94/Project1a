package project1.ver05;

public class PhoneCompanyInfo extends PhoneInfo{
	String CompanyName;
	
	public PhoneCompanyInfo(String name, String phoneNumber,String CompanyName) {
		super(name, phoneNumber);
		this.CompanyName=CompanyName;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사명:"+CompanyName);
	}
}
