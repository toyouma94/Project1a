package project1.ver09.Statement;

import java.sql.SQLException;
import java.sql.Statement;

import project1.ver09.connect.IConnectImpl;

public class SelectQuery extends IConnectImpl{

	String name;
	public SelectQuery(String name) {
		super(ORACLE_DRIVER,"kosmo","1234");
		this.name=name;
	}
/*
 ResultSet클래스
 	:select문 실행시 쿼리의 실행결과가 resultSet객체에 저장된다.
 	결과로 반환된 레코드의 처음부터 마지막까지 next()메소드를 통해
 	확인 후 반복하면서 추출하게된다.
 	-getXXX()계열의 메소드
 	오라클의 자료형이
 		number타입:getInt()
 		char/vatchar2타입:getString()
 			->오라클 자료형에 상관없이 모든타입을 추출할 수 있다.
 		date타입:getDate()
 		메소드로 각 컬럼의 데이터를 추출한다.
 	-인자는 select절의 컬럼순서대로 인덱스(1부터시작)를 사용하거나
 	컬럼명을 사용할 수 있다.
 */
	public void execute() {
		try {
			smt=(Statement) con.createStatement();
			
			String query = " SELECT name, phoneNumber, birthday FROM phonebook_tb"
					+ " WHERE name "
					+ " LIKE '%" +name+ "%'";
			
			
			rs=smt.executeQuery(query);
			while(rs.next()) {
				String name=rs.getString("name");
				String phoneNumber=rs.getString("phoneNumber");
				String birthday=rs.getString("birthday");
				/*
				 오라클의 date타입을 getDate()로 추출하면 0000-00-00
				 형태로 출력된다.이 경우 date형 자료가 되기 때문에
				 java.sql.Date클래스의 참조변수로 저장해야한다.
				 */
//				java.sql.Date regidate=rs.getDate("regidate");
				/*
				 오라클의 date타입을 getString()으로 추출하면
				 0000-00-00 00:00:00형태로 시간까지 출력할 수 있다.
				 만약 문자열을 잘라서 출력하고 싶다면 substring()을 사용한다.
				 */
//				String regidate1=rs.getString("name");
//				String regidate2=rs.getString("regidate").substring(0,13);
//				String regidate3=rs.getString("d1");//별칭을 그대로 사용
						
				System.out.printf("%s %s %s\n",name
						,phoneNumber,birthday);
				System.out.println("쿼리 반환");
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리오류 발생");
			e.printStackTrace();
		}
		finally {
			close2();
		}
	}
//	public static void main(String[] args) {
//		SelectQuery selectSQL1=new SelectQuery();
//		selectSQL1.execute();
//	}

}
