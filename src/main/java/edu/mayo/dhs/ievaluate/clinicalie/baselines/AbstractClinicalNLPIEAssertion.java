package edu.mayo.dhs.ievaluate.clinicalie.baselines;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mayo.dhs.ievaluate.clinicalie.ClinicalContexts.*;

/**
 * Represents an assertion made for clinical information extraction via NLP tasks.
 * The concept being extracted is defined in the specific application class
 * <br/>
 * This task consists of the following fields:
 * <ul>
 *     <li>Negation: Whether a given mention is Positive or Negated</li>
 *     <li>Certainty: Whether a given mention is Certain or Possible</li>
 *     <li>Temporality: Whether a given mention occurs in the Present or Past</li>
 *     <li>Experiencer: Whether a given mention occurs to the Patient or to a Family Member</li>
 * </ul>
 */
public abstract class AbstractClinicalNLPIEAssertion {
    @JsonIgnore
    protected ObjectMapper om = new ObjectMapper();

    protected NegationStatus negation;
    protected CertaintyStatus certainty;
    protected TemporalStatus temporality;
    protected Experiencer experiencer;

}
