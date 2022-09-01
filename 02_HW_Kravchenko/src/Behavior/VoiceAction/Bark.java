package Behavior.VoiceAction;

public class Bark extends VoiceSound implements VoiceBehavior {
    public Bark(String exactVoiceSound) {
        super(exactVoiceSound);
    }

    @Override
    public void voice() {
        System.out.println("The animal barks " + getExactVoiceSound() + ".");
    }

    @Override
    public void voice(String type, String name) {
        System.out.println("The animal-" + type + " " + name + " barks " + "\"" + getExactVoiceSound() + "\"" + ".");
    }
}
