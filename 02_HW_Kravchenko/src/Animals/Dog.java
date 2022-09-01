package Animals;

import Behavior.MoveAction.Run;
import Behavior.VoiceAction.Bark;

import java.util.List;

public class Dog extends Animal {
    private final String VOICE_SOUND = "Woof-woof";
    private final int CALLING_STEP_TO_PERSON = 4;
    private final int START_DISTANCE = 10;

    public Dog(String nickname, List<Colors> color, int age) {
        super(nickname, color, age);
        moveBehavior = new Run(START_DISTANCE, CALLING_STEP_TO_PERSON);
        voiceBehavior = new Bark(VOICE_SOUND);
    }
}
