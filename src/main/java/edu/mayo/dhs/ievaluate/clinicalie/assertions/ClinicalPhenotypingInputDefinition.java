package edu.mayo.dhs.ievaluate.clinicalie.assertions;

import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionInput;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClinicalPhenotypingInputDefinition extends AssertionInput {

    public static final String PARAM_KEY_PATIENT_ID = "Patient Record ID";
    public static final String PARAM_KEY_PHENOTYPE_DATE = "Phenotyping Date";

    private String mrn;
    private Date executionDate;
    private DateFormat userFriendlyDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<String> parameterNames() {
        return Arrays.asList(PARAM_KEY_PATIENT_ID, PARAM_KEY_PHENOTYPE_DATE);
    }

    @Override
    public Map<String, String> asParameterMap() {
        Map<String, String> ret = new HashMap<>();
        ret.put(PARAM_KEY_PATIENT_ID, mrn);
        ret.put(PARAM_KEY_PHENOTYPE_DATE, executionDate == null ? null : userFriendlyDateFormat.format(executionDate));
        return ret;
    }

    @Override
    public void fromParameterMap(Map<String, String> params) {
        mrn = params.get(PARAM_KEY_PATIENT_ID);
        try {
            executionDate = userFriendlyDateFormat.parse(params.get(PARAM_KEY_PHENOTYPE_DATE));
        } catch (ParseException e) {
            e.printStackTrace(); // TODO logging and error handle to prevent null
        }
    }

    @Override
    public boolean matches(AssertionInput o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClinicalPhenotypingInputDefinition that = (ClinicalPhenotypingInputDefinition) o;
        return Objects.equals(mrn, that.mrn) &&
                Objects.equals(executionDate, that.executionDate);
    }

    @Override
    public int toHash() {
        return Objects.hash(super.hashCode(), mrn, executionDate);
    }

}
