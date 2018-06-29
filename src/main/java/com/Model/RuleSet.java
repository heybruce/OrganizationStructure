package com.Model;

import javax.xml.bind.annotation.XmlElement;

public class RuleSet {

    private String ruleSetName;

    private int weight;

    @XmlElement(name = "RuleSetName")
    public String getRuleSetName() {
        return ruleSetName;
    }

    public void setRuleSetName(String ruleSetName) {
        this.ruleSetName = ruleSetName;
    }


    @XmlElement(name = "Weight")
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
