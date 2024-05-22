package model_ver1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DAO_ver1 {
	
	public ArrayList<People_DTO> connect() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//List ->
		// List<데이터타입> 변수명 = new ArrayList<>(); o
		// List<데이터타입> 변수명 = new List<>(); x
		// List는 인터페이스 : 객체구현 x
		// ArrayList / LinkedList
		// 빠른탐색에 유리 / 삽입삭제에 유리
		//ArrayList를 List로 구현 후 상위 타입이 List로 업캐스팅해서 사용 => 다형성.
		List<People_DTO> list = new ArrayList<>();
		
		// MVC Model1 방식으로: Logic과 View를 모두 JSP에 작성한다.
		// Model만 따로 뺀다.
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "service";
		String pw = "12345";
		
		// 오라클과 연결할 드라이버 객체 만들기
		try {
			Class.forName(driver);
			
			//지정한 DB와 연결하기 위한 Connection객체 생성하기
			conn = DriverManager.getConnection(url,user, pw);
			
			//실행할 sql문 정의
			String sql="select * from people1";
			
			//쿼리문을 다루기 위한 PrepareStatement 객체만들기.
			ps =conn.prepareStatement(sql);
			
			//insert , update, delete => 테이블에 변화가 있음 -> executeUpdate -> row
			//select => 테이블에 변화x => executeQuery => resultSet반환
			rs=ps.executeQuery();
			
			//
			while(rs.next()) { //next(): 커서를 한 칸씩 움직이고 가리키고 있는 행에 데이터가 있으면 true
				String name = rs.getString(1); //커서가 가리키고 있는 행에 데이터 가져오기.(컬럼순서/컬럼이름)
				String major=rs.getString("major");
				String phone=rs.getString(3);
				
				People_DTO student=new People_DTO(name, major,phone);
				list.add(student);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rs != null) {
					rs.close();
				}else if (ps!=null) {
					ps.close();
				}else if (conn!=null) {
					conn.close();
				}
			}catch (SQLException e) {					
					e.printStackTrace();
				}
			}
		return (ArrayList<People_DTO>) list;
		}						
	}
	