package ru.job4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Properties;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Created by Andrey on 26.09.2017.
 */
public class SQLStorage {

    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main (String[] args) {
        String url = "jdbc:postgresql://127.0.0.1:5432/admin";

        String username = new String("postgres");
        String password = new String("password");
        Properties p = new Properties();
        p.setProperty("user", "postgres");
        p.setProperty("password", "password");
        Connection conn = null;
        /*try {
            conn = DriverManager.getConnection(url, p*//*, username, password*//*);



            int N = 10;
            PreparedStatement st = conn.prepareStatement("CREATE TABLE if not exists java_users (field INT )");
            st.executeUpdate();

            st = conn.prepareStatement("DELETE FROM java_users");
            st.executeUpdate();
            for (int i = 1; i <= N; i++) {
                st = conn.prepareStatement("INSERT INTO java_users VALUES (?)");
                st.setInt(1, i);
                st.executeUpdate();
            }

            st = conn.prepareStatement("SELECT * FROM java_users");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("field"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }*/

        /*try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            // staff elements
            Element staff = doc.createElement("Staff");
            rootElement.appendChild(staff);

            // set attribute to staff element
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            staff.setAttributeNode(attr);

            // shorten way
            // staff.setAttribute("id", "1");

            // firstname elements
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("yong"));
            staff.appendChild(firstname);

            // lastname elements
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("mook kim"));
            staff.appendChild(lastname);

            // nickname elements
            Element nickname = doc.createElement("nickname");
            nickname.appendChild(doc.createTextNode("mkyong"));
            staff.appendChild(nickname);

            // salary elements
            Element salary = doc.createElement("salary");
            salary.appendChild(doc.createTextNode("100000"));
            staff.appendChild(salary);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
//            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\Андрей\\Desktop\\file.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }*/





        try {

            int N = 10;

            // соединяемся с бд
            conn = DriverManager.getConnection(url, username, password);

            // проверяем создана ли таблица TEST в бд, если нет - создаем таблицу TEST
            PreparedStatement st = conn.prepareStatement("CREATE TABLE if not exists TEST (field INT )");
            st.executeUpdate();

            // очищаем бд TEST
            st = conn.prepareStatement("DELETE FROM TEST");
            st.executeUpdate();

            // вставляем данные в таблицу TEST
            for (int i = 1; i <= N; i++) {
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
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\Андрей\\Desktop\\1.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
        
    }
}
