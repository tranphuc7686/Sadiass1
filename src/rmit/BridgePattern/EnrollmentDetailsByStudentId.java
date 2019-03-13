package rmit.BridgePattern;

import rmit.Facade.StudentEnrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentDetailsByStudentId implements EnrollmentDetails {
    private ArrayList<StudentEnrollment> studentEnrollments;

    public EnrollmentDetailsByStudentId(ArrayList<StudentEnrollment> studentEnrollments,String id) {
        this.studentEnrollments = studentEnrollments;
        this.id = id;
    }
    String id;


    public void settingDisplayStudent( EnrollmentDetails mEnrollmentDetails) {
        mEnrollmentDetails.printfl(id);
    }
    private static List<StudentEnrollment> enrollmentDetails(ArrayList<StudentEnrollment> studentEnrollments, String idSinhVien) {
        return studentEnrollments.stream()
                .filter(enrollment -> {
                    return enrollment.getmStudentList().stream().anyMatch(e -> e.getSid().equals(idSinhVien));
                })
                .collect(Collectors.toList());
    }

    @Override
    public void printfl(String id) {
        enrollmentDetails(this.studentEnrollments,id).stream().forEach(e->e.printStudentEnrollment());
    }
}
