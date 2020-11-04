package project1.ver08;

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
	public String getInfo() {
		return super.getInfo()+String.format("전공:%s 학년:%s\n",Major,grade);
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.print(","+"전공:"+Major+",");
		System.out.print("학년:"+grade);
	}

	
}
