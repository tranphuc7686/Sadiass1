package rmit.Facade;
import java.util.List;
import java.util.ArrayList;

import rmit.Controller.StudentEnrollmentManager;
import rmit.Model.Course;
import rmit.Model.Student;

public class StudentEnrollment implements StudentEnrollmentManager {
    private String idErollment;
    private List<Course> mCourseList ;
    private List<Student> mStudentList;
    private String semester ;

    public StudentEnrollment() {
        this.mCourseList = new ArrayList<>();
        this.mStudentList = new ArrayList<>();
    }

    public StudentEnrollment(String idErollment, List<Course> mCourseList, List<Student> mStudentList) {
        this.idErollment = idErollment;
        this.mCourseList = mCourseList;
        this.mStudentList = mStudentList;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getIdErollment() {
        return idErollment;
    }

    public void setIdErollment(String idErollment) {
        this.idErollment = idErollment;
    }

    public List<Course> getmCourseList() {
        return mCourseList;
    }

    public void setmCourseList(List<Course> mCourseList) {
        this.mCourseList = mCourseList;
    }

    public List<Student> getmStudentList() {
        return mStudentList;
    }

    public void setmStudentList(List<Student> mStudentList) {
        this.mStudentList = mStudentList;
    }

    @Override
    public void printStudentEnrollment() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "StudentEnrollment : \n" +
                "           ID Erollment: " + idErollment + '\n' +
                "           Semester: " + semester + '\n' +
                "           Courses: " + mCourseList +'\n' +
                "           Students: " + mStudentList ;
    }
}
