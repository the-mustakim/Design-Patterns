package ProxyDesignPattern;

public class EmployeeDaoProxy implements EmployeeDao{

    EmployeeDao employeeDao;

    EmployeeDaoProxy(){
        this.employeeDao=new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, Employee obj) throws Exception {
        if(client.equals("ADMIN")){
            employeeDao.create(client,obj);
            return;
        }
        throw  new Exception("Access Denied");
    }

    @Override
    public void delete(String cleint, int employeeId) throws Exception {
        if(cleint.equals("ADMIN")){
            employeeDao.delete(cleint, employeeId);
            return;
        }
        throw new RuntimeException("Access Denied");
    }

    @Override
    public Employee get(String client, int employedId) throws Exception {
        if(client.equals("ADMIN") || client.equals("USER")){
            return employeeDao.get(client,employedId);
        }
        throw  new Exception("Access Denied");
    }
}
