package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void main(String[] args) {

		PhoneInfo phoneInfo = new PhoneInfo();
		Scanner scanner = new Scanner(System.in);


		while(true) {
			System.out.println("선택하세요....");
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램 종료");
			System.out.print("선택:");
			
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:
				phoneInfo.showData();
				System.out.println();
				phoneInfo.showPhoneInfo();
				System.out.println();
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("1~2사이의 숫자를 입력하세요.");
			}
		}//while 끝
	}

}
