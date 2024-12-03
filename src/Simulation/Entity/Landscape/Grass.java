package Simulation.Entity.Landscape;

import Simulation.Entity.Coordinates;

public class Grass extends Landscape {


    @Override
    public String getSprite() {
        return "\uD83C\uDF40";
    }

    public Coordinates coordinates;
    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
