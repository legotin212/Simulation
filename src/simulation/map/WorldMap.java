package simulation.map;

import simulation.entity.Coordinates;
import simulation.entity.creature.Predator;
import simulation.entity.Entity;
import simulation.entity.landscape.Rock;
import simulation.entity.landscape.Tree;

import java.util.*;

public class WorldMap {

    private final Map<Coordinates, Entity> entities = new HashMap<>();

    private int mapSize;    //final

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

    public void setEntity(Entity entity, Coordinates coordinates){
        if(checkIfCoordinatesIsEmpty(coordinates)&&checkIfInBound(coordinates)){entities.put(coordinates, entity);}
        throw new IllegalArgumentException("Coordinates is not empty or out of bounds " + coordinates);
    }
    public void removeEntity(Coordinates coordinates){
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
        return coordinates.column >= 0 && coordinates.column <= getMapSize() - 1 && coordinates.row >= 0 && coordinates.row <= getMapSize() - 1;
    }

    public Boolean checkIfPassable(Coordinates coordinates){
        return checkIfCoordinatesIsEmpty(coordinates) || !((getEntityByCoordinates(coordinates) instanceof Rock)||(getEntityByCoordinates(coordinates) instanceof Tree)
                ||(getEntityByCoordinates(coordinates) instanceof Predator));
    }

    public Boolean checkIfTarget(Coordinates coordinates, Class<?> target){
        if(checkIfCoordinatesIsEmpty(coordinates)){return false;}
        return getEntityByCoordinates(coordinates).getClass().equals(target);
    }


    }






