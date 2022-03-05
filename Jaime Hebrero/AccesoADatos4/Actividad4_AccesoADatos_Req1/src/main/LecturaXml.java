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
		Document document;
		Node node;
		
		try 
		{
			analizador = fabrica.newDocumentBuilder();
			document = analizador.parse("concierto.xml");
			node = document.getDocumentElement();
			recorrerNodos(node);
			
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	private static void recorrerNodos(Node node) {
		
		NodeList nodos = node.getChildNodes();
		System.out.println("Elementos del nodo raiz: " + nodos.getLength());
		
		for(int i=0; i<nodos.getLength(); i++)
		{
			Node nodoHijo = nodos.item(i);
			
			if(nodoHijo.getNodeType() == Node.ELEMENT_NODE) 
			{
				Node fecha = nodoHijo.getChildNodes().item(5);
				System.out.println("Fecha: " + fecha.getTextContent());
			}
		}
		
	}

}
