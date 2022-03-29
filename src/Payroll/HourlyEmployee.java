package Payroll;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HourlyEmployee extends Employee{
    private double wage;
    private double hours;

    public HourlyEmployee(){};

    @Override
    public double getPaymentAmount(){

        return  this.hours * this.wage;
    }

      public HourlyEmployee(String fName, String lName, String ssNumber, double wage, double hours)
    {
        super(fName, lName, ssNumber);
        this.wage = wage;
        this.hours = hours;
    }

    //setters
    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    //Getters
    public double getWage() {
        return wage;
    }

    public double getHours() {
        return hours;
    }

    //write to file

    @Override
    public void writeToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("paystub.txt", true))) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            writer.write("\n\n******Hourly Employee*****");
            writer.write("\nDate: "+formattedDate+"\nName:" + getFirstName() + " " + getLastName() + "\nPayment total: " + getPaymentAmount());

        } catch (IOException e) {
            System.out.println("Error occurred writing to file.");
            e.printStackTrace();
        }
    }
}
