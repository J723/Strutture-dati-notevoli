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
            for (LinkedList<T> row : adjList)
                if (row.getFirst().equals(summit)) return false;
            
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
            int i = -1;
            for (LinkedList<T> row : adjList)
                if (row.getFirst().equals(summit)) i = adjList.indexOf(row);
            
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
            int[] indexes = new int[]{ -1, -1};            
            for (LinkedList<T> row : adjList){
                if (row.getFirst().equals(s1)) indexes[0] = adjList.indexOf(row);
                if (row.getFirst().equals(s2)) indexes[1] = adjList.indexOf(row);
            }
            
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
            int[] indexes = new int[]{ -1, -1};            
            for (LinkedList<T> row : adjList){
                 if (row.getFirst().equals(s1)) indexes[0] = adjList.indexOf(row);
                 if (row.getFirst().equals(s2)) indexes[1] = adjList.indexOf(row);
             }
            
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
            int[] indexes = new int[]{ -1, -1};            
            for (LinkedList<T> row : adjList){
                if (row.getFirst().equals(s1)) indexes[0] = adjList.indexOf(row);
                if (row.getFirst().equals(s2)) indexes[1] = adjList.indexOf(row);
            }
            
            //verifica l'esistenza dei vertici
            if (indexes[0] == -1 || indexes[1] == -1) return false;
            
            //controlla le loro riga di adiacenza verificando l' indicizzazione e ritorna l'esito
            return adjList.get(indexes[0]).subList(2, adjList.get(indexes[0]).size()).contains(s2); //l'ordine conta per la direzione dell'arco

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean[][] showAdjMat() {
        //try{                   
            //genera una matrice di adiacenza [quadrata]
            Boolean[][] matrix = new Boolean[adjList.size()][adjList.size()];   
            
            for (int j = 0; j < matrix.length; j++)
                for (int n = 0; n < matrix.length; n++){  
                    List l = adjList.get(j).subList(1, adjList.get(j).size());
                    matrix[j][n] =  l.contains(adjList.get(n).get(0));
                }            
            return matrix;
       /*     
        }catch(Exception e){
            return null;
        }
*/
    }    

    @Override
    public int countSummits() {
        return adjList.size();
    }

    @Override
    public int countArch(T summit) {        
        //verifica l'esistenza del vertice, se non esiste ritorna -1
        LinkedList<T> r = new LinkedList<>();
        for (LinkedList<T> row : adjList)
            if (row.getFirst().equals(summit)) r = row;
        if (r.isEmpty()) return -1;    
        else return r.size() - 1; //meno la cella di testa
    }
}
