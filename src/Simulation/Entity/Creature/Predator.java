package Simulation.Entity.Creature;

import Simulation.Entity.Coordinates;
import Simulation.Map.WorldMap;

public class Predator extends Creature {
    private Integer speed;
    private Integer hp;
    private WorldMap worldMap;
    private PathFinder pathFinder;

    public Coordinates coordinates;

    public Predator(WorldMap worldMap, PathFinder pathFinder, Coordinates coordinates) {
        this.worldMap = worldMap;
        this.pathFinder = pathFinder;
        this.coordinates = coordinates;
        this.speed = 1;
        this.hp = 1;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }



    @Override
    public String getSprite() {
        return "\uD83D\uDC3A";
    }

    @Override
    public void makeMove() {
        if (pathFinder.findPathToNearestTarget(coordinates, Herbivore.class.getName()).isPresent()) {
            Coordinates next = pathFinder.findPathToNearestTarget(coordinates,Herbivore.class.getName()).get().get(1);
            worldMap.removeEntity(coordinates);
            worldMap.setEntity(this, next);
            coordinates = next;
        }
    }
}
