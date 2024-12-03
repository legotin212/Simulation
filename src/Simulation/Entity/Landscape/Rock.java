package Simulation.Entity.Landscape;

import Simulation.Entity.Coordinates;

public class Rock extends Landscape{
    public Coordinates coordinates;

    @Override
    public String getSprite() {
        return "\uD83D\uDDFF" + " " +" ";

    }

    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
