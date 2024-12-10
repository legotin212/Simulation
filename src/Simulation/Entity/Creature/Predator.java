package Simulation.Entity.Creature;

import Simulation.Entity.Coordinates;
import Simulation.Map.WorldMap;

import java.util.List;

public class Predator extends Creature {
    private Integer speed;
    private Integer hp;
    private WorldMap worldMap;
    private PathFinder pathFinder;
    private Integer attack;

    public Coordinates coordinates;

    public Predator(WorldMap worldMap, PathFinder pathFinder, Coordinates coordinates) {
        this.worldMap = worldMap;
        this.pathFinder = pathFinder;
        this.coordinates = coordinates;
        this.speed = 1;
        this.hp = 1;
        this.attack = 1;
    }

    public Integer getAttack() {
        return attack;
    }

    @Override
    public void makeMove() {
        List<Coordinates> path = pathFinder.findPathToNearestTarget(coordinates,Herbivore.class,worldMap);
        if(!path.isEmpty()){
            Coordinates next = path.get(1);
            if(worldMap.checkIfTarget(next, Herbivore.class)){
                System.out.println("attack");
                attack(next);
            }
            else {
                worldMap.removeEntityByCoordinates(coordinates);
                worldMap.setEntityOnMapByCoordinates(this, next);
                coordinates = next;
            }
        }
    }

    public void attack(Coordinates next) {
        Herbivore herbivore = (Herbivore) worldMap.getEntityByCoordinates(next);
        Integer herbHP = herbivore.getDamage(this.getAttack());
        if(herbHP <= 0) {
            worldMap.removeEntityByCoordinates(next);
        }
    }
}
