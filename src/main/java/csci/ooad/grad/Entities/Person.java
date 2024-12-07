package csci.ooad.grad.Entities;

public class Person extends Entity implements CanAdmire {

    public Person(String name) {
        super(name);

        setNoise("Wow, that's so beautiful");
    }

    public String admire(Entity admiring) {
        return getNoise() + " at " + admiring.getName();
    }
}