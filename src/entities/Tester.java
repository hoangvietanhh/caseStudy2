package entities;

public class Tester extends Employee {
    private int numberOfBugFind;
    private int incomeTester;
    private final int RATE_PER_BUG = 50000;


    public int getNumberOfBugFind() {
        return numberOfBugFind;
    }

    public void setNumberOfBugFind(int numberOfBugFind) {
        this.numberOfBugFind = numberOfBugFind;
    }

    public int getRATE_PER_BUG() {
        return RATE_PER_BUG;
    }

    public int getIncomeTester() {
        return incomeTester;
    }

    public void setIncomeTester() {
        this.incomeTester = (getBasicRate() + getNumberOfBugFind() * getRATE_PER_BUG()) - (getNumberDayLateForWork() * getRATE_PER_DAY_LATE());
    }

    @Override
    public String toString() {
        return "Tester{" +
                "Staff Code= " + getEmployeeCode() +
                ", Name= " + getName() +
                ", Date of birth= " + getDateOfBirth() +
                ", Gender= " + getGender() +
                ", Phone Number= " + getPhoneNumber() +
                ", Basic Rate= " + getBasicRate() +
                ", Work place= " + getWorkPlace() +
                "Number Of Bug Found=" + numberOfBugFind +
                ", Rate per bug=" + RATE_PER_BUG +
                '}';
    }
}
