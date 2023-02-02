package pl.ladybroker.part2;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Logger {

    private PrintWriter writer;
    private final boolean logInfo;
    private final boolean logError;


    public FileLogger(String fileName,boolean logInfo,boolean logError ) {
        this.logInfo = logInfo;
        this.logError = logError;

        try {
            FileOutputStream fileStream = new FileOutputStream(fileName, true);
            this.writer = new PrintWriter(fileStream, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void info(String logString) {
        if (logInfo) {
            writer.printf("[%s]INFO: %s\n", getCurrentDateTimeString(), logString);
        }
    }
    public void error(String logString) {
        if (logError) {
            writer.printf("[%s]ERROR: %s\n", getCurrentDateTimeString(), logString);
        }
    }
    private String getCurrentDateTimeString() {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return simpleDateFormat.format(now);
    }
}
