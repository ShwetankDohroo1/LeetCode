class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        for(char c:expression.toCharArray()){
            if(c == ',' || c == '('){
                //ignore commas and opening parenthesis
                continue;
            }
            else if(c == 't' || c == 'f' || c == '!' || c == '&' || c == '|'){
                //push boolean values and operators
                st.push(c);
            } 
            else if(c == ')'){
                List<Character> sb = new ArrayList<>();
                //pop all characters until we reach an operator
                while(st.peek() != '!' && st.peek() != '&' && st.peek() != '|'){
                    sb.add(st.pop());
                }
                //pop operator
                char operator = st.pop();
                
                //checking based on operator
                boolean result;
                if(operator == '!'){
                    result = sb.get(0) == 'f';
                } 
                else if(operator == '&'){
                    result = sb.stream().allMatch(ch -> ch == 't');
                } 
                else{ //operator == '|'
                    result = sb.stream().anyMatch(ch -> ch == 't');
                }
                //push the result back to the stack
                st.push(result ? 't' : 'f');
            }
        }
        return st.pop() == 't';
    }
}
