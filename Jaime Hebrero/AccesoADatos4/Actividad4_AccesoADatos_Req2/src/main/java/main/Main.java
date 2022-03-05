package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Jugador;
import beans.Servidor;

public class Main {
	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Servidor.class);
		}catch (JAXBException e) {
			e.printStackTrace();			
			return;
		}
		
		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Servidor servidor = new Servidor();
			servidor.setNombre("Ninavee");
			servidor.setRegion("Europa");
			
			servidor.getJugadores().add(new Jugador(1, "Eve", "Nitoi", 32));
			servidor.getJugadores().add(new Jugador(2, "jaime", "Hebrero", 23));
			servidor.getJugadores().add(new Jugador(3, "Victor", "Martin", 26));
			servidor.getJugadores().add(new Jugador(4, "Pablo", "Gil", 17));
			servidor.getJugadores().add(new Jugador(5, "Alvaro", "Sanchez", 20));
			
			m.marshal(servidor, new File("servidor.xml"));
			System.out.println("El archivo Servidor.xml ha sido creado con éxito, refresca Eclipse");
		}catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}
	}
}