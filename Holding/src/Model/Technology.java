package Model;
//imports of java used
import java.util.ArrayList;
import java.util.Date;
//interface used
import Interfaces.ICompanyService;

public class Technology extends LegalPersonality implements ICompanyService  {
	//atributes
	private ArrayList<Poll> polls;
	private String[] services={"Consultoria","Capacitacion","Desarrollo de software a la medida","Infrastructura como servicio","Plataforma como servicio"};
	private double anualEnergy;
	
	//builder + super
	public Technology(String name, int nit, String dirCorrespon, int tel, int employeeCuant,
			int actPesos, Date consDate, OrgType consType, String legalRepreName,
			double anualEnergy, Cubicle[][][] building) {
		super(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate,
				consType, legalRepreName, building);
		this.anualEnergy = anualEnergy;
		polls=new ArrayList<Poll>();
	}
	//method from interface named addPoll
	/**
	* 	descripcion:
	*	pre: previo al metodo
	*	@param d from the Poll arrayList
	*	@return added to the Poll Array
	*/
	@Override
	public void addPoll(Poll d) {
		polls.add(d);
		return;
		
	}
	//method for calculating the anual energy
	/**
	*	@return 8 if 1 <= anualEnergy <= 1001
	*	@return 35 if 1001 < anualEnergy <= 3000
	*	@return 500 if 3000 < anualEnergy
	*	@return 0 if its none of the above, in which case is below 1
	*/
	public int energyXTree() {
		
		
		if(anualEnergy>=1&&anualEnergy<=1001) {
			return 8;
		}
		else if(anualEnergy>1001&&anualEnergy<=3000) {
			return 35;
		}else if(anualEnergy>3000) {
			return 500;
		}
		return 0;
	}
	//getters and setters
	public ArrayList<Poll> getPolls() {
		return polls;
	}
	public void setPolls(ArrayList<Poll> polls) {
		this.polls = polls;
	}
	public String[] getServices() {
		return services;
	}
	public void setServices(String[] services) {
		this.services = services;
	}
	public double getAnualEnergy() {
		return anualEnergy;
	}
	public void setAnualEnergy(double anualEnergy) {
		this.anualEnergy = anualEnergy;
	}

	
	
	
	
}
