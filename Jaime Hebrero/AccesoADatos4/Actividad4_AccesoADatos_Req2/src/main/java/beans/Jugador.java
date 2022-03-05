package beans;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="jugador")

public class Jugador {
	private int idJugador;
	private String nombre;
	private String apellidos;
	private int edad;
	
	public Jugador() {
		
	}

	public Jugador(int idJugador, String nombre, String apellidos, int edad) {
		super();
		this.idJugador = idJugador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	@XmlAttribute(name = "id")
	public int getidJugador() {
		return idJugador;
	}

	public void setidJugador(int idJugador) {
		this.idJugador = idJugador;
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
		return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad="
				+ edad + "]";
	}	
}

