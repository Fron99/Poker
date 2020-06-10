package managements;

import basicsClasses.CardImpl;
import basicsClasses.PlayerImpl;
import enums.Genders;

import java.sql.*;
import java.util.GregorianCalendar;

public class ManagementPoker {

    public Connection getConnection(){
        String sourceURL = "jdbc:sqlserver://localhost:1433;database=PokerAuto";
        String usernameBBDD = "UserJava";
        String passwordBBDD = "newPassUser";
        Connection connectionDataBase = null;

        try {
            connectionDataBase = DriverManager.getConnection(sourceURL, usernameBBDD, passwordBBDD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connectionDataBase;
    }

    /**
     * @param username
     * @param password
     * @param connection
     * @return
     */


    public boolean existUser(String username, String password, Connection connection){

        Statement sentence = null;
        ResultSet user = null;
        boolean exist = false;

        String select = "SELECT Username " +
                        "FROM Users " +
                        "WHERE Username = '"+username+"' AND Password = '"+password+"'";

        try {
            sentence = connection.createStatement();
            user = sentence.executeQuery(select);
            exist = user.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            user.close();
            sentence.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return exist;
    }

    public PlayerImpl getUser(String username, Connection connection){
        PlayerImpl player = null;

        Statement sentence = null;
        ResultSet user = null;
        String usernameRead, passwordRead, nameRead, surnameRead, emailRead, IBANRead;
        Genders genderRead;
        GregorianCalendar birthdayRead;
        int balanceRead;
        int day, month, year;
        String dateString;
        CardImpl[] cards = new CardImpl[2];
        cards[0] = new CardImpl();
        cards[1] = new CardImpl();

        String select = "SELECT Username, [Password], [Name], [Surname], Gender, Birthday, Balance, Email, IBAN" +
                " FROM Users " +
                "WHERE Username = '"+username+"'";

        try {
            sentence = connection.createStatement();
            user = sentence.executeQuery(select);
            while (user.next()){
                usernameRead = user.getString("Username");
                passwordRead = user.getString("Password");
                nameRead = user.getString("Name");
                surnameRead = user.getString("Surname");
                genderRead = Genders.valueOf(user.getString("Gender"));
                emailRead = user.getString("Email");
                IBANRead = user.getString("IBAN");
                dateString = user.getString("Birthday");
                day = Integer.parseInt(dateString.split("-")[2].substring(0,2));
                month = Integer.parseInt(dateString.split("-")[1]);
                year = Integer.parseInt(dateString.split("-")[0]);
                birthdayRead = new GregorianCalendar(year,month,day);
                balanceRead = user.getInt("Balance");

                player = new PlayerImpl(usernameRead, passwordRead, nameRead, surnameRead, genderRead, emailRead, IBANRead, birthdayRead, balanceRead,cards);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            user.close();
            sentence.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return player;
    }

    public PlayerImpl getRandomUser(Connection connection){
        PlayerImpl player = null;

        Statement sentence = null;
        ResultSet user = null;
        String usernameRead, passwordRead, nameRead, surnameRead, emailRead, IBANRead;
        Genders genderRead;
        GregorianCalendar birthdayRead;
        int balanceRead;
        int day, month, year;
        String dateString;
        CardImpl[] cards = new CardImpl[2];
        cards[0] = new CardImpl();
        cards[1] = new CardImpl();

        String select = "SELECT TOP 1 Username, [Password], [Name], [Surname], Gender, Birthday, Balance, Email, IBAN " +
                        "FROM Users ORDER BY NEWID()";

        try {
            sentence = connection.createStatement();
            user = sentence.executeQuery(select);
            while (user.next()){
                usernameRead = user.getString("Username");
                passwordRead = user.getString("Password");
                nameRead = user.getString("Name");
                surnameRead = user.getString("Surname");
                genderRead = Genders.valueOf(user.getString("Gender"));
                emailRead = user.getString("Email");
                IBANRead = user.getString("IBAN");
                dateString = user.getString("Birthday");
                day = Integer.parseInt(dateString.split("-")[2].substring(0,2));
                month = Integer.parseInt(dateString.split("-")[1]);
                year = Integer.parseInt(dateString.split("-")[0]);
                birthdayRead = new GregorianCalendar(year,month,day);
                balanceRead = user.getInt("Balance");


                player = new PlayerImpl(usernameRead, passwordRead, nameRead, surnameRead, genderRead, emailRead, IBANRead, birthdayRead, balanceRead,cards);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            user.close();
            sentence.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return player;
    }

}
