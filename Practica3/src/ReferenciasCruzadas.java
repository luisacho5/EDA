
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;



/**
 *
 * @author mayte
 */
public class ReferenciasCruzadas {
   
    /**
    * Builds an ordered dictionary from a file
    * 
    * @param fichero
    * @throws java.io.IOException
    */
    private TreeMap<String,List<Integer>> almacen;

    public ReferenciasCruzadas (FileReader fichero) throws IOException{
        
        almacen= new TreeMap<>();
        Scanner sc = new Scanner(fichero).useDelimiter("\\`|\\~|\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\(|\\)|\\+|\\=|\\[|\\{|\\]|\\}|\\||\\\\|\\'|\\<|\\,|\\.|\\>|\\?|\\/|\\\"\"|\\;|\\:|\\s+");
        int pos=1;
        while(sc.hasNext()){
            String palabra = sc.next();
            if(!palabra.isEmpty()){
            List<Integer> valor = almacen.get(palabra);
            if(valor== null){
                valor= new ArrayList<>();
            }else{
                almacen.remove(palabra);
            }
            valor.add(pos);
            almacen.put(palabra, valor);
            pos++;
            }
        }
    }
    
    /**
    * Returns the list of indexes that the word occupies in the text with which the dictionary has been built. 
    * If the word does not belong to the file returns null
    * @param word     
    * @return      
    */
    public List<Integer> apariciones(String word){
        
        return almacen.get(word);    
    }
    
}
