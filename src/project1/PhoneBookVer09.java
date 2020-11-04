package project1;

import java.util.Scanner;

import project1.ver09.PhoneInfo;
import project1.ver09.PhoneBookManager;

public class PhoneBookVer09 {

	public static void main(String[] args) {

		
		PhoneBookManager phonebookManager=new PhoneBookManager(100);
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			phonebookManager.printMenu();
				
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("데이터 입력을 시작합니다.");
				phonebookManager.dataInput(choice);
				System.out.println();
				break;
			case 2:
				System.out.println("데이터를 검색합니다.");
				phonebookManager.dataSearch();
				System.out.println();
				break;
			case 3:
				System.out.println("데이터를 삭제합니다.");
				phonebookManager.dataDelete();
				System.out.println();
				break;
			case 4:
				System.out.println("주소록을 출력합니다.");
				phonebookManager.dataAllShow();
				System.out.println();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("1~5사이의 숫자를 입력하세요.");
			}
		}//while 끝
	}

}
