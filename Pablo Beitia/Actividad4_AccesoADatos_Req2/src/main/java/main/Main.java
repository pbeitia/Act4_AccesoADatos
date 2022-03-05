package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Asistente;
import beans.Teatro;

public class Main {
	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Teatro.class);
		}catch (JAXBException e) {
			e.printStackTrace();			
			return;
		}
		
		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Teatro teatro = new Teatro();
			teatro.setNombre("Teatro Maravillas");
			teatro.setDireccion("C. de Manuela Malasaña, 6, 28004 Madrid");
			
			teatro.getAsistentes().add(new Asistente(1, "Andrea", "Recio", 20));
			teatro.getAsistentes().add(new Asistente(2, "Ángel", "Peña", 47));
			teatro.getAsistentes().add(new Asistente(3, "Benito", "Álvarez", 48));
			teatro.getAsistentes().add(new Asistente(4, "Pablo", "Beitia", 19));
			teatro.getAsistentes().add(new Asistente(5, "Montse", "Gil", 56));
			
			m.marshal(teatro, new File("teatro.xml"));
			System.out.println("El archivo Teatro.xml ha sido creado con éxito, refresca Eclipse");
		}catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}
	}
}