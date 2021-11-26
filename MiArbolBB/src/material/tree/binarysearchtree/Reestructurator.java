package material.tree.binarysearchtree;

import material.Position;
import material.tree.binarytree.LinkedBinaryTree;

/**
 * LinkedBinarySearchTree that implements the tri-node restructuration
 * @author jvelez
 */
class Reestructurator {
   /**
     * Performs a tri-node restructuring. Assumes the nodes are in one of
     * following configurations:
     *
     * <pre>
     *          z=c       z=c        z=a         z=a
     *         /  \      /  \       /  \        /  \
     *       y=b  t4   y=a  t4    t1  y=c     t1  y=b
     *      /  \      /  \           /  \         /  \
     *    x=a  t3    t1 x=b        x=b  t4       t2 x=c
     *   /  \          /  \       /  \             /  \
     *  t1  t2        t2  t3     t2  t3           t3  t4
     * </pre>
     *
     * @return the new root of the restructured subtree
     */ 
    public Position restructure(Position posNode, LinkedBinaryTree binTree) {
        Position parent = binTree.parent(posNode);
        boolean esHijoIzq = ((binTree.hasLeft(parent)) && (binTree.left(parent) == posNode));
        Position abuelo = binTree.parent(parent);
        boolean esPadreIzq = ((binTree.hasLeft(abuelo)) && (binTree.left(abuelo) == parent));
        boolean esRaizAbuelo = binTree.isRoot(parent);
        boolean esAbueloIzq = false;
        Position padreAbuelo = null;
        if (!esRaizAbuelo) {
            padreAbuelo = binTree.parent(abuelo);
            esAbueloIzq = ((binTree.hasLeft(padreAbuelo)) && (binTree.left(padreAbuelo) == parent));
        }
        LinkedBinaryTree t2, t3, a, b, c;

        if (esHijoIzq && esPadreIzq) {//izq izq
            t2 = binTree.hasRight(posNode) ? binTree.subTree(binTree.right(posNode)) : null;
            t3 = binTree.hasRight(parent) ? binTree.subTree(binTree.right(parent)) : null;
            a = binTree.subTree(posNode);
            b = binTree.subTree(parent);
            c = binTree.subTree(abuelo);
        } else if (!esHijoIzq && esPadreIzq) {//der izq
            t2 = binTree.hasLeft(posNode) ? binTree.subTree(binTree.left(posNode)) : null;
            t3 = binTree.hasRight(posNode) ? binTree.subTree(binTree.right(posNode)) : null;
            b = binTree.subTree(posNode);
            a = binTree.subTree(parent);
            c = binTree.subTree(abuelo);
        } else if (esHijoIzq && !esPadreIzq) {//izq-der
            t2 = binTree.hasLeft(posNode) ? binTree.subTree(binTree.left(posNode)) : null;
            t3 = binTree.hasRight(posNode) ? binTree.subTree(binTree.right(posNode)) : null;
            b = binTree.subTree(posNode);
            c = binTree.subTree(parent);
            a = binTree.subTree(abuelo);
        } else {//der-der
            t2 = binTree.hasLeft(parent) ? binTree.subTree(binTree.left(parent)) : null;
            t3 = binTree.hasLeft(posNode) ? binTree.subTree(binTree.left(posNode)) : null;
            c = binTree.subTree(posNode);
            b = binTree.subTree(parent);
            a = binTree.subTree(abuelo);
        }
        if(t2!=null)
            a.attachRight(a.root(), t2);
        
        if(t3!=null)
            c.attachLeft(c.root(), t3);
        b.attachLeft(b.root(), a);
        b.attachRight(b.root(), c);
        Position nuevaRaiz=b.root();
        if(esRaizAbuelo)
            binTree.attach(b);
        else{
            if(esAbueloIzq)
                binTree.attachLeft(padreAbuelo, b);
            else
                binTree.attachRight(padreAbuelo, b);
        }
        return nuevaRaiz;
    }
}
