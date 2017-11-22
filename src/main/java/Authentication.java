import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class Authentication {
    private String databaseURL;
    private String login;
    private String password;

    Authentication(String filename) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(filename);
            XPath xPath = XPathFactory.newInstance().newXPath();
            databaseURL = xPath.evaluate("/authentification/databaseURL/text()", document);
            login = xPath.evaluate("/authentification/login/text()", document);
            password = xPath.evaluate("/authentification/password/text()", document);
        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException e) {
            System.err.println(e.getMessage());
        }

    }

    public String getDatabaseURL() {
        return databaseURL;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


}
