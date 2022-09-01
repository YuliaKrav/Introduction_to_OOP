package Animals;

import Behavior.MoveAction.Swim;
import Behavior.VoiceAction.BeSilent;

import java.util.List;

public class Fish extends Animal {
    private final String VOICE_SOUND = "... - ...";
    private final int CALLING_STEP_TO_PERSON = 0;
    private final int START_DISTANCE = 8;

    public Fish(String nickname, List<Colors> color, int age) {
        super(nickname, color, age);
        moveBehavior = new Swim(START_DISTANCE, CALLING_STEP_TO_PERSON);
        voiceBehavior = new BeSilent(VOICE_SOUND);
    }
}
