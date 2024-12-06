import Entity;

public class Cat extends Entity implements CanMeow {

    public Cat(String name) {
        super(name);

        setNoise("meow");
    }

    public String meow(Entity annoyedAt) {
        return getNoise() + " to " + annoyedAt;
    }

}