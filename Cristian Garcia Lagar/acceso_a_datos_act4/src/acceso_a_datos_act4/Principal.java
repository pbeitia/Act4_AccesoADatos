package acceso_a_datos_act4;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Principal {

	public static void main(String[] args) {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document documento;
		Element concierto;
		
		try {
			
			db = dbFactory.newDocumentBuilder();
			documento = db.newDocument();
			concierto = documento.createElement("concierto");
			documento.appendChild(concierto);
			agregarNodosARaiz(documento, concierto);
			guardar(documento);
			System.out.println("Se ha creado el documento");
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * Agrega los nodos hijos a la raiz del fichero
	 * @param documento se trata del documento que se va a crear
	 * @param concierto es el elemento raiz del que colgaran las distintas etiquetas hijo
	 */
	public static void agregarNodosARaiz(Document documento, Element concierto) {
			Element fecha, hora, participantes, participante, entrada, grupo;
			
			fecha = documento.createElement("fecha");
			fecha.appendChild(documento.createTextNode("20-oct-2018"));
			concierto.appendChild(fecha);
			
			hora = documento.createElement("hora");
			hora.appendChild(documento.createTextNode("21:30"));
			concierto.appendChild(hora);
			
			participantes = documento.createElement("participantes");
			concierto.appendChild(participantes);
			
			participante = documento.createElement("participante");
			participantes.appendChild(participante);
			entrada = documento.createElement("entrada");
			entrada.appendChild(documento.createTextNode("21:30"));
			grupo = documento.createElement("grupo");
			grupo.appendChild(documento.createTextNode("Las ardillas de Dakota"));
			participante.appendChild(entrada);
			participante.appendChild(grupo);
			
			participante = documento.createElement("participante");
			participantes.appendChild(participante);
			entrada = documento.createElement("entrada");
			entrada.appendChild(documento.createTextNode("22:15"));
			grupo = documento.createElement("grupo");
			grupo.appendChild(documento.createTextNode("Fito y Fitipaldis"));
			participante.appendChild(entrada);
			participante.appendChild(grupo);
			
			participante = documento.createElement("participante");
			participantes.appendChild(participante);
			entrada = documento.createElement("entrada");
			entrada.appendChild(documento.createTextNode("23:00"));
			grupo = documento.createElement("grupo");
			grupo.appendChild(documento.createTextNode("ColdPlay"));
			participante.appendChild(entrada);
			participante.appendChild(grupo);
			
	}
	/**
	 * Premite serializar la informacion en un fichero .xml
	 * @param documento archivo.xml que se va a crear
	 * @throws TransformerException
	 */
	public static void guardar(Document documento) throws TransformerException {
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource domSource = new DOMSource(documento);
		StreamResult result = new StreamResult(new File("concierto.xml"));
		transformer.transform(domSource, result);
	}

}
