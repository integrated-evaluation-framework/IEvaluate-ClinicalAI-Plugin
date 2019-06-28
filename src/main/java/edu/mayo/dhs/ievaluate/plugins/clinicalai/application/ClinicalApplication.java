package edu.mayo.dhs.ievaluate.plugins.clinicalai.application;

import edu.mayo.dhs.ievaluate.api.applications.ApplicationDefinition;
import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.models.tasks.ApplicationTask;

import java.util.UUID;

/**
 * Represents a generic clinical application which consists of one or more {@link ClinicalApplicationTask}s
 *
 * By default, contains implementations for phenotyping tasks (i.e. "Does this patient meet a certain set of criteria")
 * @see ClinicalPhenotypingTask
 */
public class ClinicalApplication extends ProfiledApplication {

    public ClinicalApplication() {
        this(UUID.randomUUID(), "Untitled Clinical Application", "A clinical application");
    }

    public ClinicalApplication(UUID id, String name, String description, ApplicationTask... tasks) {
        super(id, name, description, tasks);
    }

    @Override
    public Class<? extends ApplicationDefinition> getApplicationDefinition() {
        return ClinicalApplicationDefinition.class;
    }
}
