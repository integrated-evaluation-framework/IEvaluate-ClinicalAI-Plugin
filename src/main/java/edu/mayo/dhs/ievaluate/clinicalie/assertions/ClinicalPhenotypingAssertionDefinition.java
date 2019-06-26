package edu.mayo.dhs.ievaluate.clinicalie.assertions;

import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionDefinition;
import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionInput;
import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionOutput;

/**
 * An assertion definition for clinical phenotyping tasks
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
