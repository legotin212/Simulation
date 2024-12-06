package Simulation.Actions;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Creature.Creature;
import Simulation.Entity.Entity;
import Simulation.Map.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class MoveAllAction implements Action {
    private WorldMap worldMap;

    public MoveAllAction(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void moveAll(){
        List<Creature> creatures = new ArrayList<>();
        for (int rank = 0; rank < worldMap.getMapSize(); rank++) {
            for (int file = 0; file < worldMap.getMapSize(); file++) {
                if (!worldMap.checkIfEmpty(new Coordinates(file, rank))) {
                    Entity entity = worldMap.getEntity(new Coordinates(file, rank));
                    if (entity instanceof Creature) {
                        creatures.add((Creature) entity);
                    }
                }
            }

        }
        creatures.forEach(creature -> creature.makeMove());
    }
}
