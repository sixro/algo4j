package algo4j.timeseries;

import java.math.BigDecimal;

/**
 * Represents a time series made up of open,high,low,close and volume.
 *
 * @see algo4j.Market
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public interface OHLC extends TimeSeries<OHLC.Value, OHLC> {

    Numerical open();

    Numerical high();

    Numerical low();

    Numerical close();

    Numerical volume();

    interface Value {

        BigDecimal open();

        BigDecimal high();

        BigDecimal low();

        BigDecimal close();

        BigDecimal volume();
    }

}
