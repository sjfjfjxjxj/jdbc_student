package kom.kh.jdbc.day03.citizen.run;

import java.util.List;

import kom.kh.jdbc.day03.citizen.controller.CitizenController;
import kom.kh.jdbc.day03.citizen.model.vo.Citizen;
import kom.kh.jdbc.day03.citizen.view.CitizenView;

public class CitizenRun {
    public static void main(String [] args) {
    	CitizenView cView = new CitizenView();
    	CitizenController cCon = new CitizenController();
    	List<Citizen> cList = null; 
    	
    	exit :
    		while(true) {
    			int choice = cView.printMain();
    			switch(choice) {
    			case 0 : break exit;
    			case 1 : //전체조회
    				cList = cCon.loadAll();
    				if(!cList.isEmpty()) {
    					cView.printAll(cList);
    				}else {
    					cView.failMsg("아이디가 없습니다");
    				}
    				break;
    			case 2 : break;
    			case 3 : break;
    			case 4 : break;
    			case 5 : break;
    			case 6 : break;
    			case 7 : break;
    			}
    			
    			
    		}
    	
    	
    	
    }
}
