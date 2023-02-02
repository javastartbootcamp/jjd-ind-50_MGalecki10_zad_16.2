package pl.javastart.task;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
        List<String> patterns = List.of(Type.DATE_TIME_STANDARD.getPattern(),
                Type.DATE_TIME_DOT.getPattern());
        System.out.println("Podaj datę i czas:");
        String dateInput = scanner.nextLine();
        for (String pattern : patterns) {
            try {
                DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern(pattern);
                TemporalAccessor temporalAccessor = dateTimePattern.parse(dateInput);
                LocalDateTime rightPattern = LocalDateTime.from(temporalAccessor);
                showTime(rightPattern, dateTimePattern);
            } catch (DateTimeException e) {
                //ignore
            }
        }
    }

    private void showTime(LocalDateTime time, DateTimeFormatter pattern) {
        System.out.println("Czas lokalny: " + time.atZone(ZoneId.systemDefault()).format(pattern));
        timeZone(pattern);
    }

    private void timeZone(DateTimeFormatter pattern) {
        Map<String, String> zones = new LinkedHashMap<>();
        zones.put("UTC", "UTC");
        zones.put("London", "Europe/London");
        zones.put("Los Angeles", "America/Los_Angeles");
        zones.put("Sydney", "Australia/Sydney");
        for (String key : zones.keySet()) {
            System.out.println(key + ": " + ZonedDateTime.of(LocalDateTime.now(ZoneId.of(zones.get(key))),
                    ZoneId.of(zones.get(key))).format(pattern));
        }
    }
}

