package ProxyDesignPattern;

public class Client {
    public static void main(String[] args) {
        try {
            EmployeeDao empTableObj = new EmployeeDaoProxy();
            empTableObj.create("ADMIN",new Employee());
            System.out.println("Operation Successful");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
