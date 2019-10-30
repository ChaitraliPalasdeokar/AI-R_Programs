/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.util.ArrayList;
import java.util.Iterator;


public class HeadNode                                         // Head node in adjacency list of graph
{
    private String name;                                       // node name
    private ArrayList<Node> adjnodes = new ArrayList<>();      // List of adjacent nodes
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNodeInfo(String name,int distance)          // Add adjacent node
    {
        Node n = new Node(name,distance);
        adjnodes.add(n);
    }
 
    public ArrayList getNodeList()
    {
        return adjnodes;
    }
    
    public void displayNodeList()                             // Display adjacent nodes list (name,distance)
    {
        Iterator i = adjnodes.iterator();
        if(i.hasNext())
        {
            Node temp= (Node)i.next();
            System.out.print("("+temp.getName()+","+temp.getDistance()+")");
        
        }
        while(i.hasNext())
        {
            Node temp= (Node)i.next();
            System.out.print(", ("+temp.getName()+","+temp.getDistance()+")");
        }
    }
    
}
