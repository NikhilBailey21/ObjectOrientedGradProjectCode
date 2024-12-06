public Exhibit() {

    private List<CanAdmire> patrons;
    private List<Entity> enclosure;

    public Exhibit() {
        patrons = new ArrayList<>;
        enclosure = new ArrayList<>();
    }

    public List<String> getEnclosureNoises() {

        List<String> noises = new ArrayList<String>();

        for (Entity entity : enclosure) {
            if (entity instanceof canBark) noises.add(((CanBark) entity).bark())
            if (entity instanceof canMeow) noises.add(((CanBark) entity).meow(getRandomExhibitEnity()))
            if (entity instanceof canAdmire) noises.add(((CanBark) entity).admire(getRandomExhibitEnity()))
        }

        return noises;
    }

    public List<String> getPatronNoises() {

        List<String> noises = new ArrayList<String>();

        for (Patron patron : patrons) {
            noises.add(patron.admire(getRandomExhibitEntity()))
        }

        return noises;
    }

    public void addEnclosedEnity(Entity entity) {
        enclosure.add(entity);
    }

    public void enter(CanAdmire patron) {
        patrons.add(patron);
    }

    public void exit(CanAdmire patron) {
        patrons.remove(patron);
    }
}