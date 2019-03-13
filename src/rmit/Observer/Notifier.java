package rmit.Observer;

import rmit.Facade.StudentEnrollment;

public class Notifier {
    private String name;
    private String email;


    public Notifier(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
