package simulation.entity.creature;

import simulation.entity.Coordinates;
import simulation.entity.landscape.Grass;
import simulation.map.PathFinder;
import simulation.map.WorldMap;

import java.util.List;

public class Herbivore extends Creature{
    private PathFinder pathFinder;
    private WorldMap worldMap;
    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }


    public int getSpeed(){
        return super.getSpeed();
    }
    public int getDamage(int damage) {
        setHp(getHp()-damage);
        System.out.println("Herbivore has " + getHp()+ " hp after attack");
        return getHp();

    }

    public Coordinates getCoordinates() {
        return super.getCoordinates();
    }

    public Herbivore(int speed, int hp, Coordinates coordinates, PathFinder pathFinder, WorldMap worldMap) {
        super(speed, hp, coordinates);
        this.pathFinder = pathFinder;
        this.worldMap = worldMap;
    }

    public int getHp() {
        return super.getHp();
    }

    @Override
    public void makeMove() {
        for(int i = 0; i<getSpeed(); i++){
        List<Coordinates> path = pathFinder.findPathToNearestTarget(getCoordinates(),Grass.class,worldMap);
        if(!path.isEmpty()){
            Coordinates next = path.get(1);
            if(pathFinder.checkIfTarget(next, Grass.class, worldMap)){
                consumeGrass(next);
            }
            worldMap.removeEntity(getCoordinates());
            worldMap.setEntity(this, next);
            setCoordinates(next);
            }
        }
    }

    public void consumeGrass(Coordinates herbCoordinates){
        if(getHp()<2){
            setHp(getHp()+1);
        }
        worldMap.removeEntity(herbCoordinates);
        System.out.println("Herbivore consumed grass now it has " + getHp() + " hp");
        }
    }


