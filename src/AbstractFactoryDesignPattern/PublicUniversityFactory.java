package AbstractFactoryDesignPattern;

public class PublicUniversityFactory extends UniversityFactory{

    public AdmitCard getAdmitCard(String course){
        switch (course){
            case "Math":
                return new USCAdmitCard();
            case "Physics":
                return new VSUAdmitCard();
            case "CS":
                return  new ASUAdmitCard();
            default:
                break;
        }
        return null;
    }

    public FeeCalculator getFeeCalculator(String course){
        switch (course){
            case "Math":
                return new USCCalculator();
            case "Physics":
                return new VSUFeeCalculator();
            case "CS":
                return  new ASUFeeCalculator();
            default:
                break;
        }
        return null;
    }
}
