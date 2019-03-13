package rmit.Controller;

import rmit.Model.Student;
import rmit.Observer.Notifier;

public class StudentBuilder {
    private String sid;
    private String sname;
    private String birthdate;
    private Notifier mNotifierList;

    public StudentBuilder setsid(String sid){
        this.sid = sid;
        return this;
    }
    public StudentBuilder setsname(String sname){
        this.sname = sname;
        return this;
    }
    public StudentBuilder setbirthdate(String birthdate){
        this.birthdate = birthdate;
        return this;
        }
    public Student studentbuild(){
        return new Student(sid,sname,birthdate,mNotifierList);
    }


}

