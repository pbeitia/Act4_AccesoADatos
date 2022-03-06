package acceso_a_datos_act4;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {
	public static void main(String[] args) {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document documento;
		Node raiz;
		
		try {
			
			db = dbFactory.newDocumentBuilder();
			documento = db.parse("concierto.xml");
			//Deserializacion del fichero
			raiz = documento.getDocumentElement();
			recorrerRaiz(raiz);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	/**
	 * Permite recorrer el archivo concierto.xml
	 * @param raiz
	 */
	public static void recorrerRaiz(Node raiz) {
		
		NodeList nodos = raiz.getChildNodes();
		System.out.println("Fecha y hora del concierto: " + nodos.item(0).getTextContent()+ " "+ nodos.item(1).getTextContent());
		System.out.println("Participan los siguientes grupos: ");
		NodeList participantes = nodos.item(2).getChildNodes();
		for(int i=0;i<participantes.getLength();i++) {
			Node participante  = participantes.item(i);
			System.out.println("   "+participante.getChildNodes().item(0).getTextContent()+ " " + participante.getChildNodes().item(1).getTextContent());
		}
		
	}

}
