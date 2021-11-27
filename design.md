# DESIGN

+ [Min Stack](#min-stack)
<!---->

## Min Stack

https://leetcode.com/problems/min-stack/

<details>
    <summary> Test Cases </summary>

``` java
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetcodeSolutionTest {
private LeetcodeSolution solution;

@Test
public void test () {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    // Returns -3.
    System.out.println(minStack.getMin());
    minStack.pop();
    // Returns 0.
    System.out.println(minStack.top());
    // Returns -2.
    System.out.println(minStack.getMin());
}


@Test
public void test1 () {
    MinStack minStack = new MinStack();
    minStack.push(-1);

    // Returns -1.
    System.out.println(minStack.top());
    // Returns -1.
    System.out.println(minStack.getMin());
}

@Test
public void test3 () {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-1);
    // Returns -2.
    System.out.println(minStack.getMin());
    // Returns -1.
    System.out.println(minStack.top());

    minStack.pop();
    // Returns -2.
    System.out.println(minStack.getMin());
}

@Test
public void test4 () {
    MinStack minStack = new MinStack();
    minStack.push(1);
    minStack.push(2);

    System.out.println(minStack.top());
    System.out.println(minStack.getMin());

    minStack.pop();
    System.out.println(minStack.top());

    System.out.println(minStack.getMin());
    System.out.println(minStack.top());
}}
```

</details>

```java


class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;
    
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();}
    
    public void push(int val) {
        stack.push(val);
        if(min.size() == 0 || min.size() > 0 && min.peek() > val) { 
            min.push(val);} 
            else {
            min.push(min.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}


