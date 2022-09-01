package Animals;

import Behavior.MoveAction.MoveBehavior;
import Behavior.VoiceAction.VoiceBehavior;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Animal {
    MoveBehavior moveBehavior;
    VoiceBehavior voiceBehavior;

    private final String nickname;
    private final List<Colors> color;
    private final int age;

    public Animal(String nickname, List<Colors> color, int age) {
        this.nickname = nickname;
        this.color = color;
        this.age = age;
    }

    public void performMove(int times) {
        moveBehavior.move(getAnimalType(), getNickname(), times);
    }

    private String getAnimalType() {
        String animalType = this.getClass().getTypeName().toLowerCase();
        return animalType.contains(".") ?
                animalType.substring(animalType.lastIndexOf(".") + 1) :
                animalType;
    }

    public void performVoice() {
        voiceBehavior.voice(getAnimalType(), getNickname());
    }

    public String getNickname() {
        return nickname;
    }

    public List<Colors> getColor() {
        return color;
    }

    public String getColorString() {
        return color.stream().map(Colors::toString).collect(Collectors.joining("-"));
    }

    public int getAge() {
        return age;
    }

    public void getFullDescription() {
        String description = "Type: " + this.getClass().getName() + "\n" +
                "Name: " + this.nickname + "\n" +
                "Color: " + this.getColorString() + "\n" +
                "Age: " + this.age + "\n";

        System.out.println(description);
    }
}
