package entities;

public class Developer extends Employee {
    private int overTime;
    private int incomeDEV;
    private final int RATE_PER_HOUR = 200000;

    public Developer() {
    }

    public Developer(int overTime, int incomeDEV) {
        this.overTime = overTime;
        this.incomeDEV = incomeDEV;
    }

    public Developer(String employeeCode, String name, String dateOfBirth, String isMale, String phoneNumber, int basicRate, int numberDayLateForWork, int overTime) {
        super(employeeCode, name, dateOfBirth, isMale, phoneNumber, basicRate, numberDayLateForWork);
        this.overTime = overTime;

    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    public int getRATE_PER_HOUR() {
        return RATE_PER_HOUR;
    }

    public int getIncomeDEV() {
        return incomeDEV;
    }

    public void setIncomeDEV() {
        this.incomeDEV = (getBasicRate() + getOverTime() * getRATE_PER_HOUR()) - (getNumberDayLateForWork() * getRATE_PER_DAY_LATE()) ;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "Staff Code= " + getEmployeeCode() +
                ", Name= " + getName() +
                ", Date of birth= " + getDateOfBirth() +
                ", Gender= " + getGender() +
                ", Phone Number= " + getPhoneNumber() +
                ", Basic Rate= " + getBasicRate() +
                ", Work place= " + getWorkPlace() +
                ", Over time=" + overTime +
                ", Rate per hour=" + RATE_PER_HOUR +
                '}';
    }

}
