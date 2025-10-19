package PrototypeDesignPattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Creating object using protype desing pattern");
        NetworkConnection networkConnection = new NetworkConnection();

        networkConnection.setIp("192.162.4.4");
        networkConnection.loadImpData();

        System.out.println(networkConnection);

        try {
            NetworkConnection networkConnection1 = networkConnection.clone();
            System.out.println(networkConnection==networkConnection1);
            System.out.println("Shallow copy: " + networkConnection.getImportantData()==networkConnection1.getImportantData());
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
