package simulation;

import simulation.actions.Action;
import simulation.actions.InitAction;
import simulation.actions.turnActions.MoveAllCreaturesAction;
import simulation.actions.turnActions.RespawnGrassAction;
import simulation.map.MapPrinter;
import simulation.map.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class SimulationFactory {


    public Simulation getSimulation(int height, int width) {
        WorldMap worldMap = new WorldMap(height, width);
        MapPrinter mapPrinter = new MapPrinter();
        InitAction initAction = new InitAction();
        MoveAllCreaturesAction moveAllCreaturesAction = new MoveAllCreaturesAction();
        RespawnGrassAction respawnGrassAction = new RespawnGrassAction();
        List<Action> turnActions = new ArrayList<>();
        turnActions.add(respawnGrassAction);
        turnActions.add(moveAllCreaturesAction);
        Simulation simulation = new Simulation(initAction, mapPrinter,worldMap,turnActions);
        return simulation;
    }
}
