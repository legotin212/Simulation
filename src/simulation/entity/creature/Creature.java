package simulation.entity.creature;


import simulation.entity.Coordinates;
import simulation.entity.Entity;

public abstract class Creature extends Entity {
    private Integer speed;
    private Integer hp;

    public abstract void makeMove();
    Coordinates coordinates;
}

