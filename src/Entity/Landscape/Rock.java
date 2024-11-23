package Entity.Landscape;

import Entity.Coordinates;

public class Rock extends Landscape{
    public Coordinates coordinates;
    public String getUnicodeSim() {
        return "￭";
    }
    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
