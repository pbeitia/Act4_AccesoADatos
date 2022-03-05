package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="servidor")

public class Servidor {
	private String nombre;
	private String Region;
	private List<Jugador> Jugadores;
	
	public Servidor() {
		Jugadores = new ArrayList<Jugador>();
	}

	@XmlElement(name = "jugador")
	@XmlElementWrapper(name = "jugadores")
	public List<Jugador> getJugadores() {
		return Jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.Jugadores = jugadores;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}
}
