package AdapterDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class StudentClient {

    public List<Student> getStudentList(){
        List<Student> students = new ArrayList<>();

        CollegeStudent collegeStudent = new CollegeStudent("a", "b", "c");

        SchoolStudent  schoolStudent = new SchoolStudent("x", "y", "z");

        students.add(collegeStudent);

        //Below is the case where we need to use the adapter as SchoolStudent is not implementing the Student interface, it will be trouble for us
        //students.add(schoolStudent);

        // Instead of passing the SchoolStudent we are passing SchoolStudentAdapter, which adapted the properties of SchoolStudent
        students.add(new SchoolStudentAdpater(schoolStudent));
        return students;

    }
}
