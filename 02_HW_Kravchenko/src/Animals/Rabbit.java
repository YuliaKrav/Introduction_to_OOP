package Animals;

import Behavior.MoveAction.Hop;
import Behavior.VoiceAction.Squeak;

import java.util.List;

public class Rabbit extends Animal {
    private final String VOICE_SOUND = "Thumpety-thump";
    private final int CALLING_STEP_TO_PERSON = -1;
    private final int START_DISTANCE = 10;

    public Rabbit(String nickname, List<Colors> color, int age) {
        super(nickname, color, age);
        moveBehavior = new Hop(START_DISTANCE, CALLING_STEP_TO_PERSON);
        voiceBehavior = new Squeak(VOICE_SOUND);
    }

}
