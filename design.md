# DESIGN

+ [Min Stack](#min-stack)
+ [Implement Stack using Queues](#implement-stack-using-queues)
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
```

## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/

<details>
    <summary> Test Cases </summary>

``` java
package com.github.stack;

import org.junit.Ignore;
import org.junit.Test;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetcodeSolutionTest {
private LeetcodeSolution solution;
import static org.junit.Assert.*;
import org.junit.Test;

    public class ImplementStackUsingQueuesTest {

        @Test
        public void test1() {
            ImplementStackUsingQueues myStack = new ImplementStackUsingQueues();

            myStack.push(1);
            myStack.push(2);
            assertEquals(2, myStack.top()); // return 2
            assertEquals(2, myStack.pop()); // return 2
            assertFalse(myStack.empty()); // return False
        }

        @Test
        public void test2() {
            ImplementStackUsingQueues myStack = new ImplementStackUsingQueues();

            myStack.push(1);
            assertEquals(1, myStack.pop());
            assertTrue(myStack.empty()); // return False
        }

        @Test
        public void test3() {
            MyStack myStack = new MyStack();

            myStack.push(1);
            myStack.push(2);
            assertEquals(2, myStack.top()); // return 2
            assertEquals(2, myStack.pop()); // return 2
            assertFalse(myStack.empty()); // return False
        }

        @Test
        public void test4() {
            MyStack myStack = new MyStack();

            myStack.push(1);
            assertEquals(1, myStack.pop());
            assertTrue(myStack.empty()); // return False
        }
    }}
```

</details>

```java


cimport java.util.LinkedList;

public class ImplementStackUsingQueues {

	private LinkedList<Integer> firstQueue;
	private LinkedList<Integer> secondQueue;

	
	public ImplementStackUsingQueues() {
		firstQueue = new LinkedList<>();
		secondQueue = new LinkedList<>();
	}


	public void push(int x) {
		if(empty()) {
			firstQueue.offer(x);
			return;
		}
		
		if (!firstQueue.isEmpty())
			firstQueue.offer(x);
		else
			secondQueue.offer(x);
	}

	
	public int pop() {
		if (empty())
			throw new RuntimeException("Stack is empty");

		if(firstQueue.isEmpty()) {
			while(secondQueue.size() > 1) {
				firstQueue.offer(secondQueue.poll());
			}
			return secondQueue.poll();
		}else {
			while(firstQueue.size() > 1) {
				secondQueue.offer(firstQueue.poll());
			}
			return firstQueue.poll();
		}
	}

	
	public int top() {
		if (empty())
			throw new RuntimeException("Stack is empty");
		if(firstQueue.isEmpty()) {
			while(secondQueue.size() > 1) {
				firstQueue.offer(secondQueue.poll());
			}
			Integer temp = secondQueue.poll();
			firstQueue.offer(temp);
			return temp;
		}else {
			while(firstQueue.size() > 1) {
				secondQueue.offer(firstQueue.poll());
			}
			Integer temp = firstQueue.poll();
			secondQueue.offer(temp);
			return temp;
		}
	}


	public boolean empty() {
		return firstQueue.isEmpty() && secondQueue.isEmpty();
	}
}


