package Simulation.Actions.SpawnActions;

import Simulation.Entity.Landscape.Tree;
import Simulation.Map.WorldMap;

public class TreeSpawnAction extends SpawnAction {


    @Override
    public void perform(WorldMap worldMap) {
        worldMap.setEntityOnMapByCoordinates(new Tree(), worldMap.getRandomEmptyCoordinates());
    }
}
