package Simulation.Entity.Landscape;

import Simulation.Entity.Coordinates;

public class Tree extends Landscape{
    public Coordinates coordinates;

    @Override
    public String getSprite() {
        return "\uD83C\uDF33" + " ";
    }

    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
