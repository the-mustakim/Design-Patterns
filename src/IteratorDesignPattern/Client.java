package IteratorDesignPattern;

public class Client {
    public static void main(String[] args) {

        UserManagement userManagement = new UserManagement();

        userManagement.addUser(new User("durgesh", "14"));
        userManagement.addUser(new User("rahul", "15"));
        userManagement.addUser(new User("jay", "16"));

        MyIterator myIterator = userManagement.getIterator();
        while(myIterator.hasNext()){
            User user = (User) myIterator.next();
            System.out.println(user);
        }

    }
}
