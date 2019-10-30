/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class BFS                        // Class for BFS Algorithm
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        
        int n;
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//    
         n=Integer.parseInt(JOptionPane.showInputDialog("Enter No of nodes"));              // Enter no. of rows
        PriorityQueue<Node> pq = new PriorityQueue<>(new DistanceComparator());             // Initilize priority queue
        ArrayList<Boolean> visited = new ArrayList<>(n);
        ArrayList<String> parent = new ArrayList<>(n);                                      // Store parent node
        for(int i=0;i<n;i++)
        {
            visited.add(false);                                                             // Set visited list for all nodes false
            parent.add("NIL");                                                              // Set parent of all nodes NIL
        }
        
        Graph graph = new Graph(n);                                                         // Create graph instance
        graph.initGraph();                                                                  // Initialize graph
        graph.displayGraph();                                                               // Display graph as adjacency list
        
        String start, goal;                                                                 // Accept start and goal nodes
        start = JOptionPane.showInputDialog("Enter the name of start node : ");
        
        goal = JOptionPane.showInputDialog("Enter the name of goal node : ");
        
        
        pq.add(new Node(start,0));                                                          // Add start node to priority queue with distance 0
        visited.set(graph.getIndex(start), true);                                           // Set visited true
        parent.set(graph.getIndex(start), "NIL");                                           // Set parent of start NIL
        System.out.println("\n\nPriority queue contents : \n");
        displayQueue(pq);
        
        while(!pq.isEmpty())                                                                // Process untill queue is not empty
        {
            Node temp = pq.poll();                                                          // Remove node with minimum distance
            displayQueue(pq);
            if(temp.getName().equals(goal))                                                 // Check if goal node is found
            {
                //JOptionPane.showMessageDialog(,"\nGoal node found");
                System.out.println("\nGoal node '"+temp.getName() + "'  found");
                break;
            }
            else
            {
                ArrayList<Node> neighbours = graph.getNeighbours(temp.getName());           // Get the neighbours of the retrieved node that are not visited
                for(Node n1:neighbours)                                                     // For all adjacent nodes
                {
                    if(!visited.get(graph.getIndex(n1.getName())))                          
                    {
                        visited.set(graph.getIndex(n1.getName()), Boolean.TRUE);            // Mark visited if not marked
                        pq.add(n1);                                                         // Add them to queue
                        parent.set(graph.getIndex(n1.getName()), temp.getName());           // Set parent of neighbour node
                    }
                }
                displayQueue(pq);                                                           // Display the Queue
            }
            
            
        }
        
        tracePath(parent,graph,goal);
    }
    
    
    private static void displayQueue(PriorityQueue<Node> pq)                                // Fuction to display queue
    {
        
        for(Node n:pq)
        {
            System.out.print(n.getName()+"\t");
        }
       
        System.out.println("");
    }
    
    private static void tracePath(ArrayList<String> parent, Graph graph, String goal)       // Function to trace the path
    {
        System.out.println("\n\nPath : ");
        String path = goal;
        String temp = goal;
        while(!parent.get(graph.getIndex(temp)).equals("NIL"))                              // Continue path till parent is not NIL
        {
            temp = parent.get(graph.getIndex(temp));
            path = temp + ", " + path;
        }
        
        System.out.println(path);
    }
    
    
    
}



/* 

OUTPUT :

run:

A : (B,3), (C,1)
B : (D,3), (E,2)
C : 
D : 
E : 

Priority queue contents : 

A	

C	B	
B	
B	

E	D	
D	
D	


Goal node 'D'  found


Path : 
A, B, D
BUILD SUCCESSFUL (total time: 1 minute 8 seconds)

*/