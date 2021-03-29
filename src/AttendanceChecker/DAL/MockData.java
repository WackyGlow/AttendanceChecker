package AttendanceChecker.DAL;

import AttendanceChecker.Be.Student;
import java.util.ArrayList;


public class MockData {
    public ArrayList<Student> listOfStudents;
    public MockData() {
        listOfStudents = new ArrayList<>();

    }
    public ArrayList<Student> getListOfStudents() {
        Student lars = new Student( 1,"Lars",100,0,0,"Monday");
        Student kim = new Student(2,"Kim",100,50,50,"Friday");
        Student bo = new Student(3,"Bo",100,100,100,"Tuesday");
        listOfStudents.add(lars);
        listOfStudents.add(kim);
        listOfStudents.add(bo);
        return listOfStudents;
    }
}
