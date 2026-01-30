import java.time.*;
import java.util.*;
import java.util.stream.*;

class Event {
    String name;
    LocalDate date;

    Event(String name, String dateStr) {
        this.name = name;
        this.date = LocalDate.parse(dateStr); // yyyy-MM-dd
    }
}

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String date = sc.next();
            events.add(new Event(name, date));
        }

        int month = sc.nextInt();

        List<Event> sortedEvents = events.stream()
                .sorted(Comparator.comparing(e -> e.date))
                .collect(Collectors.toList());

        System.out.println(
                sortedEvents.stream()
                        .map(e -> e.name)
                        .collect(Collectors.joining(" "))
        );

        Event earliest = sortedEvents.get(0);
        System.out.println(earliest.name);

        Event latest = sortedEvents.get(sortedEvents.size() - 1);
        System.out.println(latest.name);

        String monthEvents = events.stream()
                .filter(e -> e.date.getMonthValue() == month)
                .map(e -> e.name)
                .collect(Collectors.joining(" "));

        System.out.println(monthEvents);
    }
}
