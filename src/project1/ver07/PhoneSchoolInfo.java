package project1.ver07;

public class PhoneSchoolInfo extends PhoneInfo{
	String Major;
	int grade;
	public PhoneSchoolInfo(String name, String phoneNumber,String Major,int grade) {
		super(name, phoneNumber);
		this.Major = Major;
		this.grade=grade;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("전공:"+Major);
		System.out.println("학년:"+grade);
	}

}
