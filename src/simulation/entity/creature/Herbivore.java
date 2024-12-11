package simulation.entity.creature;

import simulation.entity.Coordinates;
import simulation.entity.landscape.Grass;
import simulation.map.WorldMap;

import java.util.List;

public class Herbivore extends Creature{
    public Coordinates coordinates;
    private PathFinder pathFinder;
    private WorldMap worldMap;
    private Integer speed;
    private Integer hp;

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getDamage(Integer damage) {
        this.hp -= damage;
        System.out.println("Herbivore has " + this.hp + " hp after attack");
        return this.hp;

    }


    public Herbivore(WorldMap worldMap, PathFinder pathFinder,Coordinates coordinates) {
        this.coordinates = coordinates;
        this.pathFinder = pathFinder;
        this.worldMap = worldMap;
        this.hp=1;
        this.speed=2;
    }

    @Override
    public void makeMove() {
        for(int i = 0; i<speed; i++){
        List<Coordinates> path = pathFinder.findPathToNearestTarget(coordinates,Grass.class,worldMap);
        if(!path.isEmpty()){
            Coordinates next = path.get(1);
            if(pathFinder.checkIfTarget(next, Grass.class, worldMap)){
                consumeGrass(next);
            }
            worldMap.removeEntity(coordinates);
            worldMap.setEntity(this, next);
            coordinates = next;
            }
        }
    }

    public void consumeGrass(Coordinates herbCoordinates){
        if(hp<2){
            this.hp+=1;
        }
        worldMap.removeEntity(herbCoordinates);
        System.out.println("Herbivore consumed grass now it has " + this.hp + " hp");
        }
    }


