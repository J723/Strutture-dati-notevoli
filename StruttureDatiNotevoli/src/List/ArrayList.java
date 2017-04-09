/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;
/**
 *
 * @author -Undert{0}w-
 * @param <Type>
 */
public class ArrayList<Type> implements List<Type>{
    Element[] list;
    int count;      //indice cardinale delle celle occupate
    
    public ArrayList() {
        list = new Element[10];
        this.count = 0;
    }
    
    //metodi di inserimento
    //
    @Override
    public Boolean insert(Type e, int pos){
        if(pos <= count && pos >= 0){
            count++;
            extendList();//se necessario        
            //sposta a destra tutti gli elementi se list[pos] è pieno
            if(list[pos] != null){
                Element<Type> t1 = list[pos];
                Element<Type> t2 = list[pos+1];
                for(int c = pos; c < count; c++){
                    list[c+1] = t1;
                    t1 = t2;
                    t2 = list[c + 2];
                }
            }
            //inserisce l'elemento nella posizione specificata
            list[pos] = new Element<>(e);
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public Boolean add(Type e){
        extendList();
        //inserisce nella prima posizione libera
        list[count] = new Element<>(e);
        count++;
        return true;
    }
    
    //metodi di ricerca
    //  
    @Override
    public int[] findKey(Type e){
        //inizializza una lista con i dati uguali ad 'e'
        ArrayList l = new ArrayList();
        String s = "";
        //aggiunge alla lista i dati uguali ad 'e'
        for(int i = 0; i < count; i++){
            if(list[i] == e)
                l.add(i);            
        }
        //ritorna la lista sotto forma di array
        return l.toInteger();
    }   
    
    @Override
    public Type findPos(int pos){
        if(pos >= list.length)
            return null;
        return (Type)list[pos].value;
    }
    
    //
    //metodi di eliminazione
    //    
    @Override
    public Boolean delete(int pos){
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
    public Type[] show(){
        Element[] r  = new Element[count];
        for(int i = 0; i < count; i++)
            r[i] = list[i];
        return (Type[])r;
    } 
    
    int[] toInteger(){        
        int[] i = new int[count];
        try{
            for(int c = 0; c < list.length; c++)
                i[c] = Integer.parseInt(list[c].toString());
        }
        catch(NumberFormatException e){
            i = null;
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
    //non è usato ma è una funzione bellina e la voglio tenere :)
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
        Element[] e = new Element[count];
        for(int c = 0; c < e.length; c++){
            e[c] = list[c];
        }
        list = e;
    }
    
    void extendList(){
        if(count == list.length){
            Element[] o = new Element[list.length + 10];
            for(int i = 0; i < list.length; i++)
                o[i] = list[i]; 
            list = o;
        }
    }
}
