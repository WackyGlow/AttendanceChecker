package AttendanceChecker.BLL;

import AttendanceChecker.Be.Student;

import java.util.List;
import java.util.TimerTask;

public class TimeManagerTask {
    /**
     * This "class within a class" is structured this way, as it is the only way it is able to be
     * used by the TimeManager class.
     */
    public static class MyTimeTask extends TimerTask
    {
        private List<Student> listOfStudents;

        public void run()
        {
            //needs a for each loop that adds absent days to unmarked students, as
            //as well as a method to add 1 day to total days in the database
            for (Student S: listOfStudents) {
                if(S.isPresentToday() == false){
                    //add absent day in database
                }
                if(S.isPresentToday() == true){
                    //set isPresentTOday to flase in database
                }

            }
            //add one to total days in database
        }
    }
}
