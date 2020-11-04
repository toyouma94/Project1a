package project1.ver08;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager extends Thread implements SubMenuItem{

	public HashSet<PhoneInfo> PhoneInfos = new HashSet<PhoneInfo>();
//	public int numOfPhoneInfo;
	Scanner scanner = new Scanner(System.in);
	
	public PhoneBookManager() {
//		numOfPhoneInfo = 0;
		try {
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("src/project1/ver08/PhoneBook.obj"));
			PhoneInfos=(HashSet<PhoneInfo>)in.readObject();
			in.close();
		}
		catch (Exception e) {
			System.out.println("저장안됌");
		}
	}
    //입력 : 
   public void dataInput(int choice) {
      String name;
      String phoneNumber;
      String Major ;
      int grade;
      String CompanyName;
      System.out.print("이름:");
      name=scanner.nextLine();
      System.out.print("전화번호:");
      phoneNumber=scanner.nextLine();
         if(choice==normal) {   
            PhoneInfo ph1 =
                  new PhoneInfo(name, phoneNumber);
            boolean a=PhoneInfos.add(ph1);
//            PhoneInfos.add(ph1);
            if(!(a)) {
                  System.out.print("중복데이터발견됨, 덮어쓸까요?(y/n)");
                  String str = scanner.nextLine();
                  if(str.equalsIgnoreCase("y")) {
                        if(!(a)) {
                           PhoneInfos.remove(ph1);
                           PhoneInfos.add(ph1);
                        }
                     System.out.println("덮어쓰기 완료되었습니다.");
                  	}
                  if(str.equalsIgnoreCase("n")) {
                     System.out.println("덮어쓰기 실패하였습니다.");
                  	}
            	}
         	}
         if(choice==alumnus) {   
        	 Scanner scanner = new Scanner(System.in);
            System.out.print("전공:");
            Major=scanner.nextLine();
            System.out.print("학년:");
            grade=scanner.nextInt();
            scanner.nextLine();
            PhoneSchoolInfo  ph2 =
                  new PhoneSchoolInfo (name, phoneNumber,Major,grade);
            boolean b=PhoneInfos.add(ph2);
//            PhoneInfos.add(ph2);
            if(!(b)) {
                  System.out.print("중복데이터발견됨, 덮어쓸까요?(y/n)");
                  String str = scanner.nextLine();
                  if(str.equalsIgnoreCase("y")) {
                        if(!(b)) {
                           PhoneInfos.remove(ph2);
                           PhoneInfos.add(ph2);
                        }
                     System.out.println("덮어쓰기 완료되었습니다.");
                  	}
                  if(str.equalsIgnoreCase("n")) {
                     System.out.println("덮어쓰기 실패하였습니다.");
                  	}
            	}
         	}
         if(choice==company) {   
        	 Scanner scanner = new Scanner(System.in);
            System.out.print("회사:");
            CompanyName=scanner.nextLine();
            PhoneCompanyInfo ph3 =
                  new PhoneCompanyInfo(name, phoneNumber,CompanyName);
            boolean c=PhoneInfos.add(ph3);
//            PhoneInfos.add(ph3);
            if(!(c)) {
                  System.out.print("중복데이터발견됨, 덮어쓸까요?(y/n)");
                  String str = scanner.nextLine();
                  if(str.equalsIgnoreCase("y")) {
                        if(!(c)) {
                           PhoneInfos.remove(ph3);
                           PhoneInfos.add(ph3);
                        }
                     System.out.println("덮어쓰기 완료되었습니다.");
                  	}
                  if(str.equalsIgnoreCase("n")) {
                     System.out.println("덮어쓰기 실패하였습니다.");
                  	}
            	}
         	}
         
      System.out.println("친구정보 입력이 완료되었습니다.");
   	}	

	//검색 : 
	public void dataSearch(){
		System.out.println("데이터를 검색합니다.");
		boolean isFind = false;//검색한 정보가 있는지 확인을 위한 변수
		System.out.print("검색할 이름:");
		String searchName = scanner.nextLine();

		//객체배열에 저장된 친구정보의 갯수만큼 반복
		for(PhoneInfo phoneInfo : PhoneInfos) {			
			
			if(searchName.equals(phoneInfo.name)) {
				phoneInfo.showPhoneInfo();
				System.out.println();
				System.out.println("데이터 검색이 완료되었습니다");
				isFind = true;//찾는 정보가 있다면 true로 변경
			}
		}
		
		if(isFind==false)
			System.out.println("데이터가 없습니다");
		
	}////end of searchInfo
	//삭제 : 
	public void dataDelete(){
		System.out.println("데이터를 삭제합니다.");
		Iterator<PhoneInfo> itr = PhoneInfos.iterator();
		System.out.print("삭제할 이름:");
		String deleteName = scanner.nextLine();
		
		boolean isRemoved = false; 
		
        while(itr.hasNext()) {
     	   PhoneInfo pi = itr.next();
			if(deleteName.equals(pi.name)) {
				itr.remove();
				isRemoved = true;
			}
		}
		if(isRemoved==false) {
			//검색된 데이터가 없어 삭제되지 않았을때...
			System.out.println("==삭제 실패==");
		}
		else {

			System.out.println("==데이터가 삭제되었습니다==");
		}
	}////end of deleteInfo
	
	//메뉴출력 : 
	public void printMenu(){
		System.out.println("===============메뉴를 선택하세요===============");
		System.out.println("1.주소록입력 2.검색 3.삭제 4.출력 5.저장옵션 6.종료");
		System.out.println("==========================================");
		System.out.print("메뉴선택:");
	}
	//주소록전체출력 : 
	public void dataAllShow(){
		System.out.println("==전체정보를 출력함==");
		for(PhoneInfo ph:PhoneInfos) {
			ph.showPhoneInfo();
			System.out.println();
		}
		System.out.println();
		System.out.println("==전체정보가 출력되었습니다==");
	}////end of showAllData
	
	AutoSaverT dt ;
	int save=0;
	public void autoOp() {
		System.out.println("==저장옵션선택==");
		System.out.println("저장옵션을 선택하세요.");
		System.out.println("1.자동저장On, 2.자동저장Off");
		int auto=scanner.nextInt();
		scanner.nextLine();
		
		switch (auto) {
		case 1:
			if(save==1) {
				System.out.println("자동저장이 이미 실행중입니다.");
				break;
			}
			else if(save!=1) {
			System.out.println("자동저장을 시작합니다.");
			dt = new AutoSaverT(this);
			dt.setDaemon(true);
			dt.start();
			save=1;
			break;
			}
		case 2:
			dt.interrupt();
			System.out.println("자동저장을 종료합니다.");
			break;
		}
		
	}
	public void autoSave() throws IOException {
		try {
			
			PrintWriter out = new PrintWriter(
					new FileWriter("src/project1/ver08/AutoSaveBook.txt"));
			for(PhoneInfo phoneInfo : PhoneInfos) {	
				out.printf(phoneInfo.getInfo());
			}
			out.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

}
