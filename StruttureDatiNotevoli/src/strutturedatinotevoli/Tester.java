/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strutturedatinotevoli;
//Liste
//
import List.List;
import List.Linked_List;
import List.Array_List;
import java.util.Scanner;
/**
 *
 * @author -Undert{0}w-
 */
public class Tester {        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List l = null;
        String title = null;
        while (true){
            System.out.println("Scegli la struttura dati da testare ma evita di prendere a testate lo schermo perchè questo programma non funziona così!\n1-Array list\n2-Linked list\n0-Esci");
            switch(new Scanner(System.in).nextLine()){
                case "0":
                    return;
                    
                case "1": 
                    l = new Array_List();
                    title = "array list";
                    break;
                
                case "2":
                    l = new Linked_List();
                    title = "linked list";
                    break;
            }
            if (title == null)
                break;
            test_List(l, title);
            System.out.flush();//ripulisce la console
        }
    }
    
    public static void test_List(List l, String listName){  
        while(true){
        System.out.println("Test Funzioni " + listName + " | lunghezza lista attuale: " + l.count() + " |\npremere:\n1-Inserisci\n2-Aggiungi\n3-Cancella\n4-Cerca elemento\n5-Ottieni posizione\n6-Mostra\n7-Chiudi");
            switch(new Scanner(System.in).nextLine()){
                case "1":
                    insert(l);
                    break;
                case "2":
                    add(l);
                    break;
                case "3":
                    delete(l);
                    break;   
                case "4":
                    findPos(l);
                    break;
                case "5":
                    findKey(l);
                    break;
                case "6":
                    show(l);
                    break;
                case "7":
                    return;
            }
            System.out.flush();//ripulisce la console
        }
    }    
    
    //testMethods Functions
    //
    public static void insert(List l){
        //Query all'utente dei dati necessari
        System.out.println("Inserisci la posizione in cui inserire l'elemento:");
        int p = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Scrivere cosa inserire nella lista:");
        //stampa in base all'esito
        if(l.insert(new Scanner(System.in).nextLine(), p)){            
            System.out.println("Fatto!");
        }
        else            
            System.out.println("C'è stato un errore, probabilmente la posizione superava la lunghezza della lista + 1");
        //attesa
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }    
    public static void add(List l){
        //Query all'utente sull'elemento da inserire
        System.out.println("Scrivere cosa inserire nella lista:");
        if (l.add(new Scanner(System.in).nextLine()))
            System.out.println("Fatto!");
        else            
            System.out.println("C'è stato un errore :/");
        
        //attesa
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }   
    public static void delete(List l){
        //Query all'utente dei dati necessari
        System.out.println("Inserisci la posizione dell'elemento da eliminare:");
        //stampa in base all'esito
        if(l.delete(Integer.parseInt(new Scanner(System.in).nextLine())))           
            System.out.println("Fatto!");
        else            
            System.out.println("C'è stato un errore, probabilmente nella posizione selezionata non vi è alcun elemento");
        //attesa
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }    
    public static void findPos(List l){
        //Query all'utente dei dati necessari
        System.out.println("Inserisci la posizione da cui estrarre l'elemento");
        String e = (String)l.findPos(Integer.parseInt(new Scanner(System.in).nextLine()));//estrae l'elemento e lo converte in stringa
        
        //stampa in base all'esito
        if(e != null)          
            System.out.println("hai estratto: " + e);
        else            
            System.out.println("C'è stato un errore, probabilmente a tale posizione non corrisponde alcun elemento");
        //attesa
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }    
    public static void findKey(List l){
        //Query all'utente dei dati necessari
        System.out.println("Inserisci l'elemento da ricercare, se ve ne sono di uguai, restituirò tutte le posizioni di quegli elementi");
        int[] s = l.findKey(new Scanner(System.in).nextLine());

        //stampa in base all'esito
        if(s.length >= 1){            
            System.out.println("Fatto!");
            //stampa tutto
            for(int i = 0; i < s.length; i++)
                System.out.print("-" + s[i]);
        }
        else            
            System.out.println("C'è stato un errore, nessun elemento trovato");
        //attesa
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }    
    public static void show(List l){
        System.out.println();
        //stampa gli elementi con la relativa posizione
        for(int i = 0; i < l.count(); i++){
            System.out.println((String)l.findPos(i));
        }
    }    
    public static void MoreDatas(){
        //possibili futuri implementabili calcoli di spazio e tempistiche
    }
}