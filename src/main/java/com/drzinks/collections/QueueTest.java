package com.drzinks.collections;

import java.util.*;

public class QueueTest {

    public static void main(String[] args) {
        priorityQueue();
    }

    static void priorityQueue() {
        Comparator<String> taskPrioritizer = (t1,t2) -> {
            List<String> myOrder = Arrays.asList("Prayer", "Meditation", "Excercises", "Breakfast");
            int index1 = myOrder.indexOf(t1);
            int index2 = myOrder.indexOf(t2);

            if(index1 != -1 && index2 != -1){ //both on list
                return Integer.compare(index1, index2);
            }else if(index1 != -1){ //only t1 on list
                return -1; //t1 goes on top
            }else if(index2 != -1) { //only t2 on list
                return 1; //t1 goes down
            }else{ //none on the list - lexicographical order
                return t1.compareTo(t2);
            }
        };
        Queue<String> tasks = new PriorityQueue<String>(taskPrioritizer);
        tasks.add("Excercises");
        tasks.add("Prayer");
        tasks.add("Surfing net");
        tasks.add("Meditation");
        tasks.add("Breakfast");

        Iterator<String> itPrio = tasks.iterator();

        while(itPrio.hasNext()){
            System.out.print(tasks.poll() + ", "); //Prayer, Meditation, Excercises, Breakfast, Surfing net
        }

    }

    Deque<String> linkedQ = new LinkedList<>();
    Deque<String> arrayDeq = new ArrayDeque<>();

}
