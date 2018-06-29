package com.Model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class OrgLevel {

    private int size;

    private List<RuleSet> AssignedRuleSets;

    private List<RuleSet> UnassignedRuleSets;

   @XmlElement(name = "SIZE")
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @XmlElement(name = "AssignedRuleSets")
    public List<RuleSet> getAssignedRuleSets() {
        return AssignedRuleSets;
    }

    public void setAssignedRuleSets(List<RuleSet> assignedRuleSets) {

        this.AssignedRuleSets = assignedRuleSets;
    }

    @XmlElement(name = "UnassignedRuleSets")
    public List<RuleSet> getUnassignedRuleSets() {
        return UnassignedRuleSets;
    }

    public void setUnassignedRuleSets(List<RuleSet> unassignedRuleSets) {

        this.UnassignedRuleSets = unassignedRuleSets;
    }
}
