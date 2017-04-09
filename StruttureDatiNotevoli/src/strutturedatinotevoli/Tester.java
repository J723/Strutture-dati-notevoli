
package strutturedatinotevoli;

import List.*;
import Graphs.*;
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
        
        DataStruct<String> ds = null;
        String title = null;
        while (true){
            System.out.println("Scegli la struttura dati da testare ma evita di prendere a testate lo schermo perchè questo programma non funziona così!\n1-Array list\n2-Linked list\n0-Esci");
            
            int response = Integer.parseInt(new Scanner(System.in).nextLine());
            if (response >= 0 && response < 5){
                switch(response){
                case 0:
                    return;
                    
                case 1: 
                    ds = new ArrayList();
                    title = "array list";
                    break;
                
                case 2:
                    ds = new LinkedList();
                    title = "linked list";
                    break;
                    
                case 3:
                    ds = new MatrixGraph();
                    title = "matrix graph";
                    break;
                    
                case 4:
                    ds = new ListGraph();
                    title = "list graph";
                    break;    
                }
                
                if (title == null) break;

                if (response < 3){
                    List l = (List) ds;
                    test_List(l, title);
                }
                else if (response < 5){
                    Graph g = (Graph) ds;
                    //test_graph(g, title);
                }
            
                nonsenseAndEntropyAreFlushingTheOutput_GodDamnIt();//ripulisce la console
            }
        }
        
    }
    
    public static void test_List(List l, String listName){  
        while(true){
            System.out.println("\n\nTest Funzioni " + listName + " | lunghezza lista attuale: " + l.count() + " |\npremere:\n1-Inserisci\n2-Aggiungi\n3-Cancella\n4-Cerca elemento\n5-Ottieni posizione\n6-Mostra\n7-Chiudi");

            int response = Integer.parseInt(new Scanner(System.in).nextLine());
            if (response > 0 && response < 8){
                switch(response){
                        case 1:
                            insert(l);
                            break;
                        case 2:
                            add(l);
                            break;
                        case 3:
                            delete(l);
                            break;   
                        case 4:
                            findPos(l);
                            break;
                        case 5:
                            findKey(l);
                            break;
                        case 6:
                            show(l);
                            break;
                        case 7:
                            return;
                    }
                nonsenseAndEntropyAreFlushingTheOutput_GodDamnIt();//ripulisce la console
            }
        }
    }    
    
    //testMethods Functions - LISTE
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
        if(s != null && s.length >= 1){            
            System.out.println("Fatto!");
            //stampa tutto
            for(int i = 0; i < s.length; i++)
                System.out.print("\n-" + s[i]);
        }
        else            
            System.out.println("C'è stato un errore, nessun elemento trovato");
        //attesa
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }    
    public static void show(List l){
        System.out.println("Contenuto lista:");
        //stampa gli elementi con la relativa posizione
        Object[] result = l.show();
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }    
    public static void MoreDatas(){
        //possibili futuri implementabili calcoli di spazio e tempistiche
    }
    
    private static void nonsenseAndEntropyAreFlushingTheOutput_GodDamnIt(){
        /*
        for(int i = 0; i < 10000; i++)
            System.out.print("\b");
        */
        /*
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        */
        
        //AH AH! CREDEVI FOSSE DAVVERO POSSIBILE?!
    }
}