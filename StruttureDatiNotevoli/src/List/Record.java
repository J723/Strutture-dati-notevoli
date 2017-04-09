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
public class Record<Type> extends Element<Type>{
    public Record next; //indice al record successivo
    
    public Record(Type data){
        value = data;
    }
    
    public Record(Type data, Record next){
        value = data;
        this.next = next;
    }
}
