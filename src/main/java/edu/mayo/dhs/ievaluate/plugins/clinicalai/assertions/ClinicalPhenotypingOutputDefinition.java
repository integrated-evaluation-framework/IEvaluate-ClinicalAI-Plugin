package edu.mayo.dhs.ievaluate.plugins.clinicalai.assertions;

import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionOutput;

import java.util.*;

public class ClinicalPhenotypingOutputDefinition extends AssertionOutput {

    private boolean positive;

    private static final String PARAM_IS_POSITIVE_CASE = "Is a Positive Case";

    @Override
    public List<String> valueFieldNames() {
        return Collections.singletonList(PARAM_IS_POSITIVE_CASE);
    }

    @Override
    public Map<String, String> asValueMap() {
        HashMap<String, String> ret = new HashMap<>();
        ret.put(PARAM_IS_POSITIVE_CASE, positive + "");
        return ret;
    }

    @Override
    public void fromOutputMap(Map<String, String> values) {
        positive = Boolean.valueOf(values.get(PARAM_IS_POSITIVE_CASE));
    }

    @Override
    public boolean matches(AssertionOutput o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClinicalPhenotypingOutputDefinition that = (ClinicalPhenotypingOutputDefinition) o;
        return positive == that.positive;
    }

    @Override
    public int toHash() {
        return Objects.hash(super.hashCode(), positive);
    }
}
