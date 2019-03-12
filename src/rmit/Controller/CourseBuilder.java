package rmit.Controller;
import rmit.Model.Course;

public class CourseBuilder {
    private String cid;
    private String cname;
    private int numofcredit;

    public CourseBuilder setcid(String cid){
        this.cid = cid;
        return this;
    }

    public CourseBuilder setcname (String cname){
        this.cname = cname;
        return this;
    }

    public CourseBuilder setnumofcredit(int numofcredit){
        this.numofcredit = numofcredit;
        return this;
    }
    public Course coursebuild(){
        return new Course(cid,cname,numofcredit);

    }
}
