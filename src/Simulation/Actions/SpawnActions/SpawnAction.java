package Simulation.Actions.SpawnActions;

import Simulation.Actions.Action;
import Simulation.Entity.Creature.PathFinder;
import Simulation.Map.WorldMap;

public abstract class SpawnAction extends Action {
    @Override
    public void perform(WorldMap worldMap) {

    }
    public PathFinder getPathFinder() {
        return new PathFinder();
    }
}
