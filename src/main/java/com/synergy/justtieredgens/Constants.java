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

    public class FERRICORE {
        public static final String COAL = "ferricore" + Suffix.COAL;
        public static final String FLUID = "ferricore" + Suffix.FLUID;
        public static final String POCKET = Prefix.POCKET + "ferricore" + Suffix.GENERATOR;
    }

    public class BLAZEGOLD {
        public static final String COAL = "blazegold" + Suffix.COAL;
        public static final String FLUID = "blazegold" + Suffix.FLUID;
        public static final String POCKET = Prefix.POCKET + "blazegold" + Suffix.GENERATOR;
    }

    public class CELESTIGEM {
        public static final String COAL = "celestigem" + Suffix.COAL;
        public static final String FLUID = "celestigem" + Suffix.FLUID;
        public static final String POCKET = Prefix.POCKET + "celestigem" + Suffix.GENERATOR;
    }

    public class ECLIPSE_ALLOY {
        public static final String COAL = "eclipse_alloy" + Suffix.COAL;
        public static final String FLUID = "eclipse_alloy" + Suffix.FLUID;
        public static final String POCKET = Prefix.POCKET + "eclipse_alloy" + Suffix.GENERATOR;
    }
}
