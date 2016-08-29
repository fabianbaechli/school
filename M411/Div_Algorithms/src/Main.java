import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("String Input");
        String userInput = scanner.next();
        int[] sortArray = new int[userInput.length()];
        for (int i = 0; i < userInput.length(); i++){
            sortArray[i] = (int)userInput.charAt(i);
        }
        long a = 0;
        int[] output = radixSortLSD(sortArray);
        for (int i = 0; i < output.length; i++){
            a = i;
        }
        System.out.println(a);
        */
        bubbleSort();
    }

    public static void bubbleSort() {
        double[] userInput = new double[100000000];
        String userEingabe;
        Scanner zuSortieren = new Scanner(System.in);
        double var;

        System.out.println("Input String");
        userEingabe = zuSortieren.next();
        long temp = 0;
        for (int a = 0; a < userEingabe.length(); a++) {
            userInput[a] = (int) userEingabe.charAt(a);
            temp = a;
        }
        System.out.println("Chars: " + temp);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < userEingabe.length(); i++) {
            for (int c = 0; c < userEingabe.length() - i; c++) {
                if (userInput[c] > userInput[c + 1]) {
                    var = userInput[c];
                    userInput[c] = userInput[c + 1];
                    userInput[c + 1] = var;
                }
            }
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        for (int a = 0; a < userEingabe.length(); a++) {
            System.out.print((char) userInput[a + 1]);
        }
        System.out.println();
        System.out.println("Elapsed Time: " + estimatedTime);
    }

    private static void searchLowestValue(int flag) {
        //if flag = 1 : search for lowest value
        //if flag = 0 : search for highest value

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input String");
        String userInput = scanner.next();
        int[] sort = new int[userInput.length()];

        for (int a = 0; a < userInput.length(); a++) {
            sort[a] = (int) userInput.charAt(a);
        }

        int value = 0;
        if (flag == 1) {
            value = 10000000;
        }

        for (int aSort : sort) {
            if (flag == 1) {
                if (value > aSort) {
                    value = aSort;
                }
            }
            if (flag == 0) {
                if (value < aSort) {
                    value = aSort;
                }
            }
        }
        if (flag == 1) {
            System.out.println("Lowest value: " + (char) value);
        } else {
            System.out.println("Highest value: " + (char) value);
        }
    }

    public static int[] radixSortLSD(int[] old) {
        long startTime = System.currentTimeMillis();
        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
            int[] tmp = new int[old.length];
            int j = 0;

            for (int i = 0; i < old.length; i++) {
                boolean move = old[i] << shift >= 0;

                if (shift == 0 ? !move : move) {
                    tmp[j] = old[i];
                    j++;
                } else {
                    old[i - j] = old[i];
                }
            }

            for (int i = j; i < tmp.length; i++) {
                tmp[i] = old[i - j];
            }

            old = tmp;
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Elapsed Time " + estimatedTime + "ms");
        System.out.println();
        return old;
    }
}
