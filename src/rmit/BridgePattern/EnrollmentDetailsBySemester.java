package rmit.BridgePattern;

import rmit.Facade.StudentEnrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentDetailsBySemester implements EnrollmentDetails {
    private ArrayList<StudentEnrollment> studentEnrollments;
    String id;



    public EnrollmentDetailsBySemester(ArrayList<StudentEnrollment> studentEnrollments,String id) {
        this.studentEnrollments = studentEnrollments;
        this.id = id;
    }
    private static List<StudentEnrollment> enrollmentDetailsBysemester(ArrayList<StudentEnrollment> studentEnrollments, String semester) {


        return studentEnrollments.stream()
                .filter(enrollment -> {
                    return enrollment.getSemester().equals(semester);
                })
                .collect(Collectors.toList());


    }
    @Override
    public void printfl() {
        enrollmentDetailsBysemester(this.studentEnrollments,this.id).stream().forEach(e->e.printStudentEnrollment());

    }
}
