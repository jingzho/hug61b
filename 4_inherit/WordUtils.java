/** 
 * @param strList (an SLList of strings)
 * @return the longest string in the list
 * @author JingZhou
*/

public class WordUtils {
  public static String longest(SLList<String> strList) {
    String longestStr;
    String thisStr;
    int longestIndex = 0;
    for (int i = 0; i < strList.size(); i++) {
      longestStr = strList.get(longestIndex);
      thisStr = strList.get(i);
      if (thisStr.length() > longestStr.length()){
        longestIndex = i;
      }
    }
    return strList.get(longestIndex);
  } 

  public static void main(String[] args) {
    SLList<String> a = new SLList<>();
    a.addLast("ccccc");
    a.addLast("bb");
    a.addLast("aaa");
    System.out.println(longest(a));
  }
}