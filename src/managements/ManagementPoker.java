package managements;

import basicsClasses.CardImpl;
import basicsClasses.PlayerImpl;
import basicsClasses.TableImpl;
import enums.Genders;

import java.sql.*;
import java.util.GregorianCalendar;

public class ManagementPoker {

    /**
     * @return
     */

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

    /**
     * @param username
     * @param connection
     * @return
     */

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

    /**
     * @param connection
     * @return
     */

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

    /**
     * @param connection
     * @return
     */

    public int createNewPokerPlay(Connection connection){
        Statement sentence = null;
        ResultSet pokerPlay = null;
        int ID = 0;

        String select = "DECLARE @ID INT\n" +
                        "EXECUTE @ID = insertNewPokerPlay\n" +
                        "SELECT @ID AS ID";

        try {
            sentence = connection.createStatement();
            pokerPlay = sentence.executeQuery(select);
            while (pokerPlay.next()) {
                ID = pokerPlay.getInt("ID");
            }
            System.out.println(ID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            pokerPlay.close();
            sentence.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ID;
    }

    /**
     * @param table
     * @param IDPokerPlay
     * @return
     */

    public String generateInsertUsersPokerPlays(TableImpl table, int IDPokerPlay){
        String insert = "INSERT INTO UsersPokerPlays(UsernameUser,IDPlay,TotalBet,TotalPoints) VALUES ";
        int[] pointsForPlayers = table.calculatePointsForPlayer();
        for (int i = 0; i < table.getPlayers().length; i++){

            if (i != 4){
                insert += "('"+table.getUsernamePlayer(i)+"',"+IDPokerPlay+","+table.getTotalBetPlayer(i)+","+pointsForPlayers[i]+"),";
            }else{
                insert += "('"+table.getUsernamePlayer(i)+"',"+IDPokerPlay+","+table.getTotalBetPlayer(i)+","+pointsForPlayers[i]+")";
            }

        }
        return insert;
    }

    /**
     * @param table
     * @param IDPokerPlay
     * @return
     */

    public String generateInsertWinnersPoker(TableImpl table, int IDPokerPlay){

        String insert = "INSERT INTO WinnersPoker(IDPlay,UsernameUser,TotalWin) VALUES ";
        int[] winners = table.calculateWinningsForPlayer();
        for (int i = 0; i < winners.length; i++){

            if (winners[i] != 0){

                if (i != 4){
                    insert += "('"+IDPokerPlay+"',"+table.getUsernamePlayer(i)+","+winners[i]+"),";
                }else{
                    insert += "('"+IDPokerPlay+"',"+table.getUsernamePlayer(i)+","+winners[i]+")";
                }

            }

        }
        return insert;
    }

    /**
     * @param table
     * @param connection
     * @return
     */
    
    public boolean insertFinalStadistic(TableImpl table, Connection connection){
        boolean inserted = false;
        Statement sentence = null;

        int IDPokerPlay = createNewPokerPlay(connection);
        String insertUsersPokerPlays = generateInsertUsersPokerPlays(table, IDPokerPlay);
        String insertWinnersPoker = generateInsertWinnersPoker(table, IDPokerPlay);

        try {
            sentence = connection.createStatement();
            inserted = ( sentence.executeUpdate(insertUsersPokerPlays) == 5 && sentence.executeUpdate(insertWinnersPoker) > 0);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            sentence.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return inserted;
    }

}
