package validations;

import java.util.Scanner;

public class Validations {

    /**
     * @return
     */

    public boolean readAndValidateContinuePlaying(){
        Scanner sc = new Scanner(System.in);
        char caracter;
            do {
                System.out.print("Insert 'S' if want continue playing or 'N' if want leave of table game: ");
                caracter = Character.toUpperCase(sc.next().charAt(0));
            }while (caracter != 'S' && caracter != 'N');
        return caracter == 'S';
    }

    /**
     * @return
     */

    public int readAndValidateGame(){
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("0.- Leave");
            System.out.println("1.- Play poker");
            System.out.println("2.- Play roulette");
            System.out.print("Insert option: ");
            option = sc.nextInt();
        }while (option < 0 || option > 2);
        return option;
    }

}
