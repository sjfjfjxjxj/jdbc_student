package kom.kh.jdbc.day03.citizen.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
    	Citizen citizen = null;
    	//SELECT * FROM CITIZEN_TBL
    	try {
			Class.forName("oracle.jdbc.driver.Oracledriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			List<Citizen> cList = new ArrayList<Citizen>(); //어레이리스트:하나가 갖고있는 정보들, 리스트: 여러개가 갖고있는 정보들
			while(rset.next()) {
				citizen.setCitizenId(rset.getNString(1));
				citizen.setCitizenPwd(rset.getNString(2));
				citizen.setCitizenName(rset.getNString(3));
				citizen.setCitizenGender(rset.getNString(4));
				citizen.setCitizenAge(rset.getNString(5));
				citizen.setCitizenPhone(rset.getNString(6));
				citizen.setCitizenAddress(rset.getNString(7));
				citizen.setCitizenDate(rset.getNString(8));
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
}
