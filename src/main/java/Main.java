public class Main {

    public static void main(String[] args) {

        //Ad. 8:
        String[] drzewa = {"brzoza", "modrzew", "grab", "buk", "wierzba"};

        for (String drzewo : drzewa) {
            System.out.println(drzewo);
        }

        System.out.println("---");

        printWithGenericType(drzewa);

        System.out.println("===");

        //Ad.9

        System.out.println(StringComparer.compare("RAMA", "MARA"));

        System.out.println("===");

        //Ad.17
        AdultChecker.checkIfAdult("21231900001");

        System.out.println("===");


    }

    private static <T> void printWithGenericType(T[] arr) {
        for (T element : arr) {
            System.out.println(element);
        }
    }

    private static void print(String... args) {
        for (String word : args) {
            System.out.println(word);
        }
    }


}
