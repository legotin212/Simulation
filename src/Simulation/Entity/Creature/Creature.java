package Simulation.Entity.Creature;


import Simulation.Entity.Coordinates;
import Simulation.Entity.Entity;

public abstract class Creature extends Entity {
    int speed;
    int hp;
    public abstract void makeMove();
    Coordinates coordinates;
}

