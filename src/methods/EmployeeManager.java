package methods;

import entities.Developer;
import entities.Employee;
import entities.Seller;
import entities.Tester;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager  {
    ArrayList<Employee> employees = (ArrayList<Employee>) readFile();
    Information information = new Information();
    Scanner input =new Scanner(System.in);
    FileTxt fileTxt = new FileTxt();
    static final String FILE_NAME = "list";
    static final String PATH1= "listTxt";

    public void writeFileText(){
        ArrayList<String> list = new ArrayList<>();
        for (Employee employee :employees){
            list.add(employee.toString());

        }
        fileTxt.writeFile(list,PATH1);
    }

    public void addEmployee(Employee employee){
        if (employees == null){
            employees = new ArrayList<>();
        }
        employees.add(employee);


    }

    public void showListEmployee(){
        for (Employee employee: employees){
            System.out.println(employee.toString());
        }
    }

    public void searchEmployeeByCode(String code){
        for (Employee employee: employees){
            if (employee.getEmployeeCode().equals(code)){
                System.out.println(employee.toString());
            }
        }
    }

    public void searchEmployeeByName(String name){
        for (Employee employee: employees){
            if (employee.getName().equals(name)){
                System.out.println(employee.toString());
            }
        }
    }



    public void updateEmployee(String code) {
        for (Employee employee : employees) {
            if (employee.getEmployeeCode().equals(code)) {
                System.out.println("Enter employee name.");
                String employeeName = information.inputName();
                System.out.println("Enter date of birth.");
                String employeeDOB = information.inputDateOfBirth();
                System.out.println("Enter phone number.");
                String employeePhoneno = information.inputPhoneNumber();
                System.out.println("Enter basic rate.");
                int employeeRate = Integer.parseInt(input.nextLine());
                if (employee instanceof Developer) {
                    System.out.println("Enter overtime: ");
                    int overTime = Integer.parseInt(input.nextLine());
                    ((Developer) employee).setOverTime(overTime);
                    employee.setName(employeeName);
                    employee.setDateOfBirth(employeeDOB);
                    employee.setGender(employee.getGender());
                    employee.setPhoneNumber(employeePhoneno);
                    employee.setBasicRate(employeeRate);
                }
                if (employee instanceof Seller) {
                    int customer = Integer.parseInt(input.nextLine());
                    employee.setName(employeeName);
                    employee.setDateOfBirth(employeeDOB);
                    employee.setGender(employee.getGender());
                    employee.setPhoneNumber(employeePhoneno);
                    employee.setBasicRate(employeeRate);
                    ((Seller) employee).setNumberOfCustomer(customer);
                }
                if (employee instanceof Tester) {
                    int bug = Integer.parseInt(input.nextLine());
                    employee.setName(employeeName);
                    employee.setDateOfBirth(employeeDOB);
                    employee.setGender(employee.getGender());
                    employee.setPhoneNumber(employeePhoneno);
                    employee.setBasicRate(employeeRate);
                    ((Tester) employee).setNumberOfBugFind(bug);
                }
            }
        }
    }


    public ArrayList<Employee> delete(String employeeCode){
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeCode().equals(employeeCode)){
                employees.remove(i);
            }
        }
        return employees;
    }

    public void checkFloor(String floor){
        for (Employee employee : employees){
            if (employee.getWorkPlace().equals(floor)){
                System.out.println(employee.toString());
            }
        }
    }

    public boolean isContain(String code){
        if (employees == null){
            return false;
        }
        for (Employee employee: employees){
            if (employee.getEmployeeCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    public void writeFile(){
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employees);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object readFile(){
        Object o;
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            o= (ArrayList<Employee>) ois.readObject();
            ois.close();
            return o;
        } catch (Exception e) {
            return null;
        }
    }




}
