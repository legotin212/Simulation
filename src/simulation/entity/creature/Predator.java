package simulation.entity.creature;

import simulation.entity.Coordinates;
import simulation.map.WorldMap;

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
        for(int i = 0; i<speed; i++){
        List<Coordinates> path = pathFinder.findPathToNearestTarget(coordinates,Herbivore.class,worldMap);
        if(!path.isEmpty()) {
            Coordinates next = path.get(1);
            if (pathFinder.checkIfTarget(next, Herbivore.class, worldMap)) {
                System.out.println("attack");
                attack(next);
            } else {
                worldMap.removeEntity(coordinates);
                worldMap.setEntity(this, next);
                coordinates = next;
            }
        }
        }
    }

    public void attack(Coordinates next) {
        Herbivore herbivore = (Herbivore) worldMap.getEntity(next);
        Integer herbHP = herbivore.getDamage(this.getAttack());
        if(herbHP <= 0) {
            worldMap.removeEntity(next);
            speed++;
            System.out.println("Predator ate herbivore and increased it's speed to " + speed);
        }
    }
}
