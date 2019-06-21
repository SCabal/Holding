package Model;

public enum MediModality {
	//atributes
	FABRIYEXPOR("fabricar y exportar"),FABRIYVENDER("fabricar y vender"),IMPORYVENDER("importar y vender");
	private String modality;
	//builder
	private MediModality(String modality) {
		this.modality=modality;
	}
	//getters and setters
	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}
	
}
