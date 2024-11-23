package Entity.Creature;


import Entity.Coordinates;
import Entity.Entity;

public abstract class Creature extends Entity {
    public abstract String getUnicodeSim();
    int speed;
    int hp;
    int makeMove;
    Coordinates coordinates;


}

