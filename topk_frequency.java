import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class topk_frequency {
    public static void main(String[] args) {
        String[] test_first;
        test_first = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        
        System.out.println(Arrays.toString(test_first));
        System.out.println(topKFrequentProcessing(test_first, 2));
        
        String[] test_second;
        test_second = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        
        System.out.println(Arrays.toString(test_second));
        System.out.println(topKFrequentProcessing(test_second, 4));
    }

    public static List<String> topKFrequentProcessing(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed().thenComparing(Map.Entry.<String,Long>comparingByKey()))
                .map(Map.Entry::<String,Long>getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
}