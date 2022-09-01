package Behavior.VoiceAction;

public class Squeak extends VoiceSound implements VoiceBehavior {

    public Squeak(String exactVoiceSound) {
        super(exactVoiceSound);
    }

    @Override
    public void voice() {
        System.out.println("The animal squeks " + getExactVoiceSound() + ".");
    }

    public void voice(String type, String name) {
        System.out.println("The animal-" + type + " " + name + " squeks " + "\"" + getExactVoiceSound() + "\"" + ".");
    }
}
