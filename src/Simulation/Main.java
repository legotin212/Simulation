package Simulation;

import Simulation.Actions.Action;
import Simulation.Actions.InitAction;
import Simulation.Actions.MoveAllCreaturesAction;
import Simulation.Actions.SpawnActions.RespawnGrassAction;
import Simulation.Map.MapPrinter;
import Simulation.Map.WorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = getSimulation();
        UIThread UIThread = new UIThread(simulation);
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Minimum size of the map is 6x6");
        System.out.println("Enter map size from where 1 is 6x6 square, 2 is 12x12 square, 3 is 18x18 etc.");
        simulation.setMapSize(scanner.nextInt()*6);
        UIThread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        simulation.run();


    }

    private static Simulation getSimulation() {
        WorldMap wm = new WorldMap();
        MapPrinter mp = new MapPrinter(wm);
        InitAction initAction = new InitAction();
        MoveAllCreaturesAction moveAllCreaturesAction = new MoveAllCreaturesAction();
        RespawnGrassAction respawnGrassAction = new RespawnGrassAction();
        List<Action> turnActions = new ArrayList<>();
        turnActions.add(respawnGrassAction);
        turnActions.add(moveAllCreaturesAction);
        Simulation simulation = new Simulation(initAction, mp,wm,turnActions);
        return simulation;
    }

    //реализовать скорость
    //реализовать хп
}
