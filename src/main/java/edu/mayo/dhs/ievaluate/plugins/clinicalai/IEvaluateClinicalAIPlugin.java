package edu.mayo.dhs.ievaluate.plugins.clinicalai;

import edu.mayo.dhs.ievaluate.api.IEvaluate;
import edu.mayo.dhs.ievaluate.api.plugins.IEvaluatePlugin;
import edu.mayo.dhs.ievaluate.plugins.clinicalai.assertions.ClinicalPhenotypingAssertionDefinition;

public class IEvaluateClinicalAIPlugin extends IEvaluatePlugin {
    @Override
    public void onInit() {
        IEvaluate.getServer().registerAssertionDefinition(ClinicalPhenotypingAssertionDefinition.class);
    }
}
