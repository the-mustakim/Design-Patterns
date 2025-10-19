package PrototypeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class NetworkConnection implements Cloneable {

    private String ip;
    private String importantData;

    List<String> domains = new ArrayList<>();

    public NetworkConnection(){

    }

    public NetworkConnection(String ip, String importantData,List<String> domains) {
        this.ip = ip;
        this.importantData = importantData;
        this.domains = domains;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImportantData() {
        return importantData;
    }

    public void setImportantData(String importantData) {
        this.importantData = importantData;
    }

    public void loadImpData(){
        this.importantData = "Very very imp data";
        //it will take 5 minutes

        domains.add("www.learncodewithdurgesh.com");
        domains.add("www.substringtechnologies.com");
        domains.add("www.google.com");

    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ip='" + ip + '\'' +
                ", importantData='" + importantData + ',' + " domains=" + domains +
                '}';
    }

    @Override
    protected NetworkConnection clone() throws CloneNotSupportedException {
        //Shallow Copy
        //return new NetworkConnection(this.ip,this.importantData,this.domains);


        //Deep Copy
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIp(this.getIp());
        networkConnection.setImportantData(this.getImportantData());
        List<String> domains = new ArrayList<>();
        for(String ele: this.getDomains()){
            domains.add(ele);
        }
        networkConnection.setDomains(domains);

        return networkConnection;
    }

}
