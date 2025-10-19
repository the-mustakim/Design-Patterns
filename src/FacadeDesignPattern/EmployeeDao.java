package FacadeDesignPattern;

public class EmployeeDao {

    public void insert(Employee employee){
        System.out.println("Inserted into the Database: " + employee.toString());
    }
    public void delete(){
        System.out.println("Employee Deleted from the Database");
    }
    public void updateByID(){
        System.out.println("Employee Updated from the Database");
    }
}
