package edu.uwp.cs.csci242.assignments.a04.synonyms;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Synonyms {
    private HashMap<String, HashMap<String,Integer>> descriptor;
    private String word1;
    private String word2;

    public Synonyms (URL[] corpus) {
        this.descriptor = new HashMap<>();
        parseCorpus(corpus);
        this.word1 = "";
        this.word2 = "";
    }

    public void parseCorpus (URL[] corpus) {
            try {
                for (int i = 0; i < corpus.length; i++) {
                    // Create a URL and Scanner
                    URL url = corpus[i];

                    // Use a scanner to read the
                    Scanner s = new Scanner(url.openStream());

                    // Set the delimiter for the scanner
                    s.useDelimiter("[\\.\\?\\!]|\\Z");

                    // Read until the end of the URL
                    while (s.hasNext()) {
                        String sentence = s.next().toLowerCase();
                        String[] words = sentence.split("\\s+");

                        for (int j = 1; j < words.length; j++) {
                            String wordForEach = words[j].replaceAll("\\W+", "");
                            if (!descriptor.containsKey(wordForEach)) {
                                descriptor.put(wordForEach, new HashMap<String, Integer>());
                            }

                            for (int k = 1; k < words.length; k++) {
                                String otherWords = words[k].replaceAll("\\W+", "");
                                if (!wordForEach.equals(otherWords)) {
                                    if (!descriptor.get(wordForEach).containsKey(otherWords)) {
                                        descriptor.get(wordForEach).put(otherWords, 1);
                                    }
                                    else {
                                        int value = descriptor.get(wordForEach).get(otherWords);
                                        descriptor.get(wordForEach).put(otherWords, value + 1);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public double calculateCosineSimilarity (String word1, String word2) {
        HashMap<String, Integer> word1Map = descriptor.get(word1);
        HashMap<String, Integer> word2Map = descriptor.get(word2);

        double numerator = 0;
        double denominator = 0;
        double finalResult = 0;

        if (word1Map == null || word2Map == null) {
            return -1;
        }
        else {
            Set<String> word1Set = word1Map.keySet();
            Set<String> word2Set = word2Map.keySet();

            Iterator<String> itr1ForWord1 = word1Set.iterator();
            Iterator<String> itr1ForWord2 = word2Set.iterator();

            while (itr1ForWord1.hasNext() && itr1ForWord2.hasNext()) {
                String key1 = itr1ForWord1.next();
                String key2 = itr1ForWord2.next();
                numerator += word1Map.getOrDefault(key1, 0) * word2Map.getOrDefault(key2, 0);
            }

            Iterator<String> itr2ForWord1 = word1Set.iterator();
            double denom1 = 0;
            while (itr2ForWord1.hasNext()) {
                String key = itr2ForWord1.next();
                denom1 += Math.pow(word1Map.getOrDefault(key, 0), 2);
            }

            Iterator<String> itr2ForWord2 = word2Set.iterator();
            double denom2 = 0;
            while (itr2ForWord2.hasNext()) {
                String key = itr2ForWord2.next();
                denom2 += Math.pow(word2Map.getOrDefault(key, 0), 2);
            }

            denominator = denom1 + denom2;
            finalResult = numerator / denominator;

            return finalResult;
        }
    }

    public String getWord1() {
        return word1;
    }

    public String getWord2() {
        return word2;
    }

    public void setWord1(String word1) {
        this.word1 = word1;
    }

    public void setWord2(String word2) {
        this.word2 = word2;
    }

    public static void main(String[] args) throws MalformedURLException {
        URL[] corpus = {
                // Pride and Prejudice, by Jane Austen
                new URL ( "https://www.gutenberg.org/files/1342/1342-0.txt" ),
                // The Adventures of Sherlock Holmes, by A. Conan Doyle
                new URL ( "http://www.gutenberg.org/cache/epub/1661/pg1661.txt" ),
                // A Tale of Two Cities, by Charles Dickens
                new URL ( "https://www.gutenberg.org/files/98/98-0.txt" ),
                // Alice's Adventures In Wonderland, by Lewis Carroll
                new URL ( "https://www.gutenberg.org/files/11/11-0.txt" ),
                // Moby Dick; or The Whale, by Herman Melville
                new URL ( "https://www.gutenberg.org/files/2701/2701-0.txt" ),
                // War and Peace, by Leo Tolstoy
                new URL ( "https://www.gutenberg.org/files/2600/2600-0.txt" ),
                // The Importance of Being Earnest, by Oscar Wilde
                new URL ( "http://www.gutenberg.org/cache/epub/844/pg844.txt" ),
                // The Wisdom of Father Brown, by G.K. Chesterton
                new URL ( "https://www.gutenberg.org/files/223/223-0.txt" ),
        };

        Synonyms synonyms = new Synonyms(corpus);
        synonyms.parseCorpus(corpus);

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = keyboard.nextLine();
        System.out.print("Enter choices: ");
        String choices = keyboard.nextLine();
        String[] choiceGroup = choices.toLowerCase().split("\\s+");
        double[] cosineGroup = new double[choiceGroup.length];

        for (int i = 0; i < choiceGroup.length; i++) {
            synonyms.setWord1(word.toLowerCase());
            synonyms.setWord2(choiceGroup[i]);

            cosineGroup[i] = synonyms.calculateCosineSimilarity(synonyms.getWord1(), synonyms.getWord2());

            System.out.println(synonyms.getWord2() + " " + cosineGroup[i]);
        }

        double currentMax = cosineGroup[0];
        int indexOfMax = 0;

        for (int i = 1; i < cosineGroup.length; i++) {
            if(cosineGroup[i] > currentMax) {
                currentMax = cosineGroup[i];
                indexOfMax = i;
            }
        }

        System.out.println(choiceGroup[indexOfMax]);
    }
}