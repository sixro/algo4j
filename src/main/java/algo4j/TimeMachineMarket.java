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
    public TimeSeries timeSeries(String isin) {
        TimeSeries timeSeries = delegate.timeSeries(isin);
        return timeSeries.till(currentTime);
    }

}
