package Payroll;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Invoice implements  Payable{
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    String separator = System.getProperty("line.separator");

    public Invoice(String pNumber, String pDescription, int QYT, double ppItem)
    {
        partNumber = pNumber;
        partDescription = pDescription;
        quantity = QYT;
        pricePerItem = ppItem;
    }

    //Setters
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    //Getters
    public String getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    @Override
    public double getPaymentAmount(){
         return getPricePerItem()*getQuantity();
    }
    @Override
    public void writeToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("paystub.txt", true))) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            writer.write( "\n\n******INVOICE*****");
            writer.write( separator + "Transaction Date: " + formattedDate);
            writer.write(separator + "Part Number\t\t\tDescription\t\t\t\tQuantity\t\t\t\tUnit Cost\t\t\tSubtotal");
            writer.write(separator +getPartNumber()+"\t\t\t"+getPartDescription()+"\t\t"+getQuantity()+"\t\t\t\t\t"+getPricePerItem()+"\t\t\t"+getPaymentAmount());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error occurred writing to file.");
            e.printStackTrace();
        }

    }
}
