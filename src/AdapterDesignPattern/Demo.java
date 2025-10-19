package AdapterDesignPattern;

public class Demo {
    public static void main(String[] args) {
        StudentClient studentClient = new StudentClient();
        System.out.println(studentClient.getStudentList());
    }
}
