package rmit.Adapter;


import rmit.Model.Student;

import java.util.ArrayList;

public class PrintStudents implements PrintEmrollments {
    @Override
    public void print(ArrayList<Object> s) {
        s.stream().forEach(e -> {
            if (e instanceof Student) {
                Student stprint = (Student) e;
                System.out.println(" Name:" + stprint.getSname() + " " + stprint.getSid() + " " + stprint.getBirthdate());

            }
        });


    }
}
