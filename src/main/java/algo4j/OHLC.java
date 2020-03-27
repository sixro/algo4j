package algo4j;

import java.math.BigDecimal;

public interface OHLC {

    BigDecimal open();
    BigDecimal high();
    BigDecimal low();
    BigDecimal close();

    BigDecimal volume();

}
