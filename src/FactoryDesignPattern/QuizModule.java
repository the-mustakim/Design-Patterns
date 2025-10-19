package FactoryDesignPattern;

public class QuizModule implements  Module{

    private final String courseTitle;

    QuizModule(String courseTitle){this.courseTitle = courseTitle;}

    public String name(){return "Quiz Module";}

    public void deliverContent(){
        System.out.println("Starting interactive quizzes for: " + courseTitle);
    };

}
