package Payroll;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(){};

    public SalariedEmployee(String fName, String lName, String ssNumber, double wSalary)
    {
        super(fName, lName, ssNumber);
        this.weeklySalary = wSalary;
    }

    //Setter
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    //getter
    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public double getPaymentAmount(){
        return this.weeklySalary;
    }
    @Override
    public void writeToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("paystub.txt", true))) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);


            writer.write("\n\n******Salaried Employee*****");
            writer.write("\nDate: "+formattedDate+"\nName:" + getFirstName() + " " + getLastName() + "\nPayment total: " + getPaymentAmount());

        } catch (IOException e) {
            System.out.println("Error occurred writing to file.");
            e.printStackTrace();
        }
    }
}
