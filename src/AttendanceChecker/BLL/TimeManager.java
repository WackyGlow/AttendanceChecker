package AttendanceChecker.BLL;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Timer;


public class TimeManager {
    private int hour;
    private int minute;
    private int second;
    public TimeManager() {
        hour = 16;
        minute = 0;
        second = 0;
    }

    /**
     * This method executes the method "TimeManagerTask.MyTimeTask" at the time designated by
     * the variabels hour, minute and second.
     * @throws ParseException
     */
    public void schedualAtTimeTest() throws ParseException {
        Calendar goTime = Calendar.getInstance();
        goTime.set(Calendar.HOUR_OF_DAY, hour);
        goTime.set(Calendar.MINUTE, minute);
        goTime.set(Calendar.SECOND, second);
        Timer timer = new Timer();
        timer.schedule(new TimeManagerTask.MyTimeTask(), goTime.getTime());
    }
}
