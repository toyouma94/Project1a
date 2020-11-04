package project1.ver06;

import java.util.Scanner;

public class PhoneInfo {
	
	String name;
	String phoneNumber;
	
	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public void PhoneInfo() {
	}
	
	public void showData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름:");
		name=scanner.nextLine();
		System.out.print("전화번호:");
		phoneNumber=scanner.nextLine();
		System.out.println("입력된 정보 출력....");
	}
	
	public void showPhoneInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
	}
	

}
