package rmit.Singleton;

public class MenuSingleton {
    private static MenuSingleton instance = new MenuSingleton();

    private MenuSingleton(){

    }
    public static MenuSingleton getInstance(){
        return instance;
    }

    public void begin() {
        System.out.println("Welcome To Student Enroll Management System");



    }
}
