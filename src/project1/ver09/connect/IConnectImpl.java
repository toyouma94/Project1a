package project1.ver09.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IConnectImpl implements IConnect{

	//동적쿼리 처리를 위한 객체
	public PreparedStatement psmt;
	public Statement smt;
	//연결
	public Connection con;
	//결과반환
	public ResultSet rs;
	//기본생성자
	public IConnectImpl() {
		System.out.println("IConnectImpl 기본생성자 호출");
	}
	//인자생성자
	public IConnectImpl(String user,String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			//드라이버로드
			Class.forName(ORACLE_DRIVER);
			//DB연결
			connect(user, pass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	//인자생성자-오버로딩
	public IConnectImpl(String driver,String user,String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			//드라이버로드
			Class.forName(driver);
			//DB연결
			connect(user, pass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	/*
	 오버라이딩의 목적으로 정의한 메소드. 쿼리실행은 각각의 클래스에
	 진행하게 될것임
	 */
	//오라클 DB에 연결
	@Override
	public void connect(String user, String pass) {
		try {
			con=DriverManager.getConnection(ORACLE_URL, user, pass);
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}

	@Override
	public void execute() {
		//하는일 없음
	}
	@Override
	public void close1() {
		try {
			if(con!=null)con.close();
			if(psmt!=null)psmt.close();
			System.out.println("자원 반납 완료");
		}
		catch (Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
	}
	//자원해제
	@Override
	public void close2() {
		try {
			if(con!=null)con.close();
			if(smt!=null)smt.close();
			if(rs!=null)rs.close();
			System.out.println("자원 반납 완료");
		}
		catch (Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
	}
	@Override
	public String scanValue(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	

//	@Override
//	public String scanValue(String title) {
//		
//		Scanner scan=new Scanner(System.in);
//		System.out.println(title+"을(를) 입력(exit->종료):");
//		String inputStr=scan.nextLine();
//		
//		/*
//		 equalsIgnoreCase()
//		 	:equal()메소드와 동일하게 문자열이 같은지 비교하는 메소드로
//		 	다른점은 대소문자를 구분하지 않는다.
//		 */
//		if("EXIT".equalsIgnoreCase(inputStr)) {
//			System.out.println("프로그램을 종료합니다.");
//			close1();//자원해제
//			System.exit(0);//프로그램 자체가 즉시 종료된다.
//		}
//		return inputStr;//입력받은 문자열 반환
//	}
}
