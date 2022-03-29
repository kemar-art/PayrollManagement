package Payroll;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option = 0;
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("**********Menu*************");
            System.out.println("\n1. Employee\n2. Hourly Employee\n3. Commission Employee\n4. Base Plus Commission Empoyee" +
                    "\n5.Salaried Employee\n6.Invoice\n7.EXIT");
            option = input.nextInt();

            switch (option)
            {
                case 1:
                    Employee emp = new Employee("Stephen","Chung","4567FJNV452");
                    Employee emp1 = new Employee("Meleisa", "Pinnock", "CBVD156165");
                    Employee emp2 = new Employee("Kemar","South","45FGBBBH4454");
                    Employee emp3 = new Employee("Meleisa","McKnight","RJBH487885");
                    Employee emp4 = new Employee("Tonia Ann", "McLean", "HVEHVEFVG775");

                    ArrayList<Employee>employees = new ArrayList<>();
                    employees.add(emp); employees.add(emp1); employees.add(emp2);employees.add(emp3);
                    employees.add(emp4);

                    for (Employee  emps: employees)
                    {
                        System.out.println("\nEmployee Name: " + emps.firstName + " " + emps.lastName + "\nSSN: " + emps.socialSecurityNumber);
                        emps.writeToFile();
                    }

                    break;
                case 2:
                    HourlyEmployee hremly = new HourlyEmployee("Meleisa", "Pinnuck", "876786777", 1000, 80);
                    System.out.println("Employee Name " + hremly.firstName + " "+ hremly.lastName + "Salary $" + hremly.getPaymentAmount());
                    hremly.writeToFile();
                    break;
                case 3:
                    CommissionEmployee comEmp = new CommissionEmployee("Stephen","Chung","4567FJNV452",200000,0.15);
                    CommissionEmployee comEmp1 = new CommissionEmployee("Kemar","South","45FGBBBH4454",300000,0.15);
                    CommissionEmployee comEmp2 = new CommissionEmployee("Meleisa","McKnight","RJBH487885",250000,0.15);

                    ArrayList<CommissionEmployee> commish = new ArrayList<>();
                    commish.add(comEmp);commish.add(comEmp1);commish.add(comEmp2);

                    for(CommissionEmployee commishEmp : commish)
                    {
                        System.out.println("Employee Name " + commishEmp.firstName + " "+ commishEmp.lastName + "\nSalary $" + commishEmp.getPaymentAmount());
                        commishEmp.writeToFile();
                    }

                    break;

                case 4:
                    BasePlusCommissionEmployee baseCom = new BasePlusCommissionEmployee(300000,0.05,80000);
                    baseCom.setFirstName("Toni Ann"); baseCom.setLastName("McLean");
                    System.out.println("Employee Name " + baseCom.firstName + " "+ baseCom.lastName + "\nSalary $" + baseCom.getPaymentAmount());
                    baseCom.writeToFile();

                    break;

                case 5:
                    SalariedEmployee semp = new SalariedEmployee("Meleisa", "Pinnock", "876786777", 25000);
                    System.out.println("Employee Name " + semp.firstName + " "+ semp.lastName + "Salary $" + semp.getPaymentAmount());
                    semp.writeToFile();

                    break;
                case 6:
                    Invoice inv = new Invoice("6849KZN1","2022 HP Pavilion Laptop",15,150000);
                    Invoice inv1 = new Invoice("JBJV541D","2022 Dell XPS 17 Laptop",5,180000);
                    Invoice inv2 = new Invoice("CVB456F4","2022 AUS ROG Zephyrus",7,200000);
                    Invoice inv3 = new Invoice("URGUV14R","2022 Acer Spin Laptop",6,120000);

                    ArrayList<Invoice> invoices = new ArrayList<>();
                    invoices.add(inv); invoices.add(inv1); invoices.add(inv2); invoices.add(inv3);

                    for(Invoice invs:invoices)
                    {
                        System.out.println("\nItem:"+ invs.getPartDescription() +"\nUnit Cost: " +invs.getPricePerItem()+"\nQuantity"+ invs.getQuantity()
                        + "\nTotal $"+ invs.getPaymentAmount());
                        invs.writeToFile();
                    }
                    break;
                case 7:
                    System.out.println("Thank you!!");
                    break;
                default:
                    System.out.println("Not a valid option");
            }

        }
        while (option != 7);

    }
}
