package utils.config;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Читает данные из файла dream_tours.xml
 * из текущей директории.
 * Экземпляр класса создавать не нужно -
 * все функции статические.
 */
public class ConfigReader {
    private static boolean read = false;
    private static String dbDriver;
    private static String dbUrl;
    private static String dbUser;
    private static String dbPass;
    private static String albumsRoot;

    private ConfigReader() {

    }

    private static void readConfig() {
        if (!read) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            try {
                builder = factory.newDocumentBuilder();
                Document document = builder.parse(new File("dream_tours.xml"));
                NodeList nodes = document.getChildNodes().item(0).getChildNodes();
                Node node;

                for (int iNode = 0; iNode < nodes.getLength(); ++iNode) {
                    node = nodes.item(iNode);
                    switch (node.getNodeName()) {
                        case "database":
                            readDatabaseConfig(node);
                            break;

                        case "albums":
                            readAlbumsConfig(node);
                            break;
                        default:
                            break;
                    }
                }

                read = true;
            } catch (ParserConfigurationException | SAXException | IOException e) {
                Logger.getLogger(ConfigReader.class).error("Can't read config file.", e);
            }
        }
    }

    private static void readAlbumsConfig(Node node) {
        albumsRoot = node.getAttributes().getNamedItem("root").getNodeValue();
    }

    private static void readDatabaseConfig(Node node) {
        dbDriver = node.getAttributes().getNamedItem("driver").getNodeValue();
        dbUrl = node.getAttributes().getNamedItem("url").getNodeValue();
        dbUser = node.getAttributes().getNamedItem("user").getNodeValue();
        dbPass = node.getAttributes().getNamedItem("passw").getNodeValue();
    }

    public static String getDbUrl() {
        readConfig();
        return dbUrl;
    }

    public static String getDbUser() {
        readConfig();
        return dbUser;
    }

    public static String getDbPass() {
        readConfig();
        return dbPass;
    }

    public static String getAlbumsRoot() {
        readConfig();
        return albumsRoot;
    }

    public static String getDbDriver() {
        readConfig();
        return dbDriver;
    }
}
