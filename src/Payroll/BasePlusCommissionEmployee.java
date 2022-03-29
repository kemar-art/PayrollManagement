package Payroll;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;

    public BasePlusCommissionEmployee(double gSales, double cRate, double bSalary)
    {
        super(gSales, cRate);
        this.baseSalary = bSalary;
    }
    @Override
    public double getPaymentAmount(){

        double bal = this.grossSales * this.commissionRate;
        return this.baseSalary + bal;
    }

    //Setter
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    //Getter
    public double getBaseSalary() {
        return baseSalary;
    }
    @Override
    public void writeToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("paystub.txt", true))) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            writer.write("\n******BASE PLUS COMMISSIONED EMPLOYEE*****");
            writer.write("\nDate: "+formattedDate+"\nName:" + getFirstName() + " " + getLastName() + "\nPayment total: $" + getPaymentAmount());

        } catch (IOException e) {
            System.out.println("Error occurred writing to file.");
            e.printStackTrace();
        }
    }
}
