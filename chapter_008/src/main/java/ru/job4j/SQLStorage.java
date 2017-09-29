package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import sun.rmi.runtime.Log;

/**
 * Created by Андрей on 29.09.2017.
 */
public class SQLStorage {

    Connection conn = null;

    private void processDatabase(int fillAmount, String username, String password, String database, String srcXml) throws SQLException, TransformerException, ParserConfigurationException {
        String url = String.format("jdbc:postgresql://127.0.0.1:5432/%s", database);
        // соединяемся с бд
        conn = DriverManager.getConnection(url, username, password);

        // проверяем создана ли таблица TEST в бд, если нет - создаем таблицу TEST
        PreparedStatement st = conn.prepareStatement("CREATE TABLE if not exists TEST (field INT )");
        st.executeUpdate();

        // очищаем бд TEST
        st = conn.prepareStatement("DELETE FROM TEST");
        st.executeUpdate();

        // вставляем данные в таблицу TEST
        for (int i = 1; i <= fillAmount; i++) {
            st = conn.prepareStatement("INSERT INTO TEST VALUES (?)");
            st.setInt(1, i);
            st.executeUpdate();
        }

        // СОЗДАНИЕ XML ДОКУМЕНТА

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // корневой элемент
        Document doc = docBuilder.newDocument();
        Element entries = doc.createElement("entries");
        doc.appendChild(entries); // entris становится корневым элементом xml документа

        // остаем данные из бд и помещаем в xml документ
        st = conn.prepareStatement("SELECT * FROM TEST");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Element entry = doc.createElement("entry");
            Element field = doc.createElement("field");
            field.appendChild(doc.createTextNode(String.format("%s", rs.getInt("field"))));
            entry.appendChild(field); // field становится дочерним элементом entry
            entries.appendChild(entry); // entry становится дочерним элементом entris
        }

        // закрываем ресурсы
        rs.close();
        st.close();


        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");  //  устанавливаем кодировку в xml файле
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");  // устанавливаем в созданом xml файле переход на новую строку
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(srcXml));

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);

        transformer.transform(source, result);
    }

    private void xslTransform(String srcXml, String destXml, String xsltFilter) throws FileNotFoundException, TransformerException {
        // Create transformer factory
        TransformerFactory factory = TransformerFactory.newInstance();

        // Use the factory to create a template containing the xsl file
        Templates template = factory.newTemplates(new StreamSource(new FileInputStream(xsltFilter)));

        // Use the template to create a transformer
        Transformer xformer = template.newTransformer();

        // Prepare the input and output files
        Source src = new StreamSource(new FileInputStream(srcXml));
        Result res = new StreamResult(new FileOutputStream(destXml));

        // Apply the xsl file to the source file and write the result to the output file
        xformer.transform(src, res);
    }

    private int parseFile(String destXml) throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(destXml);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document docs = dBuilder.parse(inputFile);
        docs.getDocumentElement().normalize();
        NodeList list = docs.getElementsByTagName("entry");
        int count = 0;
        for (int i = 0; i < list.getLength(); i++) {
            count += Integer.parseInt(list.item(i).getAttributes().item(0).getNodeValue());
        }
        return count;
    }

    public int countSumOfElements(int fillAmount, String username, String password, String database, String srcXml, String destXml, String xsltFilter) throws IOException, SAXException, ParserConfigurationException {

        try {
            this.processDatabase(fillAmount, username, password, database, srcXml);

            this.xslTransform(srcXml, destXml, xsltFilter);


        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return this.parseFile(destXml);
    }
}
