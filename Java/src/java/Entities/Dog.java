import Entity;

public class Dog extends Entity implements CanBark {

    public Dog(String name) {
        super(name);

        setNoise("BARK");
    }

    public void bark() {
        return getNoise();
    }
}