package DS.common;

import java.util.ArrayList;

public class User {
    private String ID;
    private String pass;
    private ArrayList<Schedule> schedule = new ArrayList<Schedule>();

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getID() {
        return ID;
    }

    public String getPass() {
        return pass;
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule.add(schedule);
    }
}
