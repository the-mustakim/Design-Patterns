package BuilderDesignPattern;

public class Demo {
    public static void main(String[] args) {

        URL url = new URL();
        url.setProtocol("http://");
        url.setHostname("mywebsite");
        url.setPort(":8080/");
        url.setPathParam("hoempage");
        url.setPathParam("ramdom");

        System.out.print(url.getProtocol());
        System.out.print(url.getHostname());
        System.out.print(url.getPort());
        System.out.println(url.getPathParam());

        System.out.println("The below is the Builder Pattern");

        URL_BuilderPatten.Builder builder = new URL_BuilderPatten.Builder();
        builder.protocol("http://").hostname("newwebsite:").port("443");
        URL_BuilderPatten urlBuildr = builder.build();

        System.out.print(urlBuildr.protocol);
        System.out.print(urlBuildr.hostname);
        System.out.println(urlBuildr.port);

        System.out.println("The below is the another combination with path param");

        URL_BuilderPatten.Builder builder2 = new URL_BuilderPatten.Builder();
        builder2.protocol("http://").hostname("newwebsite:").pathParam("abc");
        URL_BuilderPatten urlBuildr2 = builder2.build();

        System.out.print(urlBuildr2.protocol);
        System.out.print(urlBuildr2.hostname);
        System.out.print(urlBuildr2.pathParam);

    }
}
