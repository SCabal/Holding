package Model;

public class Cubicle {
	//atributes
	private Employee employee;
	private String extention;
	//builder
	public Cubicle(String extenttion){
		this.extention=extenttion;
	}
	//delete and add employee methods
	/**
	*	@return employee null, is for deleting the employee
	*
	*/
	public void deleteEmployee() {
		employee=null;
	}
	/**
	*	@param name the name of the employee
	*	@param charge the charge of the employee
	*	@param eMail the email of the employee
	*	@return new employee
	*/
	public void addEmployee(String name,String charge,String eMail) {
		employee=new Employee(name, charge, eMail);
	}
	//getters and setters
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}
	
	
}
