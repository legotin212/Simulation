package Entity.Landscape;

import Entity.Coordinates;

public class Tree extends Landscape{
    public Coordinates coordinates;
    public String getUnicodeSim() {
        return "︿";
    }
    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
