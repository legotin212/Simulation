package Simulation.Entity.Creature;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Landscape.Grass;
import Simulation.Map.WorldMap;

public class Herbivore extends Creature{
    public Coordinates coordinates;
    private PathFinder pathFinder;
    private WorldMap worldMap;
    private Integer speed;
    private Integer hp;

    public void setPathFinder(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    @Override
    public String getSprite() {
        return "\uD83D\uDC07";
    }

    public Herbivore(WorldMap worldMap, PathFinder pathFinder,Coordinates coordinates) {
        this.coordinates = coordinates;
        this.pathFinder = pathFinder;
        this.worldMap = worldMap;
        this.hp=1;
        this.speed=1;
    }

    @Override
    public void makeMove() {
        if (pathFinder.findPathToNearestTarget(coordinates, Grass.class.getName()).isPresent()) {
            Coordinates next = pathFinder.findPathToNearestTarget(coordinates, Grass.class.getName()).get().get(1);
            worldMap.removeEntity(coordinates);
            worldMap.setEntity(this, next);
            coordinates = next;
        }

    }
}
