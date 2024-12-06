package Simulation.Actions;

import Simulation.Entity.Creature.Herbivore;
import Simulation.Entity.Creature.PathFinder;
import Simulation.Entity.Creature.Predator;
import Simulation.Entity.Landscape.Grass;
import Simulation.Entity.Landscape.Rock;
import Simulation.Entity.Landscape.Tree;
import Simulation.Map.WorldMap;

public class InitAction implements Action {

    private WorldMap   worldMap;
    private PathFinder pathFinder;

    public InitAction(PathFinder pathFinder, WorldMap worldMap) {
        this.pathFinder = pathFinder;
        this.worldMap = worldMap;
    }

    public void initAction(){
        Predator pred = new Predator(worldMap,pathFinder,worldMap.getRandomEmptyCoordinates());
        worldMap.setEntity(pred,pred.coordinates);
        System.out.println(pred.coordinates);
        Herbivore herb1 = new Herbivore(worldMap,pathFinder,worldMap.getRandomEmptyCoordinates());
        worldMap.setEntity(herb1,herb1.coordinates);
        Herbivore herb2 = new Herbivore(worldMap,pathFinder,worldMap.getRandomEmptyCoordinates());
        worldMap.setEntity(herb2,herb2.coordinates);
        Grass grass1 = new Grass();
        worldMap.setEntity(grass1,worldMap.getRandomEmptyCoordinates());
        Grass grass2 = new Grass();
        worldMap.setEntity(grass2,worldMap.getRandomEmptyCoordinates());
        Grass grass3 = new Grass();
        worldMap.setEntity(grass3,worldMap.getRandomEmptyCoordinates());
        Grass grass4 = new Grass();
        worldMap.setEntity(grass4,worldMap.getRandomEmptyCoordinates());
        Tree tree1 = new Tree();
        worldMap.setEntity(tree1,worldMap.getRandomEmptyCoordinates());
        Tree tree2 = new Tree();
        worldMap.setEntity(tree2,worldMap.getRandomEmptyCoordinates());
        Rock rock1 = new Rock();
        worldMap.setEntity(rock1,worldMap.getRandomEmptyCoordinates());




    }
}
