package ChainOfResponsibilityDesignPattern.LoggingSystem;

public class DebugLogProcessor extends LogProcessor{

    DebugLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    @Override
    public void log(int logLevel, String message) {
        if(logLevel==DEBUG){
            System.out.println("DEBUG: " + message);
        }else{
            System.out.println("Debug → next");
            super.log(logLevel,message);
        }
    }
}
