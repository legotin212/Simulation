package Simulation.Map;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Creature.Predator;
import Simulation.Entity.Entity;
import Simulation.Entity.Landscape.Rock;
import Simulation.Entity.Landscape.Tree;

import java.util.*;

public class WorldMap {

    private final Map<Coordinates, Entity> entities = new HashMap<>();

    private int mapSize;

    public WorldMap() {
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public  int getMapSize(){
        return mapSize;
    }

    public Collection<Entity> getAllEntities(){
        return entities.values();
    }

    public void setEntityOnMapByCoordinates(Entity entity, Coordinates coordinates){
        if(checkIfCoordinatesIsEmpty(coordinates)&&checkIfInBound(coordinates)){entities.put(coordinates, entity);}
        else{throw new IllegalArgumentException("Coordinates is not empty or out of bounds " + coordinates);}
    }
    public void removeEntityByCoordinates(Coordinates coordinates){
        if (checkIfCoordinatesIsEmpty(coordinates)){throw new IllegalArgumentException("No entity found " + coordinates);}
        entities.remove(coordinates);
    }

    public Entity getEntityByCoordinates(Coordinates coordinates) {
        if(!checkIfCoordinatesIsEmpty(coordinates)){return entities.get(coordinates);}
        else {throw new IllegalArgumentException("No entity found " + coordinates);}
    }

    public Boolean checkIfCoordinatesIsEmpty(Coordinates coordinates){
        return !entities.containsKey(coordinates);
    }
    public Boolean checkIfInBound(Coordinates coordinates){
        return coordinates.y >= 0 && coordinates.y <= getMapSize() - 1 && coordinates.x >= 0 && coordinates.x <= getMapSize() - 1;
    }

    public Boolean checkIfPassable(Coordinates coordinates){
        return checkIfCoordinatesIsEmpty(coordinates) || !((getEntityByCoordinates(coordinates) instanceof Rock)||(getEntityByCoordinates(coordinates) instanceof Tree)
                ||(getEntityByCoordinates(coordinates) instanceof Predator));
    }

    public Boolean checkIfTarget(Coordinates coordinates, Class<?> target){
        if(checkIfCoordinatesIsEmpty(coordinates)){return false;}
        return getEntityByCoordinates(coordinates).getClass().equals(target);
    }

    public Coordinates getRandomEmptyCoordinates(){
        Random rand = new Random();
        while(true){
            Coordinates next = new Coordinates(rand.nextInt(getMapSize()-1), rand.nextInt(getMapSize()-1));
            if(checkIfCoordinatesIsEmpty(next)){return next;}
            }
        }
    }






