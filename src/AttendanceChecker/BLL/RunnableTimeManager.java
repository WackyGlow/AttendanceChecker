package AttendanceChecker.BLL;


import java.text.ParseException;

public class RunnableTimeManager implements Runnable{
    private TimeManager tM;
    public RunnableTimeManager() {
        TimeManager tM = new TimeManager();

    }

    @Override
    public void run() {
        try {
            tM.timeKeeper();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
