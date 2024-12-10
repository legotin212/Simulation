package Simulation.Actions.SpawnActions;

import Simulation.Entity.Entity;
import Simulation.Entity.Landscape.Grass;
import Simulation.Map.WorldMap;

import java.util.Collection;

public class RespawnGrassAction extends SpawnAction {
    @Override
    public void perform(WorldMap worldMap) {
        Collection<Entity> entities = worldMap.getAllEntities();
        long currentGrass = entities.stream().filter(entity -> entity instanceof Grass).count();
        GrassSpawnAction grassSpawnAction = new GrassSpawnAction();
        if (currentGrass < worldMap.getMapSize()) {
            grassSpawnAction.perform(worldMap);
        }

    }


}
