package Model;
//imports used of the java util
import java.util.ArrayList;
import java.util.Date;
//interface used
import Interfaces.ICompanyService;

public class PublicServices extends LegalPersonality implements ICompanyService{
	//atributes
	private PublicServiceType type;
	private int totalSubs;
	private int stratum1and2Subs;
	private ArrayList<Poll> polls;
	//builder + super
	public PublicServices(String name, int nit, String dirCorrespon, int tel, int employeeCuant,
			int actPesos, Date consDate, OrgType consType, String legalRepreName,
			PublicServiceType type, int totalSubs, int stratum1and2Subs, Cubicle[][][] building) {
		super(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate,
				consType, legalRepreName, building);
		this.type = type;
		this.totalSubs = totalSubs;
		this.stratum1and2Subs = stratum1and2Subs;
		polls=new ArrayList<Poll>();
	}
	//getters and setters
	public PublicServiceType getType() {
		return type;
	}
	public void setType(PublicServiceType type) {
		this.type = type;
	}
	public int getTotalSubs() {
		return totalSubs;
	}
	public void setTotalSubs(int totalSubs) {
		this.totalSubs = totalSubs;
	}
	public int getStratum1and2Subs() {
		return stratum1and2Subs;
	}
	public void setStratum1and2Subs(int stratum1and2Subs) {
		this.stratum1and2Subs = stratum1and2Subs;
	}
	public ArrayList<Poll> getPolls() {
		return polls;
	}
	public void setPolls(ArrayList<Poll> polls) {
		this.polls = polls;
	}
	//interface method addPoll
	/**
	*	@param d from the Poll arrayList
	*	@return added to the Poll Array
	*/
	@Override
	public void addPoll(Poll d) {
		polls.add(d);
		
	}
	//tax percent for pro cultura calculator method
	/**
	*	@param tax an auxiliar parameter used to calculate taxes
	*	
	*	@return tax when it is calculates
	*
	*/
	public double proCulturaTaxPercent() {
		double tax;
		if((tax=(40.0-(100.0*((double)(totalSubs-stratum1and2Subs)/totalSubs))))<0.0) {
			tax=0.0;
		}
		return tax;
	}
	
	
	
	
}
