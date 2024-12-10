package Simulation.Actions.SpawnActions;

import Simulation.Entity.Landscape.Rock;
import Simulation.Map.WorldMap;

public class RockSpawnAction extends SpawnAction{
    @Override
    public void perform(WorldMap worldMap) {
        worldMap.setEntityOnMapByCoordinates(new Rock(),worldMap.getRandomEmptyCoordinates());
    }
}
