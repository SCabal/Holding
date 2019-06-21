package Model;

public class Employee {
	//atributes
	private String employeeName;
	private String charge;
	private String eMail;
	//builder
	public Employee(String employeeName, String charge, String eMail) {
		this.employeeName = employeeName;
		this.charge = charge;
		this.eMail = eMail;
	}
	//getter and setters
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getEMail() {
		return eMail;
	}
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	
	
}
