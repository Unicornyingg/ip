import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Deadline extends Task{
    private static final DateTimeFormatter OUTPUT_DATE_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy", Locale.ENGLISH);
    private static final DateTimeFormatter OUTPUT_DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy h:mma", Locale.ENGLISH);

    String date;

    public Deadline(String description, String date) {
        super(description);
        this.date = formatDateTime(date.strip());
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " " + "(by: " + date + ")";
    }

    private String formatDateTime(String input) {
        LocalDateTime parsedDateTime = parseDateTime(input);
        if (parsedDateTime != null) {
            return parsedDateTime.format(OUTPUT_DATE_TIME_FORMAT);
        }

        LocalDate parsedDate = parseDate(input);
        if (parsedDate != null) {
            return parsedDate.format(OUTPUT_DATE_FORMAT);
        }

        return input;
    }

    private LocalDateTime parseDateTime(String input) {
        DateTimeFormatter[] dateTimeFormats = new DateTimeFormatter[] {
            DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("MMM dd yyyy h:mma", Locale.ENGLISH),
            DateTimeFormatter.ofPattern("MMM d yyyy h:mma", Locale.ENGLISH),
            DateTimeFormatter.ofPattern("MMM dd yyyy h:mm a", Locale.ENGLISH),
            DateTimeFormatter.ofPattern("MMM d yyyy h:mm a", Locale.ENGLISH)
        };

        for (DateTimeFormatter formatter : dateTimeFormats) {
            try {
                return LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                // try next format
            }
        }
        return null;
    }

    private LocalDate parseDate(String input) {
        DateTimeFormatter[] dateFormats = new DateTimeFormatter[] {
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("MMM dd yyyy", Locale.ENGLISH),
            DateTimeFormatter.ofPattern("MMM d yyyy", Locale.ENGLISH)
        };

        for (DateTimeFormatter formatter : dateFormats) {
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                // try next format
            }
        }
        return null;
    }
}
