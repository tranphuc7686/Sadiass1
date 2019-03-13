package rmit.Decorator;

public class Message implements Decorator{
    @Override
    public void himessage(String name) {
        System.out.println("Hi "+name);
    }
}
