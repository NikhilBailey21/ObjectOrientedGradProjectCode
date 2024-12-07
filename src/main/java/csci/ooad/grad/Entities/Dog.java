package csci.ooad.grad.Entities;

public class Dog extends Entity implements CanBark {

    public Dog(String name) {
        super(name);

        setNoise("BARK");
    }

    public String bark() {
        return getNoise();
    }
}