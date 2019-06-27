package edu.mayo.dhs.ievaluate.plugins.clinicalai.application;

import com.fasterxml.jackson.databind.JsonNode;
import edu.mayo.dhs.ievaluate.api.applications.ApplicationProvider;
import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;

public class ClinicalApplicationProvider implements ApplicationProvider<ClinicalApplication> {
    @Override
    public String applicationName() {
        return null;
    }

    @Override
    public Class<ClinicalApplication> applicationClass() {
        return null;
    }

    @Override
    public JsonNode marshal(ProfiledApplication applicationInstance) {
        return null;
    }

    @Override
    public ClinicalApplication unmarshal(JsonNode json) {
        return null;
    }

    @Override
    public ClinicalApplication produceNew() {
        return null;
    }
}
