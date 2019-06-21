package Model;

public enum OrgType {
	//different types of organizations
	AgriCazaSilviPezca("AGRICULTURA, CAZA, SILVICULTURA Y PEZCA"), ExploMinasCante("EXPLOTACION DE MINAS Y CANTERAS"),
	Manufactu("INDUSTRIA MANUFACTURERA"), ElectriGasVapo("ELECTRICIDAD, GAS Y VAPOR"), Constru("CONSTRUCCION"),
	ComerciMayorMenor("COMERCIO AL POR MAYOR Y AL POR MENOR"),
	TranspoAlmaceComunic("TRANSPORTE, ALMACENAMIENTO Y COMUNICACIONES"),
	CieroSegurosComani("EST.F/CIEROS,SEGUROS,B.INMUEBLES,SERV. A COMPANIAS"), ComunalesSociales("COMUNALES, SOCIALES");
	//aribute
	private String type;
	//builder
	private OrgType(String type) {
		this.type = type;
	}
	//getters and setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
