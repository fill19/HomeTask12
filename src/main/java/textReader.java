import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class textReader {
    private List<String> countingOfWords;
    private List<String> badWords;
    private final List<String> checkingOfWords;
    private static final int sizeOfWord = 3;

    public textReader(final String textPath, final String badWordsPath) {

        countingOfWords = getCountingOfWords(textPath);
        badWords = getBadWords(badWordsPath);
        checkingOfWords = new ArrayList<>();
        checkingOfWords.addAll(countingOfWords);


    }

    private List<String> getCountingOfWords(String textPath) {
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(textPath))) {
            String temp;
            while (scanner.hasNext()) {
                temp = scanner.next().replaceAll("[(),. !?]", "").toLowerCase();
                list.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file found." + textPath);
        }
        return list;
    }


    private List<String> getBadWords(String badWordsPath) {
        return badWords = getCountingOfWords(badWordsPath);


    }

    public final int getInitAmountOfWords() {
        return countingOfWords.size();
    }

    public final int getAmountOfNotValidWords() {
        return sizeOfWord;
    }


    public String[] getExcludedWords() {
        List<String> wrongWords = new ArrayList<>();
        for (String word : countingOfWords) {
            if (word.length() < sizeOfWord || badWords.contains(word)) {
                wrongWords.add(word);

            }
        }

        checkingOfWords.removeAll(wrongWords);
        return wrongWords.toArray(new String[0]);

    }

    public final List<Object> getMostRepetitiveWords(final int n) {
        return Arrays.asList(
                checkingOfWords.stream().collect(
                        Collectors.groupingBy(word -> word, Collectors.counting()))
                        .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .limit(n).toArray());

    }
}

