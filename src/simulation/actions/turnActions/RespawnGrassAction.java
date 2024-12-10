package simulation.actions.turnActions;

import simulation.actions.EntityFactory;
import simulation.entity.Entity;
import simulation.entity.landscape.Grass;
import simulation.map.WorldMap;

import java.util.Collection;

public class RespawnGrassAction extends RespawnAction {
    private final EntityFactory entityFactory = new EntityFactory();
    @Override
    public void perform(WorldMap worldMap) {
        Collection<Entity> entities = worldMap.getAllEntities();
        long currentGrass = entities.stream().filter(entity -> entity instanceof Grass).count();
        if (currentGrass < worldMap.getMapSize()) {
            entityFactory.createEntity(Grass.class.getSimpleName(),worldMap);
        }

    }


}
