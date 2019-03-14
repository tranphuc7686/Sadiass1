package rmit.Command;

public class LightOnCommand  implements Command{
    //reference to the light
    Mess light;
    public LightOnCommand(Mess light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.sayBye();
    }
}
