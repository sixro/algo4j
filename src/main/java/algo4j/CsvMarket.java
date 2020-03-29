package algo4j;

import algo4j.timeseries.DataPoint;
import algo4j.timeseries.ListOHLC;
import algo4j.timeseries.OHLC;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a {@code Market} working with <a href="https://en.wikipedia.org/wiki/Comma-separated_values">CSV</a>
 * files found in a specific folder or classpath.
 *
 * <p>
 * The CSV files has to be named with the ISIN code (e.g. {@code IE00BKM4GZ66.csv}).<br>
 * Here an example on how to use this object:
 * </p>
 * <pre>
 *     Market market = CsvMarket.fromClasspath("/csv-market");
 *     OHLC ts = market.ohlc(ISIN.of("IE00BKM4GZ66"));
 *     ...
 * </pre>
 *
 * @author <a href="mailto:me@sixro.net" >Sixro</a>
 * @since 1.0
 */
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
    public OHLC ohlc(ISIN isin) {
        Reader reader = newReader(isin.code());
        BufferedReader br = new BufferedReader(reader);
        CSVParser csv = null;
        try {
            csv =  new CSVParser(br, CSVFormat.DEFAULT.withHeader());
            List<DataPoint<OHLC.Value>> list = new LinkedList<>();
            for (CSVRecord record: csv) {
                // TODO weak but at the moment I support just EOD values... so it is ok
                LocalDate date = LocalDate.parse(record.get(0));
                LocalDateTime time = date.atStartOfDay();
                BigDecimal open = new BigDecimal(record.get(1));
                BigDecimal high = new BigDecimal(record.get(2));
                BigDecimal low = new BigDecimal(record.get(3));
                BigDecimal close = new BigDecimal(record.get(4));
                BigDecimal volume = new BigDecimal(record.get(5));
                list.add(DataPoint.of(ListOHLC.SimpleOHLCValue.of(open, high, low, close, volume), time));
            }
            ListOHLC ohlc = new ListOHLC(list);
            return ohlc;
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
