package Program;

import entities.*;
import methods.EmployeeManager;
import methods.Menu;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Admin admin = Admin.getInstance();

        EmployeeManager employeeManager = new EmployeeManager();
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        String code;
        do {
            System.out.println("------------Login-------------");
            System.out.println("Enter employee code: ");
            code = input.nextLine();

        } while (!employeeManager.isContain(code) && !admin.getEmployeeCode().equals(code));
        menu.menu();
    }
}
