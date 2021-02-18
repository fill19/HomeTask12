
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args)  {
        textReader wholeSong = new textReader("src/main/resources/resources/wholeSong.txt", "src/main/resources/resources/badWords.txt");

        int initAmountOfWords = wholeSong.getInitAmountOfWords();
        System.out.println("All words " + initAmountOfWords + "\n");

        List<String> wrongWords = Arrays.asList(wholeSong.getExcludedWords());
        int amountExcludedWords = wholeSong.getAmountOfNotValidWords();
        System.out.println("Wrong words: " + amountExcludedWords);
        wrongWords.forEach(System.out::println);


        int amount = new Scanner(System.in).nextInt();
        List<Object> topRepWords = wholeSong.getMostRepetitiveWords(amount);
        System.out.println("\nthe most repetitive words:" + amount  );
        System.out.print(topRepWords);
    }
}
