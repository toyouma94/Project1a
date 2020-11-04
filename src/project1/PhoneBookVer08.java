package project1;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InterfaceAddress;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.PhoneInfo;
import project1.ver08.SubMenuItem;
import project1.ver08.AutoSaverT;
import project1.ver08.MenuSelectException;
import project1.ver08.Menuitem;
import project1.ver08.PhoneBookManager;

public class PhoneBookVer08 implements Menuitem,SubMenuItem{

	public static void main(String[] args) throws IOException{


		PhoneBookManager phonebookManager=new PhoneBookManager();

		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
			phonebookManager.printMenu();
				int menu=scanner.nextInt();
				if(menu>6 || menu<0) {
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
					phonebookManager.dataSearch();
					System.out.println();
					break;
				case dataDelete:
					phonebookManager.dataDelete();
					System.out.println();
					break;
				case dataAllShow:
					phonebookManager.dataAllShow();
					System.out.println();
					break;
				case saveOption:
					phonebookManager.autoOp();
					System.out.println();
					break;
				case Exit:
					try {
						ObjectOutputStream out=new ObjectOutputStream(
								new FileOutputStream("src/project1/ver08/PhoneBook.obj"));
						out.writeObject(phonebookManager.PhoneInfos);
						System.out.println("PhoneBook.obj 가 생성되었습니다");
						out.close();
					}
					catch (Exception e) {
						System.out.println("저장되었습니다");
					}
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}
			catch (MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			catch (InputMismatchException e) {	
				System.out.println("문자열입력은 불가합니다");
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}//while 끝
	}
		
}
