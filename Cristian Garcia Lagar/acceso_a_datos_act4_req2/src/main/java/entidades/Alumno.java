package entidades;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name= "alumno")
@XmlType(propOrder = {
		"idAlumno",
	    "nombre",
	    "apellido",
	    "edad",
	    "direccion"
	})
public class Alumno {
	
	private int idAlumno;
	private String nombre;
	private String apellido;
	private int edad;
	private Direccion direccion;
	
	
	public Alumno() {
		super();
	}


	public Alumno(int idAlumno, String nombre, String apellido, int edad, Direccion direccion) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
	}
	
	@XmlAttribute(name="id")
	public int getIdAlumno() {
		return idAlumno;
	}


	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", direccion=" + direccion + "]";
	}
	
	
	
	

}
