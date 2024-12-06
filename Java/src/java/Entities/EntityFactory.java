public class EntityFactory {

    private List<String> catNames = List.of("Sally", "Kitty", "Raider", "Rosie");
    private List<String> dogNames = List.of("Rover", "Rex", "Spot", "Fido");
    private List<String> peopleNames = List.of("John", "Adam", "Emily", "Anna");

    public Entity createCat(String name) {
        return new Cat(getRandomName(catNames));
    }

    public Entity createDog(String name) {
        return new Dog(getRandomName(dogNames));
    }

    public Entity createDisguisedDog() {
        return new CatAdapter(new Dog(getRandomName(dogNames)));
    }

    public CanAdmire createPerson() {
        return new Person(getRandomName(peopleNames));
    }

    private getRandomName(List<String> options) {
        return options.get(new Random().nextInt(options.size()))
    }
}