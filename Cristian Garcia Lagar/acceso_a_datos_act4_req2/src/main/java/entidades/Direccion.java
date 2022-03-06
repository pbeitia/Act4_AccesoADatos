package entidades;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "direccion")
public class Direccion {
	
	private String nombreVia;
	private String cp;
	private String ciudad;
	private String provincia;
		
	public Direccion() {
		super();
	}

	public Direccion(String nombreVia, String cp, String ciudad, String provincia) {
		super();
		this.nombreVia = nombreVia;
		this.cp = cp;
		this.ciudad = ciudad;
		this.provincia = provincia;
	}
	
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String toString() {
		return "Direccion [nombreVia=" + nombreVia + ", cp=" + cp + ", ciudad=" + ciudad + ", provincia=" + provincia
				+ "]";
	}
	
	
	

}
