package Simulation.Actions;

import Simulation.Actions.SpawnActions.*;
import Simulation.Map.WorldMap;

public class InitAction extends Action {

    @Override
    public void perform(WorldMap worldMap) {
        GrassSpawnAction grassSpawnAction = new GrassSpawnAction();
        TreeSpawnAction treeSpawnAction = new TreeSpawnAction();
        RockSpawnAction rockSpawnAction = new RockSpawnAction();
        HerbivoreSpawnAction herbivoreSpawnAction = new HerbivoreSpawnAction();
        PredatorSpawnAction predatorSpawnAction = new PredatorSpawnAction();
        for(int i = 0; i< worldMap.getMapSize()/5; i++){
            for(int j=0; j<6; j++){
                treeSpawnAction.perform(worldMap);
            }
            for(int k=0; k<8; k++){
                grassSpawnAction.perform(worldMap);
            }
            for(int j=0; j<4; j++){
                rockSpawnAction.perform(worldMap);
            }
            predatorSpawnAction.perform(worldMap);
            herbivoreSpawnAction.perform(worldMap);
            herbivoreSpawnAction.perform(worldMap);

        }

    }
}
