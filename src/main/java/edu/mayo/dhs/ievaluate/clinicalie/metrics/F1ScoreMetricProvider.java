package edu.mayo.dhs.ievaluate.clinicalie.metrics;

import edu.mayo.dhs.ievaluate.api.applications.ApplicationAssertion;
import edu.mayo.dhs.ievaluate.api.applications.ApplicationAssertionCollection;
import edu.mayo.dhs.ievaluate.api.models.baselines.BaselineAssertion;
import edu.mayo.dhs.ievaluate.api.models.baselines.BaselineCohort;
import edu.mayo.dhs.ievaluate.api.models.metrics.MetricDatapoint;
import edu.mayo.dhs.ievaluate.api.models.metrics.MetricProvider;
import edu.mayo.dhs.ievaluate.api.models.tasks.ApplicationTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class F1ScoreMetricProvider extends MetricProvider {

    public MetricDatapoint produceMetrics(ApplicationTask task, ApplicationAssertionCollection assertions, BaselineCohort cohort) {
        // Generate an internal mapping of the specific task
        Map<AssertionSubjectDefinition, String> assertionMapping = new HashMap<>();
        Map<AssertionSubjectDefinition, String> baselineAssertions = new HashMap<>();
        cohort.getItems().stream().filter(assertion -> assertion.getTask().equals(task)).forEach(a -> {
            AssertionSubjectDefinition subj = new AssertionSubjectDefinition(a.getInput(), a.getInputParams());
            // TODO support quorums, for now just pull the first
            String asserted = a.getAssertions().iterator().next().getAssertedValue();
            baselineAssertions.put(subj, asserted);
        });
        return null;
    }

    private class AssertionSubjectDefinition {
        private String input;
        private Map<String, String> inputParams;

        public AssertionSubjectDefinition(String input, Map<String, String> inputParams) {
            this.input = input;
            this.inputParams = inputParams == null || inputParams.isEmpty() ? null : inputParams; // ensure empty is stored as null for memory
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AssertionSubjectDefinition that = (AssertionSubjectDefinition) o;
            return Objects.equals(input, that.input) &&
                    Objects.equals(inputParams, that.inputParams);
        }

        @Override
        public int hashCode() {
            return Objects.hash(input, inputParams);
        }
    }

}
