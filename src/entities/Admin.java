package entities;

public class Admin extends Employee {
    private static Admin instance;
    private Admin(){

    }

    public Admin(String employeeCode, String name, String dateOfBirth, String gender, String phoneNumber, int basicRate, int numberDayLateForWork) {
        super(employeeCode, name, dateOfBirth, gender, phoneNumber, basicRate, numberDayLateForWork);
    }

    public static Admin getInstance(){
        if (instance == null){
            instance = new Admin("CG9999","Admin","11/11/2011","male","0123456789",5000000,0);
        }
        return instance;
    }
}
