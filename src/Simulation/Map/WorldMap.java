package Simulation.Map;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Creature.Herbivore;
import Simulation.Entity.Creature.Predator;
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
        if(checkIfEmpty(coordinates)){entities.put(coordinates, entity);}
        else{throw new IllegalArgumentException("Coordinates is not empty");}


    }
    public void removeEntity(Coordinates coordinates){
        entities.remove(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        if(!checkIfEmpty(coordinates)){return entities.get(coordinates);}
        else {throw new IllegalArgumentException("No entity found");}
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
        if(checkIfEmpty(coordinates)){return false;}
        return getEntity(coordinates) instanceof Herbivore;
    }
    public Boolean checkIfTarget(Coordinates coordinates, String targetClassName){
        if(checkIfEmpty(coordinates)){return false;}
        return getEntity(coordinates).getClass().getName().equals(targetClassName);
    }

    public Coordinates getRandomEmptyCoordinates(){
        Random rand = new Random();
        while(true){
            Coordinates next = new Coordinates(rand.nextInt(getMapSize()-1), rand.nextInt(getMapSize()-1));
            if(checkIfEmpty(next)){return next;}
            }///Может зависнуть если нет пустых координат
        }
    }






