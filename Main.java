import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        EmployeeDAO dao=new EmployeeDAO();

        while (true){
            System.out.println("\n===== Employee DB Menu =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter Name: ");
                    sc.nextLine();
                    String name=sc.nextLine();

                    System.out.println("Enter Email: ");
                    String email= sc.next();

                    System.out.println("Enter Salary");
                    double salary= sc.nextDouble();
                    dao.addEmployee(new Employee(name, email, salary));
                    break;

                case 2:
                    List<Employee> list=dao.getAllEmployee();
                    System.out.println("\n--- Employee List ---");
                    for (Employee e:list){
                        System.out.println(e.getId() +" | "+
                        e.getName()+" | "+e.getEmail()+" | "+e.getSalary());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    name = sc.nextLine();
                    System.out.print("Enter new email: ");
                    email = sc.next();
                    System.out.print("Enter new salary: ");
                    salary = sc.nextDouble();
                    dao.updateEmployee(new Employee(id, name, email, salary));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");

            }
        }
    }
}