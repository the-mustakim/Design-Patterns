package FactoryDesignPattern;

// ----- Concrete Products -----
public class VideoModule implements  Module{
    private final String courseTitle;

    VideoModule(String courseTitle){this.courseTitle = courseTitle;}

    @Override
    public String name() {
        return "Video Module";
    }

    @Override
    public void deliverContent() {
        System.out.println("Playing lesson videos for: " + courseTitle);
    }
}
