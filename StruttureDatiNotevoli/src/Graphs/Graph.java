/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;
import strutturedatinotevoli.DataStruct;

public interface Graph<T> extends DataStruct<T>{
    
    //Gestione Vertici
    Boolean addSummit(T summit);
    Boolean removeSummit(T summit);
    
    //Gestione Archi
    Boolean addArch(T s1, T s2);
    Boolean removeArch(T s1, T s2);
    Boolean existArch(T s1, T s2);

    //Gestione Grafo
    Boolean[][] showAdjMat();
}
