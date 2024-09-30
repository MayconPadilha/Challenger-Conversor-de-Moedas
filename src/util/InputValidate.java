package util;

import java.util.Scanner;

public class InputValidate {

    private static Scanner scan = new Scanner(System.in);

    public int inputNumberValidate(int startWith, int endWith, String question, String messageError) {
        if (startWith > endWith) {
            int tmp = startWith;
            startWith = endWith;
            endWith = tmp;
        }
        int option;
        while (true) {
            try {
                System.out.print(question);
                option = Integer.parseInt(scan.nextLine());
                if (option >= startWith && option <= endWith)
                    return option;
                else
                    throw new IllegalArgumentException();
            } catch (Exception e) {
                System.err.print(messageError);
            }
        }
    }

    public double inputNumberValidate(double startWith, double endWith, String question, String messageError) {
        if (startWith > endWith) {
            double tmp = startWith;
            startWith = endWith;
            endWith = tmp;
        }
        double option;
        while (true) {
            try {
                System.out.print(question);
                option = Double.parseDouble(scan.nextLine().replaceAll(",", "."));
                if (option >= startWith && option <= endWith)
                    return option;
                else
                    throw new IllegalArgumentException();
            } catch (Exception e) {
                System.err.print(messageError);
            }
        }
    }

}
