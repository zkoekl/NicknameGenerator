package main;

import java.util.Arrays;
import java.util.Locale;


public enum Alphabet {

    // You can change the weights to adjust how often the letter appear.
    // The weights of the vowels are set bigger than the consonants, so that the words are read normally.
    A(9), B(6), C(4), D(5), E(9), F(5), G(4), H(3), I(9),
    J(4), K(4), L(6), M(6), N(6), O(9), P(4), Q(5), R(5),
    S(5), T(5), U(8), V(6), W(5), X(4), Y(8), Z(6), WTF(0);

    private static final int totalWeight;

    static {
        totalWeight = Arrays.stream(values()).mapToInt(Alphabet::getWeight).sum();
    }

    private final int weight;

    Alphabet(int weight) {
        this.weight = weight;
    }

    public static String randomLetter() {
        int index = (int) (Math.random() * totalWeight);
        return getByWeightIndex(index).toString();
    }

    public static boolean isVowel(String letter) {
        return A.toString().equals(letter.toUpperCase(Locale.ROOT)) ||
            E.toString().equals(letter.toUpperCase(Locale.ROOT)) ||
            I.toString().equals(letter.toUpperCase(Locale.ROOT)) ||
            O.toString().equals(letter.toUpperCase(Locale.ROOT)) ||
            U.toString().equals(letter.toUpperCase(Locale.ROOT)) ||
            Y.toString().equals(letter.toUpperCase(Locale.ROOT));
    }

    private static Alphabet getByWeightIndex(int index) {
        for (Alphabet letter : values()) {
            if (index < letter.weight) {
                return letter;
            }
            index -= letter.weight;
        }
        return Alphabet.WTF;
    }

    private int getWeight() {
        return weight;
    }

}
