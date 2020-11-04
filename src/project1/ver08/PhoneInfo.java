package project1.ver08;

import java.io.Serializable;
import java.util.Scanner;

public class PhoneInfo implements Serializable {
	
	String name;
	String phoneNumber;
	
	
	
	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getInfo() {
		return String.format("이름:%s 전화번호:%s\n",name,phoneNumber);
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
		System.out.print("이름:"+name+",");
		System.out.print("전화번호:"+phoneNumber);
	}
	
	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		return hc1;	
	}
	@Override
	public boolean equals(Object obj) {
		
		PhoneInfo phoneInfos = (PhoneInfo)obj;		
		if(this.name.equals(phoneInfos.name)){
			return true;
		}
		else {
			return false;
		}
	}
}
