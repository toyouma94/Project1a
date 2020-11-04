package project1.ver03;

import java.util.Scanner;


public class PhoneBookManager {

	private PhoneInfo[] PhoneInfo;
	private int numOfPhoneInfo;
	
	public PhoneBookManager(int num) {
 		PhoneInfo = new PhoneInfo[num];
		numOfPhoneInfo = 0;
	}
		//입력 : 
	public void dataInput(int choice) {
		String name;
		String phoneNumber;
		String birthday;
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름:");
		name=scanner.nextLine();
		System.out.print("전화번호:");
		phoneNumber=scanner.nextLine();
		System.out.print("생년월일:");
		birthday=scanner.nextLine();
			if(choice==1) {	
				PhoneInfo ph =
						new PhoneInfo(name, phoneNumber, birthday);
				PhoneInfo[numOfPhoneInfo++] = ph;
			}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}

	//검색 : 
	public void dataSearch(){
		boolean isFind = false;//검색한 정보가 있는지 확인을 위한 변수
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름:");
		String searchName = scan.nextLine();

		//객체배열에 저장된 친구정보의 갯수만큼 반복
		for(int i=0 ; i<numOfPhoneInfo ; i++) {			
			
			if(searchName.compareTo(PhoneInfo[i].name)==0) {
				PhoneInfo[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다");
				isFind = true;//찾는 정보가 있다면 true로 변경
			}
		}
		
		if(isFind==false)
			System.out.println("데이터가 없습니다");
		
	}////end of searchInfo
	//삭제 : 
	public void dataDelete(){
		Scanner scan = new Scanner(System.in);
		System.out.print("이름:");
		String deleteName = scan.nextLine();
		
		/*
		배열의 요소중 삭제된 요소의 인덱스값을 저장할 용도의 변수.
		요소를 삭제한 후 빈자리를 채워넣을때 사용할것임.
		 */
		int deleteIndex = -1;//배열의 index이므로 초기값은 -1로 설정

		for(int i=0 ; i<numOfPhoneInfo ; i++) {
			if(deleteName.compareTo(PhoneInfo[i].name)==0) {
				//요소를 삭제하기 위해 null값으로 변경
				PhoneInfo[i] = null;
				//삭제된 요소의 index를 저장
				deleteIndex = i;
				//전체카운트를 -1 차감
				numOfPhoneInfo--;
			}
		}

		if(deleteIndex==-1) {
			//검색된 데이터가 없어 삭제되지 않았을때...
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			/*
			객체배열에서 검색된 요소를 삭제한 후 입력된 위치의 바로뒤 요소를
			앞으로 하나씩 교환한다. 
			 */
			for(int i=deleteIndex ; i<numOfPhoneInfo ; i++) {
				PhoneInfo[i] = PhoneInfo[i+1];
			}
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
		for(int i=0 ; i<numOfPhoneInfo ; i++) {
			PhoneInfo[i].showPhoneInfo();
			System.out.println();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}////end of showAllData
}
