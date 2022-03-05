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
		Document doc;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.newDocument();
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			agregarConciertos(concierto, doc);
			guardar(doc);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void guardar(Document doc) throws TransformerException {
		//fabrica de Transformes
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		//creamos el objeto Transfomer, que nos permitira serializar el arbol
		//dom a un fichero
		Transformer conversor = fabricaConversor.newTransformer();
		//creamos la fuente de la cual sacaremos el arbol dom
		DOMSource fuente = new DOMSource(doc); 
		//Creamos el flujo de salida, al fichero que queremos (tubito)
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		//por ultimo, serializamos los datos
		conversor.transform(fuente, resultado);
	}

	private static void agregarConciertos(Element concierto, Document doc){
		Element fecha = doc.createElement("fecha");
		fecha.appendChild(doc.createTextNode("20-oct-2018"));
		concierto.appendChild(fecha);
		
		Element hora = doc.createElement("hora");
		hora.appendChild(doc.createTextNode("21:30"));
		concierto.appendChild(hora);
		
		Element participantes = doc.createElement("participantes");
		concierto.appendChild(participantes);
			
			Element participante = doc.createElement("participante");
			participantes.appendChild(participante);
			
			Element entrada = doc.createElement("entrada");
			entrada.appendChild(doc.createTextNode("21:30"));
			participante.appendChild(entrada);
			
			Element grupo = doc.createElement("grupo");
			Text textoArdillas = doc.createTextNode("Las Ardillas de Dakota");
			grupo.appendChild(textoArdillas);
			participante.appendChild(grupo);
			
			participante = doc.createElement("participante");
			participantes.appendChild(participante);
			entrada = doc.createElement("entrada");
			entrada.appendChild(doc.createTextNode("22:15"));
			participante.appendChild(entrada);
			grupo = doc.createElement("grupo");
			grupo.appendChild(doc.createTextNode("Fito y Fitipaldis"));
			participante.appendChild(grupo);
			
			participante = doc.createElement("participante");
			participantes.appendChild(participante);
			entrada = doc.createElement("entrada");
			entrada.appendChild(doc.createTextNode("23:00"));
			participante.appendChild(entrada);
			grupo = doc.createElement("grupo");
			grupo.appendChild(doc.createTextNode("Coldplay"));
			participante.appendChild(grupo);

	}
}
