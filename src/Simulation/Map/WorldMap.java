package Simulation.Map;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Creature.Herbivore;
import Simulation.Entity.Entity;
import Simulation.Entity.Landscape.Grass;
import Simulation.Entity.Landscape.Rock;
import Simulation.Entity.Landscape.Tree;

import java.util.*;

public class WorldMap {

    public HashMap<Coordinates, Entity> entities = new HashMap<>();

    public WorldMap() {
    }

    public  int getMapSize(){
        return 10;
    }

    public void setEntity(Entity entity, Coordinates coordinates){

        entities.put(coordinates, entity);
    }
    public void removeEntity(Coordinates coordinates){
        entities.remove(coordinates);
    }

    public Entity getEntity(Coordinates coordinates){
        return entities.get(coordinates);
    }

    public boolean checkIfEmpty(Coordinates coordinates){
        return !entities.containsKey(coordinates);
    }

    public Boolean checkIfInBound(Coordinates coordinates){
        return coordinates.y >= 0 && coordinates.y <= getMapSize() - 1 && coordinates.x >= 0 && coordinates.x <= getMapSize() - 1;
    }
    public Boolean checkIfPassable(Coordinates coordinates){
        return checkIfEmpty(coordinates) || !((getEntity(coordinates) instanceof Rock)||(getEntity(coordinates) instanceof Tree));
    }
    public Boolean checkIfGrass(Coordinates coordinates){
        return getEntity(coordinates) instanceof Grass;
    }

    public Boolean checkIfHerbivore(Coordinates coordinates){
        return getEntity(coordinates) instanceof Herbivore;
    }
    public Boolean checkIfTarget(Coordinates coordinates, String targetClassName){
        if(checkIfEmpty(coordinates)){return false;}
        return getEntity(coordinates).getClass().getName().equals(targetClassName);
    }

    public Coordinates getRandomEmptyCoordinates(){
        Random rand = new Random();
        while(true){
            if(checkIfEmpty(new Coordinates(rand.nextInt(getMapSize()-1), rand.nextInt(getMapSize()-1)))){
                return new Coordinates(rand.nextInt(getMapSize()-1), rand.nextInt(getMapSize()-1));
            }///Может зависнуть если нет пустых координат
        }
    }




}

