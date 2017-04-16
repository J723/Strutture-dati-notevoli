
package strutturedatinotevoli;

import List.*;
import Graphs.*;
/**
 *
 * @author jesus christ super programmer
 */
public class Tester {      
    
    public static void main(String[] args) throws InterruptedException {
        DataStruct<String> ds = null;
        String title = null;
        while (true){
                  
            Display.clear();
            Display.writeLine("Scegli la struttura dati da testare ma evita di prendere a testate lo schermo perchè questo programma non funziona così!\n1-Array list\n2-Linked list\n3-Matrix graph\n4-List graph\n0-Esci");
            
            int response = Integer.parseInt(Display.ReadLine());
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
                    test_Graph(g, title);
                } 
            }
        }
        
    }
 
    //TESTER LISTE
    public static void test_List(List l, String listName) throws InterruptedException{  
        while(true){
                  
            Display.clear();
            Display.writeLine("Test Funzioni " + listName + " | lunghezza lista attuale: " + l.count() + " |\npremere:\n1-Inserisci\n2-Aggiungi\n3-Cancella\n4-Cerca elemento\n5-Ottieni posizione\n6-Mostra\n7-Chiudi");

            int response = 0;
            try{ response = Integer.parseInt(Display.ReadLine()); }catch(NumberFormatException e){}
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
            Display.ReadLine();
        }
    }    
    
    //TESTER GRAFI
    public static void test_Graph(Graph g, String graphType) throws InterruptedException{  
        while(true){
                  
            Display.clear();
            Display.writeLine("Test Funzioni " + graphType + " | numero elementi attuale: " + g.countSummits()+ "|\npremere:\n1-Aggiungi un vertice\n2-Rimuovi un vertice\n3-Aggiungi arco\n4-Controlla arco\n5-Elimina arco\n6-Conta relazioni\n7-Ottini tabella di adiacenza\n8-Chiudi");

            int response = 0;
            try{ response = Integer.parseInt(Display.ReadLine()); }catch(NumberFormatException e){}
            switch(response){
                case 1:
                    addSummit(g);
                    break;
                case 2:
                    removeSummit(g);
                    break;
                case 3:
                    addArch(g);
                    break;   
                case 4:
                    controlArch(g);
                    break;
                case 5:
                    removeArch(g);
                    break;
                case 6:
                    countRelation(g);
                    break;
                case 7:
                    show(g);
                    break;
                case 8:
                    return;
            }
            Display.ReadLine(); 
        }
    }   
    
    //LISTE
    public static void insert(List l){
        //Query all'utente dei dati necessari
        Display.writeLine("Inserisci la posizione in cui inserire l'elemento:");
        int p = Integer.parseInt(Display.ReadLine());
        Display.writeLine("Scrivere cosa inserire nella lista:");
        //stampa in base all'esito
        if(l.insert(Display.ReadLine(), p)){            
            Display.writeLine("Fatto!");
        }
        else            
            Display.writeLine("C'è stato un errore, probabilmente la posizione superava la lunghezza della lista + 1");
    }    
    
    //LISTE
    public static void add(List l){
        //Query all'utente sull'elemento da inserire
        Display.writeLine("Scrivere cosa inserire nella lista:");
        if (l.add(Display.ReadLine()))
            Display.writeLine("Fatto!");
        else            
            Display.writeLine("C'è stato un errore :/");
    }   
    
    //LISTE
    public static void delete(List l){
        //Query all'utente dei dati necessari
        Display.writeLine("Inserisci la posizione dell'elemento da eliminare:");
        //stampa in base all'esito
        if(l.delete(Integer.parseInt(Display.ReadLine())))           
            Display.writeLine("Fatto!");
        else            
            Display.writeLine("C'è stato un errore, probabilmente nella posizione selezionata non vi è alcun elemento");
    }    
    
    //LISTE
    public static void findPos(List l){
        //Query all'utente dei dati necessari
        Display.writeLine("Inserisci la posizione da cui estrarre l'elemento");
        String e = (String)l.findPos(Integer.parseInt(Display.ReadLine()));//estrae l'elemento e lo converte in stringa
        
        //stampa in base all'esito
        if(e != null)          
            Display.writeLine("hai estratto: " + e);
        else            
            Display.writeLine("C'è stato un errore, probabilmente a tale posizione non corrisponde alcun elemento");
    } 
    
    //LISTE
    public static void findKey(List l){
        //Query all'utente dei dati necessari
        Display.writeLine("Inserisci l'elemento da ricercare, se ve ne sono di uguai, restituirò tutte le posizioni di quegli elementi");
        int[] s = l.findKey(Display.ReadLine());

        //stampa in base all'esito
        if(s != null && s.length >= 1){            
            Display.writeLine("Fatto!");
            //stampa tutto
            for(int i = 0; i < s.length; i++)
                Display.writeLine("\n-" + s[i]);
        }
        else            
            Display.writeLine("C'è stato un errore, nessun elemento trovato");
    }    
    
    //LISTE
    public static void show(List l){
        Display.writeLine("Contenuto lista:");
        //stampa gli elementi con la relativa posizione
        Object[] result = l.show();
        for(int i = 0; i < result.length; i++){
            Display.writeLine(result[i]);
        }
    }    
    public static void MoreDatas(){
        //possibili futuri implementabili calcoli di spazio e tempistiche
    }  
    
    
    //GRAFI
    public static void addSummit(Graph g){
        Display.writeLine("Inserisci un elemento");
        if (g.addSummit(Display.ReadLine()))
            Display.writeLine("Fatto! hai inserito un vertice!!!");
        else            
            Display.writeLine("C'è stato un errore :/");
    }
    
    //GRAFI
    public static void removeSummit(Graph g){
        Display.writeLine("Inserisci il nome dell' elemento da rimuovere");
        if (g.removeSummit(Display.ReadLine()))
            Display.writeLine("hai eliminato un vertice\nsi chiamava Charlie\nPrey for Charlie");
        else            
            Display.writeLine("C'è stato un errore, ci dispiace molto\nRitenta: sarai più fortunato :/");
    }
    
    //GRAFI
    public static void addArch(Graph g){
        Display.writeLine("Inserisci il nome del primo vertice, dal quale creare l'arco");
        String first = Display.ReadLine();
        Display.writeLine("Inserisci il nome del secondo vertice, verso il quale creare l'arco");
        String second = Display.ReadLine();
        
        if (g.addArch(first, second))
            Display.writeLine("Fatto! Hai aggiunto un arco!");
        else            
            Display.writeLine("C'è stato un errore, ci dispiace molto :/");
    }
    
    //GRAFI
    public static void controlArch(Graph g){
        Display.writeLine("Inserisci il nome del primo vertice, dal quale parte l'arco");
        String first = Display.ReadLine();
        Display.writeLine("Inserisci il nome del secondo vertice, verso il quale termina l'arco");
        String second = Display.ReadLine();
        
        if (g.existArch(first, second))
            Display.writeLine("Esiste! il tuo arco esiste! non sei felicio?!");
        else            
            Display.writeLine("Ci dispiace molto, il tuo arco potrebbe avere il telefono spento o non raggiungibile");
    }
    
    //GRAFI
    public static void removeArch(Graph g){
        Display.writeLine("Inserisci il nome del primo vertice, dal quale parte l'arco");
        String first = Display.ReadLine();
        Display.writeLine("Inserisci il nome del secondo vertice, verso il quale termina l'arco");
        String second = Display.ReadLine();
        
        if (g.addArch(first, second))
            Display.writeLine("Hai eliminato un arco\nEra il ponte di Tacoma\nPrey for Tacoma");
        else            
            Display.writeLine("Non sei riuscito ad eliminarlo AHAH!\nritenta sarai più fortunato :/");
    }
    
    //GRAFI
    public static void countRelation(Graph g){
        Display.writeLine("Inserisci il nome dell' elemento da rimuovere");
        int n = g.countArch(Display.ReadLine());
        Display.writeLine("il tuo vertice ha " + n + " relazioni");
        if (n <= 2)
            Display.writeLine("il tuo vertice ha una vita sociale molto simile alla tua");
        else if (n == 0)            
            Display.writeLine("il tuo vertice si sente un po' solo");
        else             
            Display.writeLine("il tuo vertice ha una vita sociale più attiva della tua");
    }
    
    //GRAFI
    public static void show(Graph g){
        Display.writeLine("queste sono le adiacenze nel grafo, fanne buon uso\n'da grandi adiacenze derivano grandi responsabilità'");
        Boolean[][] mat = g.showAdjMat();
        for (Boolean[] row : mat){
            for (Boolean b : row) {
                if(b) Display.write("1");
                else Display.write("0");
            }
            Display.write("\n");
        }
    }
}