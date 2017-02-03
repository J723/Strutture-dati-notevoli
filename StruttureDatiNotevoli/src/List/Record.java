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
public class Record {
    public Object data; //dati sensibili
    public Record next; //indice al record successivo
    
    public Record(Object data){
        this.data = data;
    }
    
    public Record(Object data, Record next){
        this.data = data;
        this.next = next;
    }
}
