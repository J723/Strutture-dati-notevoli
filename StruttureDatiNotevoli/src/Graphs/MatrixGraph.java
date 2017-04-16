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
public class MatrixGraph<T> implements Graph<T>{
    
    ArrayList<ArrayList<Boolean>> adjMatrix;
    ArrayList<T> summits;
    
    public MatrixGraph(){
        adjMatrix = new ArrayList<>();
        summits = new ArrayList<>();
    }
    
    @Override
    public Boolean addSummit(T summit) {        
        try{
            //controlla l'esistenza del vertice
            if (summits.contains(summit)) return false;
            
            //Aggiunge alla lista degli oggetti
            summits.add(summit);

            //Aggiunge una colonna a tutti
            for (ArrayList<Boolean> l : adjMatrix)
                l.add(false);

            //aggiunge una nuova riga di lunghezza [colonne] e starta le adiacenze a false
            adjMatrix.add(new ArrayList<>(Collections.nCopies(summits.toArray().length, false)));

            return true;
        
        }catch (Exception e){
            return false;
        }        
    }

    @Override
    public Boolean removeSummit(T summit) {
        try{
            //controlla l'esistenza del vertice
            if (!summits.contains(summit)) return false;
            
            // memorizza l'indice e rimuove dalla lista degli oggetti
            int s = summits.indexOf(summit);
            summits.remove(s);

            //rimuove la riga di adiacenza del summit
            adjMatrix.remove(s);

            //rimuove la colonna a tutti
            for (ArrayList<Boolean> l : adjMatrix) l.remove(s);

            return true;
        
        }catch (Exception e){
            return false;
        }    
    }

    @Override
    public Boolean addArch(T s1, T s2) {
        try{
            //preleva gli indici            
            int[] indexes = new int[2];
            
            indexes[0] = summits.indexOf(s1);
            indexes[1] = summits.indexOf(s2);
            
            //verifica l'esistenza dei vertici
            if (indexes[0] == -1 || indexes[1] == -1) return false;
            
            //verifica la preesistenza dell'arco
            if (existArch(s1, s2)) return false;
            
            //setta a true la cella di adiacenza nella riga del primo vertice relativa al secondo (unidirezionale)
            adjMatrix.get(indexes[0]).set(indexes[1], true);
            
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
            
            indexes[0] = summits.indexOf(s1);
            indexes[1] = summits.indexOf(s2);
            
            //verifica l'esistenza dei vertici
            if (indexes[0] == -1 || indexes[1] == -1) return false;
            
            //verifica la NON preesistenza dell'arco
            if (!existArch(s1, s2)) return false;
            
            //setta a false la cella di adiacenza nella riga del primo vertice relativa al secondo (unidirezionale)
            adjMatrix.get(indexes[0]).set(indexes[1], false);
            
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
            
            indexes[0] = summits.indexOf(s1);
            indexes[1] = summits.indexOf(s2);
            
            //verifica l'esistenza dei vertici
            if (indexes[0] == -1 || indexes[1] == -1) return false;
            
            //ritorna l'esistenza dell'arco (la cella di adiacenza)
            return adjMatrix.get(indexes[0]).get(indexes[1]);
            
        }catch (Exception e){
            return false;
        }
    }    

    @Override
    public Boolean[][] showAdjMat() {
        try{
            //converte la matrice in array bidimensionale e la ritorna
            Boolean[][] matrix = new Boolean[adjMatrix.size()][adjMatrix.size()];            
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++) 
                    matrix[i][j] = adjMatrix.get(i).get(j);
            
            return matrix;
            
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public int countSummits() {
        return summits.size();
    }

    @Override
    public int countArch(T summit) {
        //ottiene l'indice del vertice
        int i = summits.indexOf(summit);

        //controlla l'0esistenza del vertice
        if (i == -1) return i;        
        
        //conta ogni true nella riga di adiacenza
        int l = 0;
        for (boolean b : adjMatrix.get(i)) if (b) l++;        
        return l;
    }
}
