package SingletonDesignPattern;

public enum JdbcConnectionENUM {

    INSTANCE;

    public void test(){
        System.out.println("This is the test method inside the ENUM");
    }

}