package project1.ver03;

import java.util.Scanner;

public class PhoneInfo {
	
	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = "입력되지않음";
	}
	public void PhoneInfo() {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	
	public void init(String name, String phoneNumber, String birthday) {
		this.name=name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public void showData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름:");
		name=scanner.nextLine();
		System.out.print("전화번호:");
		phoneNumber=scanner.nextLine();
		System.out.print("생년월일:");
		birthday=scanner.nextLine();
		System.out.println("입력된 정보 출력....");
	}
	
	public void showPhoneInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		System.out.println("생년월일:"+birthday);
	}
	

}
