package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager implements SubMenuItem{

	private HashSet<PhoneInfo> PhoneInfos = new HashSet<PhoneInfo>();
	Scanner scanner = new Scanner(System.in);
//	private int numOfPhoneInfo;
	
	public PhoneBookManager(int num) {
//		numOfPhoneInfo = 0;
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
              	  Scanner scanner = new Scanner(System.in);
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
            System.out.print("전공:");
            Major=scanner.nextLine();
            System.out.print("학년:");
            grade=scanner.nextInt();
            PhoneSchoolInfo  ph2 =
                  new PhoneSchoolInfo (name, phoneNumber,Major,grade);
            boolean b=PhoneInfos.add(ph2);
//            PhoneInfos.add(ph2);
            if(!(b)) {
                  System.out.print("중복데이터발견됨, 덮어쓸까요?(y/n)");
              	  Scanner scanner = new Scanner(System.in);
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
            System.out.print("회사:");
            Scanner scanner = new Scanner(System.in);
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
		boolean isFind = false;//검색한 정보가 있는지 확인을 위한 변수
		System.out.print("검색할 이름:");
		String searchName = scanner.nextLine();

		//객체배열에 저장된 친구정보의 갯수만큼 반복
		for(PhoneInfo phoneInfo : PhoneInfos) {			
			
			if(searchName.equals(phoneInfo.name)) {
				phoneInfo.showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다");
				isFind = true;//찾는 정보가 있다면 true로 변경
			}
		}
		
		if(isFind==false)
			System.out.println("데이터가 없습니다");
		
	}////end of searchInfo
	//삭제 : 
	public void dataDelete(){
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
		System.out.println("선택하세요....");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("선택:");
	}
	//주소록전체출력 : 
	public void dataAllShow(){
		for(PhoneInfo ph:PhoneInfos) {
			ph.showPhoneInfo();
			System.out.println("==전체정보가 출력되었습니다==");
		}
	}////end of showAllData
}
