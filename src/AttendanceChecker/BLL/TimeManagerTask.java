package AttendanceChecker.BLL;

import AttendanceChecker.Be.Student;
import AttendanceChecker.DAL.DAO.StudentDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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

            listOfStudents = new ArrayList<>();
            Calendar c = Calendar.getInstance();
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            String day = "day";
            if(dayOfWeek == 2){
                day = "monday";
            }
            else if(dayOfWeek == 3){
                day = "Tuesday";
            }
            else if(dayOfWeek == 4){
                day = "wednesday";
            }
            else if(dayOfWeek == 5){
                day = "thursday";
            }
            else if(dayOfWeek == 6){
                day = "friday";
            }
            StudentDAO sGetter = null;
            try {
                sGetter = new StudentDAO();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert sGetter != null;
            listOfStudents = sGetter.getAllStudents();
            for (Student S: listOfStudents) {
                if(S.isPresentToday() == false){
                    try {
                        sGetter.addToAbsentDays(S);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        sGetter.addToMostAbsentDay(S, day);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                if(S.isPresentToday() == true){
                    try {
                        sGetter.changeIsPresentBack(S);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

            }
            try {
                sGetter.addToTotalDays();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
