package AttendanceChecker.Be;

import javafx.beans.property.*;

public class Student {
    private final int id;
    private final StringProperty name;
    private final IntegerProperty absentDays;
    private final boolean presentToday;

    /**
     * constructor for the student calss
     * @param id
     * @param name
     * @param absentDays
     * @param presentToday
     */
    public Student(int id, String name, int absentDays, boolean presentToday){
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.absentDays = new SimpleIntegerProperty(absentDays);
        this.presentToday = presentToday;
    }

    /**
     * getter for the presentToday boolean
     * @return
     */
    public boolean isPresentToday() {
        return presentToday;
    }

    /**
     * getter for the name string
     * @return
     */
    public String getName() {
        return name.get();
    }

    /**
     * getter for the name string, returns a StringProperty
     * rather than a regular string
     * @return
     */
    public StringProperty nameProperty() {
        return name;
    }

    /**
     * setter for the name string
     * @param name
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * getter for the absentDays integer
     * @return
     */
    public int getAbsentDays() {
        return absentDays.get();
    }

    /**
     * getter for the absentDays integer, returns a IntegerProperty
     * rather than a regular integer
     * @return
     */
    public IntegerProperty absentDaysProperty() {
        return absentDays;
    }

    /**
     * setter for the absentDays integer
     * @param absentDays
     */
    public void setAbsentDays(int absentDays) {
        this.absentDays.set(absentDays);
    }

    /**
     * getter for the id integer
     * @return
     */
    public int getID(){
        return this.id;
    }

}
