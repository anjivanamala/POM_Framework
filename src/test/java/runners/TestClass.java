package runners;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class TestClass {
    public static Map<String, Integer> counter = new HashMap<>();
    public int counter1 = 0;
    public int counter2 = 0;
    public int counter3 = 0;

    public static void main(String[] args) {
        String xmlStr = "<DETAILS>\n" +
                "\t<JOBNUMBER>100136887</JOBNUMBER>\n" +
                "\t<JOBSTATUS>\n" +
                "\t\t<STATUSDESCRIPTION>Pre-Confirmed</STATUSDESCRIPTION>\n" +
                "\t</JOBSTATUS>\n" +
                "\t<JOBCREATEDDATE>2020-03-08T17:50:48.000000</JOBCREATEDDATE>\n" +
                "\t<JOBUPDATEDDATE>2020-03-08T12:22:28.000000</JOBUPDATEDDATE>\n" +
                "\t<PRODUCT>Ocean Freight</PRODUCT>\n" +
                "\t<PRODUCTTYPE>FCL (NVOCC)</PRODUCTTYPE>\n" +
                "\t<AGILITYMOVEMENTTYPE>DTCYD</AGILITYMOVEMENTTYPE>\n" +
                "\t<ENTRYMODE   ENTRYREFERENCENUMBER=\"FOCIS\">Manual</ENTRYMODE>\n" +
                "\t<INCOTERMLOCATION  INCOTERMTYPE =\"DAT\">AutoLocation</INCOTERMLOCATION>\n" +
                "\t<AMSFLAG></AMSFLAG>\n" +
                "\t<AESFLAG></AESFLAG>\n" +
                "\t<PARTIES>\n" +
                "\t\t<PARTY>\n" +
                "\t\t\t<PARTYTYPE>BRANCH</PARTYTYPE>\n" +
                "\t\t\t<PARTYID>5910</PARTYID>\n" +
                "\t\t\t<PARTYNAME>Agility Logistics Private Ltd - India</PARTYNAME>\n" +
                "\t\t\t<NWCCODE>BOM</NWCCODE>\n" +
                "\t\t\t<ADDRESS>\n" +
                "\t\t\t\t<ADDRESSTYPE></ADDRESSTYPE>\n" +
                "\t\t\t\t<ADDRESSLINE1>5th Floor\n" +
                "</ADDRESSLINE1>\n" +
                "\t\t\t\t<ADDRESSLINE2>A-501/502 &quot;B&quot; Wing</ADDRESSLINE2>\n" +
                "\t\t\t\t<ADDRESSLINE3>Polaris Off Marol Maroshi Road Marol Andheri (E)</ADDRESSLINE3>\n" +
                "\t\t\t\t<ADDRESSLINE4>Mumbai, Maharashtra, 400059</ADDRESSLINE4>\n" +
                "\t\t\t\t<ADDRESSLINE5>India</ADDRESSLINE5>\n" +
                "\t\t\t\t<ADDRESSLINE6></ADDRESSLINE6>\n" +
                "\t\t\t\t<CITY>Mumbai</CITY>\n" +
                "\t\t\t\t<STATE>Maharashtra</STATE>\n" +
                "\t\t\t\t<COUNTRYCODE>IN</COUNTRYCODE>\n" +
                "\t\t\t\t<COUNTRYNAME>India</COUNTRYNAME>\n" +
                "\t\t\t\t<POSTCODE>400059</POSTCODE>\n" +
                "\t\t\t\t<PARTYREFERENCES>\n" +
                "\t\t\t\t\t<REFERENCEVALUE></REFERENCEVALUE>\n" +
                "\t\t\t\t</PARTYREFERENCES>\n" +
                "\t\t\t\t<CONTACTDETAILS>\n" +
                "\t\t\t\t\t<CONTACTTYPE>USERNAME</CONTACTTYPE>\n" +
                "\t\t\t\t\t<CONTACT>Export Job </CONTACT>\n" +
                "\t\t\t\t</CONTACTDETAILS>\n" +
                "\t\t\t\t<CONTACTDETAILS>\n" +
                "\t\t\t\t\t<CONTACTTYPE>TELEPHONE</CONTACTTYPE>\n" +
                "\t\t\t\t\t<CONTACT>67647878</CONTACT>\n" +
                "\t\t\t\t</CONTACTDETAILS>\n" +
                "\t\t\t\t<CONTACTDETAILS>\n" +
                "\t\t\t\t\t<CONTACTTYPE>EMAILID</CONTACTTYPE>\n" +
                "\t\t\t\t\t<CONTACT>noreply@agility.com</CONTACT>\n" +
                "\t\t\t\t</CONTACTDETAILS>\n" +
                "\t\t\t</ADDRESS>\n" +
                "\t\t</PARTY>\n" +
                "\t</PARTIES>\n" +
                "</DETAILS>";
        xmlStr = xmlStr.replaceAll("\t", "");

//        //Use method to convert XML string content to XML Document object
//        Document doc = convertStringToXMLDocument(xmlStr);
//        String textToPrint = "";
//        //Verify XML document is build correctly
//        doc.getDocumentElement().normalize();
//        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//        NodeList nList = doc.getElementsByTagName("PARTY");
//        System.out.println("----------------------------");
//        for (int temp = 0; temp < nList.getLength(); temp++) {
//
//            Node nNode = nList.item(temp);
//
//            System.out.println("\nCurrent Element :" + nNode.getNodeName());
//
//            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//
//                Element eElement = (Element) nNode;
//                System.out.println(eElement.getChildNodes().getLength());
//                for (int i = 0; i < eElement.getElementsByTagName("*").getLength(); i++) {
//
//                    System.out.println(eElement.getElementsByTagName("*").item(i).getNodeName());
//                    System.out.println(eElement.getElementsByTagName("*").item(i).getTextContent());
//                }
//                System.out.println("PARTYTYPE Name : " + eElement.getElementsByTagName("PARTYTYPE").item(0).getTextContent());
//                System.out.println("PARTYID Name : " + eElement.getElementsByTagName("PARTYID").item(0).getTextContent());
//                System.out.println("PARTYNAME Name : " + eElement.getElementsByTagName("PARTYNAME").item(0).getTextContent());
//                System.out.println("NWCCODE Name : " + eElement.getElementsByTagName("NWCCODE").item(0).getTextContent());
//                System.out.println(eElement.getTagName());
//            }
//        }

        printChildNodes(xmlStr, "PARTIES");
    }

    public static void printChildNodes(String xmlStr, String node) {
        Document doc = convertStringToXMLDocument(xmlStr);
        String textToPrint = "";
        //Verify XML document is build correctly
        doc.getDocumentElement().normalize();
//        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName(node);
        System.out.println(node + "and size is " + nList.getLength());
        if (!counter.containsKey(node)) {
            counter.put(node, nList.getLength());
        } else {
            int tep2 = counter.get(node);
            counter.put(node, tep2 - 1);
        }

//        System.out.println("----------------------------");

        if (counter.get(node) > 0) {
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    System.out.println(eElement.getChildNodes().getLength());
                    if (eElement.getChildNodes().getLength() <= 1) {
                        System.out.println(eElement.getNodeName() + " - " + eElement.getTextContent());
                        System.out.println(eElement.getTextContent());
                        if (eElement.getNextSibling().getNextSibling() == null) {
                            int te = counter.get(eElement.getParentNode().getNodeName());
                            counter.put(eElement.getParentNode().getNodeName(), te-1);
                            printChildNodes(xmlStr, eElement.getParentNode().getNextSibling().getNextSibling().getNodeName());
                        } else {
                            System.out.println(eElement.getNextSibling().getNextSibling().getNodeName());
                            printChildNodes(xmlStr, eElement.getNextSibling().getNextSibling().getNodeName());
                        }


                    } else {
                        printChildNodes(xmlStr, eElement.getChildNodes().item(1).getNodeName());
                    }

                }
            }
        } else {
            System.out.println("Done with Printing");
        }


    }

    private static Document convertStringToXMLDocument(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

