package Model;

public class Product {
	//atributes
	private String name;
	private String code;
	private double waterLiters;
	private int invCuant;
	
	//builder
	public Product(String name, String code, double waterLiters, int invCuant) {
		this.name = name;
		this.code = code;
		this.waterLiters = waterLiters;
		this.invCuant = invCuant;
	}
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getWaterLiters() {
		return waterLiters;
	}
	public void setWaterLiters(double waterLiters) {
		this.waterLiters = waterLiters;
	}
	public int getInvCuant() {
		return invCuant;
	}
	public void setInvCuant(int invCuant) {
		this.invCuant = invCuant;
	}
	
}
