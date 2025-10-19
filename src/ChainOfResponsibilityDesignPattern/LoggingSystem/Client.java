package ChainOfResponsibilityDesignPattern.LoggingSystem;

public class Client {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.log(LogProcessor.ERROR,"Exception Happens");
        System.out.println("--------------------");
        logProcessor.log(LogProcessor.DEBUG, "need to debug this ");
        System.out.println("--------------------");
        logProcessor.log(LogProcessor.INFO, "just for info ");
        System.out.println("--------------------");

    }
}
