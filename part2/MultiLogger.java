package pl.ladybroker.part2;

public class MultiLogger implements Logger {

    private final Logger[] loggers;

    public MultiLogger(Logger[] loggers) {
        this.loggers = loggers;
    }

    public void info(String logString) {
        for (Logger logger:loggers) {
            logger.info(logString);
        }
    }
    public void error(String logString) {
        for (Logger logger: loggers) {
            logger.error(logString);
        }

    }
}
