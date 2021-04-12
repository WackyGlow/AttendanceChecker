package AttendanceChecker.Be;

import javafx.beans.property.*;

public class Student {
    private final int id;
    private StringProperty name;
    private ObjectProperty<Integer> absentDays;
    private boolean presentToday;

    public Student(int id, String name, int absentDays, boolean presentToday){
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.absentDays = new SimpleIntegerProperty(absentDays).asObject();
        this.presentToday = presentToday;
    }

    public boolean isPresentToday() {
        return presentToday;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getAbsentDays() {
        return absentDays.get();
    }

    public ObjectProperty<Integer> absentDaysProperty() {
        return absentDays;
    }

    public void setAbsentDays(int absentDays) {
        this.absentDays.set(absentDays);
    }

}
