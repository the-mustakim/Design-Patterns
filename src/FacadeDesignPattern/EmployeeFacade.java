package FacadeDesignPattern;

public class EmployeeFacade {
    EmployeeDao employeeDao;

    public EmployeeFacade(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    // As you can see we hide all the unnecessary methods from client, we are providing only those which are needed by the client. How we are inserting client doesn't know about it.
    public void insert(Employee employee){
        employeeDao.insert(employee);
    }
}
