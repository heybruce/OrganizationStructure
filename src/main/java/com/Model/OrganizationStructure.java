package com.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@XmlRootElement(name = "OrganizationStructure")
public class OrganizationStructure {

    private List<Org> orgList;

    private int numOfLv1Org;
    private int numOfLv2Org;
    private int numOfLv3Org;

    private HashMap<String, List<String>> orgDict;

    @XmlElement(name = "ORG")
    public List<Org> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<Org> orgList) {
        this.orgList = orgList;
    }

    public int getNumOfLv1Org() {
        return numOfLv1Org;
    }

    public int getNumOfLv2Org() {
        return numOfLv2Org;
    }

    public int getNumOfLv3Org() {
        return numOfLv3Org;
    }

    public HashMap getOrgDict() {
        return orgDict;
    }

    public void setNumOfLv1Org(int numOfLv1Org) {
        this.numOfLv1Org = numOfLv1Org;
    }

    public void setNumOfLv2Org(int numOfLv2Org) {
        this.numOfLv2Org = numOfLv2Org;
    }

    public void setNumOfLv3Org(int numOfLv3Org) {
        this.numOfLv3Org = numOfLv3Org;
    }

    public void setOrgDict(HashMap<String, List<String>> orgDict) {
        this.orgDict = orgDict;
    }
}
