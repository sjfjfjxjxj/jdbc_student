package kom.kh.jdbc.day03.citizen.controller;

import java.util.List;

import kom.kh.jdbc.day03.citizen.model.dao.CitizenDAO;
import kom.kh.jdbc.day03.citizen.model.vo.Citizen;

public class CitizenController {
	
	public List<Citizen> loadAll() {
		CitizenDAO cDao = new CitizenDAO();
		List<Citizen> cList = cDao.recieveAll();
		return cList;
				
	}

}
