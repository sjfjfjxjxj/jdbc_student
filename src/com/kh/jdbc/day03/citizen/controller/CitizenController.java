package com.kh.jdbc.day03.citizen.controller;

import java.util.List;

import com.kh.jdbc.day03.citizen.model.dao.CitizenDAO;
import com.kh.jdbc.day03.citizen.model.vo.Citizen;

public class CitizenController {
	
	public List<Citizen> loadAll() {
		CitizenDAO cDao = new CitizenDAO();
		List<Citizen> cList = cDao.recieveAll();
		return cList;
				
	}

}
