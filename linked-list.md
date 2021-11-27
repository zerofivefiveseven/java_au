# LINKED LIST

+ [Reverse linked list](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
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


public ListNode frontPointer;

public boolean recursivelyCheck(ListNode currentNode) {
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

```




## Merge Two Sorted Lists

https://leetcode.com/problems/merge-two-sorted-lists/

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
    void testMergeTwoLists() {
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 2));
        ListNode l2 = ListNodeHandler.buildList(List.of(3, 4));
        ListNode res = ListNodeHandler.buildList(List.of(1, 2, 3, 4));
        assertEquals(res, solution.mergeTwoLists(l1, l2));
    }

    @Test
    void testMergeOneList() {
        ListNode l2 = ListNodeHandler.buildList(List.of(3, 4));
        ListNode res = ListNodeHandler.buildList(List.of(3, 4));
        assertEquals(res, solution.mergeTwoLists(null, l2));
    }

    @Test
    void testMergeEqualLists() {
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 2, 3));
        ListNode res = ListNodeHandler.buildList(List.of(1, 1, 2, 2, 3, 3));
        assertEquals(res, solution.mergeTwoLists(l1, l1));
    }
    
    @Test
    void testMergeTwoLists() {
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 2, 4));
        ListNode l2 = ListNodeHandler.buildList(List.of(1, 3, 4));
        ListNode res = ListNodeHandler.buildList(List.of(1, 1, 2, 3, 4, 4));
        assertEquals(res, solution.mergeTwoLists(l1, l2));
    }

}

```
```java
class ListNodeHandler {
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

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode node = new ListNode();
    ListNode head = node;
    while (l1!=null && l2!=null){
        if(l1.val<=l2.val){
            node.next = l1;
            l1 = l1.next;
        } else {
            node.next = l2;
            l2 = l2.next;
        }
        node = node.next;
    }

    if(l1 != null){
        node.next = l1;
    }
    if(l2 != null){
        node.next = l2;
    }
    return head.next;
}

```


## Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

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
    void testGetIntersectionNode() {
        ListNode l1 = ListNodeHandler.buildList(List.of(2, 3, 4));
        ListNode l2 = ListNodeHandler.buildList(List.of(5, 6));
        assertEquals(null, solution.getIntersectionNode(l1, l2));
    }

    @Test
    void testGetIntersectionNode2() {
        ListNode l1 = ListNodeHandler.buildList(List.of(6, 7, 8));
        ListNode l2 = ListNodeHandler.buildList(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        assertEquals(6, solution.getIntersectionNode(l1, l2));
    }


}
```
```java

class ListNodeHandler {
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

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    ListNode currentA = headA;
    if(headA==null || headB==null) return null;
    while(currentA!=null){
        ListNode   currentB=headB;
        if(currentA==currentB) return currentA;
        while(currentB.next!=null && currentB.next!=currentA) currentB=currentB.next;
        if(currentB.next==null) currentA=currentA.next;
        else return currentA;
    }
    return currentA;
}

```


## Merge Sort

https://leetcode.com/problems/sort-list/

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
    void testSortList() {
        ListNode l1 = ListNodeHandler.buildList(List.of(4, 2, 1, 3));
        ListNode res = ListNodeHandler.buildList(List.of(1, 2, 3, 4));
        assertEquals(res, solution.sortList(l1));
    }
    
    @Test
    void testSortList() {
        ListNode l1 = ListNodeHandler.buildList(List.of(-1,5,3,4,0));
        ListNode res = ListNodeHandler.buildList(List.of(-1,0,3,4,5));
        assertEquals(res, solution.sortList(l1));
    }

    @Test
    void testSortNullList() {
        assertNull(solution.sortList(null));
    }

    @Test
    void testSortEqList() {
        ListNode res = ListNodeHandler.buildList(List.of(1, 1, 1, 1));
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 1, 1, 1));
        assertEquals(res, solution.sortList(l1));
    }

}
```
```java

class ListNodeHandler {
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

public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
        return head;

        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
        }
ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
        } else {
        p.next = l2;
        l2 = l2.next;
        }
        p = p.next;
        }

        if (l1 != null)
        p.next = l1;

        if (l2 != null)
        p.next = l2;

        return l.next;
        }

```