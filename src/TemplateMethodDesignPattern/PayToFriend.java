package TemplateMethodDesignPattern;

public class PayToFriend extends PaymentFlow{

    @Override
    public void validateRequest() {
        //specifies validation for PayToFriend flow
        System.out.println("Validate logic of PayToFriend");
    }

    @Override
    public void calculateFees() {
        //debit the amount
        System.out.println("Debit the amount logic of PayToFriend");
    }

    @Override
    public void debitAmount() {
        //specifies fee computation logic for PayToFriend flow
        System.out.println("0% fee charged");
    }

    @Override
    public void creditAmount() {
        //credit the amount logic
        System.out.println("Credit the full amount");
    }
}
