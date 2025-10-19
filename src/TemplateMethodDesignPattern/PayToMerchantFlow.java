package TemplateMethodDesignPattern;

public class PayToMerchantFlow extends PaymentFlow{


    @Override
    public void validateRequest() {
        //specifies validation for PayToFriend flow
        System.out.println("Validate logic of PayToMerchant");
    }

    @Override
    public void calculateFees() {
        //debit the amount
        System.out.println("Debit the Amount logic of PayToMerchant");
    }

    @Override
    public void debitAmount() {
        //specifies fee computation logic for PayToFriend flow
        System.out.println("2% fees charged");
    }

    @Override
    public void creditAmount() {
        // Credit the amount logic
        System.out.println("Credit the remaining amount");
    }
}
