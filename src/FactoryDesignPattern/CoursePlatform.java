package FactoryDesignPattern;


// ----- Creator (Factory) -----
public abstract class CoursePlatform {

    // Template method: shared workflow
    public void startCourse(String title){
        System.out.println("\n=== Starting course: " + title + "===");
        Module m = createModule(title);           // <-- Factory Method
        System.out.println("Using: " + m.name());
        m.deliverContent();
        System.out.println("Tracking progreshaans, awarding badges....\n");
    }

    // Factory Method: subClasses decide what concrete Module to make
    protected abstract Module createModule(String courseTitle);
}
