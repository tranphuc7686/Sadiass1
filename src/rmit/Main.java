package rmit;

import rmit.BridgePattern.EnrollmentDetails;
import rmit.BridgePattern.EnrollmentDetailsBySemester;
import rmit.BridgePattern.EnrollmentDetailsByStudentId;
import rmit.Controller.CourseBuilder;
import rmit.Controller.StudentBuilder;
import rmit.Decorator.Decorator;
import rmit.Decorator.Message;
import rmit.Decorator.NewMessage;
import rmit.Model.Course;
import rmit.Model.Student;
import rmit.Facade.StudentEnrollment;
import rmit.Proxy.Banner;
import rmit.Proxy.ProxyBanner;
import rmit.Singleton.MyTask;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Banner banner = new ProxyBanner();//Proxy
        banner.show();//Proxy
        ArrayList<Student> arrayListStudent = new ArrayList<Student>();
        StudentBuilder studentBuilder = new StudentBuilder(); //Builder - add example
        Student student1 = studentBuilder.setsid("1").setsname("Tu Nguyen").setbirthdate("1997").studentbuild(); //Builder
        Student student2 = studentBuilder.setsid("2").setsname("Lan Tran").setbirthdate("1997").studentbuild(); //Builder
        Student student3 = studentBuilder.setsid("3").setsname("Le Van Dung").setbirthdate("1997").studentbuild(); //Builder
        arrayListStudent.add(student1);
        arrayListStudent.add(student2);
        arrayListStudent.add(student3);
        /*---*/

        ArrayList<Course> courseArrayList = new ArrayList<Course>();
        CourseBuilder courseBuilder = new CourseBuilder(); //Builder - add example
        Course course1 = courseBuilder.setcid("1").setcname("Programming1").setnumofcredit(12).coursebuild();
        Course course2 = courseBuilder.setcid("2").setcname("SADI").setnumofcredit(12).coursebuild();
        Course course3 = courseBuilder.setcid("3").setcname("Web Programming").setnumofcredit(12).coursebuild();
        courseArrayList.add(course1);
        courseArrayList.add(course2);
        courseArrayList.add(course3);
        /*----*/

        MyTask menuSingleton = MyTask.getInstance(); //singleton
        menuSingleton.run();  // Singleton
        ArrayList<StudentEnrollment> studentEnrollmentArrayList = new ArrayList<>();

        while (true) {
            String[] general_array = {"--------------------------------","|     Enrollment Menu          |", "--------------------------------", "Please enter your choice (1 - 5)",
                    "1 - Add new enrollment", "2 - Update enrollment", "3 - Delete enrollment", "4 - View the list", "5 - Print enrollment details for each student", "6 - Print enrollment for all students for 1 semester. ", "7 - Exit"};  //Menu
            for (String aGeneral_array : general_array) {
                System.out.println(aGeneral_array);
            }
            int choice = 0;
            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        StudentEnrollment studentEnrollment = new StudentEnrollment();
                        System.out.println("Please enter the id of student that you want to enroll: ");
                        String idStudent = String.valueOf(scanner.nextInt());

                        System.out.println("Please enter the id of Course that you want to enroll: ");
                        String idCourse = String.valueOf(scanner.nextInt());
                        System.out.println("Enter the semester: 1.2018A |2.2018B |3.2018C");
                        String semester = randomId(scanner.nextInt());
                        studentEnrollment.getmStudentList().add(arrayListStudent.stream()
                                .filter(e -> e.getSid().equals(idStudent))
                                .findFirst().get()
                        );
                        studentEnrollment.getmCourseList().add(courseArrayList.stream()
                                .filter(e -> e.getcid().equals(idCourse))
                                .findFirst().get()
                        );
                        studentEnrollment.setIdErollment(randomId(studentEnrollmentArrayList) + "");
                        studentEnrollment.setSemester(semester);

                        studentEnrollmentArrayList.add(studentEnrollment);
                        studentEnrollmentArrayList.stream().forEach(e -> {
                            e.printStudentEnrollment();
                        });
                        System.out.println("Done !");
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Please enter the id of enrollment that you want to update");
                        String idEnrollment = String.valueOf(scanner.nextInt());
                        Optional<StudentEnrollment> studentEnrollment1 = studentEnrollmentArrayList
                                .stream()
                                .filter(e -> e.getIdErollment().equals(idEnrollment))
                                .findFirst();
                        if(!studentEnrollment1.isPresent()){
                            System.out.println("Invalid Input. Please try again");
                            break;
                        }
                        System.out.println("Please enter the id of student that you want to enroll: ");
                        String idStudent1 = String.valueOf(scanner.nextInt());
                        System.out.println("Please enter the id of Course that you want to enroll: ");
                        String idCourse1 = String.valueOf(scanner.nextInt());
                        studentEnrollment1.get().getmStudentList().add(arrayListStudent.stream()
                                .filter(e -> e.getSid().equals(idStudent1))
                                .findFirst().get()
                        );
                        studentEnrollment1.get().getmCourseList().add(courseArrayList.stream()
                                .filter(e -> e.getcid().equals(idCourse1))
                                .findFirst().get()
                        );
                        System.out.println("Done !");


                        break;
                    }

                    case 3:
                        System.out.println("Please enter the id of enrollment that you want to delete");
                        String idEnrollment = String.valueOf(scanner.nextInt());
                        Optional<StudentEnrollment> studentEnrollment1 = studentEnrollmentArrayList
                                .stream()
                                .filter(e -> e.getIdErollment().equals(idEnrollment))
                                .findFirst();
                        if(!studentEnrollment1.isPresent()){
                            System.out.println("Invalid Input. Please try again");
                            break;
                        }
                        studentEnrollmentArrayList.remove(studentEnrollment1.get());
                        System.out.println("Done !");

                        break;
                    case 4:
                        if (studentEnrollmentArrayList.size() > 1 || studentEnrollmentArrayList.size() == 1) {
                            System.out.println("The List Of Enrollment");
                            studentEnrollmentArrayList.stream().forEach(e -> {
                                e.printStudentEnrollment();
                            });
                        } else {
                            System.out.println("The List Of Enrollment is empty !!");
                        }

                        break;
                    case 5: {
                        System.out.println("Please enter the id of student that you want to find: ");
                        String idStudent1 = String.valueOf(scanner.nextInt());
                        EnrollmentDetails enrollmentDetailsByStudentId = new EnrollmentDetailsByStudentId(studentEnrollmentArrayList,idStudent1);
                        enrollmentDetailsByStudentId.printfl();
                        break;
                    }
                    case 6: {
                        System.out.println("Please enter the semester of student that you want to find: ");
                        System.out.println("Enter the semester: 1.2018A |2.2018B |3.2018C");
                        String semester = randomId(scanner.nextInt());
                        EnrollmentDetails enrollmentDetailsByStudentId =new EnrollmentDetailsBySemester(studentEnrollmentArrayList,semester);
                        enrollmentDetailsByStudentId.printfl();
                        break;
                    }
                    case 7:
                        System.out.println("Good Bye");
                        Decorator newmessage = new NewMessage(new Message()); //Singleton
                        newmessage.himessage("You !");
                        return;
                    default:
                        System.out.println("Invalid Input. Please try again");
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Invalid Input. Please try again");
            }
        }







    }

    private static int randomId(ArrayList<StudentEnrollment> studentEnrollments) {
        while (true) {
            Random ran = new Random();
            int x = ran.nextInt(6) + 5;
            if (!studentEnrollments
                    .stream()
                    .filter(e -> e.getIdErollment().equals(x + ""))
                    .findFirst().isPresent()) {
                return x;

            }
        }
    }





    private static String randomId(int index) {
        switch (index) {
            case 1:
                return "2018A";
            case 2:
                return "2018B";
            case 3:
                return "2018C";

        }
        return "Invalid Input. Please try again";

    }
}
