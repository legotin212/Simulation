package Entity.Landscape;

import Entity.Coordinates;
import Entity.Entity;

public abstract class Landscape extends Entity {
    public abstract String getUnicodeSim();
    Coordinates coordinates;
}
