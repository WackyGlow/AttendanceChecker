package AttendanceChecker.BLL;

import AttendanceChecker.Be.Student;
import AttendanceChecker.DAL.DAO.StudentDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
            listOfStudents = new ArrayList<>();
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
