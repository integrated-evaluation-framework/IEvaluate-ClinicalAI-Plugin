package edu.mayo.dhs.ievaluate.plugins.clinicalai.assertions;

import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionDefinition;
import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionInput;
import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionOutput;

/**
 * An assertion definition for clinicalai phenotyping tasks
 */
public class ClinicalPhenotypingAssertionDefinition extends AssertionDefinition {
    @Override
    public Class<? extends AssertionInput> getInputType() {
        return ClinicalPhenotypingInputDefinition.class;
    }

    @Override
    public Class<? extends AssertionOutput> getOutputType() {
        return ClinicalPhenotypingOutputDefinition.class;
    }
}
