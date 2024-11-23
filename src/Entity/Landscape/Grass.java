package Entity.Landscape;

import Entity.Coordinates;

public class Grass extends Landscape {


    public String getUnicodeSim() {
        return "︿";
    }

    public Coordinates coordinates;
    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
