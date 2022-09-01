package Behavior.VoiceAction;

public class BeSilent extends VoiceSound implements VoiceBehavior {
    public BeSilent(String exactVoiceSound) {
        super(exactVoiceSound);
    }

    @Override
    public void voice() {
        System.out.println("The animal is silent.");
    }

    @Override
    public void voice(String type, String name) {
        System.out.println("The animal-" + type + " " + name + " is silent " + "\"" + getExactVoiceSound() + "\"" + ".");
    }
}
