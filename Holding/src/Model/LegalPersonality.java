package Model;
//date java import
import java.util.Date;
//abstract class
public abstract class LegalPersonality {
	//atributes
	private String name;
	private int nit;
	private String dirCorrespon;
	private int tel;
	private int employeeCuant;
	private int actPesos;
	private Date consDate;
	private OrgType consType;
	private String legalRepreName;
	private Cubicle[][][] building;
	
	//builder
	public LegalPersonality(String name, int nit, String dirCorrespon, int tel,
			int employeeCuant, int actPesos, Date consDate, OrgType consType,
			String legalRepreName, Cubicle[][][] building) {
		this.name = name;
		this.nit = nit;
		this.dirCorrespon = dirCorrespon;
		this.tel = tel;
		this.employeeCuant = employeeCuant;
		this.actPesos = actPesos;
		this.consDate = consDate;
		this.consType = consType;
		this.legalRepreName = legalRepreName;
		this.building = building;
		initializeBuilding();
	}
	
	//method for initializing the building matrix
	/**
	*
	*	@return void , this is just for initializing the building of the cubicle matrix
	*/
	private void initializeBuilding() {
		for (int floor = 0; floor < building.length; floor++) {
			for (int i = 0; i < building[0].length; i++) {
				for (int j = 0; j < building[0][0].length; j++) {
					building[floor][i][j]=new Cubicle(floor+"-"+i+"-"+j);
				}
			}
		}
		
	}
	public boolean addEmployee(String name,String charge,String eMail) {
		for (int floor = 0; floor < building.length; floor++) {
			for (int i = 0; i < building[0].length; i++) {
				for (int j = 0; j < building[0][0].length; j++) {
					if(building[floor][i][j].getEmployee()==null) {
						building[floor][i][j].addEmployee(name, charge, eMail);
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean deleteEmployee(String extention) {
		String[] exten=extention.split("-");
		int floor=Integer.parseInt(exten[0]);
		int i=Integer.parseInt(exten[1]);
		int j=Integer.parseInt(exten[2]);
		Employee aux=building[floor][i][j].getEmployee();
		if(aux!=null) {
			building[floor][i][j].deleteEmployee();
			return true;
		}
		return false;
		
	}
	//solo podes llamar a esto si es impar la cantidad de pisos
	public String findEmployeeNameByE(String name) {
		for (int floor = 0; floor < building.length; floor++) {
			for (int i = 0; i < building[0].length; i++) {
				for (int j = 0; j < building[0][0].length; j++) {
					if(building[floor][i][j].getEmployee()!=null&&building[floor][i][j].getEmployee().getEmployeeName().equals(name)) {
						return building[floor][i][j].getExtention();
					}
				}
			}
			
		}
		return null;
	}
	public String findEmployeeNameByX(String name) {
		for (int floor = 0; floor < building.length; floor++) {
			for (int i = 0, j=0; i < building[0].length&&j<building[0][0].length;j++, i++) {
				
					if(building[floor][i][i].getEmployee()!=null&&building[floor][i][i].getEmployee().getEmployeeName().equals(name)) {
						return building[floor][i][i].getExtention();
					}
				
			}
			for (int i = building[0].length-1,j=building[0][0].length-1; i >=0&&j>=0; i--,j--) {
				if(building[floor][i][j].getEmployee()!=null&&building[floor][i][j].getEmployee().getEmployeeName().equals(name)) {
					return building[floor][i][j].getExtention();
				}
			}
		}
		return null;
	}
	public String findEmployeeNameByZ(String name) {
		for (int i = 0; i < building[0].length; i++) {
			for (int j = 0; j < building[0][0].length; j++) {
				if(building[0][i][j].getEmployee()!=null&&building[0][i][j].getEmployee().getEmployeeName().equals(name)) {
					return building[0][i][j].getExtention();
				}
			}
		}
		for (int i = 0; i < building[0].length; i++) {
			for (int j = 0; j < building[0][0].length; j++) {
				if(building[building.length-1][i][j].getEmployee()!=null&&building[building.length-1][i][j].getEmployee().getEmployeeName().equals(name)) {
					return building[building.length-1][i][j].getExtention();
				}
			}
		}
		for (int floor = 0; floor < building.length; floor++) {	
			for (int i = building[0].length-1,j=building[0][0].length-1; i >=0&&j>=0; i--,j--) {
				if(building[floor][i][j].getEmployee()!=null&&building[floor][i][j].getEmployee().getEmployeeName().equals(name)) {
					return building[floor][i][j].getExtention();
				}
			}
		}
		return null;
	}
	public String findEmployeeNameByL(String name) {
		for (int i = 0; i < building[0].length; i++) {
			for (int j = 0; j < building[0][0].length; j++) {
				if(building[0][i][j].getEmployee()!=null&&building[0][i][j].getEmployee().getEmployeeName().equals(name)) {
					return building[0][i][j].getExtention();
				}
			}
		}
		
		for (int floor = 0; floor < building.length; floor++) {
			for (int j = 0; j < building[0][0].length; j++) {
				if(building[floor][0][j].getEmployee()!=null&&building[floor][0][j].getEmployee().getEmployeeName().equals(name)) {
					return building[floor][0][j].getExtention();
				}
			}
		}
		return null;
	}
	public String findEmployeeNameByO(String name) {
		
			for (int i = 0; i < building[0].length; i++) {
				for (int j = 0; j < building[0][0].length; j++) {
					if(building[0][i][j].getEmployee()!=null&&building[0][i][j].getEmployee().getEmployeeName().equals(name)) {
						return building[0][i][j].getExtention();
					}
				}
			}
			for (int i = 0; i < building[0].length; i++) {
				for (int j = 0; j < building[0][0].length; j++) {
					if(building[building.length-1][i][j].getEmployee()!=null&&building[building.length-1][i][j].getEmployee().getEmployeeName().equals(name)) {
						return building[building.length-1][i][j].getExtention();
					}
				}
			}
			for (int floor = 1; floor < building.length-1; floor++) {
				for (int i = 0; i < building[0].length; i++) {
					if(building[floor][i][0].getEmployee()!=null&&building[floor][i][0].getEmployee().getEmployeeName().equals(name)) {
						return building[floor][i][0].getExtention();
					}
					else if(building[floor][i][building[0][0].length-1].getEmployee()!=null&&building[floor][i][building[0][0].length-1].getEmployee().getEmployeeName().equals(name)) {
						return building[floor][i][building[0][0].length-1].getExtention();
					}
				}
				for (int j = 0; j < building[0][0].length; j++) {
					if(building[floor][0][j].getEmployee()!=null&&building[floor][0][j].getEmployee().getEmployeeName().equals(name)) {
						return building[floor][0][j].getExtention();
					}
					else if(building[floor][building[0].length-1][j].getEmployee()!=null&&building[floor][building[0].length-1][j].getEmployee().getEmployeeName().equals(name)) {
						return building[floor][building[0].length-1][j].getExtention();
					}
				}
			}
			
		
		return null;
	}
	public ArrayList<String> findMailsByCharge(String charge){
		ArrayList<String> mails=new ArrayList<String>();
		for (int floor = 0; floor < building.length; floor++) {
			boolean flag=true;
			int i=0;
			int j=0;
			int iLimit=building[0].length-1;
			int jLimit=building[0][0].length-1;
			int ibajo=0;
			int ialto=0;
			int jbajo=0;
			int jalto=1;
			
			while(flag) {
				Cubiculo aux=building[floor][i][j];
				if(aux.getEmployee()!=null&&aux.getEmployee().getCharge().equals(charge)) {
					mails.add(aux.getEmployee().geteMail());
				}
				if(j==jalto-1&&i<iLimit-ibajo) {
					i++;
					if(i==iLimit-ibajo)
						ibajo++;
				}
				else if(i==(iLimit-ibajo)+1&&j<jLimit-jbajo) {
					j++;
					if(j==jLimit-jbajo)
						jbajo++;
				}
				else if(j==(jLimit-jbajo)+1&&i>ialto) {
					i--;
					if(i==ialto)
						ialto++;
				}
				else if(i==ialto-1&&j>jalto) {
					j--;
					if(j==jalto)
						jalto++;
				}else {
					flag=false;
				}
			}
		}
		return mails;
	}


	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getDirCorrespon() {
		return dirCorrespon;
	}
	public void setDirCorrespon(String dirCorrespon) {
		this.dirCorrespon = dirCorrespon;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getEmployeeCuant() {
		return employeeCuant;
	}
	public void setEmployeeCuant(int employeeCuant) {
		this.employeeCuant = employeeCuant;
	}
	public int getActPesos() {
		return actPesos;
	}
	public void setActPesos(int actPesos) {
		this.actPesos = actPesos;
	}
	public Date getConsDate() {
		return consDate;
	}
	public void setConsDate(Date consDate) {
		this.consDate = consDate;
	}
	public OrgType getConsType() {
		return consType;
	}
	public void setConsType(OrgType consType) {
		this.consType = consType;
	}
	public String getLegalRepreName() {
		return legalRepreName;
	}
	public void setLegalRepreName(String legalRepreName) {
		this.legalRepreName = legalRepreName;
	}
	public Cubicle[][][] getBuilding() {
		return building;
	}
	public void setBuilding(Cubicle[][][] building) {
		this.building = building;
	}
	
	
}

