package Payroll;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Employee implements Payable{
    protected String firstName;
    protected String lastName;
    protected String socialSecurityNumber;

    public Employee(){};

    public Employee (String fName, String lName, String ssNumber)
    {
        this.firstName = fName;
        this.lastName = lName;
        this.socialSecurityNumber = ssNumber;
    }

    @Override
    public double getPaymentAmount() {
        return 0;
    }

    // Setters
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @Override
    public void writeToFile(){
        StringBuilder contents = new StringBuilder();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("paystub.txt", true))){
            writer.write("\n\n******EMPLOYEE*****");
            writer.write("\nEmployee Name:" +getFirstName()+" "+ getLastName()+"\nSSN: "+getSocialSecurityNumber());

        } catch (IOException e) {
            System.out.println("Error occurred writing to file.");
            e.printStackTrace();
        }
    }



}
