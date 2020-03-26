package algo4j;

import java.math.BigDecimal;
import java.util.Optional;

public interface Bar {

    BigDecimal open();

    BigDecimal high();

    BigDecimal low();

    BigDecimal close();

    Optional<BigDecimal> volume();

}
