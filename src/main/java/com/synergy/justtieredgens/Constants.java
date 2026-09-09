package com.synergy.justtieredgens;

public class Constants {

    public class Suffix {
        public static final String GENERATOR = "_generator";
        public static final String COAL = "_coal" + GENERATOR;
        public static final String FLUID = "_fuel" + GENERATOR;
    }

    public class Prefix {
        public static final String POCKET = "pocket_";
    }

    public class MaterialType {
        public static final String FERRICORE = "ferricore";
        public static final String BLAZEGOLD = "blazegold";
        public static final String CELESTIGEM = "celestigem";
        public static final String ECLIPSE_ALLOY = "eclipse_alloy";
    }

    public class FERRICORE {
        public static final String COAL = MaterialType.FERRICORE + Suffix.COAL;
        public static final String FLUID = MaterialType.FERRICORE + Suffix.FLUID;
        public static final String POCKET = Prefix.POCKET + MaterialType.FERRICORE + Suffix.GENERATOR;
    }

    public class BLAZEGOLD {
        public static final String COAL = MaterialType.BLAZEGOLD + Suffix.COAL;
        public static final String FLUID = MaterialType.BLAZEGOLD + Suffix.FLUID;
        public static final String POCKET = Prefix.POCKET + MaterialType.BLAZEGOLD + Suffix.GENERATOR;
    }

    public class CELESTIGEM {
        public static final String COAL = MaterialType.CELESTIGEM + Suffix.COAL;
        public static final String FLUID = MaterialType.CELESTIGEM + Suffix.FLUID;
        public static final String POCKET = Prefix.POCKET + MaterialType.CELESTIGEM + Suffix.GENERATOR;
    }

    public class ECLIPSE_ALLOY {
        public static final String COAL = MaterialType.ECLIPSE_ALLOY + Suffix.COAL;
        public static final String FLUID = MaterialType.ECLIPSE_ALLOY + Suffix.FLUID;
        public static final String POCKET = Prefix.POCKET + MaterialType.ECLIPSE_ALLOY + Suffix.GENERATOR;
    }
}
