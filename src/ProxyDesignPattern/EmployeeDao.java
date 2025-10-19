package ProxyDesignPattern;

public interface EmployeeDao {
    public void create(String client, Employee obj) throws Exception;
    public void delete(String cleint, int employeeId) throws Exception;
    public Employee get(String client, int employedId) throws Exception;

}
