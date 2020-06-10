package validations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


    /** Read and Validate a Password
     * @return Validate password
     */

    public String readAndValidateUsername(Connection connection){
        Scanner sc = new Scanner(System.in);
        boolean exist = false;
        String username;

        Statement sentence = null;
        ResultSet user = null;

        do {
            System.out.print("Insert the username: ");
            username = sc.next();
            String select = "SELECT Username " +
                            "FROM Users " +
                            "WHERE Username = '"+username+"'";

            try {
                sentence = connection.createStatement();
                user = sentence.executeQuery(select);
                if (!(exist = user.next())){
                    System.out.println("The username don`t exist.");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            finally {
                try {
                    user.close();
                    sentence.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }while (!exist);

        return username;
    }


    /**
     * @return
     */

    public String readAndValidatePassword(){
        Scanner sc = new Scanner(System.in);
        Utils u = new Utils();
        String password;

        do {
            System.out.print("Insert the password: ");
            if ((password = sc.next()).length() < 8){
                System.out.println("The password must be longer than 7 characters");
            }
        }while (password.length() < 8);

        password = u.encriptPassword(password);
        return password;
    }


}
