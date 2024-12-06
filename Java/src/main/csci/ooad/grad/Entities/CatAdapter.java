package csci.ooad.grad.Entities;

public class CatAdapter extends Cat {
    private final Dog dog;

    public CatAdapter(Dog dog) {
        super(dog.getName());

        this.dog = dog;
    }

    @Override
    public String meow(Entity annoyedAt) {
        return dog.bark() + " at " + annoyedAt.getName();
    }

    @Override
    public String getNoise() {
        return dog.getNoise();
    }

    @Override
    public String getName() {
        return dog.getName();
    }

}