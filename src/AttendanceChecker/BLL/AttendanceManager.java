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
    private String mostAbsentDay;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;

    /**
     * constructor for this class
     * @throws IOException
     */
    public AttendanceManager() throws IOException {
        studentDAO = new StudentDAO();
    }

    /**
     * marks a student as present in the database
     * @param student
     * @throws IOException
     * @throws SQLException
     */
    public void markAsPresent(Student student) throws IOException, SQLException {
        studentDAO.markStudentAsPresent(student);
    }

    /**
     * Removes absence from a specific day i.e. monday from given student in the database
     * @param student
     * @param specifiedDay
     */
    public void removeFromMostDayAbsentDay(Student student, String specifiedDay){
        studentDAO.removeFromMostDayAbsentDay(student,specifiedDay);
    }

    /**
     * lowers the amount of absent days from the given student in the databse
     * @param student
     * @throws SQLException
     */
    public void removefromAbsentDays(Student student) throws SQLException{
        studentDAO.removefromAbsentDays(student);
    }

    /**
     * gets the current day of the week and returns a string with the days name
     * @param localDate
     * @return
     */
    public String localDateToDayOfWeek(LocalDate localDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(localDate.getYear(), localDate.getMonthValue()-1, localDate.getDayOfMonth());
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == 2){
            day = "monday";
        } else if(dayOfWeek == 3){
            day = "Tuesday";
        } else if(dayOfWeek == 4){
            day = "wednesday";
        } else if(dayOfWeek == 5){
            day = "thursday";
        } else if(dayOfWeek == 6){
            day = "friday";
        }
        return day;
    }

    /**
     * calculates which day of the week the student has the most absence,
     * and returns that day as a string
     * @param student
     * @return
     */
    public String getValueFromDay(Student student){
        monday = studentDAO.getValueFromDay(student, "monday");
        tuesday = studentDAO.getValueFromDay(student, "tuesday");
        wednesday = studentDAO.getValueFromDay(student, "wednesday");
        thursday = studentDAO.getValueFromDay(student, "thursday");
        friday = studentDAO.getValueFromDay(student, "friday");
        int largest = Math.max(monday,Math.max(tuesday,Math.max(wednesday,Math.max(thursday,friday))));
        if (largest == monday){
            return "Monday";
        } else if (largest == tuesday) {
            return "Tuesday";
        } else if (largest == wednesday){
            return "Wednesday";
        } else if (largest == thursday){
            return "Thursday";
        } else if (largest == friday){
            return "Friday";
        } else {
            return "No absence, ggwp ;)";
        }
    }
}
