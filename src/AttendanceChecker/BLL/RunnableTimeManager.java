package AttendanceChecker.BLL;


import java.text.ParseException;

public class RunnableTimeManager implements Runnable{
    public RunnableTimeManager() {

    }

    @Override
    public void run() {
        TimeManager tM = new TimeManager();
        try {
            tM.timeKeeper();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
