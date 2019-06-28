package edu.mayo.dhs.ievaluate.plugins.clinicalai;

import edu.mayo.dhs.ievaluate.api.IEvaluate;
import edu.mayo.dhs.ievaluate.api.plugins.IEvaluatePlugin;
import edu.mayo.dhs.ievaluate.plugins.clinicalai.application.ClinicalApplicationProvider;
import edu.mayo.dhs.ievaluate.plugins.clinicalai.assertions.ClinicalPhenotypingAssertionDefinition;

public class IEvaluateClinicalAIPlugin extends IEvaluatePlugin {
    @Override
    public void onInit() {
        IEvaluate.getServer().getApplicationManager().registerApplicationProvider(new ClinicalApplicationProvider());
        IEvaluate.getServer().registerAssertionDefinition(ClinicalPhenotypingAssertionDefinition.class);
    }
}
