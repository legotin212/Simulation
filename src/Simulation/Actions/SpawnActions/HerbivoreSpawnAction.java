package Simulation.Actions.SpawnActions;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Creature.Herbivore;
import Simulation.Entity.Creature.PathFinder;
import Simulation.Map.WorldMap;

public class HerbivoreSpawnAction extends SpawnAction {
    @Override
    public void perform(WorldMap worldMap) {
        Coordinates coordinates = worldMap.getRandomEmptyCoordinates();
        worldMap.setEntityOnMapByCoordinates(new Herbivore(worldMap,getPathFinder(),coordinates), coordinates);
    }

    @Override
    public PathFinder getPathFinder() {
        return super.getPathFinder();
    }
}
