package AttendanceChecker.BLL;

import AttendanceChecker.DAL.MockData;

import java.util.ArrayList;

public class BllClass {
    public ArrayList<String> name1;
    public ArrayList<Integer> totalDays1;
    public ArrayList<Integer> absentDays1;
    public ArrayList<Integer> absentProcent1;
    public ArrayList<String> mostAbsentDay1;
    public BllClass() {
        MockData MoD = new MockData();
        name1= MoD.getName();
        totalDays1 = MoD.getTotalDays();
        absentDays1 = MoD.getAbsentDays();
        absentProcent1 = MoD.getAbsentProcent();
        mostAbsentDay1 = MoD.getMostAbsentDay();
    }

    public ArrayList<String> getName1() {
        return name1;
    }

    public ArrayList<Integer> getTotalDays1() {
        return totalDays1;
    }

    public ArrayList<Integer> getAbsentDays1() {
        return absentDays1;
    }

    public ArrayList<Integer> getAbsentProcent1() {
        return absentProcent1;
    }

    public ArrayList<String> getMostAbsentDay1() {
        return mostAbsentDay1;
    }
}
