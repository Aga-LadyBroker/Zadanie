package pl.ladybroker.part2;

public class ConsoleLogger implements Logger {

    public void info(String logString) {
        System.out.println("INFO: " + logString);
    }

    public void error(String logString) {
        System.out.println("ERROR: " + logString);
    }
}
