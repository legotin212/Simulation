package simulation.actions;

import simulation.entity.creature.Herbivore;
import simulation.entity.creature.Predator;
import simulation.entity.landscape.Grass;
import simulation.entity.landscape.Rock;
import simulation.entity.landscape.Tree;
import simulation.map.WorldMap;

public class InitAction extends Action {
    private final int NUMBER_OF_TREES = 2;
    private final int NUMBER_OF_GRASSES= 4;
    private final int NUMBER_OF_ROCKS = 2;
    private final int NUMBER_OF_PREDATORS = 1;
    private final int NUMBER_OF_HERBIVORES = 2;

    private final EntityFactory entityFactory = new EntityFactory();

    @Override
    public void perform(WorldMap worldMap) {
        for(int i = 0; i< worldMap.getHeight()*worldMap.getWidth()/25; i++){
            for(int j=0; j<NUMBER_OF_TREES; j++){
                entityFactory.createEntity(Tree.class.getSimpleName(),worldMap);
            }
            for(int j=0; j<NUMBER_OF_GRASSES; j++){
                entityFactory.createEntity(Grass.class.getSimpleName(),worldMap);
            }
            for(int j=0; j<NUMBER_OF_ROCKS; j++){
                entityFactory.createEntity(Rock.class.getSimpleName(),worldMap);
            }
            for(int j=0; j<NUMBER_OF_HERBIVORES; j++){
                entityFactory.createEntity(Herbivore.class.getSimpleName(),worldMap);
            }
            for(int j=0; j<NUMBER_OF_PREDATORS; j++){
                entityFactory.createEntity(Predator.class.getSimpleName(),worldMap);
            }

        }

    }
}
