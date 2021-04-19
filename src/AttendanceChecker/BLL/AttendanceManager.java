package AttendanceChecker.BLL;

import AttendanceChecker.Be.Student;
import AttendanceChecker.DAL.DAO.StudentDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

public class AttendanceManager {
    private StudentDAO studentDAO;
    private int dayOfWeek;
    private String day;

    public AttendanceManager() throws IOException {
        studentDAO = new StudentDAO();
    }

    public void markAsPresent(Student student) throws IOException, SQLException {
        studentDAO.markStudentAsPresent(student);
    }
    public String localDateToDayOfWeek(LocalDate localDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(localDate.getYear(), localDate.getMonthValue()-1, localDate.getDayOfMonth());
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
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
        return day;
    }
}
