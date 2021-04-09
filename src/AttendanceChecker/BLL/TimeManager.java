package AttendanceChecker.BLL;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Timer;


public class TimeManager {
    private int time;
    private int minut;
    private int sekund;
    public TimeManager() {
        time = 16;
        minut = 0;
        sekund = 0;
    }

    public void schedualAtTimeTest() throws ParseException {
        Calendar goTime = Calendar.getInstance();
        goTime.set(Calendar.HOUR_OF_DAY, time);
        goTime.set(Calendar.MINUTE, minut);
        goTime.set(Calendar.SECOND, sekund);
        Timer timer = new Timer();
        timer.schedule(new TimeManagerTask.MyTimeTask(), goTime.getTime());
    }
}
