package SingletonDesignPattern;

public class JdbcConnection {

    private static JdbcConnection jdbcConnection;

    private JdbcConnection(){
        if(jdbcConnection!=null){
            throw new RuntimeException("You are trying to break the pattern");
        }
    }

    // This is a lazy initialization of the object
    public synchronized static JdbcConnection getJdbcConnection(){
        if(jdbcConnection==null){

            synchronized (JdbcConnection.class){
                jdbcConnection = new JdbcConnection();
            }
        }
        return jdbcConnection;
    }
}

/***
 * 1. Make the constructor of the class private.
 * 2. Define a field of class type in the class and make it private, so it can hold the object which is created.
 * 3. Write a static method to create a single object of the class.
 * 4. if the refrance already holds an object then the same object will be returned upan calling getJdbcConnection method
 * ***/
