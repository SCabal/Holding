package Model;
//imports needed
import java.util.ArrayList;
import java.util.Date;
//interface used
import Interfaces.ICompanyService;

public class Education extends LegalPersonality implements ICompanyService{
	//constants
	public static final String HIGHSCHOOL="Bachillerato";
	public static final String COLLEGE="Universidad";
	//atributes
	private int regisAproMEN;
	private int yearsAcredit;
	private int nacSaber11;
	private int nacSaberPro;
	private String principalName;
	private String educationSector;
	private int stratum1and2Act;
	private int totalActStudents;
	
	private ArrayList<Poll> polls;
	
	//builder + super
	public Education(String name, int nit, String dirCorrespon, int tel, int employeeCuant,
			int actPesos, Date consDate, OrgType consType, String legalRepreName,
			int regisAproMEN, int yearsAcredit, int nacSaber11, int nacSaberPro, String principalName,
			String educationSector, int stratum1and2Act, int totalActStudents, Cubicle[][][] building) {
		super(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate,
				consType, legalRepreName, building);
		this.regisAproMEN = regisAproMEN;
		this.yearsAcredit = yearsAcredit;
		this.nacSaber11 = nacSaber11;
		this.nacSaberPro = nacSaberPro;
		this.principalName = principalName;
		this.educationSector = educationSector;
		this.stratum1and2Act = stratum1and2Act;
		this.totalActStudents = totalActStudents;
		polls=new ArrayList<Poll>();
	}

	//methods
	/**
	*	@return tax , this will have an a auxiliar variable named tax, which is gonna be returned at the end
	*
	*/

	public double proCulturaTaxPercent() {
		double tax;
		if((tax=(20.0-(100.0*((double)stratum1and2Act/totalActStudents))))<0.0) {
			tax=0.0;
		}
		return tax;
	}
	/**
	*	@param d this will create a poll d
	*
	*	@return an added poll to the arraylist Poll
	*/
	public void addPoll(Poll d) {
		polls.add(d);
	}
	//getters and setters
	public int getRegisAproMEN() {
		return regisAproMEN;
	}


	public void setRegisAproMEN(int regisAproMEN) {
		this.regisAproMEN = regisAproMEN;
	}


	public int getYearsAcredit() {
		return yearsAcredit;
	}


	public void setYearsAcredit(int yearsAcredit) {
		this.yearsAcredit = yearsAcredit;
	}


	public int getNacSaber11() {
		return nacSaber11;
	}


	public void setNacSaber11(int nacSaber11) {
		this.nacSaber11 = nacSaber11;
	}


	public int getNacSaberPro() {
		return nacSaberPro;
	}


	public void setNacSaberPro(int nacSaberPro) {
		this.nacSaberPro = nacSaberPro;
	}


	public String getPrincipalName() {
		return principalName;
	}


	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}


	public String getEducationSector() {
		return educationSector;
	}


	public void setEducationSector(String educationSector) {
		this.educationSector = educationSector;
	}


	public int getStratum1and2Act() {
		return stratum1and2Act;
	}


	public void setStratum1and2Act(int stratum1and2Act) {
		this.stratum1and2Act = stratum1and2Act;
	}


	public int getTotalActStudents() {
		return totalActStudents;
	}


	public void setTotalActStudents(int totalActStudents) {
		this.totalActStudents = totalActStudents;
	}


	public ArrayList<Poll> getPolls() {
		return polls;
	}


	public void setPolls(ArrayList<Poll> polls) {
		this.polls = polls;
	}
	
	
}
