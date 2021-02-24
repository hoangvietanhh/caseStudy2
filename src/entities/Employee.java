package entities;


import java.io.Serializable;

public class Employee implements Serializable {
    private String employeeCode;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private int basicRate;
    private int numberDayLateForWork;
    private String workPlace;
    private final int RATE_PER_DAY_LATE = 10000;



    public Employee() {
    }

    public Employee(String employeeCode, String name, String dateOfBirth, String gender, String phoneNumber, int basicRate, int numberDayLateForWork) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.basicRate = basicRate;
        this.numberDayLateForWork = numberDayLateForWork;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public int getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(int basicRate) {
        this.basicRate = basicRate;
    }

    public int getNumberDayLateForWork() {
        return numberDayLateForWork;
    }

    public void setNumberDayLateForWork(int numberDayLateForWork) {
        this.numberDayLateForWork = numberDayLateForWork;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getRATE_PER_DAY_LATE() {
        return RATE_PER_DAY_LATE;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Staff Code= " + employeeCode +
                ", Name= " + name +
                ", Date of birth= " + dateOfBirth +
                ", Gender= " + gender +
                ", Phone Number= " + phoneNumber +
                ", Basic Rate= " + basicRate +
                ", Work place= " + workPlace +
                '}';
    }

}
