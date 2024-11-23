package Entity.Creature;

import Entity.Coordinates;

public class Herbivore extends Creature{
    public Coordinates coordinates;
    @Override
    public String getUnicodeSim() {
        return "f" ;
    }

    public Herbivore(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
