package BuilderDesignPattern;

public class URLTelescope {
    private String protocol;
    private String hostname;
    private String port;
    private String pathParam;
    private String queryParam;

    public URLTelescope(){

    }
    public URLTelescope (String protocol){
        this.protocol = protocol;
    }

    public URLTelescope(String protocol, String hostname){
        this(protocol);
        this.hostname  = hostname;
    }

    public URLTelescope(String protocol, String hostname, String port){
        this(protocol,hostname);
        this.port = port;
    }

    public URLTelescope(String protocol, String hostname, String port, String pathParam){
        this( protocol,hostname,port);
        this.pathParam = pathParam;
    }

    public URLTelescope(String protocol, String hostname, String port, String pathParam, String queryParam){
        this( protocol,hostname,port,pathParam);
        this.queryParam = queryParam;
    }

    // This way of coding might solve one problem the code becomes less lengthy but, this won't solve the problem of multiple combinations.
    // To solve the problem of multiple combinations of the constructor then the builder pattern comes into the picture

}
