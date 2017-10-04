package ub.cse.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
      private int startNode;
      private HashMap<Integer, ArrayList<Integer>> graph;
      public Solution(int node, HashMap<Integer, ArrayList<Integer>> g){
        startNode = node;
        graph = g;
      }

      public int[] outputDistances(){
        int[] ret = new int[graph.size()];
        ret[startNode] = 0;
        boolean[] done = new boolean[graph.size()];
        done[startNode]=true;
        int counter = 1;
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.add(graph.get(startNode));
        while(!q.peek().isEmpty()) {
            ArrayList<Integer> list = q.poll();
            ArrayList<Integer> next = new ArrayList<Integer>();
            for(int i: list) {
            	ret[i] = counter;
            	done[i] = true;
            }
            for(int i: list) {
	            for(int x : graph.get(i)) {
				  		if (done[x]==false) {
				  			next.add(x);
				  			done[x]=true;
				  		}
				  	}
            }
            q.add(next);
            counter++;
        }
        for(int i = 0; i < done.length; i++) {
        	if (done[i]==false) {
        		ret[i] = -1;
        	}
        }
        return ret;
      }

}