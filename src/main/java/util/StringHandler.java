package util;

public class StringHandler {

    public static String firstLetterUpperCase(String word) {

        if(!"".equals(word.trim())){
            String first = word.substring(0, 1).toUpperCase();
            String remain = word.substring(1);
            word = first + remain;
        }

        return word;
    }

}
