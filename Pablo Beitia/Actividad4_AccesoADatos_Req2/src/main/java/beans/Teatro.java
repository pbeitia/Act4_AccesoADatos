package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="teatro")
public class Teatro {
	private String nombre;
	private String Direccion;
	private List<Asistente> asistentes;
	
	public Teatro() {
		asistentes = new ArrayList<Asistente>();
	}

	@XmlElement(name = "asistente")
	@XmlElementWrapper(name = "asistentes")
	public List<Asistente> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<Asistente> asistentes) {
		this.asistentes = asistentes;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
}
