package Simulation;

import Simulation.Actions.InitAction;
import Simulation.Actions.MoveAllAction;
import Simulation.Map.MapPrinter;
import Simulation.Entity.Creature.PathFinder;
import Simulation.Map.WorldMap;

public class Main {
    public static void main(String[] args) {
        WorldMap wm = new WorldMap();
        PathFinder pf = new PathFinder(wm);
        MapPrinter mp = new MapPrinter(wm);
        InitAction initAction = new InitAction(pf,wm);
        MoveAllAction moveAllAction= new MoveAllAction(wm);
        Simulation simulation = new Simulation(moveAllAction,initAction,pf,mp,wm);
        simulation.startSimulation();

//        simulation.startSimulation();
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("pause");
//        simulation.pauseSimulation();
    }
    /// TO DO LIST
    /// Сделать систему коллизий, реализовать хп,
}