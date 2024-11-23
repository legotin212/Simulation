import Entity.Coordinates;

public class Simulation {
    private Map map;

    public Coordinates findNearestGrass(Coordinates coordinates){
        for(int y = coordinates.y; y< Map.getMapSize(); y++) {
            for (int x = coordinates.x; x < Map.getMapSize(); x++){

            }
        }
        return null;
    }
    public Simulation(Map map) {
        this.map = map;
    }
}
