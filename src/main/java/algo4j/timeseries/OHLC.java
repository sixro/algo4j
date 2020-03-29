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

    NumericalTimeSeries open();

    NumericalTimeSeries high();

    NumericalTimeSeries low();

    NumericalTimeSeries close();

    NumericalTimeSeries volume();

    interface Value {

        BigDecimal open();

        BigDecimal high();

        BigDecimal low();

        BigDecimal close();

        BigDecimal volume();
    }

}
