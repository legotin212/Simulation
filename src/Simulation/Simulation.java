package Simulation;

import Simulation.Actions.InitAction;
import Simulation.Actions.MoveAllAction;
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
    private InitAction initAction;
    private MoveAllAction moveAllAction;


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

    public Simulation(MoveAllAction moveAllAction, InitAction initAction, PathFinder pathFinder, MapPrinter mapPrinter, WorldMap worldMap) {
        this.moveAllAction = moveAllAction;
        this.initAction = initAction;
        this.pathFinder = pathFinder;
        this.isGoing = false;
        this.turnCounter = 0;
        this.mapPrinter = mapPrinter;
        this.worldMap = worldMap;
    }

    public void nextTurn(){
        mapPrinter.printMap(worldMap);
        System.out.println("Turn " + turnCounter);
        moveAllAction.moveAll();
        turnCounter++;
    }

    public void startSimulation(){
        initAction.initAction();
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

    public void pauseSimulation(){
        setGoing(false);
        System.out.println("pauseSimulation");///не работает
    }
}
