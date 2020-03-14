package runners;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class xmlTest {


    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        String xmlFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<Site xmlns=\"bla\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  id=\"0\" affiliations=\"foo\""
                + " status=\"OPERATIONAL\" color=\"#DB2253\" updateTime=\"2002-12-17T09:30:47.0Z\" name=\"GFB_0035\" "
                + "subject=\"GF\">"
                + "    <location>"
                + "        <vertices lat=\"41.905889\" lon=\"12.452019\"/>"
                + "        <vertices lat=\"41.905973\" lon=\"12.453596\"/>"
                + "        <vertices lat=\"41.905206\" lon=\"12.453707\"/>"
                + "        <vertices lat=\"41.905058\" lon=\"12.452109\"/>"
                + "    </location>"
                + "</Site>";

        XmlMapper mapper = new XmlMapper();
        SiteData site = mapper.readValue(xmlFile, SiteData.class);
        System.out.println(site);
    }

}

