package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import beans.Jugador;

public class XML_A_Objeto {
	public static void main(String[] args) {
		try{
			JAXBContext contexto = JAXBContext.newInstance(Jugador.class);
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("jugador.xml");
			if(fichero.exists()) {
				Jugador a = (Jugador) u.unmarshal(fichero);
				System.out.println(a.getApellidos());
				System.out.println(a.getEdad());
				System.out.println(a.getNombre());
				System.out.println(a);
			}else {
				System.out.println("Fichero jugador.xml no encontrado");
			}
		
		}catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}
}