package ProxyDesignPattern;

//Concrete Class
public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create(String client, Employee obj) throws Exception {
        //creates a new Row
        System.out.println("created new row in the Employee table");
    }

    @Override
    public void delete(String cleint, int employeeId) throws Exception {
        //delete a Row
        System.out.println("deleted row with employeeID: " + employeeId);
    }

    @Override
    public Employee get(String client, int employedId) throws Exception {
        //fetch now
        System.out.println("fetching data from the DB:");
        return new Employee();
    }
}
