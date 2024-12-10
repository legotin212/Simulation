package Simulation.Entity.Creature;


import Simulation.Entity.Coordinates;
import Simulation.Entity.Entity;

public abstract class Creature extends Entity {
    private Integer speed;
    private Integer hp;

    public abstract void makeMove();
    Coordinates coordinates;
}

