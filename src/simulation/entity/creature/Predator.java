package simulation.entity.creature;

import simulation.entity.Coordinates;
import simulation.map.PathFinder;
import simulation.map.WorldMap;

import java.util.List;

public class Predator extends Creature {
    private WorldMap worldMap;
    private PathFinder pathFinder;
    private int attack;
    private Coordinates coordinates;

    public Predator(int speed, int hp, Coordinates coordinates,  WorldMap worldMap, PathFinder pathFinder,int attack) {
        super(speed, hp, coordinates);
        this.worldMap = worldMap;
        this.pathFinder = pathFinder;
        this.attack = attack;
    }

    @Override
    public void makeMove() {
        for(int i = 0; i<getSpeed(); i++){
        List<Coordinates> path = pathFinder.findPathToNearestTarget(getCoordinates(),Herbivore.class,worldMap);
        if(!path.isEmpty()) {
            Coordinates next = path.get(1);
            if (pathFinder.checkIfTarget(next, Herbivore.class, worldMap)) {
                System.out.println("attack");
                attack(next);
            } else {
                worldMap.removeEntity(getCoordinates());
                worldMap.setEntity(this, next);
                setCoordinates(next);
            }
        }
        }
    }

    public void attack(Coordinates next) {
        Herbivore herbivore = (Herbivore) worldMap.getEntity(next);
        int herbHP = herbivore.getDamage(this.getAttack());
        if(herbHP <= 0) {
            worldMap.removeEntity(next);
            setSpeed(getSpeed()+1);
            System.out.println("Predator ate herbivore and increased it's speed to " + getSpeed());
        }
    }
    public int getAttack() {
        return attack;
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public int getSpeed() {
        return super.getSpeed();
    }

    @Override
    public Coordinates getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setSpeed(int speed) {
        super.setSpeed(speed);
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        super.setCoordinates(coordinates);
    }
}
