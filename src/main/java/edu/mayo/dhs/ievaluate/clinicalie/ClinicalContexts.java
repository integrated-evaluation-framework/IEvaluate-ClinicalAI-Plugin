package edu.mayo.dhs.ievaluate.clinicalie;

/**
 * Wrapper class for various clinical context enumerations
 * Default state is always Ordinal 0
 */
public class ClinicalContexts {
    public enum NegationStatus {
        POSITIVE("Positive"),
        NEGATED("Negative");

        private final String display;

        NegationStatus(String display) {
            this.display = display;
        }

        public String getDisplay() {
            return display;
        }
    }

    public enum TemporalStatus {
        PRESENT("Present"),
        HISTORICAL("Historical");

        private final String display;

        TemporalStatus(String display) {
            this.display = display;
        }

        public String getDisplay() {
            return display;
        }
    }

    public enum CertaintyStatus {
        CERTAIN("Certain"),
        POSSIBLE("Possible");

        private final String display;

        CertaintyStatus(String display) {
            this.display = display;
        }

        public String getDisplay() {
            return display;
        }
    }

    public enum Experiencer {
        PATIENT("Patient"),
        OTHER("Other");

        private final String display;

        Experiencer(String display) {
            this.display = display;
        }

        public String getDisplay() {
            return display;
        }
    }
}
