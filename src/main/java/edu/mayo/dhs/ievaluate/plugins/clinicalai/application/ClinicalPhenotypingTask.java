package edu.mayo.dhs.ievaluate.plugins.clinicalai.application;

import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionDefinition;
import edu.mayo.dhs.ievaluate.plugins.clinicalai.assertions.ClinicalPhenotypingAssertionDefinition;

public class ClinicalPhenotypingTask extends ClinicalApplicationTask {

    private String conditionName;

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    @Override
    public String getName() {
        return "HAS_" + conditionName.toUpperCase().replaceAll("[\\s\\t]", "_");
    }

    @Override
    public Class<? extends AssertionDefinition> getTaskAssertionDef() {
        return ClinicalPhenotypingAssertionDefinition.class;
    }
}
