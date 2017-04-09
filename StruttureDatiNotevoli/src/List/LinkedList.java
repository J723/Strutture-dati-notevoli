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
public class LinkedList<Type> implements List<Type>{
    Record<Type> first;
    
    //Metodi di inseriment
    //
    @Override
    public Boolean insert(Type element, int pos){
        //casi d'eccezione (Lista vuota ma pos == o, lista vuota e pos != 0, pos >= count)
        Record<Type> temp;        
        if (first != null && pos <= count())
            temp = first;
        else if (pos == 0){
            first = new Record(element);
            return true;
        }
        else
            return false;
        
        //slitta temp di n elementi finchè non ottiene il puntatore di quello in pos (non può arrivare a superare la fine della lista)
        for (int i = 0; i < pos - 1; i++)
            temp = temp.next; 
            //alla fine: Temp Contiene il record in [pos - 1]
        
        //crea un nuovo record con l'elemento da inserire, lo collega al precedente e gli collega il successivo
        Record<Type> temp0 = new Record(element);
        
        //collega al nuovo record quello che occupava la sua posizione
        if(temp.next != null) 
            temp0.next = temp.next; 
        
        //collega al precedente della lista
        temp.next = temp0;
        return true;
    }  
    
    @Override
    public Boolean add(Type element){
        //eccezione (lista vuota)
        if (first == null){
            first = new Record(element);
            return true;
        }
        
        Record<Type> temp = first;        
        //slitta temp di n elementi finchè non ottiene l'ultimo elemento con next == null
        while(temp.next != null)
            temp = temp.next;
        //inserisce
        temp.next = new Record(element);
        return true;
    }
    
    //metodi di eliminazione
    //
    @Override
    public Boolean delete(int pos){
        //eccezione (lista vuota e/o pos > count)
        Record<Type> temp;
        if (first != null && pos < count())
            temp = first;
        else
            return false;
                
        //trova l'elemento da eliminare, se non esiste 'false' 
        for(int i = 0; i < pos - 1; i++)
            temp = temp.next;
            //alla fine: Temp Contiene il record in [pos - 1] 
        
        //se l'elemento ha un successivo lo ricollega al precedente di quello da eliminare
        if(temp.next.next != null)
            temp.next = temp.next.next;//l'indice di quello da eliminare diventa l'indice del suo successivo 
        else    //altrimenti nulla l'elemento da eliminare
            temp.next = null;
        return true;
    }
    
    //metodi di ricerca
    //
    @Override
    public Type findPos(int pos){
        //eccezzioni (lista vuota o pos > count)
        Record<Type> temp;
        if (first != null && pos < count())
            temp = first;
        else 
            return null;
        
        //slitta temp di n elementi finchè non arriva alla fine della lista
        for (int i = 0; i < pos; i++)
            temp = temp.next;
        return temp.value;
    }
    
    @Override
    public int[] findKey(Type e){
        //eccezioni (lista vuota)
        Record<Type> temp;
        if (first != null)
            temp = first;
        else 
            return new int[0];
        
        LinkedList indexes = new LinkedList();//lista degli indici di elementi = e
        //slitta temp di n elementi finchè non arriva alla fine della lista, estrapola gli ndici delle posizioni degli elementi uguali ad e
        for (int i = 0; temp != null; i++, temp = temp.next)
            if (temp.value.equals(e))
                indexes.add(i);            
        
        return indexes.toInteger();
    }
    
    //metodi di output della lista
    //
    @Override
    public Type[] show(){              
        //eccezione (lista vuota)
        if (first == null) 
            return null;
        
        int n = count();  
        Record<Type> temp = first;
        
        //inizializza l' array ed estrae gli oggetti dai record
        Type[] list;
        //list = (Type[])Array.newInstance(Class<Type[]>, n);
        list = (Type[])new Object[n];
        for(int i = 0; i < n; i++, temp = temp.next)
            list[i] = temp.value;
        
        //ritorna l'array di elementi
        return list;
    }
    
    @Override
    public int count(){
        //eccezione (lista vuota-->ritorna 0)
        if(first == null)
            return 0;
        //ottiene la lunghezza della lista
        int n = 0;
        for (Record<Type> temp = first; temp != null; temp = temp.next)
            n++;   
        return n;
    }
    
    public int[] toInteger(){
        //eccezione (lista vuota)
        if(first == null)
            return new int[0];
        
        //inizializza l' array ed estrae gli oggetti dai record
        Record<Type> temp = first;
        int n = count();
        int[] list = new int[n];
        
        //converte gli oggetti in interi
        for(int i = 0; i < n; i++, temp = temp.next)
            list[i] = (Integer)temp.value;
        
        //ritorna l'array di elementi
        return list;
    }
}
