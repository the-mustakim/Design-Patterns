package AdapterDesignPattern;

public class SchoolStudentAdpater implements Student {

    private SchoolStudent schoolStudent;

    public SchoolStudentAdpater(SchoolStudent schoolStudent){
        this.schoolStudent = schoolStudent;
    }


    @Override
    public String getName() {
        return schoolStudent.getFirstname();
    }

    @Override
    public String getSurname() {
        return schoolStudent.getLastname();
    }

    @Override
    public String getEmail() {
        return schoolStudent.getEmailaddress();
    }
}
