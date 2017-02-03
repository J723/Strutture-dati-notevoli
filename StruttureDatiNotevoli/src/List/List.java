/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author -Undert{0}w-
 */
public interface List {
    //metodi di inserimento
    boolean insert(Object e, int pos);
    boolean add(Object e);
    
    //metodi di ricerca
    int[] findKey(Object e);
    Object findPos(int pos);
    
    //metodi di eliminazione
    boolean delete(int pos);
    
    //metodi di output della lista
    Object[] show();
    int count();
}
