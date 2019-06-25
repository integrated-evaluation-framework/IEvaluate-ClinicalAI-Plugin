package edu.mayo.dhs.ievaluate.clinicalie.assertions;

import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionDefinition;
import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionInput;
import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionOutput;

/**
 *
 */
public class ClinicalPhenotypingAssertion extends AssertionDefinition {
    @Override
    public Class<? extends AssertionInput> getInputType() {
        return null;
    }

    @Override
    public Class<? extends AssertionOutput> getOutputType() {
        return null;
    }
}
