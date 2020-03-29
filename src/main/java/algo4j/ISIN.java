package algo4j;

/**
 * Represents an ISIN.
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
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
