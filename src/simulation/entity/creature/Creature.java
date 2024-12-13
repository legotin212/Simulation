package simulation.entity.creature;


import simulation.entity.Coordinates;
import simulation.entity.Entity;

public abstract class Creature extends Entity {
    private int speed;
    private int hp;
    private Coordinates coordinates;

    public Creature(int speed, int hp, Coordinates coordinates) {
        this.speed = speed;
        this.hp = hp;
        this.coordinates = coordinates;
    }

    public abstract void    makeMove();

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}

