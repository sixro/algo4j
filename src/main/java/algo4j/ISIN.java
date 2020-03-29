package algo4j;

/**
 * Represents an ISIN.
 */
public interface ISIN {

    static ISIN of(String code) {
        return new ISIN.Default(code);
    }

    String code();

    class Default implements ISIN {
        private final String code;

        public Default(String code) {
            this.code = code;
        }

        @Override
        public String code() {
            return code;
        }
    }
}
