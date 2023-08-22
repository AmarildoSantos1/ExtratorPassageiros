import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ExtratorPassageiros {
    public static void main(String[] args) {
        try {
            File inputFile = new File("passageiros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            NodeList nodeList = doc.getElementsByTagName("passageiro");
            
            System.out.println("Número de passageiros: " + nodeList.getLength());
            System.out.println("Origens e destinos:");
            
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String origem = element.getElementsByTagName("origem").item(0).getTextContent();
                    String destino = element.getElementsByTagName("destino").item(0).getTextContent();
                    System.out.println("Passageiro " + (temp + 1) + ": Origem - " + origem + ", Destino - " + destino);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

