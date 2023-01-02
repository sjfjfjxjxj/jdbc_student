package kom.kh.jdbc.day03.citizen.model.vo;

import java.sql.Timestamp;

public class Citizen {
    private String citizenId;
    private String citizenPwd;
    private String citizenName;
    private String citizenGender;
    private int citizenAge;
    private String citizenPhone;
    private String citizenAddress;
    private Timestamp citizenDate;
	
    public Citizen() {
		super();
	}

	public Citizen(String citizenId, String citizenPwd, String citizenName, String citizenGender, int citizenAge,
			String citizenPhone, String citizenAddress) {
		super();
		this.citizenId = citizenId;
		this.citizenPwd = citizenPwd;
		this.citizenName = citizenName;
		this.citizenGender = citizenGender;
		this.citizenAge = citizenAge;
		this.citizenPhone = citizenPhone;
		this.citizenAddress = citizenAddress;
	}

	public String getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}

	public String getCitizenPwd() {
		return citizenPwd;
	}

	public void setCitizenPwd(String citizenPwd) {
		this.citizenPwd = citizenPwd;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getCitizenGender() {
		return citizenGender;
	}

	public void setCitizenGender(String citizenGender) {
		this.citizenGender = citizenGender;
	}

	public int getCitizenAge() {
		return citizenAge;
	}

	public void setCitizenAge(int citizenAge) {
		this.citizenAge = citizenAge;
	}

	public String getCitizenPhone() {
		return citizenPhone;
	}

	public void setCitizenPhone(String citizenPhone) {
		this.citizenPhone = citizenPhone;
	}

	public String getCitizenAddress() {
		return citizenAddress;
	}

	public void setCitizenAddress(String citizenAddress) {
		this.citizenAddress = citizenAddress;
	}

	public Timestamp getCitizenDate() {
		return citizenDate;
	}

	public void setCitizenDate(Timestamp citizenDate) {
		this.citizenDate = citizenDate;
	}

	@Override
	public String toString() {
		return "Citizen [citizenId=" + citizenId + ", citizenPwd=" + citizenPwd + ", citizenName=" + citizenName
				+ ", citizenGender=" + citizenGender + ", citizenAge=" + citizenAge + ", citizenPhone=" + citizenPhone
				+ ", citizenAddress=" + citizenAddress + ", citizenDate=" + citizenDate + "]";
	}
    
    
    
    
    
    
}
