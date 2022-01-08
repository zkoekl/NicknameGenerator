package main;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hey, ");
        GenerateRandom10();
        System.out.print(Generator.TheChosenOne(3, 7, 7));
    }

    public static void GenerateRandom10() {
        for (int j = 0; j < 10; j++) {
            System.out.print(Generator.generate(5, 7) + ", ");
        }
        System.out.println(Generator.generate(5, 7));
    }

}
