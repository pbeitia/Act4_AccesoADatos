package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "colegio")
@XmlType(propOrder = { 
			"idColegio",
			"nombre",
			"direccion",
			"alumnos"})
public class Colegio {
	
	private int idColegio;
	private String nombre;
	private Direccion direccion;
	private List<Alumno> alumnos;
	
	public Colegio() {
		super();
		alumnos= new ArrayList<Alumno>();
	}

	public Colegio(int idColegio, String nombre, Direccion direccion, List<Alumno> alumnos) {
		super();
		this.idColegio = idColegio;
		this.nombre = nombre;
		this.direccion = direccion;
		this.alumnos = alumnos;
	}
	
	@XmlAttribute(name = "id")
	public int getIdColegio() {
		return idColegio;
	}

	public void setIdColegio(int idColegio) {
		this.idColegio = idColegio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@XmlElement(name= "alumno")
	@XmlElementWrapper(name ="alumnos")
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Colegio [idColegio=" + idColegio + ", nombre=" + nombre + ", direccion=" + direccion + ", alumnos="
				+ alumnos + "]";
	}
	
	
	
	

}
