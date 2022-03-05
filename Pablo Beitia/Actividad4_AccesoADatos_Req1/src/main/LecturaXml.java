package main;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXml {
	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		Node raiz;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.parse("concierto.xml");
			raiz = doc.getDocumentElement();
			recorrerNodos(raiz);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void recorrerNodos(Node raiz) {
		NodeList nodos = raiz.getChildNodes();
		System.out.println("Elementos en el nodo raiz: " + nodos.getLength());
		
		for(int i=0; i<nodos.getLength(); i++) {
			Node nodoHijo = nodos.item(i);
			if(nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
				Node fecha = nodoHijo.getChildNodes().item(5);
				System.out.println("Fecha: " + fecha.getTextContent());
			}
		}
		
	}
/*
	private static void recorrerparticipantes(Node participantes) {
		
	}*/
}
