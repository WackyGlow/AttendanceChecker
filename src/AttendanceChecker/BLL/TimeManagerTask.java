package AttendanceChecker.BLL;

import java.util.TimerTask;

public class TimeManagerTask {
    /**
     * This "class within a class" is structured this way, as it is the only way it is able to be
     * used by the TimeManager class.
     */
    public static class MyTimeTask extends TimerTask
    {

        public void run()
        {
            //needs a for each loop that adds absent days to unmarked students, as
            //as well as a method to add 1 day to total days in the database
            System.out.println("success 2");
        }
    }
}
