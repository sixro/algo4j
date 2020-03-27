package algo4j;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Iterator;

public class CsvMarket implements Market {

    private final File baseDir;
    private final String baseClasspath;

    private CsvMarket(File baseDir, String baseClasspath) {
        this.baseDir = baseDir;
        this.baseClasspath = baseClasspath;
    }

    public static CsvMarket fromClasspath(String baseClasspath) {
        return new CsvMarket(null, baseClasspath);
    }

    public static CsvMarket fromDirectory(File baseDir) {
        return new CsvMarket(baseDir, null);
    }

    @Override
    public TimeSeries timeSeries(String isin, TimeFrame timeFrame) {
        // TODO in case of higher time frames we should recalculates them. Probably we just need to create an impl of TimeSeries which takes a daily TimeSeries and recalc the data points
        if (! TimeFrame.DAILY.equals(timeFrame))
            throw new UnsupportedOperationException("only daily time frame is supported at the moment");

        Reader reader = newReader(isin);
        BufferedReader br = new BufferedReader(reader);
        CSVParser csv = null;
        try {
            csv =  new CSVParser(br, CSVFormat.DEFAULT.withHeader());
            SimpleTimeSeries timeSeries = new SimpleTimeSeries();
            for (CSVRecord record: csv) {
                // TODO if TimeFrame is not intraday it is ok to use LocalDate but I have to convert to ZonedDateTime
                LocalDate time = LocalDate.parse(record.get(0));
                BigDecimal open = new BigDecimal(record.get(1));
                BigDecimal high = new BigDecimal(record.get(2));
                BigDecimal low = new BigDecimal(record.get(3));
                BigDecimal close = new BigDecimal(record.get(4));
                BigDecimal volume = new BigDecimal(record.get(5));
                // TODO probably the zoneId should be known by the market or is a characteristic of the ISIN...
                ZonedDateTime datetime = time.atStartOfDay().atZone(ZoneId.systemDefault());
                timeSeries.add(new SimpleBar(open, high, low, close, volume), datetime);
            }
            return timeSeries;
        } catch (IOException e) {
            throw new RuntimeException("Unable to read time series of ISIN " + isin, e);
        } finally {
            if (csv != null) {
                try { csv.close(); }
                catch (IOException ignore) { }
            }
        }
    }

    private Reader newReader(String filename) {
        try {
            InputStream is = baseDir != null
                    ? new FileInputStream(new File(baseDir, filename + ".csv"))
                    : CsvMarket.class.getResourceAsStream(baseClasspath + "/" + filename + ".csv");
            InputStreamReader isr = new InputStreamReader(is);
            return isr;
        } catch (IOException e) {
            throw new RuntimeException("Unable to read time series in file name '" + filename + "'", e);
        }
    }
}
