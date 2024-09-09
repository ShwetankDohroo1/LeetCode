class MyQueue {
private Stack<Integer> st1 = new Stack<>();
private Stack<Integer> st2 = new Stack<>();
    void ele(){
        while(!st1.empty()){
            st2.push(st1.peek());
            st1.pop();
        }
    }
    public MyQueue() {   
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(st2.empty()){
            ele();
        }
        int a = st2.peek();
        st2.pop();
        return a;
    }
    
    public int peek() {
        if(st2.empty()){
            ele();
        }
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.empty() && st2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */