package Model;
//imports needed
import java.util.ArrayList;
import java.util.Date;
//interface used
import Interfaces.ICompanyFabrication;

public class MedFabrication extends Fabrication implements ICompanyFabrication{

	private ArrayList<MedProduct> medProducts;
	//builder + super
	public MedFabrication(String name, int nit, String dirCorrespon, int tel, int employeeCuant,
			int actPesos, Date consDate, OrgType consType, String legalRepreName, Cubicle[][][] building) {
		super(name, nit, dirCorrespon, tel, employeeCuant, actPesos, consDate,
				consType, legalRepreName, building);
		medProducts=new ArrayList<MedProduct>();
	}
	//getters and setters
	public ArrayList<MedProduct> getMedProducts() {
		return medProducts;
	}

	public void setMedProducts(ArrayList<MedProduct> medProducts) {
		this.medProducts = medProducts;
	}
	//water x tree method, calculates the total water used in liters
	/**
	*	@param totalWater this has an auxiliar parameter, which is is started in 0 it is used as a flag.
	*	@return 6 if 1 <= totalWater <= 141
	*	@return 25 if 141 < totalWater <=800
	*	@return 200 if 800 < totalWater 
	*	@return 0 in case that is none of above
	*/
	public int waterXTree() {
		double totalWater=0;
		for (int i = 0; i < medProducts.size(); i++) {
			totalWater+=medProducts.get(i).getWaterLiters();
		}
		if(totalWater>=1&&totalWater<=141) {
			return 6;
		}
		else if(totalWater>141&&totalWater<=800) {
			return 25;
		}else if(totalWater>800) {
			return 200;
		}
		return 0;
	}
	
}
