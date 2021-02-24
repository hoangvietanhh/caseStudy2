package entities;

public class Seller extends Employee {
    private int numberOfCustomer;
    private int incomeSeller;
    int RatePerCustomer;

    public Seller() {
    }

    public Seller(int numberOfCustomer) {
        this.numberOfCustomer = numberOfCustomer;
    }

    public Seller(String employeeCode, String name, String dateOfBirth, String gender, String phoneNumber, int basicRate, int numberDayLateForWork, int numberOfCustomer) {
        super(employeeCode, name, dateOfBirth, gender, phoneNumber, basicRate, numberDayLateForWork);
        this.numberOfCustomer = numberOfCustomer;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public void setNumberOfCustomer(int numberOfCustomer) {
        this.numberOfCustomer = numberOfCustomer;
    }

    public int getIncomeSeller() {
        return incomeSeller;
    }

    public void setIncomeSeller() {
        int ratePerCustomer= 0;
            if (numberOfCustomer >= 1 && numberOfCustomer <= 199) {
                ratePerCustomer = 100000;
            } else if (numberOfCustomer >= 200 && numberOfCustomer <= 399) {
                 ratePerCustomer= 200000;
            } else if (numberOfCustomer >= 400 && numberOfCustomer <= 599) {
                ratePerCustomer = 300000;
            } else {
                ratePerCustomer = 500000;
            }
            this.incomeSeller = (numberOfCustomer * ratePerCustomer) - (getNumberDayLateForWork() * getRATE_PER_DAY_LATE());
    }

    @Override
    public String toString() {
        return "Sale{" +
                "Staff Code= " + getEmployeeCode() +
                ", Name= " + getName() +
                ", Date of birth= " + getDateOfBirth() +
                ", Gender= " + getGender() +
                ", Phone Number= " + getPhoneNumber() +
                ", Basic Rate= " + getBasicRate() +
                ", Work place= " + getWorkPlace() +
                ", Number of Customer=" + numberOfCustomer +
                '}';
    }
}
