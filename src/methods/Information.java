package methods;

import entities.Developer;
import entities.Employee;
import entities.Seller;
import entities.Tester;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Information implements Serializable {
    static final String FILE_SALARY = "salary";
    static final String PATH2 = "salaryTxt";

    FileTxt fileTxt = new FileTxt();

    public void writeFileText(){
        ArrayList<String> result = new ArrayList<>();
        Set<String> list = getListSalary().keySet();

        for (String str : list){
            result.add(str + "\t" +  getListSalary().get(str));

        }
        fileTxt.writeFile(result,PATH2);
    }

    private Map<String,Integer> listSalary = (Map<String, Integer>) readFileSalary();

    public Map<String, Integer> getListSalary() {
        return listSalary;
    }

    public void setListSalary(Map<String, Integer> listSalary) {
        this.listSalary = listSalary;
    }

    Scanner input = new Scanner(System.in);
    public Employee addInfo(Employee employee){
        System.out.println("Enter employee code.");
        employee.setEmployeeCode(inputCode());
        System.out.println("Enter employee name.");
        employee.setName(inputName());
        System.out.println("Enter date of birth.");
        employee.setDateOfBirth(inputDateOfBirth());
        inputGender(employee);
        System.out.println("Enter phone number.");
        employee.setPhoneNumber(inputPhoneNumber());
        System.out.println("Enter basic rate.");
        employee.setBasicRate(Integer.parseInt(input.nextLine()));
        System.out.println("Enter the number of day late.");
        employee.setNumberDayLateForWork(Integer.parseInt(input.nextLine()));
        inputWorkPlace(employee);

        return employee;
    }

    public void addDev(Employee employee){
        if (listSalary == null){
            listSalary = new TreeMap<>();
        }
        System.out.println("Enter the over time developer do.");
        ((Developer)employee).setOverTime(Integer.parseInt(input.nextLine()));
        ((Developer)employee).setIncomeDEV();
        listSalary.put(employee.getName(), ((Developer)employee).getIncomeDEV());
        System.out.println("-----Complete-----" + "\n");
    }

    public void addTester(Employee employee){
        if (listSalary == null){
            listSalary = new TreeMap<>();
        }
        System.out.println("Enter the number of bug of tester found.");
        ((Tester)employee).setNumberOfBugFind(Integer.parseInt(input.nextLine()));
        ((Tester)employee).setIncomeTester();
        listSalary.put(employee.getName(), ((Tester)employee).getIncomeTester());
        System.out.println("-----Complete-----"+"\n");
    }

    public void addSeller(Employee employee){
        if (listSalary == null){
            listSalary = new TreeMap<>();
        }
        System.out.println("Enter the number of customer seller get.");
        ((Seller)employee).setNumberOfCustomer(Integer.parseInt(input.nextLine()));
        ((Seller)employee).setIncomeSeller();
        listSalary.put(employee.getName(), ((Seller)employee).getIncomeSeller());
        System.out.println("-----Complete-----"+"\n");
    }



    public void inputGender(Employee employee){
        System.out.println("Enter gender: ");
        String gender = input.nextLine();
        switch(gender){
            case "male":
                employee.setGender("male");
                break;
            case "female":
                employee.setGender("female");
                break;
            default:
                System.err.println("Enter male,female or other!!");
                inputGender(employee);
                break;
        }
    }

    public void inputWorkPlace(Employee employee){
        System.out.println("Enter work place: ");
        String workPlace = input.nextLine();
        switch (workPlace){
            case "1":
                employee.setWorkPlace("First floor");
                break;
            case "2":
                employee.setWorkPlace("Second floor");
                break;
            case "3":
                employee.setWorkPlace("Third floor");
                break;
            default:
                System.out.println("Enter 1,2 or 3 floor");
                inputWorkPlace(employee);
                break;

        }
    }

    public String inputDateOfBirth(){
        String date;
        String input =new Scanner(System.in).nextLine();
        String dateRegex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher =pattern.matcher(input);
        if (matcher.find()){
            date =input;
        } else {
            System.err.println("You must enter date of birth in dd/mm/yyyy!!");
            date=inputDateOfBirth();
        }
        return date;
    }

    public String inputName(){
        String name;
        String input =new Scanner(System.in).nextLine();
        String nameRegex = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]*";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher =pattern.matcher(input);
        if (matcher.find()){
            name =input;
        } else {
            System.err.println("Enter your name again!!");
            name=inputName();
        }
        return name;
    }

    public String inputPhoneNumber(){
        String number;
        String input =new Scanner(System.in).nextLine();
        String numberRegex = "^(09|01[2|6|8|9])+([0-9]{7})$";
        Pattern pattern = Pattern.compile(numberRegex);
        Matcher matcher =pattern.matcher(input);
        if (matcher.find()){
            number =input;
        } else {
            System.err.println("Phone number include ten number!!");
            number=inputPhoneNumber();
        }
        return number;
    }

    public String inputCode(){
        String code;
        String input =new Scanner(System.in).nextLine();
        String codeRegex = "^CG\\d{4}$";
        Pattern pattern = Pattern.compile(codeRegex);
        Matcher matcher =pattern.matcher(input);
        if (matcher.find()){
            code =input;
        } else {
            System.err.println("Code include CG and 4 number");
            code=inputCode();
        }
        return code;
    }

    public void writeFileSalary(){
        try {
            FileOutputStream fos = new FileOutputStream(FILE_SALARY);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listSalary);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object readFileSalary(){
        Object o;
        try {
            FileInputStream fis = new FileInputStream(FILE_SALARY);
            ObjectInputStream ois = new ObjectInputStream(fis);
            o= ois.readObject();
            ois.close();
            return o;
        } catch (Exception e) {
            return null;
        }
    }



}
