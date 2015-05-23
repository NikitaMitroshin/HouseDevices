package by.mitroshin.homedev.report;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by HP M6 on 22.05.2015.
 */
public class Reporter   {
    public static final Reporter REPORTER = new Reporter();
    private static final String SPACE = "\n------------------------------\n";

    private Reporter() {
    }

    public void printReport(String message) throws IOException {
        FileWriter writer = new FileWriter("reports/report.txt", true);
        writer.write(SPACE);
        writer.write(message + " | TIME: " + new SimpleDateFormat("dd.MM.yy kk:mm:ss").format(System.currentTimeMillis()));
        writer.close();
    }

}
