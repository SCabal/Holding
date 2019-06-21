package Model;
//imports needed
import java.util.ArrayList;
import java.util.Date;
//interface used
import Interfaces.ICompanyFabrication;

public class Fabrication extends LegalPersonality implements ICompanyFabrication {

	private ArrayList<Product> products;
	//builder + super
	public Fabrication(String name, int nit, String dirCorrespon, int tel, int employeeCuant,
			int actPesos, Date consDate, OrgType consType, String legalRepreName, Cubicle[][][] building) {
		super(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate,
				consType, legalRepreName, building);
		this.products = new ArrayList<Product>();
	}
	//getters nad setters
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
}
