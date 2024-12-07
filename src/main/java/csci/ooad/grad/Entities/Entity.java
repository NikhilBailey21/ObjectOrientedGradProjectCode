package csci.ooad.grad.Entities;

public abstract class Entity {

    private final String name;
    protected String noise;

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNoise() {
        return noise;
    }

    void setNoise(String noise) {
        this.noise = noise;
    }
}