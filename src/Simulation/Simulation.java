package Simulation;

import Simulation.Actions.Action;
import Simulation.Actions.InitAction;
import Simulation.Map.MapPrinter;
import Simulation.Map.WorldMap;
import java.util.List;
import java.util.Scanner;

public class Simulation implements Runnable {
    private WorldMap worldMap;
    private MapPrinter mapPrinter;
    private Integer turnCounter;
    private Boolean isSimulationGoing;
    private InitAction initAction;
    private List<Action> turnActions;

    public void setIsSimulationGoing(Boolean going) {
        isSimulationGoing = going;
    }

    public Simulation(InitAction initAction, MapPrinter mapPrinter, WorldMap worldMap, List<Action> turnActions) {
        this.initAction = initAction;
        this.turnActions = turnActions;
        this.isSimulationGoing = false;
        this.turnCounter = 0;
        this.mapPrinter = mapPrinter;
        this.worldMap = worldMap;
    }

    public void nextTurn(){
        mapPrinter.printMap(worldMap);
        System.out.println("Turn " + turnCounter);
        for(Action action : turnActions){action.perform(worldMap);}
        turnCounter++;

    }
    public void setMapSize(int size){
        worldMap.setMapSize(size);
    }

    public void startSimulation(){
        initAction.perform(worldMap);
        isSimulationGoing = true;
       while (isSimulationGoing){
           nextTurn();
           try {
               Thread.sleep(3000);
           } catch (InterruptedException  e) {
               System.out.println(e);
           }
       }
    }

    public void pauseSimulation(){
        setIsSimulationGoing(false);
        System.out.println("pauseSimulation");
    }

    @Override
    public void run() {
        startSimulation();
        if(!isSimulationGoing){
            pauseSimulation();
        }
    }
}
