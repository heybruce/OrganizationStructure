package com.Service;

import com.Model.Org;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import com.Model.OrganizationStructure;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class OrganizationService {

    public String convertToJson(String orgXml) throws IOException {

        JSONObject jsonObj;
        String jsonString;

        //convert xml to json obj
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(orgXml)));
            String line;
            StringBuilder sb = new StringBuilder();
            while((line=br.readLine())!= null){
                sb.append(line.trim());
            }

            jsonObj = XML.toJSONObject(sb.toString());
            jsonString = jsonObj.toString();
        } catch (JSONException je) {
            throw new RuntimeException(je);
        }

        return jsonString;
    }


    public String toJson(String orgXml) throws IOException{

        XmlMapper xmlMapper = new XmlMapper();
        List orgList = xmlMapper.readValue(new File(orgXml), List.class);
        ObjectMapper jsonMapper = new ObjectMapper();
        String orgJson = jsonMapper.writeValueAsString(orgList);

        return orgJson;
    }


    public OrganizationStructure getOrgStructure(String orgXml) throws IOException {

        OrganizationStructure orgStructure = new OrganizationStructure();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(OrganizationStructure.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            orgStructure = (OrganizationStructure) jaxbUnmarshaller.unmarshal(new File(orgXml));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        int numOfLv1Org = 0;
        int numOfLv2Org = 0;
        int numOfLv3Org = 0;
        HashMap<String, List<String>> orgDict = new HashMap<String, List<String>>();
        String memberId;
        String parentId;

        for (Org org : orgStructure.getOrgList()) {

            memberId = org.getMemberId();
            if (!(orgDict.containsKey(memberId))) {         // check if key is existed
                orgDict.put(memberId, new ArrayList<>());   // add memberId as key
            }
            if (org.getOrgLevel() == 1) {
                numOfLv1Org++;
                orgStructure.setNumOfLv1Org(numOfLv1Org);
            }
            if (org.getOrgLevel() == 2) {
                numOfLv2Org++;
                orgStructure.setNumOfLv2Org(numOfLv2Org);
            }
            if (org.getOrgLevel() == 3) {
                numOfLv3Org++;
                orgStructure.setNumOfLv3Org(numOfLv3Org);
            }
        }

        for (Org org : orgStructure.getOrgList()) {

            parentId = org.getParentId();
            memberId = org.getMemberId();
            if (orgDict.containsKey(parentId)) {            // check if key existed
                orgDict.get(parentId).add(memberId);        // add memberId to dictionary
            }
        }

        orgStructure.setOrgDict(orgDict);

        for (Org org : orgStructure.getOrgList()) {
            memberId = org.getMemberId();
            org.setNumOfSubOrg(orgDict.get(memberId).size());
        }

        return orgStructure;
    }


    public List<Org> getOrgList(String orgXml) throws IOException {

        List<Org> orgList;
        XmlMapper xmlMapper = new XmlMapper();
        orgList = xmlMapper.readValue(new File(orgXml), ArrayList.class);

        return orgList;
    }
}
