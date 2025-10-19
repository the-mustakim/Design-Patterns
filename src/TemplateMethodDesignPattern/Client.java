package TemplateMethodDesignPattern;

public class Client {

    public static void main(String[] args) {
        PaymentFlow obj = new PayToFriend();
        obj.sendMoney();
    }

}
