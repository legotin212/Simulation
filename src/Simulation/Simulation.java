package Simulation;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Creature.Creature;
import Simulation.Entity.Creature.Herbivore;
import Simulation.Entity.Creature.PathFinder;
import Simulation.Entity.Creature.Predator;
import Simulation.Entity.Landscape.Grass;
import Simulation.Entity.Landscape.Rock;
import Simulation.Entity.Landscape.Tree;
import Simulation.Map.MapPrinter;
import Simulation.Map.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private WorldMap worldMap;
    private MapPrinter mapPrinter;
    private Integer turnCounter;
    private Boolean isGoing;
    private PathFinder pathFinder;

    public void setMapPrinter(MapPrinter mapPrinter) {
        this.mapPrinter = mapPrinter;
    }
    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }
    public void setGoing(Boolean going) {
        isGoing = going;
    }

    public Simulation(MapPrinter mapPrinter, WorldMap worldMap) {
        this.isGoing = false;
        this.turnCounter = 0;
        this.mapPrinter = mapPrinter;
        this.worldMap = worldMap;
        this.pathFinder = new PathFinder(worldMap);
    }

    public void nextTurn(){
        mapPrinter.printMap(worldMap);
        System.out.println("Turn " + turnCounter);
        moveAll();
        turnCounter++;
    }

    public void startSimulation(){
        initAction();
        isGoing = true;
       while (isGoing){
           nextTurn();
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }

    public void initAction(){
    Predator pred = new Predator(worldMap,pathFinder,worldMap.getRandomEmptyCoordinates());
    Herbivore herb1 = new Herbivore(worldMap,pathFinder,worldMap.getRandomEmptyCoordinates());
    Herbivore herb2 = new Herbivore(worldMap,pathFinder,worldMap.getRandomEmptyCoordinates());
    Grass grass1 = new Grass(worldMap.getRandomEmptyCoordinates());
    Grass grass2 = new Grass(worldMap.getRandomEmptyCoordinates());
    Grass grass3 = new Grass(worldMap.getRandomEmptyCoordinates());
    Grass grass4 = new Grass(worldMap.getRandomEmptyCoordinates());
    Tree tree1 = new Tree(worldMap.getRandomEmptyCoordinates());
    Tree tree2 = new Tree(worldMap.getRandomEmptyCoordinates());
    Rock rock1 = new Rock(worldMap.getRandomEmptyCoordinates());

    worldMap.setEntity(herb1,herb1.coordinates);
    worldMap.setEntity(herb2,herb2.coordinates);
    worldMap.setEntity(pred,pred.coordinates);
    worldMap.setEntity(grass1,grass1.coordinates);
    worldMap.setEntity(grass2,grass2.coordinates);
    worldMap.setEntity(grass3,grass3.coordinates);
    worldMap.setEntity(grass4,grass4.coordinates);
    worldMap.setEntity(tree1,tree1.coordinates);
    worldMap.setEntity(tree2,tree2.coordinates);
    worldMap.setEntity(rock1,rock1.coordinates);

    }

    public void moveAll(){
        List<Creature> creatures = new ArrayList<>();
        for (int rank = 0; rank < worldMap.getMapSize(); rank++) {
            for (int file = 0; file < worldMap.getMapSize(); file++) {
                if(worldMap.getEntity(new Coordinates(rank, file)) instanceof Creature){
                    creatures.add(((Creature) worldMap.getEntity(new Coordinates(rank,file))));}
            }


            }
        creatures.forEach(creature -> creature.makeMove());
        }



    public void pauseSimulation(){
        setGoing(false);
        System.out.println("pauseSimulation");///не работает
    }
}
