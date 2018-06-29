package com.Model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Org {

    private String name;

    private int orgLevel;

    private int depth;

    private String memberId;

    private String parentId;

    private String rootOrgId;

    private int numOfSubOrg;

    private List<OrgLevel> ruleSets;

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "NAME")
    public String getName() {
        return this.name;
    }


    public void setOrgLevel(int orgLevel) {
        this.orgLevel = orgLevel;
    }

    @XmlElement(name = "OrgLevel")
    public int getOrgLevel() {
        return orgLevel;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @XmlElement(name = "Depth")
    public int getDepth() {
        return depth;
    }


    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @XmlElement(name = "MemberId")
    public String getMemberId() {
        return memberId;
    }


    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @XmlElement(name = "ParentId")
    public String getParentId() {
        return parentId;
    }


    public void setRootOrgId(String rootOrgId) {
        this.rootOrgId = rootOrgId;
    }

    @XmlElement(name = "RootOrganizationId")
    public String getRootOrgId() {
        return rootOrgId;
    }


    public void setRuleSets(List<OrgLevel> ruleSets) {
        this.ruleSets = ruleSets;
    }
    @XmlElement(name = "RuleSets")
    public List<OrgLevel> getRuleSets() {
        return ruleSets;
    }

    public int getNumOfSubOrg() {
        return numOfSubOrg;
    }

    public void setNumOfSubOrg(int numOfSubOrg) {
        this.numOfSubOrg = numOfSubOrg;
    }
}
