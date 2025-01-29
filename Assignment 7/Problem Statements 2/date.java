import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class DateArithmetic {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String inputDate = "2025-01-29";
        LocalDate date = LocalDate.parse(inputDate, formatter);
        
        LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        
        System.out.println("Original date: " + date.format(formatter));
        System.out.println("Updated date: " + newDate.format(formatter));
    }
}
