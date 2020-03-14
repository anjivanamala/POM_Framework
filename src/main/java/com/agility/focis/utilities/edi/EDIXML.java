package com.agility.focis.utilities.edi;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class EDIXML {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        String xmlFile =
                "<DETAILS>\n" +
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
                        "\t\t\t\t<ADDRESSLINE1>5th Floor</ADDRESSLINE1>\n" +
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
                        "\t\t<PARTY>\n" +
                        "\t\t\t<PARTYTYPE>Consignee</PARTYTYPE>\n" +
                        "\t\t\t<PARTYID>10008387</PARTYID>\n" +
                        "\t\t\t<PARTYNAME>AGILITY LOGISTICS PRIVATE LIMITED</PARTYNAME>\n" +
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
                        "\t\t\t\t\t<REFERENCEVALUE>1200USORDUS120016BRNORDOE0320/</REFERENCEVALUE>\n" +
                        "\t\t\t\t</PARTYREFERENCES>\n" +
                        "\t\t\t</ADDRESS>\n" +
                        "\t\t</PARTY>\n" +
                        "\t\t<PARTY>\n" +
                        "\t\t\t<PARTYTYPE>Shipper</PARTYTYPE>\n" +
                        "\t\t\t<PARTYID>10012991</PARTYID>\n" +
                        "\t\t\t<PARTYNAME>AGILITY LOGISTICS CORP.</PARTYNAME>\n" +
                        "\t\t\t<NWCCODE>ORD</NWCCODE>\n" +
                        "\t\t\t<ADDRESS>\n" +
                        "\t\t\t\t<ADDRESSTYPE></ADDRESSTYPE>\n" +
                        "\t\t\t\t<ADDRESSLINE1>491 Supreme Drive\n" +
                        "</ADDRESSLINE1>\n" +
                        "\t\t\t\t<ADDRESSLINE2>Bensenville, IL 60106</ADDRESSLINE2>\n" +
                        "\t\t\t\t<ADDRESSLINE3>United States</ADDRESSLINE3>\n" +
                        "\t\t\t\t<ADDRESSLINE4></ADDRESSLINE4>\n" +
                        "\t\t\t\t<ADDRESSLINE5></ADDRESSLINE5>\n" +
                        "\t\t\t\t<ADDRESSLINE6></ADDRESSLINE6>\n" +
                        "\t\t\t\t<CITY>Bensenville</CITY>\n" +
                        "\t\t\t\t<STATE>Illinois</STATE>\n" +
                        "\t\t\t\t<COUNTRYCODE>US</COUNTRYCODE>\n" +
                        "\t\t\t\t<COUNTRYNAME>United States</COUNTRYNAME>\n" +
                        "\t\t\t\t<POSTCODE>60106</POSTCODE>\n" +
                        "\t\t\t\t<PARTYREFERENCES>\n" +
                        "\t\t\t\t\t<REFERENCEVALUE>1200USORDUS120016BRNORDOE0320/</REFERENCEVALUE>\n" +
                        "\t\t\t\t</PARTYREFERENCES>\n" +
                        "\t\t\t</ADDRESS>\n" +
                        "\t\t</PARTY>\n" +
                        "\t\t<PARTY>\n" +
                        "\t\t\t<PARTYTYPE>Notify Party</PARTYTYPE>\n" +
                        "\t\t\t<PARTYID>10008387</PARTYID>\n" +
                        "\t\t\t<PARTYNAME>AGILITY LOGISTICS PRIVATE LIMITED</PARTYNAME>\n" +
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
                        "\t\t\t</ADDRESS>\n" +
                        "\t\t</PARTY>\n" +
                        "\t\t<PARTY>\n" +
                        "\t\t\t<PARTYTYPE>Agility Office</PARTYTYPE>\n" +
                        "\t\t\t<PARTYID>10012991</PARTYID>\n" +
                        "\t\t\t<PARTYNAME>AGILITY LOGISTICS CORP.</PARTYNAME>\n" +
                        "\t\t\t<NWCCODE>ORD</NWCCODE>\n" +
                        "\t\t\t<ADDRESS>\n" +
                        "\t\t\t\t<ADDRESSTYPE></ADDRESSTYPE>\n" +
                        "\t\t\t\t<ADDRESSLINE1>491 Supreme Drive\n" +
                        "</ADDRESSLINE1>\n" +
                        "\t\t\t\t<ADDRESSLINE2>Bensenville, IL 60106</ADDRESSLINE2>\n" +
                        "\t\t\t\t<ADDRESSLINE3>United States</ADDRESSLINE3>\n" +
                        "\t\t\t\t<ADDRESSLINE4></ADDRESSLINE4>\n" +
                        "\t\t\t\t<ADDRESSLINE5></ADDRESSLINE5>\n" +
                        "\t\t\t\t<ADDRESSLINE6></ADDRESSLINE6>\n" +
                        "\t\t\t\t<CITY>Bensenville</CITY>\n" +
                        "\t\t\t\t<STATE>Illinois</STATE>\n" +
                        "\t\t\t\t<COUNTRYCODE>US</COUNTRYCODE>\n" +
                        "\t\t\t\t<COUNTRYNAME>United States</COUNTRYNAME>\n" +
                        "\t\t\t\t<POSTCODE>60106</POSTCODE>\n" +
                        "\t\t\t\t<PARTYREFERENCES>\n" +
                        "\t\t\t\t\t<REFERENCEVALUE>1200USORDUS120016BRNORDOE0320/</REFERENCEVALUE>\n" +
                        "\t\t\t\t</PARTYREFERENCES>\n" +
                        "\t\t\t\t<CONTACTDETAILS>\n" +
                        "\t\t\t\t\t<CONTACTTYPE>USERNAME</CONTACTTYPE>\n" +
                        "\t\t\t\t\t<CONTACT>Export Job </CONTACT>\n" +
                        "\t\t\t\t</CONTACTDETAILS>\n" +
                        "\t\t\t\t<CONTACTDETAILS>\n" +
                        "\t\t\t\t\t<CONTACTTYPE>WORKPHONE</CONTACTTYPE>\n" +
                        "\t\t\t\t\t<CONTACT>67647878</CONTACT>\n" +
                        "\t\t\t\t</CONTACTDETAILS>\n" +
                        "\t\t\t\t<CONTACTDETAILS>\n" +
                        "\t\t\t\t\t<CONTACTTYPE>EMAILID</CONTACTTYPE>\n" +
                        "\t\t\t\t\t<CONTACT>noreply@agility.com</CONTACT>\n" +
                        "\t\t\t\t</CONTACTDETAILS>\n" +
                        "\t\t\t</ADDRESS>\n" +
                        "\t\t</PARTY>\n" +
                        "\t</PARTIES>\n" +
                        "\t<JOBREFERENCES>\n" +
                        "\t\t<REFERENCES>\n" +
                        "\t\t\t<REFERENCETYPE>Archival Number</REFERENCETYPE>\n" +
                        "\t\t\t<REFERENCEVALUE>1200USORDUS120016BRNORDOE0320/000116</REFERENCEVALUE>\n" +
                        "\t\t</REFERENCES>\n" +
                        "\t\t<REFERENCES>\n" +
                        "\t\t\t<REFERENCETYPE>Consignment Id</REFERENCETYPE>\n" +
                        "\t\t\t<REFERENCEVALUE>100136887</REFERENCEVALUE>\n" +
                        "\t\t</REFERENCES>\n" +
                        "\t</JOBREFERENCES>\n" +
                        "\t<ORIGINCUSTOMSCLEARANCEBY></ORIGINCUSTOMSCLEARANCEBY>\n" +
                        "\t<DESTINATIONCUSTOMSCLEARANCEBY></DESTINATIONCUSTOMSCLEARANCEBY>\n" +
                        "\t<ISLETTEROFCREDITAPPLICABLE>No</ISLETTEROFCREDITAPPLICABLE>\n" +
                        "\t<ISINSURANCEREQUIRED>No</ISINSURANCEREQUIRED>\n" +
                        "\t<CARGOAVAILABLEDATE></CARGOAVAILABLEDATE>\n" +
                        "\t<MBLTYPE>Express</MBLTYPE>\n" +
                        "\t<MBLTERM>Prepaid</MBLTERM>\n" +
                        "\t<INSTRUCTIONDETAILS>\n" +
                        "\t\t<INSTRUCTIONS INSTRUCTIONCATEGORYTYPE =\"General\"></INSTRUCTIONS>\n" +
                        "\t</INSTRUCTIONDETAILS>\n" +
                        "\t<CONTROLTOTAL>\n" +
                        "\t\t<NUMBEROFUNITS>2</NUMBEROFUNITS>\n" +
                        "\t\t<GROSSWEIGHT UOM=\"KG\">1100</GROSSWEIGHT>\n" +
                        "\t\t<GROSSVOLUME UOM=\"CBM\">3.03</GROSSVOLUME>\n" +
                        "\t</CONTROLTOTAL>\n" +
                        "\t<CARGODETAILS>\n" +
                        "\t\t<UNIT_PACKAGE_ITEM>\n" +
                        "\t\t\t<UNIT_PACKAGE_ITEMQUALIFIER>U</UNIT_PACKAGE_ITEMQUALIFIER>\n" +
                        "\t\t\t<UNITNUMBER>UNIT001</UNITNUMBER>\n" +
                        "\t\t\t<ISSHIPPERCONTAINER>Yes</ISSHIPPERCONTAINER>\n" +
                        "\t\t\t<UNITCODE>22G0</UNITCODE>\n" +
                        "\t\t\t<UNITTYPE>20&apos; DC</UNITTYPE>\n" +
                        "\t\t\t<DESCRIPTIONOFGOODS>Test Description</DESCRIPTIONOFGOODS>\n" +
                        "\t\t\t<PIECES>100</PIECES>\n" +
                        "\t\t\t<ISHAZARDOUS>No</ISHAZARDOUS>\n" +
                        "\t\t\t<ISOOG>No</ISOOG>\n" +
                        "\t\t\t<ISTC>No</ISTC>\n" +
                        "\t\t\t<NONACTIVEREEFER></NONACTIVEREEFER>\n" +
                        "\t\t\t<MARKSANDNUMBERS>Test Marks</MARKSANDNUMBERS>\n" +
                        "\t\t\t<GROSSWEIGHT UOM=\"KG\">1000</GROSSWEIGHT>\n" +
                        "\t\t\t<NETWEIGHT UOM=\"KG\"></NETWEIGHT>\n" +
                        "\t\t\t<VOLUME UOM=\"CBM\">3</VOLUME>\n" +
                        "\t\t\t<EQUIPMENTPARTIES>\n" +
                        "\t\t\t\t<EQUIPMENTPARTY>\n" +
                        "\t\t\t\t\t<ROLE>OriginCargoCollection</ROLE>\n" +
                        "\t\t\t\t\t<NAME>Smatbot- US</NAME>\n" +
                        "\t\t\t\t\t<IDENTIFIER TYPE=\" \">10019970</IDENTIFIER>\n" +
                        "\t\t\t\t\t<UNITNUMBER>UNIT001</UNITNUMBER>\n" +
                        "\t\t\t\t\t<ADDRESS>\n" +
                        "\t\t\t\t\t\t<STREETADDRESS>300West 31st StreetManhattan</STREETADDRESS>\n" +
                        "\t\t\t\t\t\t<CITYNAME>New York</CITYNAME>\n" +
                        "\t\t\t\t\t\t<SUBDIVISION></SUBDIVISION>\n" +
                        "\t\t\t\t\t\t<POSTALCODE>10001</POSTALCODE>\n" +
                        "\t\t\t\t\t\t<COUNTRYCODE>US</COUNTRYCODE>\n" +
                        "\t\t\t\t\t\t<COUNTRYNAME>United States</COUNTRYNAME>\n" +
                        "\t\t\t\t\t</ADDRESS>\n" +
                        "\t\t\t\t\t<DATETIME DATETYPE=\"OriginCargoCollection\">2020-03-09T12:00:00.000000000</DATETIME>\n" +
                        "\t\t\t\t\t<UTCDATETIME UTCDATETYPE=\"OriginCargoCollection\">2020-03-09T16:00:00.000000000</UTCDATETIME>\n" +
                        "\t\t\t\t\t<CONTACTS>\n" +
                        "\t\t\t\t\t\t<CONTACTTYPE>NAME</CONTACTTYPE>\n" +
                        "\t\t\t\t\t\t<CONTACT>Atul</CONTACT>\n" +
                        "\t\t\t\t\t</CONTACTS>\n" +
                        "\t\t\t\t\t<CONTACTS>\n" +
                        "\t\t\t\t\t\t<CONTACTTYPE>PHONE</CONTACTTYPE>\n" +
                        "\t\t\t\t\t\t<CONTACT>1 773-922-4020</CONTACT>\n" +
                        "\t\t\t\t\t</CONTACTS>\n" +
                        "\t\t\t\t</EQUIPMENTPARTY>\n" +
                        "\t\t\t</EQUIPMENTPARTIES>\n" +
                        "\t\t</UNIT_PACKAGE_ITEM>\n" +
                        "\t\t<UNIT_PACKAGE_ITEM>\n" +
                        "\t\t\t<UNIT_PACKAGE_ITEMQUALIFIER>U</UNIT_PACKAGE_ITEMQUALIFIER>\n" +
                        "\t\t\t<UNITNUMBER>UNIT002</UNITNUMBER>\n" +
                        "\t\t\t<ISSHIPPERCONTAINER>No</ISSHIPPERCONTAINER>\n" +
                        "\t\t\t<UNITCODE>42G0</UNITCODE>\n" +
                        "\t\t\t<UNITTYPE>40&apos; DC</UNITTYPE>\n" +
                        "\t\t\t<DESCRIPTIONOFGOODS>Test Description</DESCRIPTIONOFGOODS>\n" +
                        "\t\t\t<PIECES>10</PIECES>\n" +
                        "\t\t\t<ISHAZARDOUS>No</ISHAZARDOUS>\n" +
                        "\t\t\t<ISOOG>No</ISOOG>\n" +
                        "\t\t\t<ISTC>No</ISTC>\n" +
                        "\t\t\t<NONACTIVEREEFER></NONACTIVEREEFER>\n" +
                        "\t\t\t<MARKSANDNUMBERS>Test Marks</MARKSANDNUMBERS>\n" +
                        "\t\t\t<GROSSWEIGHT UOM=\"KG\">100</GROSSWEIGHT>\n" +
                        "\t\t\t<NETWEIGHT UOM=\"KG\"></NETWEIGHT>\n" +
                        "\t\t\t<VOLUME UOM=\"CBM\">.03</VOLUME>\n" +
                        "\t\t\t<EQUIPMENTPARTIES>\n" +
                        "\t\t\t\t<EQUIPMENTPARTY>\n" +
                        "\t\t\t\t\t<ROLE>OriginCargoCollection</ROLE>\n" +
                        "\t\t\t\t\t<NAME>Smatbot- US</NAME>\n" +
                        "\t\t\t\t\t<IDENTIFIER TYPE=\" \">10019970</IDENTIFIER>\n" +
                        "\t\t\t\t\t<UNITNUMBER>UNIT002</UNITNUMBER>\n" +
                        "\t\t\t\t\t<ADDRESS>\n" +
                        "\t\t\t\t\t\t<STREETADDRESS>300West 31st StreetManhattan</STREETADDRESS>\n" +
                        "\t\t\t\t\t\t<CITYNAME>New York</CITYNAME>\n" +
                        "\t\t\t\t\t\t<SUBDIVISION></SUBDIVISION>\n" +
                        "\t\t\t\t\t\t<POSTALCODE>10001</POSTALCODE>\n" +
                        "\t\t\t\t\t\t<COUNTRYCODE>US</COUNTRYCODE>\n" +
                        "\t\t\t\t\t\t<COUNTRYNAME>United States</COUNTRYNAME>\n" +
                        "\t\t\t\t\t</ADDRESS>\n" +
                        "\t\t\t\t\t<DATETIME DATETYPE=\"OriginCargoCollection\">2020-03-09T12:00:00.000000000</DATETIME>\n" +
                        "\t\t\t\t\t<UTCDATETIME UTCDATETYPE=\"OriginCargoCollection\">2020-03-09T16:00:00.000000000</UTCDATETIME>\n" +
                        "\t\t\t\t\t<CONTACTS>\n" +
                        "\t\t\t\t\t\t<CONTACTTYPE>NAME</CONTACTTYPE>\n" +
                        "\t\t\t\t\t\t<CONTACT>Atul</CONTACT>\n" +
                        "\t\t\t\t\t</CONTACTS>\n" +
                        "\t\t\t\t\t<CONTACTS>\n" +
                        "\t\t\t\t\t\t<CONTACTTYPE>PHONE</CONTACTTYPE>\n" +
                        "\t\t\t\t\t\t<CONTACT>1 773-922-4020</CONTACT>\n" +
                        "\t\t\t\t\t</CONTACTS>\n" +
                        "\t\t\t\t</EQUIPMENTPARTY>\n" +
                        "\t\t\t</EQUIPMENTPARTIES>\n" +
                        "\t\t</UNIT_PACKAGE_ITEM>\n" +
                        "\t\t<UNIT_PACKAGE_ITEM>\n" +
                        "\t\t\t<UNIT_PACKAGE_ITEMQUALIFIER>S</UNIT_PACKAGE_ITEMQUALIFIER>\n" +
                        "\t\t\t<DESCRIPTIONOFGOODS></DESCRIPTIONOFGOODS>\n" +
                        "\t\t\t<PIECES>110</PIECES>\n" +
                        "\t\t\t<ISHAZARDOUS></ISHAZARDOUS>\n" +
                        "\t\t\t<ISOOG></ISOOG>\n" +
                        "\t\t\t<ISTC></ISTC>\n" +
                        "\t\t\t<MARKSANDNUMBERS></MARKSANDNUMBERS>\n" +
                        "\t\t\t<PACKAGETYPE>BX</PACKAGETYPE>\n" +
                        "\t\t\t<PACKAGETYPEDESCRIPTION>Box(es)</PACKAGETYPEDESCRIPTION>\n" +
                        "\t\t\t<NONSTACKABLE></NONSTACKABLE>\n" +
                        "\t\t\t<HSCODE></HSCODE>\n" +
                        "\t\t\t<GROSSWEIGHT UOM=\"KG\">1100</GROSSWEIGHT>\n" +
                        "\t\t\t<NETWEIGHT UOM=\"KG\"></NETWEIGHT>\n" +
                        "\t\t\t<VOLUME UOM=\"CBM\">3.03</VOLUME>\n" +
                        "\t\t\t<EQUIPMENTPARTIES></EQUIPMENTPARTIES>\n" +
                        "\t\t\t<DIMENSION>\n" +
                        "\t\t\t\t<LENGTH></LENGTH>\n" +
                        "\t\t\t\t<BREADTH></BREADTH>\n" +
                        "\t\t\t\t<HEIGHT></HEIGHT>\n" +
                        "\t\t\t</DIMENSION>\n" +
                        "\t\t\t<UNIT_PACKAGEREFERENCE></UNIT_PACKAGEREFERENCE>\n" +
                        "\t\t</UNIT_PACKAGE_ITEM>\n" +
                        "\t\t<UNIT_PACKAGE_ITEM>\n" +
                        "\t\t\t<UNIT_PACKAGE_ITEMQUALIFIER>P</UNIT_PACKAGE_ITEMQUALIFIER>\n" +
                        "\t\t\t<DESCRIPTIONOFGOODS>Test Description</DESCRIPTIONOFGOODS>\n" +
                        "\t\t\t<PIECES>100</PIECES>\n" +
                        "\t\t\t<ISHAZARDOUS>No</ISHAZARDOUS>\n" +
                        "\t\t\t<ISOOG>No</ISOOG>\n" +
                        "\t\t\t<ISTC>No</ISTC>\n" +
                        "\t\t\t<MARKSANDNUMBERS>Laptops</MARKSANDNUMBERS>\n" +
                        "\t\t\t<PACKAGETYPE>BX</PACKAGETYPE>\n" +
                        "\t\t\t<PACKAGETYPEDESCRIPTION>Box(es)</PACKAGETYPEDESCRIPTION>\n" +
                        "\t\t\t<NONSTACKABLE>No</NONSTACKABLE>\n" +
                        "\t\t\t<HSCODE></HSCODE>\n" +
                        "\t\t\t<GROSSWEIGHT UOM=\"KG\">1000</GROSSWEIGHT>\n" +
                        "\t\t\t<NETWEIGHT UOM=\"KG\"></NETWEIGHT>\n" +
                        "\t\t\t<VOLUME UOM=\"CBM\">3</VOLUME>\n" +
                        "\t\t\t<EQUIPMENTPARTIES></EQUIPMENTPARTIES>\n" +
                        "\t\t\t<DIMENSION UOM=\"M\">\n" +
                        "\t\t\t\t<LENGTH>.3</LENGTH>\n" +
                        "\t\t\t\t<BREADTH>.25</BREADTH>\n" +
                        "\t\t\t\t<HEIGHT>.4</HEIGHT>\n" +
                        "\t\t\t</DIMENSION>\n" +
                        "\t\t\t<UNIT_PACKAGEREFERENCE>UNIT001</UNIT_PACKAGEREFERENCE>\n" +
                        "\t\t</UNIT_PACKAGE_ITEM>\n" +
                        "\t\t<UNIT_PACKAGE_ITEM>\n" +
                        "\t\t\t<UNIT_PACKAGE_ITEMQUALIFIER>P</UNIT_PACKAGE_ITEMQUALIFIER>\n" +
                        "\t\t\t<DESCRIPTIONOFGOODS>Test Description</DESCRIPTIONOFGOODS>\n" +
                        "\t\t\t<PIECES>10</PIECES>\n" +
                        "\t\t\t<ISHAZARDOUS>No</ISHAZARDOUS>\n" +
                        "\t\t\t<ISOOG>No</ISOOG>\n" +
                        "\t\t\t<ISTC>No</ISTC>\n" +
                        "\t\t\t<MARKSANDNUMBERS>Laptops</MARKSANDNUMBERS>\n" +
                        "\t\t\t<PACKAGETYPE>BX</PACKAGETYPE>\n" +
                        "\t\t\t<PACKAGETYPEDESCRIPTION>Box(es)</PACKAGETYPEDESCRIPTION>\n" +
                        "\t\t\t<NONSTACKABLE>No</NONSTACKABLE>\n" +
                        "\t\t\t<HSCODE></HSCODE>\n" +
                        "\t\t\t<GROSSWEIGHT UOM=\"KG\">100</GROSSWEIGHT>\n" +
                        "\t\t\t<NETWEIGHT UOM=\"KG\"></NETWEIGHT>\n" +
                        "\t\t\t<VOLUME UOM=\"CBM\">.03</VOLUME>\n" +
                        "\t\t\t<EQUIPMENTPARTIES></EQUIPMENTPARTIES>\n" +
                        "\t\t\t<DIMENSION UOM=\"M\">\n" +
                        "\t\t\t\t<LENGTH>.2</LENGTH>\n" +
                        "\t\t\t\t<BREADTH>.15</BREADTH>\n" +
                        "\t\t\t\t<HEIGHT>.1</HEIGHT>\n" +
                        "\t\t\t</DIMENSION>\n" +
                        "\t\t\t<UNIT_PACKAGEREFERENCE>UNIT002</UNIT_PACKAGEREFERENCE>\n" +
                        "\t\t</UNIT_PACKAGE_ITEM>\n" +
                        "\t</CARGODETAILS>\n" +
                        "\t<TRANSPORTDETAILS>\n" +
                        "\t\t<TRANSPORT TRANSPORTMODE=\"Maritime\" TRANSPORTSTAGE=\"Main\">\n" +
                        "\t\t\t<HAULAGEARRANGEMENT MOVEMENTTYPE=\"MM\" SERVICETYPE=\"FullLoad\"></HAULAGEARRANGEMENT>\n" +
                        "\t\t\t<LOCATION LOCATIONTYPE=\"PortOfDischarge\">\n" +
                        "\t\t\t\t<LOCATIONCODE LOCATIONQUALIFIER=\"UN\">USCHI</LOCATIONCODE>\n" +
                        "\t\t\t\t<LOCATIONNAME>Chicago</LOCATIONNAME>\n" +
                        "\t\t\t\t<CITY>Chicago</CITY>\n" +
                        "\t\t\t\t<SUBDIVISION></SUBDIVISION>\n" +
                        "\t\t\t\t<COUNTRYNAME>United States</COUNTRYNAME>\n" +
                        "\t\t\t\t<LOCATIONCOUNTRY>US</LOCATIONCOUNTRY>\n" +
                        "\t\t\t</LOCATION>\n" +
                        "\t\t\t<LOCATION LOCATIONTYPE=\"PortOfLoading\">\n" +
                        "\t\t\t\t<LOCATIONCODE LOCATIONQUALIFIER=\"UN\">INNSA</LOCATIONCODE>\n" +
                        "\t\t\t\t<LOCATIONNAME>Nhava Sheva </LOCATIONNAME>\n" +
                        "\t\t\t\t<CITY>Nhava Sheva </CITY>\n" +
                        "\t\t\t\t<SUBDIVISION></SUBDIVISION>\n" +
                        "\t\t\t\t<COUNTRYNAME>India</COUNTRYNAME>\n" +
                        "\t\t\t\t<LOCATIONCOUNTRY>IN</LOCATIONCOUNTRY>\n" +
                        "\t\t\t</LOCATION>\n" +
                        "\t\t\t<LOCATION LOCATIONTYPE=\"PlaceOfReceipt\">\n" +
                        "\t\t\t\t<LOCATIONCODE LOCATIONQUALIFIER=\"UN\">USNYC</LOCATIONCODE>\n" +
                        "\t\t\t\t<LOCATIONNAME>New York</LOCATIONNAME>\n" +
                        "\t\t\t\t<CITY>New York</CITY>\n" +
                        "\t\t\t\t<SUBDIVISION></SUBDIVISION>\n" +
                        "\t\t\t\t<COUNTRYNAME>United States</COUNTRYNAME>\n" +
                        "\t\t\t\t<LOCATIONCOUNTRY>US</LOCATIONCOUNTRY>\n" +
                        "\t\t\t</LOCATION>\n" +
                        "\t\t\t<LOCATION LOCATIONTYPE=\"PlaceOfDelivery\">\n" +
                        "\t\t\t\t<LOCATIONCODE LOCATIONQUALIFIER=\"UN\">USCHI</LOCATIONCODE>\n" +
                        "\t\t\t\t<LOCATIONNAME>Chicago</LOCATIONNAME>\n" +
                        "\t\t\t\t<CITY>Chicago</CITY>\n" +
                        "\t\t\t\t<SUBDIVISION></SUBDIVISION>\n" +
                        "\t\t\t\t<COUNTRYNAME>United States</COUNTRYNAME>\n" +
                        "\t\t\t\t<LOCATIONCOUNTRY>US</LOCATIONCOUNTRY>\n" +
                        "\t\t\t</LOCATION>\n" +
                        "\t\t\t<LOCATION LOCATIONTYPE=\"CarrierPlaceOfReceipt\">\n" +
                        "\t\t\t\t<LOCATIONCODE LOCATIONQUALIFIER=\"UN\">INNSA</LOCATIONCODE>\n" +
                        "\t\t\t\t<LOCATIONNAME>Nhava Sheva </LOCATIONNAME>\n" +
                        "\t\t\t\t<CITY>Nhava Sheva </CITY>\n" +
                        "\t\t\t\t<SUBDIVISION></SUBDIVISION>\n" +
                        "\t\t\t\t<COUNTRYNAME>India</COUNTRYNAME>\n" +
                        "\t\t\t\t<LOCATIONCOUNTRY>IN</LOCATIONCOUNTRY>\n" +
                        "\t\t\t</LOCATION>\n" +
                        "\t\t\t<LOCATION LOCATIONTYPE=\"CarrierPlaceOfDelivery\">\n" +
                        "\t\t\t\t<LOCATIONCODE LOCATIONQUALIFIER=\"UN\">USCHI</LOCATIONCODE>\n" +
                        "\t\t\t\t<LOCATIONNAME>Chicago</LOCATIONNAME>\n" +
                        "\t\t\t\t<CITY>Chicago</CITY>\n" +
                        "\t\t\t\t<SUBDIVISION></SUBDIVISION>\n" +
                        "\t\t\t\t<COUNTRYNAME>United States</COUNTRYNAME>\n" +
                        "\t\t\t\t<LOCATIONCOUNTRY>US</LOCATIONCOUNTRY>\n" +
                        "\t\t\t</LOCATION>\n" +
                        "\t\t\t<CONVEYANCEINFORMATION>\n" +
                        "\t\t\t\t<VESSELNAME>Single Leg Vessel</VESSELNAME>\n" +
                        "\t\t\t\t<VOYAGENUMBER>Single Leg Voyage</VOYAGENUMBER>\n" +
                        "\t\t\t\t<CARRIAGEFLAG></CARRIAGEFLAG>\n" +
                        "\t\t\t\t<IMONUMBER></IMONUMBER>\n" +
                        "\t\t\t\t<CARRIERBOOKINGREFERENCE></CARRIERBOOKINGREFERENCE>\n" +
                        "\t\t\t\t<CARRIERDOCCUTOFF></CARRIERDOCCUTOFF>\n" +
                        "\t\t\t\t<CARRIERCARGOCUTOFF></CARRIERCARGOCUTOFF>\n" +
                        "\t\t\t\t<ETD>2020-03-15T12:00:00.000000000</ETD>\n" +
                        "\t\t\t\t<ETA>2020-03-22T12:00:00.000000000</ETA>\n" +
                        "\t\t\t\t<ETDUTC>2020-03-15T06:30:00.000000000</ETDUTC>\n" +
                        "\t\t\t\t<ETAUTC>2020-03-22T17:00:00.000000000</ETAUTC>\n" +
                        "\t\t\t\t<CARRIERSCAC>MAEU</CARRIERSCAC>\n" +
                        "\t\t\t\t<CARRIERNAME>Maersk A/S</CARRIERNAME>\n" +
                        "\t\t\t\t<CARRIERCONTRACTNUMBERS>\n" +
                        "\t\t\t\t\t<CONTRACTTYPE>SPOTRATENO</CONTRACTTYPE>\n" +
                        "\t\t\t\t\t<CONTRACTNUMBER>FAK-AutoContract</CONTRACTNUMBER>\n" +
                        "\t\t\t\t</CARRIERCONTRACTNUMBERS>\n" +
                        "\t\t\t</CONVEYANCEINFORMATION>\n" +
                        "\t\t</TRANSPORT>\n" +
                        "\t</TRANSPORTDETAILS>\n" +
                        "\t<EVENTDETAILS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>International Departure</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Nhava Sheva </EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-15T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-15T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-15T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>NON-PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Origin Invoicing</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-15T01:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-15T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-15T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Carrier Booking Confirmation</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-08T07:19:09.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-08T12:19:09.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-08T12:19:09.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Booking Confirmation to Customer</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME></EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME></EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME></EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Departure Confirmation</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-15T01:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-15T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-15T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Arrival Confirmation</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Mumbai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-22T22:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-22T17:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-22T17:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Job</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Job Initiated</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Actual</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Mumbai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-08T17:50:48.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-08T12:20:48.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-08T12:20:48.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Job</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Job Preconfirmed</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Actual</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Mumbai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-08T17:51:26.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-08T12:21:26.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-08T12:21:26.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>NON-PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Manifestation</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Mumbai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-17T22:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-17T17:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-17T17:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>NON-PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Destination Invoicing</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Mumbai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-17T22:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-17T17:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-17T17:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Master Bill of Lading Approval</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-15T01:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-15T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-15T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Final Master Bill of Lading</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-15T01:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-15T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-15T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Origin Handling and Documents</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Canceled</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-15T01:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-15T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-15T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>VGM - Verified Gross Mass</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION></EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME></EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME></EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME></EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Master Bill of Lading Instructions</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION></EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME></EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME></EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME></EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Seaquest Line Bill of Lading</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-15T01:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-15T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-15T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Carrier Booking Request</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Actual</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-08T12:20:48.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-08T12:20:48.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-08T12:20:48.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Arrival Notice</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Mumbai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-22T22:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-22T17:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-22T17:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Cargo Release to Customer</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Mumbai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-25T22:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-25T17:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-25T17:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Vessel Arrival</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chennai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-16T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-16T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-16T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Vessel Departure</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Nhava Sheva </EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-15T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-15T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-15T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Transit Arrival 1</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chennai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-16T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-16T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-16T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Vessel Departure</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chennai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-17T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-17T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-17T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Vessel Arrival</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Dubai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-18T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-18T08:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-18T08:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Transit Departure 1</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chennai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-17T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-17T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-17T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Transit Arrival 2</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Dubai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-18T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-18T08:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-18T08:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Vessel Departure</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Dubai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-19T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-19T08:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-19T08:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>International Arrival</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-22T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-22T17:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-22T17:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Vessel Arrival</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-22T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-22T17:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-22T17:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Transit Departure 2</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Dubai</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-19T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-19T08:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-19T08:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Origin Cargo Collection</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>New York</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-09T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-09T16:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-09T16:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>PPSAC</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Origin Handling and Documents</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Chicago</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-15T01:30:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-15T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-15T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Physical receipt of Goods</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>New York</EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-09T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-09T16:00:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-09T16:00:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t\t<EVENTS>\n" +
                        "\t\t\t<EVENTTYPE>Cargo</EVENTTYPE>\n" +
                        "\t\t\t<EVENTNAME>Origin Cargo Delivery</EVENTNAME>\n" +
                        "\t\t\t<EVENTSTATUS>Expected</EVENTSTATUS>\n" +
                        "\t\t\t<EVENTLOCATION>Nhava Sheva </EVENTLOCATION>\n" +
                        "\t\t\t<EVENTLOCATIONDATETIME>2020-03-13T12:00:00.000000</EVENTLOCATIONDATETIME>\n" +
                        "\t\t\t<EVENTLOCATIONUTCDATETIME>2020-03-13T06:30:00.000000</EVENTLOCATIONUTCDATETIME>\n" +
                        "\t\t\t<REMARKS></REMARKS>\n" +
                        "\t\t\t<EVENTUPDATEDUTCDATETIME>2020-03-13T06:30:00.000000</EVENTUPDATEDUTCDATETIME>\n" +
                        "\t\t\t<EVENTUPDATEDBY>exportjob</EVENTUPDATEDBY>\n" +
                        "\t\t</EVENTS>\n" +
                        "\t</EVENTDETAILS>\n" +
                        "</DETAILS>";

        XmlMapper mapper = new XmlMapper();
        JOBDETAILS site = mapper.readValue(xmlFile, JOBDETAILS.class);
//        System.out.println(site);
//        System.out.println(site.getCreationDate());
//        System.out.println(site.getParties().getParty().get(1).getPartyType());
//        System.out.println(site.getParties().getParty().get(1).getAddress().getAddressAsString());
//        System.out.println(site.getParties().getParty().get(1).getAddress().getPartyReferences().getReference());
//        System.out.println(site.getParties().getParty().size());
//        System.out.println(site.getJobReferences().getReferences().get(1).getReferenceValue());
//        System.out.println(site.getJobReferences().getReferences().get(1).getReferenceType());
//        for(int i = 0;i<site.getParties().getParty().size();i++){
//            System.out.println(site.getParties().getParty().get(i).getPartyType());
//            System.out.println(site.getParties().getParty().get(i).getPartyName());
//            System.out.println(site.getParties().getParty().get(i).getAddress().getAddressAsString());
//            System.out.println(site.getParties().getParty().get(i).getAddress().getPartyReferences().getReference());
//        }
//        System.out.println(site.getJobReferences().getReferences().get(0).getReferenceType());
//        System.out.println(site.getJobReferences().getReferences().get(0).getReferenceValue());
//        System.out.println(site.getJobReferences().getReferences().get(1).getReferenceType());
//        System.out.println(site.getJobReferences().getReferences().get(1).getReferenceValue());
//        System.out.println(site.getTransportdetails().getTrasnports().get(0).getTRANSPORTMODE());
//        System.out.println(site.getTransportdetails().getTrasnports().get(0).getLocations().get(0).getLOCATIONTYPE());
//        System.out.println(site.getTransportdetails().getTrasnports().get(0).getLocations().get(0).getLocationcode().getCode());
//        System.out.println(site.getEventdetails().getEvents().size());
//        System.out.println(site.getEventdetails().getEvents().get(0).getEventName());
//        System.out.println(site.getTransportdetails().getTrasnports().get(0).getConveyanceinformation().getCarriercontractnumbers().getCarrierType());


        //        Party Parties = mapper.readValue(xmlFile, Party.class);
//        System.out.println(Parties);
//        System.out.println(Parties.getPartyType());
//        System.out.println(site.getParties());
        System.out.println(site.getTransportdetails().getTrasnports().get(0).getLocations().get(0).getLocationcode().getCode());
        System.out.println(site.getTransportdetails().getTrasnports().get(0).getLocations().get(0).getLocationcode().getLOCATIONQUALIFIER());
        System.out.println(site.getTransportdetails().getTrasnports().get(0).getLocations().get(0).getLocationName());
    }
}
