package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverInstantiation {
    WebDriver driver;

    public void setDriver() throws IOException {
        String browser = getBrowserType();
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chome", "src\\test\\resources\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            this.driver = driver;
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public String getBrowserType() throws IOException {
        String browserType = "Chrome";
        File properties = new File("src\\test\\execution\\excutionProperties.properties");
        FileInputStream fileInputStream = new FileInputStream(properties);
        Properties prop = new Properties();
        prop.load(fileInputStream);
        browserType = prop.getProperty("Browser");
        return browserType;

    }

    public String loginURL() throws IOException {
        String loginURL = "";
        String profile = getProfile();
        try {
            File fXmlFile = new File("src\\test\\config\\profiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Profile");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if(eElement.getElementsByTagName("Name")
                            .item(0).getTextContent().equalsIgnoreCase(profile)){
                        loginURL = eElement.getElementsByTagName("URL")
                                .item(0).getTextContent();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return loginURL;
    }

    public String getProfile() throws IOException {
        String profile = "";
        File properties = new File("src\\test\\execution\\excutionProperties.properties");
        FileInputStream fileInputStream = new FileInputStream(properties);
        Properties prop = new Properties();
        prop.load(fileInputStream);
        profile = prop.getProperty("profile");
        return profile;
    }
}
