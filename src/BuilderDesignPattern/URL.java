package BuilderDesignPattern;

public class URL {
    private String protocol;
    private String hostname;
    private String port;
    private String pathParam;
    private String queryParam;

    public URL(){

    }

    public URL(String protocol){
        this.protocol = protocol;
    }

    public URL(String protocol, String hostname){
        this.protocol = protocol;
        this.hostname = hostname;
    }

    public URL(String protocol, String hostname, String port){
        this.protocol = protocol;
        this.hostname = hostname;
        this.port = port;
    }

    public URL(String protocol, String hostname, String port, String pathParam){
        this.protocol = protocol;
        this.hostname = hostname;
        this.port = port;
        this.pathParam = pathParam;
    }

    public URL(String protocol, String hostname, String port, String pathParam, String queryParam){
        this.protocol = protocol;
        this.hostname = hostname;
        this.port = port;
        this.pathParam = pathParam;
        this.queryParam = queryParam;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHostname() {
        return hostname;
    }

    public String getPort() {
        return port;
    }

    public String getPathParam() {
        return pathParam;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPathParam(String pathParam) {
        this.pathParam = pathParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

}
