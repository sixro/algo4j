package algo4j;

/**
 * Represents an ISIN.
 */
public interface ISIN {

    static ISIN of(final String code) {
        return new ISIN() {

            private final String _code;

            { this._code = code; }

            @Override
            public String code() {
                return _code;
            }

            @Override
            public String toString() {
                return _code;
            }
        };
    }

    String code();

}
