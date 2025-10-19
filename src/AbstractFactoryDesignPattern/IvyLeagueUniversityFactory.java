package AbstractFactoryDesignPattern;

public class IvyLeagueUniversityFactory extends  UniversityFactory{

    public AdmitCard getAdmitCard(String course){
        switch (course){
            case "Math":
                return new MITAdmitCard();
            case "Physics":
                return new CallTechAdmitCard();
            case "CS":
                return  new GeorgiaTechAdmitCard();
            default:
                break;
        }
        return null;
    }

    public FeeCalculator getFeeCalculator(String course){
        switch (course){
            case "Math":
                return new MITFeeCalculator();
            case "Physics":
                return new CalTechFeeCalculator();
            case "CS":
                return  new GeorgiaTechFeeCalculator();
            default:
                break;
        }
        return null;
    }

}
