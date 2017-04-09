/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.util.*;
/**
 *
 * @author juoli
 */
public class ListGraph<T> implements Graph<T>{
    
    ArrayList<LinkedList<T>> adjList;
    
    public ListGraph(){
        adjList = new ArrayList<>();
    }

    @Override
    public Boolean addSummit(T summit) {
        try{            
            //controlla che il vertice non esista già
            if (adjList.contains(summit)) return false;
            
            //aggiunge la riga di adiacenza del nuovo vertice e quindi lo stesso
            adjList.add(new LinkedList<>());
            adjList.get(adjList.size() - 1).add(summit);
            
            return true;
            
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean removeSummit(T summit) {
        try{
            //ottiene l'indice dell'oggetto
            int i = adjList.indexOf(summit);
            
            //controlla l'esistenza del vertice
            if (i == -1) return false;
            
            //rimuove l'oggetto e la riga di adiacenza
            adjList.remove(i);
            
            //rimuove la sua cella di adiacenza in ogni riga
            for (LinkedList<T> l : adjList) l.remove(summit); //da per scontato sia solo uno per riga
            
            return true;
            
        }catch(Exception e){
            return false;
        }        
    }

    @Override
    public Boolean addArch(T s1, T s2) {
        try{
            //preleva gli indici            
            int[] indexes = new int[2];
            
            indexes[0] = adjList.indexOf(s1);
            indexes[1] = adjList.indexOf(s2);
            
            //verifica l'esistenza dei vertici
            if (indexes[0] == -1 || indexes[1] == -1) return false;
            
            //verifica la preesistenza dell'arco
            if (existArch(s1, s2)) return false;
            
            //indicizza il primo verso il secondo
            adjList.get(indexes[0]).add(s2);
            
            return true;
            
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean removeArch(T s1, T s2) {
        try{
            //preleva gli indici            
            int[] indexes = new int[2];
            
            indexes[0] = adjList.indexOf(s1);
            indexes[1] = adjList.indexOf(s2);
            
            //verifica l'esistenza dei vertici
            if (indexes[0] == -1 || indexes[1] == -1) return false;
            
            //verifica la NON preesistenza dell'arco
            if (!existArch(s1, s2)) return true;
            
            //rimuove il primo verso il secondo
            adjList.get(indexes[0]).remove(indexes[1]);
            
            return true;
            
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean existArch(T s1, T s2) {
        try{
           //preleva gli indici            
            int[] indexes = new int[2];
            
            indexes[0] = adjList.indexOf(s1);
            indexes[1] = adjList.indexOf(s2);
            
            //verifica l'esistenza dei vertici
            if (indexes[0] == -1 || indexes[1] == -1) return false;
            
            //controlla le loro riga di adiacenza verificando l' indicizzazione e ritorna l'esito
            return adjList.get(indexes[0]).contains(indexes[1]); //l'ordine conta per la direzione dell'arco

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean[][] showAdjMat() {
        try{                   
            //genera una matrice di adiacenza [quadrata]
            Boolean[][] matrix = new Boolean[adjList.size()][adjList.size()];
            
            for (int j = 0; j < adjList.size(); j++) //per ogni riga
                for (int head = 0; head < adjList.size(); head++) //per ogni cella di testa
                    for (int i = 1; i < adjList.size(); i++) //per ogni cella in ogni riga diversa dalla testa
                        matrix[j][i] =  adjList.get(j).get(i) == adjList.get(head);            
            
            return matrix;
            
        }catch(Exception e){
            return null;
        }        
    }    
}
