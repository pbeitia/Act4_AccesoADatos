package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import beans.Asistente;

public class XML_A_Objeto {
	public static void main(String[] args) {
		try{
			JAXBContext contexto = JAXBContext.newInstance(Asistente.class);
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("asistente.xml");
			if(fichero.exists()) {
				Asistente a = (Asistente) u.unmarshal(fichero);
				System.out.println(a.getApellidos());
				System.out.println(a.getEdad());
				System.out.println(a.getNombre());
				System.out.println(a);
			}else {
				System.out.println("Fichero asistente.xml no encontrado");
			}
		
		}catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}
}