package main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Principal {
	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document document;
		
		try 
		{
			analizador = fabrica.newDocumentBuilder();
			document = analizador.newDocument();
			Element concierto = document.createElement("concierto");
			document.appendChild(concierto);
			CrearConciertos(concierto, document);
			guardar(document);
		}
		
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}



	private static void CrearConciertos(Element concierto, Document document){
		Element fecha = document.createElement("fecha");
		fecha.appendChild(document.createTextNode("20-oct-2018"));
		concierto.appendChild(fecha);
		
		Element hora = document.createElement("hora");
		hora.appendChild(document.createTextNode("21:30"));
		concierto.appendChild(hora);
		
		Element participantes = document.createElement("participantes");
		concierto.appendChild(participantes);
			
			Element participante = document.createElement("participante");
			participantes.appendChild(participante);
			
			Element entrada = document.createElement("entrada");
			entrada.appendChild(document.createTextNode("21:30"));
			participante.appendChild(entrada);
			
			Element grupo = document.createElement("grupo");
			Text textoArdillas = document.createTextNode("Las Ardillas de Dakota");
			grupo.appendChild(textoArdillas);
			participante.appendChild(grupo);
			
			participante = document.createElement("participante");
			participantes.appendChild(participante);
			entrada = document.createElement("entrada");
			entrada.appendChild(document.createTextNode("22:15"));
			participante.appendChild(entrada);
			grupo = document.createElement("grupo");
			grupo.appendChild(document.createTextNode("Fito y Fitipaldis"));
			participante.appendChild(grupo);
			
			participante = document.createElement("participante");
			participantes.appendChild(participante);
			entrada = document.createElement("entrada");
			entrada.appendChild(document.createTextNode("23:00"));
			participante.appendChild(entrada);
			grupo = document.createElement("grupo");
			grupo.appendChild(document.createTextNode("Coldplay"));
			participante.appendChild(grupo);

	}
	private static void guardar(Document document) throws TransformerException {
		
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		Transformer conversor = fabricaConversor.newTransformer();
		DOMSource fuente = new DOMSource(document); 
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		conversor.transform(fuente, resultado);
	}

}
