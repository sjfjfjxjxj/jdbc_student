package kom.kh.jdbc.day03.citizen.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kom.kh.jdbc.day03.citizen.model.vo.Citizen;

public class CitizenDAO {
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "student";
	String PASSWORD = "student";
	
    public List<Citizen> recieveAll() {
    	String sql = "SELECT * FROM CITIZEN_TBL";
    	
    	//SELECT * FROM CITIZEN_TBL
    	try {
			Class.forName("oracle.jdbc.driver.Oracledriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			List<Citizen> cList = new ArrayList<Citizen>(); //어레이리스트:하나가 갖고있는 정보들, 리스트: 여러개가 갖고있는 정보들
			while(rset.next()) {
				Citizen citizen = new Citizen();
				citizen.setCitizenId(rset.getString(1));
				citizen.setCitizenPwd(rset.getString(2));
				citizen.setCitizenName(rset.getString(3));
				citizen.setCitizenGender(rset.getString(4));
				citizen.setCitizenAge(rset.getInt(5));
				citizen.setCitizenPhone(rset.getNString(6));
				citizen.setCitizenAddress(rset.getString(7));
				citizen.setCitizenDate(rset.getTimestamp(8));
				cList.add(citizen);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return cList;
    }
    
    public Citizen selectOneById(String citizenId) {
    	String sql = "";
    	Citizen citizen = null;
    	try {
			Class.forName("jdbc.oracle.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				Citizen citizen = new Citizen();
				stmt.setCitizenId(rset.getString("CITIZEN_ID"));
			}
			rset.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return citizen;
    }
    
    public int insertCitizen(Citizen citizen) {
    	int result = 0;
    	String sql = "";
    	try {
			Class.forName("jdbc.oracle.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, citizen.getCitizenId());
			
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
    
}
