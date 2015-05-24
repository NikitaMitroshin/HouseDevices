package by.mitroshin.homedev.report;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by HP M6 on 24.05.2015.
 */
public enum Reporter {

    INSTANCE;

    private static final String SPACE = "\n------------------------------\n";
    private FileWriter fileWriter;

    public void printReport(String message) throws IOException {
        if (fileWriter == null) {
            fileWriter = new FileWriter("reports/report.txt", true);
        }
        fileWriter.write(SPACE);
        fileWriter.write(message + " | TIME: " + new SimpleDateFormat("dd.MM.yy kk:mm:ss").format(System.currentTimeMillis()));
        fileWriter.flush();
    }

}
