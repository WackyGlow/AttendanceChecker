package AttendanceChecker.DAL;

import java.util.ArrayList;

public class MockData {
    public ArrayList<String> name;
    public ArrayList<Integer> totalDays;
    public ArrayList<Integer> absentDays;
    public ArrayList<Integer> absentProcent;
    public ArrayList<String> mostAbsentDay;
    public MockData() {
        name.add("Lars");
        name.add("Kim");
        name.add("Bo");
        totalDays.add(100);
        totalDays.add(100);
        totalDays.add(100);
        absentDays.add(0);
        absentDays.add(50);
        absentDays.add(100);
        absentProcent.add(0);
        absentProcent.add(50);
        absentProcent.add(100);
        mostAbsentDay.add("Monday");
        mostAbsentDay.add("Friday");
        mostAbsentDay.add("Tuesday");
    }

    public ArrayList<String> getName() {
        return name;
    }

    public ArrayList<Integer> getTotalDays() {
        return totalDays;
    }

    public ArrayList<Integer> getAbsentDays() {
        return absentDays;
    }

    public ArrayList<Integer> getAbsentProcent() {
        return absentProcent;
    }

    public ArrayList<String> getMostAbsentDay() {
        return mostAbsentDay;
    }
}
