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
public class Array_List implements List{
    
    //Corpo Attributi della classe
    Object[] list = new Object[10]; //contiene i dati sensibili
    int count = 0;      //indice cardinale delle celle occupate
    
    //metodi di inserimento
    //
    @Override
    public boolean insert(Object e, int pos){
        if(pos <= count && pos >= 0){
            count++;
            makeSomeSpace();//se necessario        
            //sposta a destra tutti gli elementi se list[pos] è pieno
            if(list[pos] != null){
                Object t1 = list[pos];
                Object t2 = list[pos+1];
                for(int c = pos; c < count; c++){
                    list[c+1] = t1;
                    t1 = t2;
                    t2 = list[c + 2];
                }
            }
            //inserisce l'elemento nella posizione specificata
            list[pos] = e;
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public boolean add(Object e){
        makeSomeSpace();
        //inserisce nella prima posizione libera
        list[count] = e;
        count++;
        return true;
    }
    
    //metodi di ricerca
    //  
    @Override
    public int[] findKey(Object e){
        Array_List l = new Array_List();
        int[] a;
        for(int i = 0; i < count; i++){
            if(list[i] == e)
                l.add(i);            
        }
        a = new int[l.count];
        for(int c = 0; c < a.length; c++){
            a[c] = (int)l.list[c];
        }
        return a;
    }   
    
    @Override
    public Object findPos(int pos){
        if(pos >= list.length)
            return null;
        return list[pos];
    }
    
    //
    //metodi di eliminazione
    //    
    @Override
    public boolean delete(int pos){
        if(list[pos] != null){
            list[pos] = null;
            count--;
            //sposta gli elementi a destra di pos, che è vuoto, più a sx di 1
            for(int i = pos, j = i + 1; j < count; i++, j++){
                //cerca la prima cella piena (nel caso raggiunga la fine dell'array)
                while(list[j] == null && j < list.length)
                    j++;
                //sposta a sx la il contenuto di list[j]
                list[i] = list[j];
                list[j] = null;
            }
        }
        return true;
    }
    
    //
    //metodi di output lista
    //
    @Override
    public Object[] show(){
        Object[] r = new Object[count];
        for(int i = 0; i < count; i++)
            r[i] = list[i];
        return r;
    } 
    
    int[] toInteger(Array_List l){
        int[] i = new int[l.count];
        for(int c = 0; c < i.length; c++){
            i[c] = (int)l.list[c];
        }
        return i;
    }
    
    @Override
    public int count(){
        return count;
    }  
    
    //
    //metodi di compattamento dell'array
    //
    void compact(){
        /*cicla finche non trova una cella vuota :
          --> sposta l'elemento più vicino nello spazio vuoto
        */        
        int j;//indice dell'elemento da spostare
        int i;//indice della cella corrente
        //sposta l'indice alla prima cella vuota
        for(i = 0; i < list.length; i++){ 
            if(list[i] == null)    
                break;
        }        
        //posiziona j alla successiva di quella vuota
        //compatta gli elementi spostandli più a sx possibile
        for(j = i + 1 ;j < list.length; j++, i++){            
            while(list[j] == null && j < list.length){//sposta l'indice alla prima cella vuota
                j++;
            }
            //sposta l'elemento più vicino a dx nella cella vuota
            list[i] = list[j];
            list[j] = null;
        } 
        //elimina le celle vuote
        Object[] e = new Object[count];
        for(int c = 0; c < e.length; c++){
            e[c] = list[c];
        }
        list = e;
    }
    
    void makeSomeSpace(){
        if(count == list.length){
            Object[] o = new Object[list.length + 10];
            for(int i = 0; i < list.length; i++)
                o[i] = list[i]; 
            list = o;
        }
    }
}
