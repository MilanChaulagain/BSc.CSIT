package FileHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VowelConsonantWriter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        FileWriter vowelWriter = null;
        FileWriter consonantWriter = null;

        try {
            vowelWriter = new FileWriter("VOWEL.TXT");
            consonantWriter = new FileWriter("CONSONANT.TXT");

            for (char ch : input.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (isVowel(ch)) {
                        vowelWriter.write(ch);
                    } else {
                        consonantWriter.write(ch);
                    }
                }
            }

            System.out.println("Vowels written to VOWEL.TXT");
            System.out.println("Consonants written to CONSONANT.TXT");

        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        } finally {
            try {
                if (vowelWriter != null) vowelWriter.close();
                if (consonantWriter != null) consonantWriter.close();
                sc.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

