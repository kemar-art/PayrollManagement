package Payroll;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommissionEmployee extends Employee{
    protected double grossSales;
    protected  double commissionRate;

    public CommissionEmployee(double gSales, double cRate){
        this.commissionRate = cRate;
        this.grossSales = gSales;
    };

    public CommissionEmployee(String fName, String lName, String ssNumber, double gSales, double cRate)
    {
        super(fName, lName, ssNumber);
        this.grossSales = gSales;
        this.commissionRate = cRate;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    // Getters
    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    @Override
    public double getPaymentAmount(){

        return this.commissionRate * this.grossSales;
    }
    @Override
    public void writeToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("paystub.txt", true))) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            writer.write("\n\n******COMMISSIONED EMPLOYEE*****");
            writer.write("\nDate: "+formattedDate+"\nName:" + getFirstName() + " " + getLastName() + "\nPayment total: $" + getPaymentAmount() + "\n");

        } catch (IOException e) {
            System.out.println("Error occurred writing to file.");
            e.printStackTrace();
        }
    }
}

