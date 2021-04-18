package tareajavaxml_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class TareaJavaXML_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valor;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("*************************************");
        System.out.println("***    Gestión de ficheros XML    ***");
        System.out.println("*************************************");

        do {
            do {
                System.out.println("\n1. Crear Fichero XML");
                System.out.println("2. Crear Fichero XML usando JDOM2");
                System.out.println("3. Leer Fichero XML");
                System.out.println("4. Leer Fichero XML usando JDOM2");
                System.out.print("Introduzca la opción que desee (0 para salir): ");
                valor = sc.nextInt();
            } while (valor < 0 || valor > 4);

            switch (valor) {
                case 1:
                    System.out.println("\nCreando el fichero XML...");
                    crearXML();
                    break;

                case 2:
                    System.out.println("\nCreando el fichero XML con JDOM2...");
                    crearXMLjdom2();
                    break;

                case 3:
                    System.out.println("\nLeyendo el fichero XML");
                    leerXML();
                    break;

                case 4:
                    System.out.println("\nLeyendo el fichero XML con JDOM2");
                    leerXMLjdom2();
                    break;

                case 0:
                    System.out.println("\nCerramos el programa");
                    break;

            }
        } while (valor != 0);
    }

    private static void crearXML() {
        try {
            //implementamos el Builder para XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            //implementamos el documento XML
            Document documento = implementation.createDocument(null, "libreria", null);
            documento.setXmlVersion("1.0");
            //creamos etiquetas padre del nodo raiz XML
            Element libros = documento.createElement("libros");
            Element libro = documento.createElement("libro");
            //
            //creamos los elementos y contenido de nuestro XML
            Element titulo = documento.createElement("titulo");
            Text textTitulo = documento.createTextNode("Don Quijote de la Mancha");
            titulo.appendChild(textTitulo); //vamos añadiendo de modo jerárquico
            libro.appendChild(titulo);  //vamos añadiendo de modo jerárquico
            //creamos los elementos y contenido de nuestro XML
            Element autor = documento.createElement("autor");
            Text textAutor = documento.createTextNode("M. de Cervantes");
            autor.appendChild(textAutor);  //vamos añadiendo de modo jerárquico
            libro.appendChild(autor);  //vamos añadiendo de modo jerárquico
            //creamos los elementos y contenido de nuestro XML
            Element paginas = documento.createElement("paginas");
            Text textPaginas = documento.createTextNode("2200");
            paginas.appendChild(textPaginas);   //vamos añadiendo de modo jerárquico
            libro.appendChild(paginas);   //vamos añadiendo de modo jerárquico
            //creamos los elementos y contenido de nuestro XML
            Element precio = documento.createElement("precio");
            Text textPrecio = documento.createTextNode("25.90");
            precio.appendChild(textPrecio);   //vamos añadiendo de modo jerárquico
            libro.appendChild(precio);    //vamos añadiendo de modo jerárquico
            //Añadimos dentro de la raiz libros todos los elementos libro creados
            libros.appendChild(libro);
            //Creamos el documento añadiendo el nodo raiz libros
            documento.getDocumentElement().appendChild(libros);
            //
            // creamos nuevo nodo libro
            libro = documento.createElement("libro");
            titulo = documento.createElement("titulo"); //creamos los elementos y contenido de nuestro XML
            textTitulo = documento.createTextNode("El retrato de Dorian Gray");
            titulo.appendChild(textTitulo); //vamos añadiendo de modo jerárquico
            libro.appendChild(titulo);  //vamos añadiendo de modo jerárquico
            //creamos los elementos y contenido de nuestro XML
            autor = documento.createElement("autor");
            textAutor = documento.createTextNode("Oscar Wilde");
            autor.appendChild(textAutor);  //vamos añadiendo de modo jerárquico
            libro.appendChild(autor);  //vamos añadiendo de modo jerárquico
            //creamos los elementos y contenido de nuestro XML
            paginas = documento.createElement("paginas");
            textPaginas = documento.createTextNode("1200");
            paginas.appendChild(textPaginas);   //vamos añadiendo de modo jerárquico
            libro.appendChild(paginas);   //vamos añadiendo de modo jerárquico
            //creamos los elementos y contenido de nuestro XML
            precio = documento.createElement("precio");
            textPrecio = documento.createTextNode("13.90");
            precio.appendChild(textPrecio);   //vamos añadiendo de modo jerárquico
            libro.appendChild(precio);    //vamos añadiendo de modo jerárquico
            //Añadimos dentro de la raiz libros todos los elementos libro creados
            libros.appendChild(libro);
            //Creamos el documento añadiendo el nodo raiz libros
            documento.getDocumentElement().appendChild(libros);
            //
            // creamos nuevo nodo Libro
            libro = documento.createElement("libro");
            titulo = documento.createElement("titulo");  //creamos los elementos y contenido de nuestro XML
            textTitulo = documento.createTextNode("Ana Karenina");
            titulo.appendChild(textTitulo); //vamos añadiendo de modo jerárquico
            libro.appendChild(titulo);  //vamos añadiendo de modo jerárquico
            //creamos los elementos y contenido de nuestro XML
            autor = documento.createElement("autor");
            textAutor = documento.createTextNode("León Tolstói");
            autor.appendChild(textAutor);  //vamos añadiendo de modo jerárquico
            libro.appendChild(autor);  //vamos añadiendo de modo jerárquico
            //creamos los elementos y contenido de nuestro XML
            paginas = documento.createElement("paginas");
            textPaginas = documento.createTextNode("3400");
            paginas.appendChild(textPaginas);   //vamos añadiendo de modo jerárquico
            libro.appendChild(paginas);   //vamos añadiendo de modo jerárquico
            //creamos los elementos y contenido de nuestro XML
            precio = documento.createElement("precio");
            textPrecio = documento.createTextNode("19.90");
            precio.appendChild(textPrecio);   //vamos añadiendo de modo jerárquico
            libro.appendChild(precio);    //vamos añadiendo de modo jerárquico
            //Añadimos dentro de la raiz libros todos los elementos libro creados
            libros.appendChild(libro);
            //Creamos el documento añadiendo el nodo raiz libros
            documento.getDocumentElement().appendChild(libros);
            //
            //
            //creamos el fichero XML con documento (el cual contiene toda la información de nuestro XML)
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("./libreria.xml")); //creamos y especificamos el archivo XML
            //La propiedad del sistema javax.xml.transform.TransformerFactory  especifica qué implementación de fábrica crear.
            //En consecuencia, esta propiedad nombra una subclase concreta de la  clase abstracta TransformerFactory  
            // Transformer transformer = TransformerFactory.newInstance().newTransformer();  //usamos factory para crear nuestro transformador
            Transformer transformer = TransformerFactory.newInstance().newTransformer();  //usamos factory para crear nuestro transformador     
            //El  transformador transforma una fuente en un resultado. En nuestro caso, la fuente es el documento XML y el resultado es el archivo de salida
            transformer.transform(source, result);  //Finalmente, le diremos al transformador que opere en el objeto de origen y emita al objeto de resultado

            System.out.println("Se ha creado el archivo libreria.xml dentro de la carpeta de su proyecto");

        } catch (TransformerException | ParserConfigurationException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void leerXML() {
        try {
            //implementamos el Builder para XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //implementamos el documento XML
            Document documento = builder.parse(new File("./libreria.xml"));
            //creamos el nodo para todos los elementos libro
            NodeList listaLibros = documento.getElementsByTagName("libro");
            //recorremos con un for los nodos del XML
            for (int i = 0; i < listaLibros.getLength(); i++) {
                Node nodo = listaLibros.item(i); //almacenamos dentro de nodo el valor del elemento raiz libro
                if (nodo.getNodeType() == Node.ELEMENT_NODE) { //si el nodo es de tipo Elemento (existen distintos tipos de nodos)
                    Element e = (Element) nodo;  //creamos un nuevo elemento
                    NodeList hijos = e.getChildNodes();  //creamos un nodelist donde almacenar los hijos
                    System.out.println("Nodo: " + e.getNodeName());
                    for (int j = 0; j < hijos.getLength(); j++) { //recorremos todos los elementos del nodo superior
                        Node hijo = hijos.item(j); //almacenamos dentro de nodo el contenido del libro
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            Element eHijo = (Element) hijo;
                            System.out.println("Propiedad: " + eHijo.getNodeName() + ", Valor: " + eHijo.getTextContent());
                        }
                    }
                }
            }

        } catch (SAXException | IOException | ParserConfigurationException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /*
    **********************************************************************************************************
    ***** Para usar los métodos de JDOM2 debemos descargarnos la librería y añadirla a nuestro Proyecto   ****
    ***** Ir a la web: http://www.jdom.org/  *****************************************************************
    ***** Ir a Downloads --> Binaries --> JDOM 2.0.6 (fichero zip)  ******************************************
    ***** Descomprimir el ZIP dentro de una carpeta JDOM2 y solo usar "jdom-2.0.6.jar"  **********************
    **********************************************************************************************************
     */
    private static void leerXMLjdom2() {
        try {
            SAXBuilder builder = new SAXBuilder();  //declaramos el objeto builder
            File xml = new File("./libreria.xml");
            //creamos el document obligando a usar la librería jdom2
            org.jdom2.Document document = builder.build(xml);
            //creamos el root con la librería jdom2
            org.jdom2.Element root = document.getRootElement();
            //creamos una lista donde almacenar todos los hijos del raiz libros
            List<org.jdom2.Element> list = root.getChildren("libros");
            //recorremos el nodo raiz 
            for (int i = 0; i < list.size(); i++) {
                org.jdom2.Element libro = list.get(i);
                //creamos una lista para almancenar los hijos, en este caso libro
                List<org.jdom2.Element> valoresLibro = libro.getChildren();
                System.out.println("Título" + "\t\t\t\t\t\t" + "Autor" + "\t\t\t" + "Páginas" + "\t\t" + "Precio");
                //recorremos el for para capturar todos los componentes hijos
                for (int j = 0; j < valoresLibro.size(); j++) {
                    org.jdom2.Element campo = valoresLibro.get(j);
                    //almacenamos los datos de los hijos
                    String titulo = campo.getChildTextTrim("titulo");
                    String autor = campo.getChildText("autor");
                    String paginas = campo.getChildTextTrim("paginas");
                    String precio = campo.getChildTextTrim("precio");
                    //mostramos en pantalla los valores almacenados
                    System.out.println(titulo + "\t\t\t" + autor + "\t\t" + paginas + "\t\t" + precio);
                }
            }
        } catch (JDOMException | IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void crearXMLjdom2() {
        //Creamos el elemento libreria y el documento
        try {
            org.jdom2.Element libreria = new org.jdom2.Element("libreria");
            org.jdom2.Document documento = new org.jdom2.Document(libreria);
            //creamos el element libros nodo raiz
            org.jdom2.Element libros = new org.jdom2.Element("libros");
            libreria.addContent(libros);
            ////////////////////////////////////////////////////////////////////////
            org.jdom2.Element libro = new org.jdom2.Element("libro"); //Creamos un nuevo elemento libro
            //creamos todos los campos y contenido del elemento libro
            org.jdom2.Element titulo = new org.jdom2.Element("titulo");
            titulo.setText("Don Quijote de la Mancha");
            org.jdom2.Element autor = new org.jdom2.Element("autor");
            autor.setText("M. de Cervantes");
            org.jdom2.Element paginas = new org.jdom2.Element("paginas");
            paginas.setText("2200");
            org.jdom2.Element precio = new org.jdom2.Element("precio");
            precio.setText("25.90");
            //añadimos el contenido al nodo libro
            libro.addContent(titulo);
            libro.addContent(autor);
            libro.addContent(paginas);
            libro.addContent(precio);
            //añadimos el contenido libro al raiz libros
            libros.addContent(libro);
            ////////////////////////////////////////////////////////////////////////
            libro = new org.jdom2.Element("libro"); //Creamos un nuevo elemento libro
            //creamos todos los campos y contenido del elemento libro
            titulo = new org.jdom2.Element("titulo");
            titulo.setText("El retrato de Dorian Gray");
            autor = new org.jdom2.Element("autor");
            autor.setText("Oscar Wilde");
            paginas = new org.jdom2.Element("paginas");
            paginas.setText("1200");
            precio = new org.jdom2.Element("precio");
            precio.setText("13.90");
            //añadimos el contenido al nodo libro
            libro.addContent(titulo);
            libro.addContent(autor);
            libro.addContent(paginas);
            libro.addContent(precio);
            //añadimos el contenido libro al raiz libros
            libros.addContent(libro);
            ////////////////////////////////////////////////////////////////////////
            libro = new org.jdom2.Element("libro");  //Creamos un nuevo elemento libro
            //creamos todos los campos y contenido del elemento libro
            titulo = new org.jdom2.Element("titulo");
            titulo.setText("El guardián entre el centeno");
            autor = new org.jdom2.Element("autor");
            autor.setText("J. D. Salinger");
            paginas = new org.jdom2.Element("paginas");
            paginas.setText("3400");
            precio = new org.jdom2.Element("precio");
            precio.setText("19.90");
            //añadimos el contenido al nodo libro
            libro.addContent(titulo);
            libro.addContent(autor);
            libro.addContent(paginas);
            libro.addContent(precio);
            //añadimos el contenido libro al raiz libros
            libros.addContent(libro);
            ///////////////////////////////////////////////////////////////////////
            //creamos un xml
            XMLOutputter xml = new XMLOutputter();
            xml.setFormat(Format.getPrettyFormat()); //formateamos para que el contenido esté formateado y justificado
            xml.output(documento, new FileWriter("./libreria.xml")); //enviamos el documento al fichero
            
            System.out.println("Se ha creado el archivo libreria.xml dentro de la carpeta de su proyecto");

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
