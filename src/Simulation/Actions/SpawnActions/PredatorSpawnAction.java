package Simulation.Actions.SpawnActions;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Creature.PathFinder;
import Simulation.Entity.Creature.Predator;
import Simulation.Map.WorldMap;

public class PredatorSpawnAction extends SpawnAction{
    @Override
    public void perform(WorldMap worldMap) {
        Coordinates coordinates = worldMap.getRandomEmptyCoordinates();
        worldMap.setEntityOnMapByCoordinates(new Predator(worldMap,getPathFinder(),coordinates),coordinates);
    }
    @Override
    public PathFinder getPathFinder() {
        return super.getPathFinder();
    }
}
