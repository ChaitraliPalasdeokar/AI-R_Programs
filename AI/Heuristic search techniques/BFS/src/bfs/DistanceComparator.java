/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.util.Comparator;


public class DistanceComparator implements Comparator<Node>               // Comparator for priority queue based on Node distance
{

    @Override
    public int compare(Node o1, Node o2) {
        if(o1.getDistance() > o2.getDistance())
            return 1;
        else if(o1.getDistance() < o2.getDistance())
            return -1;
        return 0;
    }
    
}
