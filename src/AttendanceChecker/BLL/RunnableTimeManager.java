package AttendanceChecker.BLL;


import java.text.ParseException;

public class RunnableTimeManager implements Runnable{
    public RunnableTimeManager() {

    }

    /**
     * the run method creates a TimeManager object, then calls the timeKeeper methode.
     */
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
