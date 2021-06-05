package DS.common;
public class Schedule {
    private String time;
    private String site;
    private String event;
    public void setTime(String t) { time = time; }
    public void setSite(String s) { site = s; }
    public void setEvent(String e) { event = e; }
    public String getTime() { return time; }
    public String getSite() { return site; }
    public String getEvent() { return event; }
}
public class User {
    private String ID;
    private String pass;
    private Schedule schedule;

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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
