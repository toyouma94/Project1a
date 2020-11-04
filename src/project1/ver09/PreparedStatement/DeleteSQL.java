package project1.ver09.PreparedStatement;

import project1.ver09.connect.IConnectImpl;

public class DeleteSQL extends IConnectImpl{

	String name;
	public DeleteSQL(String name) {
		super(ORACLE_DRIVER,"kosmo","1234");
		this.name=name;
	}
	@Override
	public void execute() {
		try {
			//1.쿼리문준비
			String query=" DELETE FROM phonebook_tb WHERE name=? ";
			//2.prepared객체생성
			psmt=con.prepareStatement(query);
			//3.사용자로부터 입력받은값을 인파라미터로 설정
//			psmt.setString(1,scanValue("삭제할이름"));
			psmt.setString(1, name);
			//4.쿼리실행
			System.out.println(psmt.execute()+"행이 삭제되었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close1();
		}
	}
//	public static void main(String[] args) {
//		new DeleteSQL().execute();
//	}

}
