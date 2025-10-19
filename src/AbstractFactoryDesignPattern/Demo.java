package AbstractFactoryDesignPattern;

public class Demo {
    public static void main(String[] args) {
        int entranceExamScore = 125;
        UniversityFactory abstractFactory = UniversityFactory.getUniversityFactory(entranceExamScore);

        AdmitCard admitCardOne = abstractFactory.getAdmitCard("Math");
        System.out.println(admitCardOne.getClass());
        FeeCalculator feeCalculator = abstractFactory.getFeeCalculator("Math");
        System.out.println(feeCalculator.calculateFee());

        AdmitCard admitCardTwo = abstractFactory.getAdmitCard("Physics");
        System.out.println(admitCardTwo.getClass());
        feeCalculator = abstractFactory.getFeeCalculator("Physics");
        System.out.println(feeCalculator.calculateFee());

    }
}
