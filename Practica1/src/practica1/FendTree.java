
package practica1;

/**
 *
 * @author mayte
 */
public class FendTree {
    
    
    final static int MAX = 1000;     
    static int tree[] = new int[MAX];
    /**
     * Builds a Fendwick Tree with the array that receives
     * 
     * @param array
     */
    public FendTree(int [] array){
        for(int i=1; i<=array.length; i++)
            tree[i] = 0;
        for(int i = 0; i < array.length; i++)
            upDate(i, array[i]);
    }
    
    /**
     * Receives an index and returns the partial sum from zero to that index.
     * An exception is thrown if the index is less than zero or greater than or equal to n.
     * @param index
     * @return 
     */
    public int getSum(int index){
      int sum = 0; 
        index = index + 1;
        while(index>0)
        {
            sum += tree[index];
            index -= index & (-index); //padre= original- (original and (complemento2 original)) subir en el arbol
        }
        return sum;
    }
 
    /**
     * Update the value of the position index in the array.
     * 
     * @param index
     * @param val
     */
    public void upDate (int index, int val){
        if(index==-1) index=tree.length;
        index = index + 1;
        while(index <= tree.length)
        {
            tree[index] += val;
            index += index & (-index);//siguiente= original+ (original and (complemento2 original)) para bajar en el arbol
        }
    }
    
}
