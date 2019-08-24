import java.util.*;

public class ListSetDemo {
  
  public static String cleanString(String s) {
    return s.toLowerCase();
  }

  /**  
   * @param inputFileName
   * puts every word from the input file into a list
   * use In to read words from a file. 
  */
  public static List<String> getWords(String inputFileName) {
    List<String> words = new ArrayList<>();
    In in = new In(inputFileName);
    while (!in.isEmpty()) {
      String nextWord = cleanString(in.readString());
      System.out.println(nextWord);
      words.add(nextWord);
    }
    return words;
  }

  /** 
   * @param words
   * counts how many unique words there are in the file. 
  */

  public static int countUniqueWords(List<String> words) {
    Set<String> wordsSet = new HashSet<>();
    for (String word : words) {
      wordsSet.add(word);
    }
    return wordsSet.size();
  }

  /**
   * @param words
   * finds the number of times each target word appears in the word list
  */
  public static Map<String, Integer> collectWordCount(List<String> target, List<String> words) {
    Map<String, Integer> count = new HashMap<>();
    for (String t : target) {
      count.put(t, 0);
    }
    for (String w : words) {
      if (count.containsKey(w)) {
        int oldCount = count.get(w);
        count.put(w, oldCount + 1);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    List<String> w = getWords("test.txt");
    System.out.println(w);
    System.out.println(countUniqueWords(w));

    List<String> t = new ArrayList<>();
    t.add("is");
    t.add("there");
    System.out.println(collectWordCount(t, w));
  }

}