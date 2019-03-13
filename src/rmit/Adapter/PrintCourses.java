package rmit.Adapter;


import rmit.Model.Course;

import java.util.ArrayList;
import java.util.Iterator;

public class PrintCourses implements PrintEmrollments {

    @Override
    public void print(ArrayList<Object> s) {

        s.stream().forEach(e ->{
            if (e instanceof Course) {

                Course cprint = (Course) e;
                System.out.println("ID:" +cprint.getcid()+ " " + cprint.getcname() + " " + "Credit:"+ cprint.getNumofcredits()+"");
            }
        });

    }
}
