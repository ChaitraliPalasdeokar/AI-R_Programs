/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Graph {
    
    ArrayList<HeadNode> headNodesList;                                              //arraylist to hold headNodes
    int n;
    
    public Graph(int size)                                                          //constructor to initialize the Graph
    {
        this.n = size;
        headNodesList = new ArrayList<>();
    }
    
    public void initGraph()                                                         //method to accept graph nodes
    {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++)
        {
            //System.out.println("Enter the name of node" +(i+1)+" : ");
            HeadNode hn = new HeadNode();
            hn.setName(JOptionPane.showInputDialog("Enter the name of node" +(i+1)+" : "));
            headNodesList.add(hn);                                                  //add the nodes to headNodeList
          
        }
        for(int i=0;i<n;i++)
        {
            HeadNode tempHeadNode = headNodesList.get(i);
            
            while(true)                                                             //adjacent nodes input and their distances
            {
                String name = tempHeadNode.getName();
               // sc.skip("\n");
                String ans = JOptionPane.showInputDialog("\nDo you want to add any adjacent node to node "+ name + "? (y/n) : ");
                if(ans.equals("n")  || ans.equals("N"))
                    break;
               // sc.skip("\n");
                String tempName=JOptionPane.showInputDialog("Enter the name of adjacent node of "+ name + " : ");
                //sc.skip("\n");
                int tempDistance=Integer.parseInt(JOptionPane.showInputDialog("Enter distance between nodes " + name + " and " + tempName+ " :"));
                    
                tempHeadNode.setNodeInfo(tempName,tempDistance);
                headNodesList.set(i, tempHeadNode);
            
            }
        }
    }
    
    public void displayGraph()                                                      //method to display graph in form of adjacency list
    {
        for(int i=0;i<n;i++)
        {
            HeadNode tempHeadNode = headNodesList.get(i);
            System.out.print("\n"+ tempHeadNode.getName() + " : ");
            tempHeadNode.displayNodeList();
        }
    }
    
    public int getIndex(String name)                                                //method to get index by passing name of node
    {
        for(int i=0;i<n;i++)
        {
            HeadNode tempHeadNode = headNodesList.get(i);
            if(tempHeadNode.getName().equals(name))
                return i;
        }
        return -1;                                                                      //if node not found return -1
    }
    
    public ArrayList getNeighbours(String node)                                     //method to return neighbours of selected node
    {
        int headIndex=getIndex(node);
        return headNodesList.get(headIndex).getNodeList();
    }
}
