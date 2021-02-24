package methods;

import entities.Developer;
import entities.Seller;
import entities.Tester;

import java.util.Scanner;
import java.util.Set;

public class Menu {

    public void menu(){
        EmployeeManager employeeManager = new EmployeeManager();
        Information information = new Information();
        Scanner input = new Scanner(System.in);
        boolean check = true;


        do {
            System.out.println("------------------------------");
            System.out.println(" 1. Add a new employee.");
            System.out.println(" 2. Show list of employees.");
            System.out.println(" 3. Update information employee. ");
            System.out.println(" 4. Fire an employee.");
            System.out.println(" 5. Show salary of employee.");
            System.out.println(" 6. Find employee.");
            System.out.println(" 7. Export file to save.");
            System.out.println(" 8. Export file to text.");
            System.out.println(" 0. Exit.");
            System.out.println("------------------------------");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("------------------------------");
                    System.out.println(" 1. Add a new developer.");
                    System.out.println(" 2. Add a new tester.");
                    System.out.println(" 3. Add a new seller.");
                    System.out.println(" 0. Back to menu.");
                    System.out.println("------------------------------");
                    int select = Integer.parseInt(input.nextLine());
                    switch (select) {
                        case 1:
                            Developer developer = new Developer();
                            information.addDev(information.addInfo(developer));
                            employeeManager.addEmployee(developer);
                            break;
                        case 2:
                            Tester tester = new Tester();
                            information.addTester(information.addInfo(tester));
                            employeeManager.addEmployee(tester);
                            break;
                        case 3:
                            Seller seller = new Seller();
                            information.addSeller(information.addInfo(seller));
                            employeeManager.addEmployee(seller);
                            break;
                        case 0:
                            menu();
                    }
                    break;
                case 2:
                    employeeManager.showListEmployee();
                    break;
                case 3:
                    System.out.println("Enter employee code: ");
                    String code = input.nextLine();
                    employeeManager.updateEmployee(code);
                    System.out.println("-----Complete-----");
                    break;
                case 4:
                    System.out.println("Enter employee code");
                    String employeeCode = input.nextLine();
                    employeeManager.delete(employeeCode);
                    System.out.println("-----Complete-----");
                    break;
                case 5:
                    Set<String> set = information.getListSalary().keySet();
                    for (String key:set
                    ) {
                        System.out.println("-----------------------------");
                        System.out.println("Employee" + "   " + "Salary");
                        System.out.println(key + "          " + information.getListSalary().get(key));
                        System.out.println("------------------------------");
                    }
                    break;
                case 6:
                    System.out.println("1. Show list of employee in first floor.");
                    System.out.println("2. Show list of employee in second floor.");
                    System.out.println("3. Show list of employee in third floor.");
                    System.out.println("4. Find employee by code.");
                    System.out.println("5. Find employee by name.");
                    System.out.println("0. Back to menu");
                    int floor = Integer.parseInt(input.nextLine());
                    switch (floor){
                        case 1:
                            employeeManager.checkFloor("First floor");
                            break;
                        case 2:
                            employeeManager.checkFloor("Second floor");
                            break;
                        case 3:
                            employeeManager.checkFloor("Third floor");
                            break;
                        case 4:
                            System.out.println("Enter employee code: ");
                            String id = input.nextLine();
                            employeeManager.searchEmployeeByCode(id);
                            break;
                        case 5:
                            System.out.println("Enter employee name: ");
                            String name = input.nextLine();
                            employeeManager.searchEmployeeByName(name);
                            break;
                        case 0:
                            menu();
                    }
                    break;
                case 7:
                    employeeManager.writeFile();
                    information.writeFileSalary();
                    System.out.println("-------Complete-------");
                    break;
                case 8:
                    employeeManager.writeFileText();
                    information.writeFileText();
                    System.out.println("-------Complete-------");
                    break;
                case 0:
                    check = false;
            }
        }while (check);
    }

}
