package AttendanceChecker.Be;

import javafx.beans.property.*;

public class Student {
    private final int id;
    private StringProperty name;
    private ObjectProperty<Integer> totalDays;
    private ObjectProperty<Integer> absentDays;
    private ObjectProperty<Integer> absentPercent;
    private StringProperty mostAbsentDay;
    private boolean presentToday;

    public Student(int id, String name, int totalDays, int absentDays, int absentPercent, String mostAbsentDay, boolean presentToday){
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.totalDays = new SimpleIntegerProperty(totalDays).asObject();
        this.absentDays = new SimpleIntegerProperty(absentDays).asObject();
        this.absentPercent = new SimpleIntegerProperty(absentPercent).asObject();
        this.mostAbsentDay = new SimpleStringProperty(mostAbsentDay);
        this.presentToday = presentToday;
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

    public int getTotalDays() {
        return totalDays.get();
    }

    public ObjectProperty<Integer> totalDaysProperty() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays.set(totalDays);
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

    public int getAbsentPercent() {
        return absentPercent.get();
    }

    public ObjectProperty<Integer> absentPercentProperty() {
        return absentPercent;
    }

    public void setAbsentPercent(int absentPercent) {
        this.absentPercent.set(absentPercent);
    }

    public String getMostAbsentDay() {
        return mostAbsentDay.get();
    }

    public StringProperty mostAbsentDayProperty() {
        return mostAbsentDay;
    }

    public void setMostAbsentDay(String mostAbsentDay) {
        this.mostAbsentDay.set(mostAbsentDay);
    }
}
