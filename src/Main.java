import FactoryDesignPattern.CoursePlatform;
import FactoryDesignPattern.InteractiveCoursePlatform;
import FactoryDesignPattern.VideoCoursePlatform;

public class Main {

    //Factory Method
    // ----- Client code -----
    // Pretend this comes from config/user choice/feature flag
    static CoursePlatform choosePlatform(String mode) {
        switch (mode.toLowerCase()) {
            case "video":
                return new VideoCoursePlatform();
            case "interactive":
                return new InteractiveCoursePlatform();
            default:
                throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }

    public static void main(String[] args) {
        CoursePlatform p1 = choosePlatform("video");
        p1.startCourse("Java 101");
        CoursePlatform p2 = choosePlatform("interactive");
        p2.startCourse("Java 101");
    }

}