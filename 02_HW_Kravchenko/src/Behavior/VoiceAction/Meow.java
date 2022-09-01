package Behavior.VoiceAction;

public class Meow extends VoiceSound implements VoiceBehavior {
    public Meow(String exactVoiceSound) {
        super(exactVoiceSound);
    }

    @Override
    public void voice() {
        System.out.println("The animal meows " + getExactVoiceSound() + ".");
    }

    @Override
    public void voice(String type, String name) {
        System.out.println("The animal-" + type + " " + name + " meows " + "\"" + getExactVoiceSound() + "\"" + ".");
    }
}
