# LINKED LIST

+ [Reverse linked list](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
<!---->

## Reverse linked list

https://leetcode.com/problems/reverse-linked-list/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setNewSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testReverseList() {
        ListNode expected = ListNodeHandler.buildList(List.of(1, 0, 0, 0));
        assertEquals(expected, solution.reverseList(ListNodeHandler.buildList(List.of(0, 0, 0, 1))));
    }

    @Test
    void testNullHead() {
        assertNull(solution.reverseList(null));
    }
```

```java
class ListNodeHandler{
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java

public ListNode reverseList(ListNode head) {
        return helper(head, null);
        }

public ListNode helper(ListNode head, ListNode prev){
        if(head == null) return prev;
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        return helper(next, prev);
        }
}
```


## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testMiddleNode() {
        ListNode expect = buildList(List.of(3,4,5));
        assertEquals(expect, solution.middleNode(ListNodeHandler.buildList(List.of(1,2,3,4,5))));
    }

    @Test
    void testTwoMiddleNodes() {
        ListNode expect = buildList(List.of(4, 5, 6));
        assertEquals(expect, solution.middleNode(ListNodeHandler.buildList(List.of(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void testNullHead() {
        assertNull(solution.middleNode(null));
    }
```

```java
class ListNodeHandler{
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java

public ListNode middleNode(ListNode head) {

        ListNode s = head;
        ListNode f = head;
        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
```


## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testIsPalindrome() {
        assertTrue(solution.isPalindrome(ListNodeHandler.buildList(List.of(3))));
    }

    @Test
    void testIsNotPalindrome(){
        assertFalse(solution.isPalindrome(ListNodeHandler.buildList(List.of(100, 2, 10, 20))));
    }

    @Test
    void testNullList(){
        assertTrue(solution.isPalindrome(ListNodeHandler.buildList(List.of())));
    }
    
}
```
```java
class ListNodeHandler{
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java

class Solution {

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
```


