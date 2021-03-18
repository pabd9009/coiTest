import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AdultChecker {

    public static boolean checkIfAdult(String pesel) {

        StringBuilder sb = new StringBuilder(pesel);

        if (sb.length() != 11) {
            throw new IllegalArgumentException("PESEL z niepoprawna liczba cyfr");
        }

        sb.delete(6, 11);

        char centuryIndicator = sb.charAt(2);
        int monthDifference = 0;
        int century = 0;
        if (centuryIndicator == '8' || centuryIndicator == '9') {
            monthDifference = 7;
            century = 18;
        } else if (centuryIndicator == '0' || centuryIndicator == '1') {
            century = 19;
        } else if (centuryIndicator == '2' || centuryIndicator == '3') {
            monthDifference = 2;
            century = 20;
        } else if (centuryIndicator == '4' || centuryIndicator == '5') {
            monthDifference = 4;
            century = 21;
        } else if (centuryIndicator == '6' || centuryIndicator == '7') {
            monthDifference = 6;
            century = 22;
        }
        int month = Integer.parseInt(sb.substring(2, 3)) - monthDifference;
        sb.replace(2, 3, String.valueOf(month));
        sb.insert(0, century);

        String dateString = sb.toString();

        LocalDate birthDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyyMMdd"));

        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data urodzenia pozniejsza niz aktualna data!");
        }

        boolean isAdult = false;
        Period period = Period.between(birthDate, LocalDate.now());
        if (period.getYears() < 18) {
            System.out.println("Niepełnoletni");
        } else {
            System.out.println("Pełnoletni");
            isAdult = true;
        }
        return isAdult;
    }
}
