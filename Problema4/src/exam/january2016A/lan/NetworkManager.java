package exam.january2016A.lan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import material.graphs.BreadthSearch;
import material.graphs.ELGraph;
import material.graphs.Vertex;



/**
 *
 * @author jvelez
 */
public class NetworkManager {

    private ELGraph<Host,Integer> graph= new ELGraph<>();
    private Map<Host,Vertex<Host>> mapV= new HashMap<>();
    private Map<Router,List<Router>> map_ad= new HashMap<>();
    private Map<Terminal,Router> map_tr= new HashMap<>();
    /**
     * Adds a terminal to the network.
     *
     * @param terminal The terminal to be added.
     * @param router The router in which the terminal is added
     * @param bps The bits per second of the connection between the router and
     * the terminal.
     */
    public void addTerminal(Terminal terminal, Router router, int bps) {
        Vertex origen= graph.insertVertex(terminal);
        mapV.put(terminal,origen);
        Vertex destino = mapV.get(router);
        graph.insertEdge(origen, destino, bps);
        map_tr.put(terminal,router);
    }

    /**
     * Adds a router to the network
     *
     * @param router The router to be added.
     * @param routerList The router list to which ths router is connected
     * @param bps The bps for each router in routerList
     */
    public void addRouter(Router router, List<Router> routerList, List<Integer> bps) {
  
        Vertex origen= graph.insertVertex(router);
        mapV.put(router,origen);
        
        if(routerList!= null){
            for(int i=0;i<routerList.size();i++){
                Vertex destino = mapV.get(routerList.get(i));
                graph.insertEdge(origen, destino, bps.get(i));
                List<Router> lista_aux= new ArrayList<>();
                List<Router> listaEstatica= map_ad.get(routerList.get(i));
                for(Router router2:listaEstatica){
                    lista_aux.add(router2);
                }
                lista_aux.add(router);
                map_ad.put(routerList.get(i), lista_aux);
            }
            map_ad.put(router, routerList);
        }else{
            map_ad.put(router,new ArrayList<>());
        }
        
    }    

    /**
     * @param r
     * @return the routers connected to the router r
     */
    List<Router> getRouters(Router r) {
        return  map_ad.get(r);
    }

    /**
     * @param t
     * @return the router connected to the terminal t
     */
    Router getRouter(Terminal t) {
        return map_tr.get(t);
    }

    /**
     *
     * @param t1
     * @param t2
     * @return Return the number of jumps between t1 and t2
     */
    public int findHops(Terminal t1, Terminal t2) {
        BreadthSearch bd= new BreadthSearch();
        return bd.getPath(graph, mapV.get(t1), mapV.get(t2)).size();
        
    }
}
