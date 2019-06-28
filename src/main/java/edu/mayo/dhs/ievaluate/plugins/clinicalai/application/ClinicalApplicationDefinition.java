package edu.mayo.dhs.ievaluate.plugins.clinicalai.application;

import com.fasterxml.jackson.databind.JsonNode;
import edu.mayo.dhs.ievaluate.api.IEvaluate;
import edu.mayo.dhs.ievaluate.api.applications.ApplicationDefinition;
import edu.mayo.dhs.ievaluate.api.applications.ApplicationProvider;
import edu.mayo.dhs.ievaluate.plugins.clinicalai.application.parameters.PhenotypingConditionParameter;

import java.util.HashSet;
import java.util.Set;

public class ClinicalApplicationDefinition extends ApplicationDefinition {

    public ClinicalApplicationDefinition() {
        super("Clinical Application", ClinicalApplicationProvider.class, new PhenotypingConditionParameter());
    }

    @Override
    public JsonNode toApplicationJson(JsonNode input) {
        @SuppressWarnings("unchecked") ApplicationProvider<ClinicalApplication> provider =
                (ApplicationProvider<ClinicalApplication>) getApplicationProvider();
        ClinicalApplication app = provider.produceNew();
        this.parameters.forEach(param -> {
            String field = param.fieldName();
            if (input.has(field)) {
                JsonNode sub = param.toApplicationJson(input.get(field));
                switch (field) {
                    case "appName":
                        app.setName(sub.asText());
                        break;
                    case "appDesc":
                        app.setDescription(sub.asText());
                        break;
                    case "conditions":
                        // each condition is a clinical phenotyping task
                        Set<String> conditions = new HashSet<>();
                        for (JsonNode condition : sub) {
                            boolean uniqueCond = conditions.add(condition.asText().toUpperCase());
                            if (!uniqueCond) {
                                continue;
                            }
                            ClinicalPhenotypingTask task = new ClinicalPhenotypingTask(); // Don't need to explicitly set a UUID, this will be a random one
                            task.setConditionName(condition.asText());
                            app.getTasks().add(task);
                        }
                }
            }
        });
        return provider.marshal(app);
    }
}
