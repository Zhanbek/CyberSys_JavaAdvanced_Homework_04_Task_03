import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static String getIntervalFromDate(LocalDateTime dateTime) {
        // Текущая дата и время
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Проверяем, что указанная дата не в будущем
        if (dateTime.isAfter(currentDateTime)) {
            return "Зазначена дата ще не настала!";
        }

        // Отримуємо різницю в роках, місяцях і днях (без урахування часу)
        Period duration = Period.between(dateTime.toLocalDate(), currentDateTime.toLocalDate());

        LocalDateTime correctedDateTime = dateTime.plusYears(duration.getYears())
                                                  .plusMonths(duration.getMonths())
                                                  .plusDays(duration.getDays());

        // Отримуємо різницю в часі (години, хвилини, секунди)
        Duration difference = Duration.between(correctedDateTime, currentDateTime);

        long hours = difference.toHours();
        if (hours >= 24) {

        } else {

        }

        long minutes = difference.toMinutesPart();
        long seconds = difference.toSecondsPart();

        StringBuilder result = new StringBuilder();
        String yearsStr = (duration.getYears() <= 0) ?  "" : String.valueOf(duration.getYears());
        String monthsStr = (duration.getMonths() <= 0) ?  "" : String.valueOf(duration.getMonths());
        String daysStr = (duration.getDays() <= 0) ?  "" : String.valueOf(duration.getDays());
        String hoursStr = (hours <= 0) ?  "" : String.valueOf(hours);
        String minutesStr = (minutes <= 0) ?  "" : String.valueOf(minutes);
        String secondsStr = (seconds <= 0) ?  "" : String.valueOf(seconds);

        result.append(yearsStr).append(" years, ").append(monthsStr).append(" months, ").append(daysStr).append(" days, ")
              .append(hoursStr).append(" hours, ").append(minutesStr).append(" minutes, ").append(secondsStr).append(" seconds.");
        return result.toString();
    }

    public static void main(String[] args) {
        LocalDateTime birthDateTime = LocalDateTime.of(1979, 6, 6, 10, 30, 9);
        System.out.println();
        System.out.println(getIntervalFromDate(birthDateTime));
    }
}