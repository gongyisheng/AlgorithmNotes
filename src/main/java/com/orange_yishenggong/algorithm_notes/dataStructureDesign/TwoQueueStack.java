package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import java.util.LinkedList;
import java.util.Queue;

/**                      push     pop     peek
 * Time Complexity:      O(1)     O(N)    O(1)
 * Space Complexity:              O(N)
 * @author Orange Meow
 */
public class TwoQueueStack {
    Queue<Integer> queue;
    Queue<Integer> help;
    public TwoQueueStack(){
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }
    private void queueToHelp(){
        while(queue.size()>1){
            help.offer(queue.poll());
        }
    }
    private void helpToQueue(){
        while(!help.isEmpty()){
            queue.offer(help.poll());
        }
    }
    
    public void push(int val){
        queue.offer(val);
        queueToHelp();
    }
    public int pop(){
        queueToHelp();
        int toPop = queue.poll();
        helpToQueue();
        queueToHelp();
        return toPop;
    }
    public int peek(){
        return queue.peek();
    }
}
