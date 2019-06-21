package Model;

public enum PublicServiceType {
	//types
	ALCANTARILLADO("Alcantarillado"),ENERGIA("Energia"),ACUEDUCTO("Acueducto");
	//atributes
	private String type;
	//builder
	private PublicServiceType(String type) {
		this.type=type;
	}
	//getters and setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
