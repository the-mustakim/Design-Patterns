package SingletonDesignPattern;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // Lazy initialization of the object -- Creating object when it is needed by the client
        JdbcConnection jdbcConnection = JdbcConnection.getJdbcConnection();
        JdbcConnection jdbcConnection1 = JdbcConnection.getJdbcConnection();
        System.out.println("JDBC object");
        System.out.println("Hashcode of the first object: " + jdbcConnection.hashCode());
        System.out.println("Hashcode of the second object: " + jdbcConnection1.hashCode());



        //Eager initialization of the object -- It will be created when the class is loaded in class loader
        System.out.println("Network object");
        NetworkConnection networkConnection = NetworkConnection.getNetworkConnection();
        NetworkConnection networkConnection1 = NetworkConnection.getNetworkConnection();
        System.out.println("Hashcode of the first object: " + networkConnection.hashCode());
        System.out.println("Hashcode of the second object: " + networkConnection1.hashCode());

        /*
        * Problem with Eager loading is -- One object created for entire system, it will still be there if no one uses it
        * Problem with Lazy loading is -- Multiple object can be created if two Thread simultaneously call getJdbcConnection() method, and they found object reference null, both thread will create two seprate
        * objects in the system. To avoid this issue we need to make the getJdbcConnection() method synchronized, using synchronized keyword on method.
        * But again there is a problem if the method contains any code which needs to be accessed by multiple threads in that case we just have to make that block or line of code synchronized.
        * */

        /***
         * Ways to break the Singleton pattern
         * 1. Using Reflection API
             * Solution:
             * 1) Throw an exception from the constructor.
             * 2) Using the ENUM: Use ENUM instead of the class
         * 2. Using Deserialization
         * 3. Cloning
         *
         * ***/
        System.out.println("");
        System.out.println("Breaking the pattern using Reflection API");
//        JdbcConnection jdbcConnection2 = JdbcConnection.getJdbcConnection();
//        Constructor<JdbcConnection> constructor = JdbcConnection.class.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        JdbcConnection jdbcConnection3 = constructor.newInstance();
//        System.out.println("Hashcode of the first object:" +jdbcConnection3.hashCode());

        //Using ENUM
//        JdbcConnectionENUM jdbcConnectionENUM = JdbcConnectionENUM.INSTANCE;
//        JdbcConnectionENUM jdbcConnectionENUM1 = JdbcConnectionENUM.INSTANCE;
//        System.out.println("Hashcode of the first object: " + jdbcConnectionENUM.hashCode());
//        System.out.println("Hashcode of the second object: " + jdbcConnectionENUM1.hashCode());



    }
}
