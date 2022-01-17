package com.orange_yishenggong.algorithm_notes.dataStructureDesign;

import java.util.Stack;

/**                      offer    poll    peek
 * Time Complexity:      O(1)     O(1)    O(1)
 * Space Complexity:              O(N)
 * @author Orange Meow
 */
public class TwoStackQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    public TwoStackQueue(){
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    private void pushToPop(){
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }
    public void offer(int val){
        pushStack.push(val);
        pushToPop();
    }
    public int poll(){
        return popStack.pop();
    }
    public int peek(){
        pushToPop();
        return popStack.peek();
    }
}
