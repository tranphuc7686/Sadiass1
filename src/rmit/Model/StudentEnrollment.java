package rmit.Model;
import java.util.List;
import java.util.ArrayList;

import rmit.Controller.StudentEnrollmentManager;

public class StudentEnrollment implements StudentEnrollmentManager {
    private String idErollment;
    private Course mCourse ;
    private Student mStudent;

    public String getIdErollment() {
        return idErollment;
    }

    public void setIdErollment(String idErollment) {
        this.idErollment = idErollment;
    }

    public StudentEnrollment(Course mCourse, Student mStudent, String idErollment) {
        this.mCourse = mCourse;
        this.mStudent = mStudent;
        this.idErollment =  idErollment;
    }
    public StudentEnrollment() {

    }
    public Course getmCourse() {
        return mCourse;
    }

    public void setmCourse(Course mCourse) {
        this.mCourse = mCourse;
    }

    public Student getmStudent() {
        return mStudent;
    }

    public void setmStudent(Student mStudent) {
        this.mStudent = mStudent;
    }


    @Override
    public void printStudentEnrollment(StudentEnrollment s) {
        System.out.println(s.toString());
    }


}
