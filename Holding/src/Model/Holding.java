package Model;
//imports needed
import java.util.ArrayList;
import java.util.Date;
//interfaces used
import Interfaces.ICompanyFabrication;
import Interfaces.ICompanyService;

public class Holding extends LegalPersonality {
	private ArrayList<ICompanyService> services;
	private ArrayList<ICompanyFabrication> fabrication;
	//builder + super
	public Holding(String name, int nit, String dirCorrespon, int tel, int employeeCuant,
			int actPesos, Date consDate, OrgType consType, String legalRepreName, Cubicle[][][] building) {
		super(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate,
				consType, legalRepreName, building);
		services = new ArrayList<ICompanyService>();
		fabrication = new ArrayList<ICompanyFabrication>();
	}
	//getters and setters
	public ArrayList<ICompanyService> getServices() {
		return services;
	}

	public void setServices(ArrayList<ICompanyService> services) {
		this.services = services;
	}

	public ArrayList<ICompanyFabrication> getFabrication() {
		return fabrication;
	}

	public void setFabrication(ArrayList<ICompanyFabrication> fabrication) {
		this.fabrication = fabrication;
	}

	

}
