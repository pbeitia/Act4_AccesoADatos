package Main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import entidades.Colegio;

public class DeserializacionXML {
	
	public static void main(String[] args) {
		
		JAXBContext contexto; 
		
		try {
			contexto= JAXBContext.newInstance(Colegio.class);
			Unmarshaller unmarshaller = contexto.createUnmarshaller();
			File fichero = new File("colegio.xml");
			if(fichero.exists()) {
				//Deserializacion del fichero colegio.xml
				Colegio colegio = (Colegio) unmarshaller.unmarshal(fichero);
				System.out.println(colegio);
			}
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
