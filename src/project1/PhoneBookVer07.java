package project1;

import java.net.InterfaceAddress;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver07.PhoneInfo;
import project1.ver07.SubMenuItem;
import project1.ver07.MenuSelectException;
import project1.ver07.Menuitem;
import project1.ver07.PhoneBookManager;

public class PhoneBookVer07 implements Menuitem,SubMenuItem{

	public static void main(String[] args) {

		PhoneBookManager phonebookManager=new PhoneBookManager(100);
		Scanner scanner = new Scanner(System.in);
		
		try {
		while(true) {
			phonebookManager.printMenu();
				int menu=scanner.nextInt();
				if(menu>5 || menu<0) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
				switch (menu) {
				case dataInput:
					while(true) {
					System.out.println("데이터 입력을 시작합니다.");
					System.out.println("1.일반, 2.동창, 3.회사");
					System.out.print("선택>>");
					int choice=scanner.nextInt();
					switch (choice) {
						case normal:
							phonebookManager.dataInput(choice);
							System.out.println();
							break;
						case alumnus:
							phonebookManager.dataInput(choice);
							System.out.println();
							break;
						case company:
							phonebookManager.dataInput(choice);
							System.out.println();
							break;
						}
					System.out.println("데이터 입력이 완료되었습니다.");
					System.out.println();
					break;
					}
					break;
				case dataSearch:
					System.out.println("데이터를 검색합니다.");
					phonebookManager.dataSearch();
					System.out.println();
					break;
				case dataDelete:
					System.out.println("데이터를 삭제합니다.");
					phonebookManager.dataDelete();
					System.out.println();
					break;
				case dataAllShow:
					System.out.println("주소록을 출력합니다.");
					phonebookManager.dataAllShow();
					System.out.println();
					break;
				case Exit:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("1~5사이의 숫자를 입력하세요.");
				}
			}
		}//while 끝
		catch (MenuSelectException e) {
			System.out.println(e.getMessage());
		}
		catch (InputMismatchException e) {	
			System.out.println("aaaa");
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
