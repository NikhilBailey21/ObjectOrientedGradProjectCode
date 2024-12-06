package csci.ooad.grad;

import csci.ooad.grad.Entities.CanAdmire;
import csci.ooad.grad.Entities.CanBark;
import csci.ooad.grad.Entities.CanMeow;
import csci.ooad.grad.Entities.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exhibit {

    private final List<CanAdmire> patrons;
    private final List<Entity> enclosure;

    public Exhibit() {
        patrons = new ArrayList<>();
        enclosure = new ArrayList<>();
    }

    public List<String> getEnclosureNoises() {

        List<String> noises = new ArrayList<>();

        for (Entity entity : enclosure) {

            String noise = "";

            if (entity instanceof CanBark) noise = ((CanBark) entity).bark();
            if (entity instanceof CanMeow) noise = ((CanMeow) entity).meow(getRandomEnclosureEntity());
            if (entity instanceof CanAdmire) noise = ((CanAdmire) entity).admire(getRandomEnclosureEntity());

            EventBus.getInstance().post(EventType.EnclosureNoise, entity.getName() + " said " + noise);
        }

        return noises;
    }

    public List<String> getPatronNoises() {

        List<String> noises = new ArrayList<String>();

        for (CanAdmire patron : patrons) {
            noises.add(patron.admire(getRandomEnclosureEntity()));
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

    private Entity getRandomEnclosureEntity() {
        return enclosure.get(new Random().nextInt(enclosure.size()));
    }
}