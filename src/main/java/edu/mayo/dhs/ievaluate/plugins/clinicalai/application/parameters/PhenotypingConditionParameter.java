package edu.mayo.dhs.ievaluate.plugins.clinicalai.application.parameters;

import com.fasterxml.jackson.databind.JsonNode;
import edu.mayo.dhs.ievaluate.api.applications.definitions.ApplicationParameter;

public class PhenotypingConditionParameter implements ApplicationParameter {
    @Override
    public String fieldName() {
        return "conditions";
    }

    @Override
    public String getLabel() {
        return "Condition Name";
    }

    @Override
    public String getValidationRegex() {
        return null;
    }

    @Override
    public String getAcceptedValuesHumanReadible() {
        return null;
    }

    @Override
    public Class<?> getParameterType() {
        return String.class;
    }

    @Override
    public boolean isCollection() {
        return true;
    }

    @Override
    public JsonNode toApplicationJson(JsonNode input) {
        return input;
    }
}
