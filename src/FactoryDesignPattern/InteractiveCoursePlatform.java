package FactoryDesignPattern;

public class InteractiveCoursePlatform extends  CoursePlatform{
    @Override
    protected Module createModule(String courseTitle) {
        return new QuizModule(courseTitle);
    }
}
