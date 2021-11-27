# ARRAY

+ [Squares of a Sorted Array](#squares-of-a-sorted-array)
<!---->

## Squares of a Sorted Array

https://leetcode.com/problems/squares-of-a-sorted-array/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetcodeSolutionTest {
private LeetcodeSolution solution;

@BeforeEach
void setSolution() {
solution = new LeetcodeSolution();
}

@Test
void testSortedSquares() {
int[] arr = new int[]{-4, -1, 0, 3, 10};
int[] expect = new int[]{1, 5, 10, 16, 100};
assertArrayEquals(expect, solution.sortedSquares(arr));
}

@Test
void testNotEquals() {
int[] arr = new int[]{3, 1, 1};
int[] expect = new int[]{1, 1, 1};
assertNotEquals(expect, solution.sortedSquares(arr));
}
```

</details>

```java

public int[] sortedSquares(int[] nums) {
    int sqr[] = new int[nums.length];
    for(int i=0; i<nums.length; i++){
    sqr[i] = nums[i]*nums[i];
    }
    Arrays.sort(sqr);
    return sqr;
}


