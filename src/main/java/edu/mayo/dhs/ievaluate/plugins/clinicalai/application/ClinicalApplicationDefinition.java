package edu.mayo.dhs.ievaluate.plugins.clinicalai.application;

import edu.mayo.dhs.ievaluate.api.IEvaluate;
import edu.mayo.dhs.ievaluate.api.applications.ApplicationDefinition;
import edu.mayo.dhs.ievaluate.api.applications.ApplicationProvider;
import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.applications.definitions.ApplicationParameter;

import java.util.List;

public class ClinicalApplicationDefinition extends ApplicationDefinition {
    @Override
    public String definitionName() {
        return "Clinical Application";
    }

    @Override
    public ApplicationProvider<? extends ProfiledApplication> getApplicationProvider() {
        return IEvaluate.getApplicationManager().getApplicationProviders().get(ClinicalApplication.class.getName()); // Callback to API, registration should be handled separately
    }

    @Override
    public List<ApplicationParameter> asParameterList() {
        return null;
    }
}
