package rmit;

import rmit.Model.Course;
import rmit.Singleton.MenuSingleton;
import rmit.Model.Student;
import rmit.Controller.StudentBuilder;
import rmit.Controller.CourseBuilder;
import rmit.Model.StudentEnrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
//        ArrayList<Student> arrayListStudent = new ArrayList<Student>();
//        StudentBuilder studentBuilder = new StudentBuilder(); //Builder - add example
//        Student student1 = studentBuilder.setsid("1").setsname("Tu Nguyen").setbirthdate(1997).studentbuild(); //Builder
//        Student student2 = studentBuilder.setsid("2").setsname("Lan Tran").setbirthdate(1997).studentbuild(); //Builder
//        Student student3 = studentBuilder.setsid("3").setsname("Le Van Dung").setbirthdate(1996).studentbuild(); //Builder
//        arrayListStudent.add(student1);
//        arrayListStudent.add(student2);
//        arrayListStudent.add(student3);
//        /*---*/
//
//        ArrayList<Course> courseArrayList = new ArrayList<Course>();
//        CourseBuilder courseBuilder = new CourseBuilder(); //Builder - add example
//        Course course1 = courseBuilder.setcid("1").setcname("Programming1").setnumofcredit(12).coursebuild();
//        Course course2 = courseBuilder.setcid("2").setcname("SADI").setnumofcredit(12).coursebuild();
//        Course course3 = courseBuilder.setcid("3").setcname("Web Programming").setnumofcredit(12).coursebuild();
//        courseArrayList.add(course1);
//        courseArrayList.add(course2);
//        courseArrayList.add(course3);
//        /*----*/
//
//         MenuSingleton menuSingleton = MenuSingleton.getInstance(); //singleton
//        menuSingleton.begin();  // Singleton
        ArrayList<StudentEnrollment> studentEnrollmentArrayList = new ArrayList<>();

        while (true) {
            String[] general_array = {"--------------------------------","|     Enrollment Menu          |", "--------------------------------", "Please enter your choice (1 - 5)",
                    "1 - Add new enrollment", "2 - Update enrollment","3 - Delete enrollment", "4 - View the list", "5 - Exit"};  //Menu
            for (String aGeneral_array : general_array) {
                System.out.println(aGeneral_array);
            }
            int choice = 0;
            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:

                        System.out.println("Please enter the Student");
                        System.out.println("Please enter the Name of Student");
                        String name = scanner.nextLine();
                        System.out.println("Please enter the Birthdate of Student");
                        String birthDate = scanner.nextLine();
                        /*---*/
                        System.out.println("Please enter the Course");
                        System.out.println("Please enter the Name of Course");
                        String cname = scanner.nextLine();
                        System.out.println("Please enter the Birthdate of Student");
                        int numofcredits = scanner.nextInt();
                        studentEnrollmentArrayList.add(new StudentEnrollment(new Course(UUID.randomUUID().toString(),cname,numofcredits),
                                new Student(UUID.randomUUID().toString(),name,birthDate),
                                UUID.randomUUID().toString()
                        ));
                        break;
                    case 2:
                    {
                        studentEnrollmentArrayList.forEach(e -> e.printStudentEnrollment(e));
                        System.out.println("Please enter the id of enrollment that you want to update");
                        String id  = scanner.nextLine();

                        System.out.println("Please enter the Student");
                        System.out.println("Please enter the Name of Student");
                        String name1 = scanner.nextLine();
                        System.out.println("Please enter the Birthdate of Student");
                        String birthDate1 = scanner.nextLine();
                        /*---*/
                        System.out.println("Please enter the Course");
                        System.out.println("Please enter the Name of Course");
                        String cname1 = scanner.nextLine();
                        System.out.println("Please enter the Birthdate of Student");
                        int numofcredits1 = scanner.nextInt();

                        StudentEnrollment mStudentEnrollment =  studentEnrollmentArrayList.stream().filter(e -> e.getIdErollment().equals(id)).findFirst().get();
                        mStudentEnrollment.setmStudent(new Student(mStudentEnrollment.getmStudent().getsId(),name1,birthDate1));
                        mStudentEnrollment.setmCourse(new Course(mStudentEnrollment.getmCourse().getcid(),cname1,numofcredits1));
                        break;
                    }

                    case 3:
                        System.out.println("Please enter the id of enrollment that you want to delete");
                        break;
                    case 4:
                        System.out.println("The List Of Enrollment");
                        StudentEnrollment studentEnrollment1 = new StudentEnrollment();
                        List<Student> studentList1 = studentEnrollment1.getStudentList();
                        System.out.println(studentList1);
                        break;
                    case 5:
                        System.out.println("Good Bye");
                        System.out.println("Have a nice day");
                        return;
                    default:
                        System.out.println("Invalid Input. Please try again");
                }
            }
            catch(Exception ex){
                System.out.println("Invalid Input. Please try again");
            }
        }







    }
}
