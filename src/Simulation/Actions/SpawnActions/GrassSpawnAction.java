package Simulation.Actions.SpawnActions;

import Simulation.Entity.Landscape.Grass;
import Simulation.Map.WorldMap;

public class GrassSpawnAction extends SpawnAction {
    @Override
    public void perform(WorldMap worldMap) {
        worldMap.setEntityOnMapByCoordinates(new Grass(),worldMap.getRandomEmptyCoordinates());
    }
}
