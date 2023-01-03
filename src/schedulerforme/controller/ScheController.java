package schedulerforme.controller;

import java.util.List;

import schedulerforme.model.ScheModelDAO;
import schedulerforme.model.Schedule;

public class ScheController {

	public List<Schedule> accessAll() {
		ScheModelDAO scheDao = new ScheModelDAO();
		List<Schedule> scheList = scheDao.loadAll();
		return scheList;
	}
	
	public List<Schedule> checkDate(int scheDate) {
		ScheModelDAO scheDao = new ScheModelDAO();
		List<Schedule> scheList = scheDao.loadSome(scheDate);
		return scheList;
	}
	
	
	public List<Schedule> checkPrivate(String insertPrivate) {
		ScheModelDAO scheDao = new ScheModelDAO();
		List<Schedule> scheList = scheDao.loadSches(insertPrivate);
		return scheList;
	}
	
	
	
	public int saveSche(Schedule schedule) {
		ScheModelDAO scheDao = new ScheModelDAO();
		int result = scheDao.upLoadOne(schedule);
		return result;
	}
	
	


	public int modifySche(String insertTitle) {
		ScheModelDAO scheDao = new ScheModelDAO();
		int result = scheDao.replaceSche(insertTitle);
		return result;
	}

	public Schedule printOneSche(String insertTitle) {
		ScheModelDAO scheDao = new ScheModelDAO();
		Schedule schedule = scheDao.loadOneSche(insertTitle);
		return schedule;
	}
	
}
