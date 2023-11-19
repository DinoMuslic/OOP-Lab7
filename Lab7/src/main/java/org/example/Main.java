package org.example;

@FunctionalInterface
interface Logger {
    String logMessage(String message);
}

record RecordLogger(String loggerName) implements Logger {
    public String logMessage(String message) {
        return this.loggerName + ": " + message;
    }
}

class ClassLogger implements Logger {
    private String loggerName;

    public ClassLogger(String loggerName) {
        this.loggerName = loggerName;
    }

    public String logMessage(String message) {
        return this.loggerName + ": " + message;
    }
}

public class Main {
    public static void main(String[] args) {
        RecordLogger recordLogger = new RecordLogger("Dino");
        ClassLogger classLogger = new ClassLogger("Idris");

        Logger recordLoggerMessage = (String message) -> recordLogger.logMessage(message);
        Logger classLoggerMessage = (String message) -> classLogger.logMessage(message);

        System.out.println(recordLoggerMessage.logMessage("banana"));
        System.out.println(classLoggerMessage.logMessage("ananas"));
    }

}