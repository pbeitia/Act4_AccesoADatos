package Main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import entidades.Alumno;
import entidades.Colegio;
import entidades.Direccion;

public class SerializacionXML {

	public static void main(String[] args) {
	
		JAXBContext contexto;
		
		try {
			contexto = JAXBContext.newInstance(Colegio.class);
		} catch (JAXBException e) {
			e.printStackTrace();
			return;
		}
		
		Marshaller marshaller;
		
		try {
			marshaller = contexto.createMarshaller();
			
			Colegio colegio = new Colegio();
			Direccion direccionColegio = new Direccion("Avd Avenida Nº1","06660","Ciudad1","Provincia1");
			Direccion direccionAlumno1 = new Direccion("C/ Calle Nº1","06660","Ciudad1","Provincia1");
			Direccion direccionAlumno2 = new Direccion("C/ Calle Nº2","06660","Ciudad1","Provincia1");
			Direccion direccionAlumno3 = new Direccion("C/ Calle Nº3","06660","Ciudad1","Provincia1");
			Alumno alumno1 = new Alumno(1, "Alumno1","Apellido1",14, direccionAlumno1);
			Alumno alumno2 = new Alumno(2, "Alumno2","Apellido2",15, direccionAlumno2);
			Alumno alumno3 = new Alumno(3, "Alumno3","Apellido3",16, direccionAlumno3);
			colegio.setIdColegio(1);
			colegio.setNombre("Colegio1");
			colegio.setDireccion(direccionColegio);
			colegio.getAlumnos().add(alumno1);
			colegio.getAlumnos().add(alumno2);
			colegio.getAlumnos().add(alumno3);
			//Serializa la clase colegio en un fichero .xml
			marshaller.marshal(colegio, new File("colegio.xml"));
			System.out.println("colegio.xml creado con exito");
			
			
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}

	}

}
