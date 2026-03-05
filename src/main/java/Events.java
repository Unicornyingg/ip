import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Represents an event task with start and end date/time text.
 */
public class Events extends Task{
    private static final DateTimeFormatter OUTPUT_DATE_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy", Locale.ENGLISH);
    private static final DateTimeFormatter OUTPUT_DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy h:mma", Locale.ENGLISH);

    String from;
    String to;
    public Events(String description, String from, String to) {
        super(description);
        this.from = formatDateTime(from.strip());
        this.to = formatDateTime(to.strip());
    }

    /**
     * Returns the formatted event string.
     *
     * @return Event string.
     */
    @Override
    public String toString(){
        return "[E]" + super.toString() + " " + "(from: " + from + " to: " + to +")";
    }

    /**
     * Formats a date/time string into the required output style when parseable.
     *
     * @param input Raw date/time text.
     * @return Formatted date/time text or original input.
     */
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

    /**
     * Parses a date-time string using supported formats.
     *
     * @param input Date-time input.
     * @return Parsed LocalDateTime, or null if parsing fails.
     */
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

    /**
     * Parses a date string using supported formats.
     *
     * @param input Date input.
     * @return Parsed LocalDate, or null if parsing fails.
     */
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
