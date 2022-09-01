package Behavior.VoiceAction;

public abstract class VoiceSound {
    private final String exactVoiceSound;

    public VoiceSound(String exactVoiceSound) {
        this.exactVoiceSound = exactVoiceSound;
    }

    public String getExactVoiceSound() {
        return exactVoiceSound;
    }
}
