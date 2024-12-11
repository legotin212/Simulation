package simulation.actions;

import simulation.entity.Coordinates;
import simulation.entity.creature.Herbivore;
import simulation.entity.creature.PathFinder;
import simulation.entity.creature.Predator;
import simulation.entity.landscape.Grass;
import simulation.entity.landscape.Rock;
import simulation.entity.landscape.Tree;
import simulation.map.WorldMap;

import java.util.Random;

public class EntityFactory {
    private final PathFinder pathFinder = new PathFinder();
    public void createEntity(String className, WorldMap worldMap){
        switch (className){
            case "Tree":
                worldMap.setEntity(new Tree(), getRandomEmptyCoordinates(worldMap));
                break;
            case "Rock":
                worldMap.setEntity(new Rock(), getRandomEmptyCoordinates(worldMap));
                break;
            case "Grass":
                worldMap.setEntity(new Grass(), getRandomEmptyCoordinates(worldMap));
                break;
            case "Predator":
                Coordinates predPosition = getRandomEmptyCoordinates(worldMap);
                worldMap.setEntity(new Predator(worldMap,pathFinder,predPosition),predPosition);
                break;
            case "Herbivore":
                Coordinates herbPosition = getRandomEmptyCoordinates(worldMap);
                worldMap.setEntity(new Herbivore(worldMap,pathFinder,herbPosition),herbPosition);
                break;
            default: throw new IllegalArgumentException("Unknown class name: "+className);
        }

    }

    public Coordinates getRandomEmptyCoordinates(WorldMap worldMap){
        Random rand = new Random();
        while(true){
            Coordinates next = new Coordinates(rand.nextInt(worldMap.getMapSize()-1), rand.nextInt(worldMap.getMapSize()-1));
            if(worldMap.checkIfCoordinatesIsEmpty(next)){return next;}
        }
    }

}

