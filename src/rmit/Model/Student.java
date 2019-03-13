package rmit.Model;

import rmit.Observer.Notifier;

import java.util.Objects;



public class Student  {
    private String sid;
    private String sname;
    private String birthdate;
    private Notifier mNotifierList;

    public Student(String sid, String sname, String birthdate, Notifier mNotifierList) {
        this.sid = sid;
        this.sname = sname;
        this.birthdate = birthdate;
        this.mNotifierList = mNotifierList;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Notifier getmNotifierList() {
        return mNotifierList;
    }

    public void setmNotifierList(Notifier mNotifierList) {
        this.mNotifierList = mNotifierList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + sid + '\'' +
                ", name='" + sname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getBirthdate().equals(student.getBirthdate()) &&
                Objects.equals(sid, student.sid) &&
                Objects.equals(sname, student.sname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sid, sname, getBirthdate());
    }



}
