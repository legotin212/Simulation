package Simulation.Actions;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Creature.Creature;
import Simulation.Entity.Creature.Herbivore;
import Simulation.Entity.Creature.Predator;
import Simulation.Entity.Entity;
import Simulation.Map.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class MoveAllCreaturesAction extends Action {
    @Override
    public void perform(WorldMap worldMap) {
        List<Creature> creatures = new ArrayList<>();
        for (int rank = 0; rank < worldMap.getMapSize(); rank++) {
            for (int file = 0; file < worldMap.getMapSize(); file++) {
                if (!worldMap.checkIfCoordinatesIsEmpty(new Coordinates(file, rank))) {
                    Entity entity = worldMap.getEntityByCoordinates(new Coordinates(file, rank));
                    if (entity instanceof Creature) {
                        creatures.add((Creature) entity);
                    }
                }
            }
        }
        creatures.stream().filter(creature -> creature instanceof Predator).forEach(creature -> creature.makeMove());
        creatures.stream().filter(creature -> creature instanceof Herbivore)
                .filter(creature -> ((Herbivore) creature).getHp()>=1).forEach(creature -> creature.makeMove());
    }

}
