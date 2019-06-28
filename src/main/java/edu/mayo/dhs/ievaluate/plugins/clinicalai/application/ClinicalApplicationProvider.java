package edu.mayo.dhs.ievaluate.plugins.clinicalai.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mayo.dhs.ievaluate.api.applications.ApplicationProvider;
import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;

public class ClinicalApplicationProvider implements ApplicationProvider<ClinicalApplication> {

    private ObjectMapper om = new ObjectMapper();

    @Override
    public String applicationName() {
        return "Clinical Application";
    }

    @Override
    public Class<ClinicalApplication> applicationClass() {
        return ClinicalApplication.class;
    }

    @Override
    public JsonNode marshal(ProfiledApplication applicationInstance) {
        if (applicationInstance instanceof ClinicalApplication) {
            // We can just use jackson; how fortunate!
            return om.valueToTree(applicationInstance);
        } else {
            throw new IllegalArgumentException(applicationInstance.getClass().getName() + " cannot be marshaled using " + getClass().getName());
        }
    }

    @Override
    public ClinicalApplication unmarshal(JsonNode json) throws JsonProcessingException {
        return om.treeToValue(json, ClinicalApplication.class);
    }

    @Override
    public ClinicalApplication produceNew() {
        return new ClinicalApplication();
    }
}
