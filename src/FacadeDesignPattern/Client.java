package FacadeDesignPattern;

public class Client {
    public static void main(String[] args) {

        Employee employee = new Employee();
        EmployeeFacade employeeFacade = new EmployeeFacade(new EmployeeDao());

        // Necessary method from Facade layer
        employeeFacade.insert(employee);

    }
}
