package main;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Generator {

    /**
     * Returns a randomly generated nicknames based on the given alphabet.
     *
     * @param min minimum number of letters in a nickname.
     * @param max maximum number of letters in a nickname.
     * @return new nickname!
     */
    public static String generate(int min, int max) {
        int length = min + (int) (Math.random() * (max - min));
        StringBuilder nickName = new StringBuilder();
        int vowelsInARow = 0;
        int consonantsInARow = 0;
        for (int i = 0; i < length; i++) {
            String letter = Alphabet.randomLetter();
            if (Alphabet.isVowel(letter)) {
                vowelsInARow++;
                consonantsInARow = 0;
                if (vowelsInARow > 2) {
                    while (Alphabet.isVowel(letter)) {
                        letter = Alphabet.randomLetter();
                    }
                    consonantsInARow = 1;
                    vowelsInARow = 0;
                }
            } else {
                consonantsInARow++;
                vowelsInARow = 0;
                if (consonantsInARow > 2) {
                    while (!Alphabet.isVowel(letter)) {
                        letter = Alphabet.randomLetter();
                    }
                    vowelsInARow = 1;
                    consonantsInARow = 0;
                }
            }
            nickName.append(letter);
        }
        return nickName.substring(0, 1) + nickName.substring(1).toLowerCase(Locale.ROOT);
    }

    /**
     * Returns a randomly generated nicknames based on the given alphabet.
     *
     * @param num the number of times that the same name must be generated to be selected.
     * @param min minimum number of letters in a nickname.
     * @param max maximum number of letters in a nickname.
     * @return new nickname!
     */
    public static String TheChosenOne(int num, int min, int max) {
        Map<String, AtomicInteger> names = new HashMap<>();
        int count = 0;
        String nickName = "";
        while (count < num) {
            nickName = generate(min, max);
            names.putIfAbsent(nickName, new AtomicInteger(0));
            count = names.get(nickName).incrementAndGet();
        }
        return nickName;
    }
}
