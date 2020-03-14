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
        Map<String, String> partyinfo = new HashMap<>();
        for (Party partyAttributes : party) {
            partyinfo.put("Name", partyAttributes.getPartyName());
            partyinfo.put("Address", partyAttributes.getAddress().getAddressAsString());
            partiesinfo.put(partyAttributes.getPartyType(), partyinfo);

        }
        return partiesinfo;
    }
}
