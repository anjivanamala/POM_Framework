package com.agility.focis.CBR;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parties {
    @JacksonXmlElementWrapper(localName = "PARTY", useWrapping = false)
    @JacksonXmlProperty(localName = "PARTY")
    private ArrayList<Party> party;

    public ArrayList<Party> getParty() {
        return party;
    }

    public void setParty(ArrayList<Party> party) {
        this.party = party;
    }

    public Map<String, Map<String, String>> getpartyInformation() {
        Map<String, Map<String, String>> partiesinfo = new HashMap<>();
        Map<String, String> agilityOffice = new HashMap<>();
        Map<String, String> branch = new HashMap<>();
        Map<String, String> shipper = new HashMap<>();
        Map<String, String> consignee = new HashMap<>();
        Map<String, String> notifyParty = new HashMap<>();
        for (int i = 0; i < getParty().size(); i++) {
            if (getParty().get(i).getPartyType().equalsIgnoreCase("Agility Office")) {
                agilityOffice.put("Name", getParty().get(i).getPartyName());
                agilityOffice.put("Address", getParty().get(i).getAddress().getAddressAsString());
            } else if (getParty().get(i).getPartyType().equalsIgnoreCase("BRANCH")) {
                branch.put("Name", getParty().get(i).getPartyName());
                branch.put("Address", getParty().get(i).getAddress().getAddressAsString());
            } else if (getParty().get(i).getPartyType().equalsIgnoreCase("Shipper")) {
                shipper.put("Name", getParty().get(i).getPartyName());
                shipper.put("Address", getParty().get(i).getAddress().getAddressAsString());
            } else if (getParty().get(i).getPartyType().equalsIgnoreCase("Consignee")) {
                consignee.put("Name", getParty().get(i).getPartyName());
                consignee.put("Address", getParty().get(i).getAddress().getAddressAsString());
            } else if (getParty().get(i).getPartyType().equalsIgnoreCase("Notify Party")) {
                notifyParty.put("Name", getParty().get(i).getPartyName());
                notifyParty.put("Address", getParty().get(i).getAddress().getAddressAsString());
            }
        }
        partiesinfo.put("Agility Office", agilityOffice);
        partiesinfo.put("Branch", branch);
        partiesinfo.put("Shipper", shipper);
        partiesinfo.put("Consignee", consignee);
        partiesinfo.put("Notify Party", notifyParty);
        return partiesinfo;
    }
}
