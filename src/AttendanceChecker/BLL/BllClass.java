package AttendanceChecker.BLL;

import AttendanceChecker.Be.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BllClass {

    public ObservableList<Student> allStudents;
    public MockData moD;
    public BllClass() {
        moD = new MockData();
    }

    public ObservableList<Student> getListOfStudents() {

        allStudents = FXCollections.observableArrayList();
        allStudents.addAll(moD.getListOfStudents());
        return allStudents;
    }
}
