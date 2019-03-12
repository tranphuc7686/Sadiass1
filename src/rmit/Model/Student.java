package rmit.Model;

import java.util.Objects;



public class Student extends StudentEnrollment {
    private String sid;
    private String sname;
    private String birthdate;

    public Student(){}



    public Student(String id, String name, String birthdate) {
        this.sid = id;
        this.sname = name;
        this.birthdate = birthdate;
    }

    public String getsId() {
        return sid;
    }

    public String getsName() {
        return sname;
    }


    public String getBirthdate() {
        return birthdate;
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
        return getBirthdate() == student.getBirthdate() &&
                Objects.equals(sid, student.sid) &&
                Objects.equals(sname, student.sname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sid, sname, getBirthdate());
    }


}
