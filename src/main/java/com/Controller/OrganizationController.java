package com.Controller;

import com.Model.OrganizationStructure;
import com.Service.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;

@Controller
public class OrganizationController {

    String xmlFile = "C:\\Users\\twllei\\Documents\\OrgStructure.xml";

    OrganizationService orgService = new OrganizationService();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void index() throws IOException {
    }

    @RequestMapping(value = "/getOrgStructure", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody OrganizationStructure getOrgStructure() throws IOException {
        OrganizationStructure orgStruc = orgService.getOrgStructure(xmlFile);
        return orgStruc;
    }

    @RequestMapping(value = "/convertToJson", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String convertToJson() throws IOException {
        String fileContent = orgService.convertToJson(xmlFile);
        return fileContent;
    }

}
