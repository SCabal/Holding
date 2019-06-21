package Model;
//date java import
import java.util.Date;

public class MedProduct extends Product {
	//constants
	public final static String VALID="Vigente";
	public final static String NOT_RENEWED="No renovado";
	//atributes
	private String sanitaryReg;
	private String status;
	private Date expires;
	private MediModality modality;
	
	
	//builder + super
	public MedProduct(String name, String code, double waterLiters, int invCuant, String sanitaryReg,
			String status, Date expires, MediModality modality) {
		super(name, code, waterLiters, invCuant);
		this.sanitaryReg = sanitaryReg;
		this.status = status;
		this.expires = expires;
		this.modality = modality;
	}
	//getters and setters
	public String getSanitaryReg() {
		return sanitaryReg;
	}
	public void setSanitaryReg(String sanitaryReg) {
		this.sanitaryReg = sanitaryReg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getExpires() {
		return expires;
	}
	public void setExpires(Date expires) {
		this.expires = expires;
	}
	public MediModality getModality() {
		return modality;
	}
	public void setModality(MediModality modality) {
		this.modality = modality;
	}
	
	
	
}
