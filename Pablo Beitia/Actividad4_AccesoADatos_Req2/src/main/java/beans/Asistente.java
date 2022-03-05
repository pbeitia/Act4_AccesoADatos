package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="asistente")

public class Asistente {
	private int idAsistente;
	private String nombre;
	private String apellidos;
	private int edad;
	
	public Asistente() {
		
	}

	public Asistente(int idAsistente, String nombre, String apellidos, int edad) {
		super();
		this.idAsistente = idAsistente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	@XmlAttribute(name = "id")
	public int getIdAsistente() {
		return idAsistente;
	}

	public void setIdAsistente(int idAsistente) {
		this.idAsistente = idAsistente;
	}
	
	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@XmlElement
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Asistente [idAsistente=" + idAsistente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad="
				+ edad + "]";
	}	
}
