package simulation.map;

import simulation.entity.Coordinates;
import simulation.entity.Entity;

import java.util.*;

public class WorldMap {

    private final Map<Coordinates, Entity> entities = new HashMap<>();

    private final int height;
    private final int width;

    public WorldMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Collection<Entity> getAllEntities(){
        return entities.values();
    }

    public void setEntity(Entity entity, Coordinates coordinates){
        if(checkIfCoordinatesIsEmpty(coordinates)&&checkIfInBound(coordinates)){entities.put(coordinates, entity);}
        else
        {throw new IllegalArgumentException("Coordinates is not empty or out of bounds " + coordinates);}
    }
    public void removeEntity(Coordinates coordinates){
        if (checkIfCoordinatesIsEmpty(coordinates)){throw new IllegalArgumentException("No entity found " + coordinates);}
        entities.remove(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        if(!checkIfCoordinatesIsEmpty(coordinates)){return entities.get(coordinates);}
        else {throw new IllegalArgumentException("No entity found " + coordinates);}
    }

    public Boolean checkIfCoordinatesIsEmpty(Coordinates coordinates){
        return !entities.containsKey(coordinates);
    }
    public Boolean checkIfInBound(Coordinates coordinates){
        return coordinates.row >= 0 && coordinates.row <= getHeight() - 1 && coordinates.column >= 0 && coordinates.column <= getWidth() - 1;
    }

    }






