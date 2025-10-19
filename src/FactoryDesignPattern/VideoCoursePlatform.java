package FactoryDesignPattern;

public class VideoCoursePlatform extends  CoursePlatform{
    @Override
    protected Module createModule(String courseTitle) {
        return new VideoModule(courseTitle);
    }
}
