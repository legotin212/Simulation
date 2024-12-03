package Simulation;

import Simulation.Map.MapPrinter;
import Simulation.Entity.Creature.PathFinder;
import Simulation.Map.WorldMap;

public class Main {
    public static void main(String[] args) {
        WorldMap wm = new WorldMap();
        PathFinder pf = new PathFinder(wm);
        MapPrinter mp = new MapPrinter(wm);
        Simulation simulation = new Simulation(mp,wm);
        simulation.startSimulation();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("pause");
        simulation.pauseSimulation();
    }
}