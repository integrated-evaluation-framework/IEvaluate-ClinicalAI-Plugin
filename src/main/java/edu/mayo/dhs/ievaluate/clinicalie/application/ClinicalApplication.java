package edu.mayo.dhs.ievaluate.clinicalie.application;

import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;

/**
 * Represents a generic clinical application which consists of one or more {@link ClinicalApplicationTask}s
 *
 * By default, contains implementations for phenotyping tasks (i.e. "Does this patient meet a certain set of criteria"),
 * and clinical NLP information extraction tasks
 *
 * @see ClinicalPhenotypingTask
 * @see ClinicalNLPIETask
 */
public class ClinicalApplication extends ProfiledApplication {

}
