public abstract class Entity {

    private final String name;
    private String noise;

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNoise() {
        return noise;
    }

    private void setNoise(String noise) {
        this.noise = noise;
    }
}