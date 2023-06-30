package mvc.project.checker;

import mvc.project.entity.mentoring_schema.Worker;

import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddWorkerChecker {
    private final static Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private Matcher matcher;

    public static boolean isCorrectData(Worker worker){
        return isCorrectEmail(worker.getEmail())
                && isCorrectTime(worker.getTime4screenshots());
    }

    private static boolean isCorrectEmail(String email){
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private static boolean isCorrectTime(LocalTime time){
        return time.isBefore(LocalTime.of(10, 0))
                && time.isAfter(LocalTime.of(0, 30));
    }
}
