package schedulerforme.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScheModelDAO {
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "student";
	private final String PASSWORD = "student";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	public List<Schedule> loadAll() {
		List<Schedule> scheList = null;
		Schedule schedule = null;
		String sql = "SELECT * FROM SCHEDULER_TBL";
		try {
			//SELECT * FROM SCHEDULE_TBL;
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			scheList = new ArrayList<Schedule>();
			while(rset.next()) {
				schedule = new Schedule();   
				schedule.setScheTitle(rset.getNString(1));
				schedule.setScheDeadline(rset.getInt(2));
				schedule.setScheOfficialCheck(rset.getNString(3));
				schedule.setScheTodo(rset.getNString(4));
				schedule.setScheWithWhom(rset.getNString(5));
				schedule.setScheToWhere(rset.getNString(6));
				schedule.setScheSysdate(rset.getString(7));
				scheList.add(schedule);
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scheList;
	}
	
	
	public int upLoadOne(Schedule schedule) {
		String sql = "INSERT INTO SCHEDULER_TBL VALUES(?,?,?,?,?,?,DEFAULT)";
		//INSERT INTO SCHEDULER_TBL VALUES(?,?,?,?,?,?,DEFAULT);
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getScheTitle());
			pstmt.setInt(2, schedule.getScheDeadline());
			pstmt.setString(3, schedule.getScheOfficialCheck());
			pstmt.setString(4, schedule.getScheTodo());
			pstmt.setString(5, schedule.getScheWithWhom());
			pstmt.setString(6, schedule.getScheToWhere());
			
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public List<Schedule> loadSome(int scheDate) {
		List<Schedule> scheList = null;
		String sql = "SELECT * FROM SCHEDULER_TBL WHERE SCHE_DEADLINE = ?";
		//SELECT *
		//FROM SCHEDULER_TBL
		//WHERE SCHE_DEADLINE = ?
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scheDate);
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()) {
				Schedule schedule = new Schedule();   
				schedule.setScheTitle(rset.getString(1));
				schedule.setScheDeadline(rset.getInt(2));
				schedule.setScheOfficialCheck(rset.getString(3));
				schedule.setScheTodo(rset.getString(4));
				schedule.setScheWithWhom(rset.getString(5));
				schedule.setScheToWhere(rset.getString(6));
				schedule.setScheSysdate(rset.getString(7));
				scheList.add(schedule);
			}
			conn.close();
			rset.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scheList;
		
	}
	
	
	
	
	
	
	
	
	
	
}
