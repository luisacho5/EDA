package parcial1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import material.Position;
import material.tree.Tree;


/**
 *
 * @author mayte
 */
public class Parcial1 {

  
    public static List antecesors(Tree t, Position node) {
        List<String> lista= new LinkedList<>();
        if(t.isRoot(node)) return null;
        
        while(!t.isRoot(node)){
            lista.add(t.parent(node).getElement().toString());
            node=t.parent(node);
        }
        return lista;
    }

    public static int degree(Tree t) {
        int degree=0;
        Iterator it= t.iterator();
        while(it.hasNext()){
            int aux=0;
            for(Object sons: t.children((Position) it.next())){
                aux++;
            }
            if(aux>degree){
                degree=aux;
            }
        }
        return degree;
    }
 

    public static boolean isIsogram(String word){
        String[] letras= word.split("");
        HashMap<String,Integer>  tabla = new HashMap<>();
        for(int i=0;i<letras.length;i++){
            tabla.put(letras[i], i);
        }
        return(tabla.size()==word.length());
    }
}
