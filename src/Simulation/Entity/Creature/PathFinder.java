package Simulation.Entity.Creature;

import Simulation.Entity.Coordinates;
import Simulation.Map.WorldMap;

import java.util.*;

public class PathFinder {
    private WorldMap worldMap;

    public PathFinder(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
    public List<Coordinates> getAvialibleCoordinateslist(Coordinates coordinates){
        List<Coordinates> coordinatesList = new ArrayList<>();

        Coordinates up = new Coordinates(coordinates.x, coordinates.y+1);
        Coordinates down = new Coordinates(coordinates.x, coordinates.y-1);
        Coordinates left = new Coordinates(coordinates.x-1, coordinates.y);
        Coordinates right = new Coordinates(coordinates.x+1, coordinates.y);
        if(worldMap.checkIfPassable(up)&&worldMap.checkIfInBound(up)){coordinatesList.add(up);}
        if(worldMap.checkIfPassable(down)&&worldMap.checkIfInBound(down)){coordinatesList.add(down);}
        if(worldMap.checkIfPassable(left)&&worldMap.checkIfInBound(left)){coordinatesList.add(left);}
        if(worldMap.checkIfPassable(right)&&worldMap.checkIfInBound(right)){coordinatesList.add(right);}
        return coordinatesList;
    }


    public Optional<List<Coordinates>> findPathToNearestTarget(Coordinates current, String targetClassName) {
        ArrayDeque<Coordinates> unvisited = new ArrayDeque<>();
        Map<Coordinates, Coordinates> predecessors = new HashMap<>();
        List<Coordinates> visited = new ArrayList<>();
        unvisited.addLast(current);
        while (!unvisited.isEmpty()) {
            current = unvisited.removeFirst();
            visited.add(current);

            if (worldMap.checkIfTarget(current,targetClassName)) {
                List<Coordinates> path = new ArrayList<>();
                for (Coordinates at = current; at != null; at = predecessors.get(at)) {
                    path.add(at);
                }
                Collections.reverse(path);
                return Optional.of(path);
            }

            for (Coordinates neighbor : getAvialibleCoordinateslist(current)) {
                if (!visited.contains(neighbor) && !unvisited.contains(neighbor)) {
                    unvisited.addLast(neighbor);
                    predecessors.put(neighbor, current);
                }
            }
        }
        return Optional.empty();
    }

}
