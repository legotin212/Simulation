package Entity.Creature;

import Entity.Coordinates;

public class Predator extends Creature {
    int speed;
    int hp;

    public Coordinates coordinates;
    public Predator(int speed, int hp, Coordinates coordinates) {
        this.speed = speed;
        this.hp = hp;
        this.coordinates = coordinates;
    }
    public void moveUp(){
        coordinates = new Coordinates(9, 9);

    }

    @Override
    public String getUnicodeSim() {
        return "︿";
    }
}
