package rmit.Command;

public class LightOffCommand implements Command{
    //reference to the light
    Mess light;
    public LightOffCommand(Mess light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.sayComeback();
    }
}