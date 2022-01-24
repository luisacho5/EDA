package smartpalacemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import material.graphs.BreadthSearch;
import material.graphs.ELGraph;
import material.graphs.Edge;
import material.graphs.Vertex;
import material.utils.Pair;

/**
 *
 * @author Fill your name here.
 */
public class SmartPalaceMap {

    private ELGraph<Room,Boolean> palacio= new ELGraph<>();
    private Map<Room,Vertex<Room>> mapa= new HashMap<>();
    private int size=0;
    /**
    * @param conectedRooms Rooms connected to the new created room. 
    *                      It can be null if there aren't any connected room.
    * @return The new created room.
    */
    public Room insertRoom(List<Room> connectedRooms) {
        Room aux = new Room();
        Vertex<Room> insertVertex = palacio.insertVertex(aux);
        mapa.put(aux, insertVertex);
        if (connectedRooms != null) {

            for (Room destino : connectedRooms) {
                palacio.insertEdge(mapa.get(destino),insertVertex, null);

            }
        }
        size = size + 1;
        return aux;
    }

    /**
    * @param  room1 Initial room of the path.
    * @param  room2 Final room of the path.
    * @return the ordered list of rooms. 
    *         The first room will be room1 and the last one will be room2. 
    *         If no path is found it will return null.
    */
    public List<Room> getPath(Room room1, Room room2) {
        List<Room> aux = new ArrayList<>();
       return  getAux(room1,room2,aux);   
    }
    
    public List<Room> getAux(Room room1, Room room2, List<Room> aux) {
        BreadthSearch<Room, Boolean> bs = new BreadthSearch<>();

        Vertex<Room> room_1 = palacio.insertVertex(room1);
        Vertex<Room> room_2 = palacio.insertVertex(room2);
        List<Edge<Boolean>> path = bs.getPath(palacio, room_1, room_2);
        List<Room> rooms = new ArrayList<>();
        for (Edge<Boolean> edge : path) {
            List<Vertex<Room>> endVertices = palacio.endVertices(edge);
            for (Vertex<Room> r : endVertices) {
                rooms.add(r.getElement());
            }
        }
        rooms.remove(rooms.size() - 2);
        return rooms;
    }
}
