package Animals;

import Behavior.MoveAction.Run;
import Behavior.VoiceAction.Squeak;

import java.util.List;

public class Rat extends Animal {
    private final String VOICE_SOUND = "Squeak-squeak";
    private final int CALLING_STEP_TO_PERSON = 5;
    private final int START_DISTANCE = 15;

    public Rat(String nickname, List<Colors> color, int age) {
        super(nickname, color, age);
        moveBehavior = new Run(CALLING_STEP_TO_PERSON, START_DISTANCE);
        voiceBehavior = new Squeak(VOICE_SOUND);
    }
}
