package rmit.Model;

import java.util.Objects;

public class Course  {
    private String cid;
    private String cname;
    private int numofcredits;

    public Course(){}

    public Course(String cid, String cname, int numofcredits) {
        this.cid = cid;
        this.cname = cname;
        this.numofcredits = numofcredits;
    }

    public String getcid() {
        return cid;
    }

    public String getcname() {
        return cname;
    }

    public int getNumofcredits() {
        return numofcredits;
    }

    @Override
    public String toString() {
        return "Course : \n" +
                "               ID of Course : " + cid + '\n' +
                "               Name of Course : '" + cname + '\n' +
                "               Num of credits : " + numofcredits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getNumofcredits() == course.getNumofcredits() &&
                Objects.equals(cid, course.cid) &&
                Objects.equals(cname, course.cname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cid, cname, getNumofcredits());
    }
}
