package project1.ver09.PreparedStatement;
import project1.ver09.connect.IConnectImpl;

public class InsertSQL extends IConnectImpl{
	String name;
	String phoneNumber; 
	String birthday;
	
	public InsertSQL(String name,String phoneNumber,String birthday) {
		super(ORACLE_DRIVER,"kosmo","1234");
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.birthday=birthday;
	}
	@Override
	public void execute() {
		try {
			//1.쿼리문 준비:값의 세팅이 필요한 부분을?(인파라미터)로 대체한다.
			String query= "INSERT INTO phonebook_tb VALUES (seq_phonebook.nextval, ?, ?, ?)";
			//2.prepared객체생성:생성시 준비한 쿼리문을 인자로 전달한다.
			psmt=con.prepareStatement(query);
			//3.DB에 입력할 값을 사용자로부터 입력받음.
//			Scanner scan=new Scanner(System.in);
//			System.out.println("이름:");
//			String name=scan.nextLine();
//			System.out.println("전화번호:");
//			String phonenumber=scan.nextLine();
//			System.out.println("생일:");
//			String birthday=scan.nextLine();
			//4.인파라미터 설정:?의 순서대로 설정하고 DB이므로 인덱스는 1부터 시작
			/*
			 	인파라미터 설정시 사용하는 메소드
			 	자료형이
			 		숫자면setInt()
			 		문자면setString()
			 		날짜면setDate()를 사용한다.
			 	해당 setXXX()메소드를 사용하면'(싱글쿼테이션)은 자동으로 삽입된다.
			 */
			psmt.setString(1, name);
			psmt.setString(2, phoneNumber);
			psmt.setString(3, birthday);
			//날짜를 문자열로 입력하는 경우
			//psmt.setString(4, "2018-11-20");
			
			//5.쿼리실행을 위해 prepared객체를 실행한다.
			int affected=psmt.executeUpdate();
			System.out.println(affected+"행이 입력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close1();
		}
	}
//	public static void main(String[] args) {
//		new InsertSQL().execute();
//	}

}
