package algo4j;

import java.time.ZonedDateTime;

public class TimeMachineMarket implements Market{

    private final Market delegate;
    private ZonedDateTime currentTime;

    public TimeMachineMarket(Market delegate) {
        this.delegate = delegate;
        this.currentTime = ZonedDateTime.now();
    }

    public void atTime(ZonedDateTime time) {
        currentTime = time;
    }

    @Override
    public TimeSeries timeSeries(String isin, TimeFrame timeFrame) {
        TimeSeries timeSeries = delegate.timeSeries(isin, timeFrame);
        return timeSeries.till(currentTime);
    }

}
