import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class date2{

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        
        System.out.println("Date in format dd/MM/yyyy: " + currentDate.format(formatter1));
        System.out.println("Date in format yyyy-MM-dd: " + currentDate.format(formatter2));
        System.out.println("Date in format EEE, MMM dd, yyyy: " + currentDate.format(formatter3));
    }
}
