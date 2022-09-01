package Animals;

import Behavior.MoveAction.Run;
import Behavior.VoiceAction.Meow;

import java.util.List;

public class Cat extends Animal {
    private final String VOICE_SOUND = "Meow - meow";
    private final int CALLING_STEP_TO_PERSON = 2;
    private final int START_DISTANCE = 10;

    public Cat(String nickname, List<Colors> color, int age) {
        super(nickname, color, age);
        moveBehavior = new Run(START_DISTANCE, CALLING_STEP_TO_PERSON);
        voiceBehavior = new Meow(VOICE_SOUND);
    }

}
