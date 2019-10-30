/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;


public class Node                              // Class for adjacent nodes to headnode
{
    String name;                               // node name                              
    int distance;                              // distance between this node and headnode
    
                                               // constructor and getters, setters for data members
    
    public Node(String name, int dist)
    {
        this.name = name;
        this.distance = dist;
    }
    
    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    
}
