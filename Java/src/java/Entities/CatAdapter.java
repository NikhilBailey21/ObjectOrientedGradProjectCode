import Cat;

public class CatAdapter extends Cat {
    private final Dog dog;

    public CatAdapter(Dog dog) {
        super(dog.getName());

        this.dog = dog;
    }

    @Override
    public String meow() {
        return dog.getNoise + " at nobody";
    }

    @Override
    String String getNoise() {
        dog.getNoise()
    }

    @Override
    void setNoise(String noise) {
        dog.setNoise(noise);
    }

    @Override
    String getName() {
        return dog.getName();
    }

}