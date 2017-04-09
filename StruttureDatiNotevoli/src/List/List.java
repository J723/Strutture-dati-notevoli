/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;
import strutturedatinotevoli.DataStruct;

public interface List<Type> extends DataStruct<Type>{
    //metodi di inserimento
    Boolean insert(Type e, int pos);
    Boolean add(Type e);
    
    //metodi di ricerca
    int[] findKey(Type e);
    Type findPos(int pos);
    
    //metodi di eliminazione
    Boolean delete(int pos);
    
    //metodi di output della lista
    Type[] show();
    int count();
}
