package com.agility.focis.utilities.edi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

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
}
