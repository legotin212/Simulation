package Simulation.Entity.Creature;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Landscape.Grass;
import Simulation.Map.WorldMap;

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
            if(worldMap.checkIfTarget(next, Grass.class)){
                consumeGrass(next);
            }
            worldMap.removeEntityByCoordinates(coordinates);
            worldMap.setEntityOnMapByCoordinates(this, next);
            coordinates = next;
            }
        }
    }

    public void consumeGrass(Coordinates herbCoordinates){
        if(hp<2){
            this.hp+=1;
        }
        worldMap.removeEntityByCoordinates(herbCoordinates);
        System.out.println("Herbivore consumed grass now it has " + this.hp + " hp");
        }
    }


