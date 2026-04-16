import java.util.*;

class Employee {
    int id;
    String name;
    double salary;


    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Id:" + id + ",Name:" + name + ",Salary:" + salary);
    }
}
public class Main{
    static List<Employee>empList=new ArrayList<>();
    static Set<Integer>empIDs=new HashSet<>();
    static Map<Integer,Employee>empMap=new HashMap<>();

    static Scanner sc=new Scanner(System.in);

    public static void addEmployees(){
        System.out.println("Enter ID: ");
        int id = sc.nextInt();

        if(empIDs.contains(id)){
            System.out.println("Employee ID already exits!");
            return;

        }
        sc.nextLine();
        System.out.println("Enter Name:");
        String name=sc.nextLine();

        System.out.println("Enter Salary: ");
        Double salary=sc.nextDouble();

        Employee emp=new Employee(id,name,salary);
        empList.add(emp);
        empIDs.add(id);
        empMap.put(id,emp);

        System.out.println("Employee details added Successfully!");

    }
    public static void viewEmployee(){
        if(empList.isEmpty()) {
            System.out.println("No records found!");
            return;
        }
        for(Employee e: empList){
            e.display();
        }
    }
    public static void updateEmployee(){
        System.out.println("Enter Employee id to update: ");
        int id=sc.nextInt();

        if(!empMap.containsKey(id)){
            System.out.println("Employee not found");
            return;
        }
        sc.nextLine();
        System.out.println("Enter New Name: ");
        String name= sc.nextLine();

        System.out.println("Enter New Salary: ");
        double salary=sc.nextDouble();

        Employee emp =empMap.get(id);
        emp.name=name;
        emp.salary=salary;

        System.out.println("Employee details updated Successfully!");
    }
    public static void deleteEmployee(){
        System.out.println("Enter Employee ID to delete: ");
        int id =sc.nextInt();

        if(!empMap.containsKey(id)){
            System.out.println("Employee not found");
            return;

        }
        Employee emp=empMap.get(id);

        empList.remove(emp);
        empIDs.remove(id);
        empMap.remove(id);

        System.out.println("Employee Details deleted successfully");
    }
    public static void main(String[] args){
        int choice;

        do{
            System.out.println("\n___Employee Records Management System___");
            System.out.println("1. Add Employees");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");

            System.out.println("Enter Your Choice: ");
            choice=sc.nextInt();

            switch (choice){
                case 1:
                    addEmployees();
                    break;
                case 2:
                    viewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting Program.....");
                    break;
                default:
                    System.out.println("Invalid Choice");

            }

        }
        while (choice!=5);
    }



}

