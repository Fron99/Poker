package managements;

import basicsClasses.CardImpl;
import basicsClasses.PlayerImpl;
import basicsClasses.TableImpl;
import enums.Genders;

import java.sql.*;
import java.util.GregorianCalendar;

public class ManagementPoker {

    /**
     * This method return connection with database
     * @return Return connection
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
     * Check if the user with the password exists
     * @param username Username
     * @param password Password
     * @param connection Connection where to check
     * @return Return True if exist or False if not exist
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
            assert user != null;
            user.close();
            sentence.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return exist;
    }

    /**
     * @param username The player's user
     * @param connection Connection where to get
     * @return Return the player from the bbdd
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
            assert user != null;
            user.close();
            sentence.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return player;
    }

    /**
     * Returns a random player from the database
     * @param connection Connection to execute query
     * @return Return Random user from the database
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
            assert user != null;
            user.close();
            sentence.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return player;
    }

    /**
     * Create a new poker play and retutn int with ID of new poker play
     * @param connection Connection to execute insert
     * @return Return int with ID of new poker play
     */

    public int createNewPokerPlay(Connection connection){
        Statement sentence = null;
        ResultSet pokerPlay = null;
        int ID = 0;

        String select = "DECLARE @ID INT " +
                        "EXECUTE @ID = insertNewPokerPlay " +
                        "SELECT @ID AS ID";

        try {
            sentence = connection.createStatement();
            pokerPlay = sentence.executeQuery(select);
            while (pokerPlay.next()) {
                ID = pokerPlay.getInt("ID");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            assert pokerPlay != null;
            pokerPlay.close();
            sentence.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ID;
    }

    /**
     * Generate insert for userPokerPlays
     * @param table Table to get info
     * @param IDPokerPlay ID of pokerPlay
     * @return Return String with insert
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
     * Generate insert for WinnersPoker
     * @param table Table to get info
     * @param IDPokerPlay ID of pokerPlay
     * @return Return String with insert
     */

    public String generateInsertWinnersPoker(TableImpl table, int IDPokerPlay){

        String insert = "INSERT INTO WinnersPoker(IDPlay,UsernameUser,TotalWin) VALUES ";
        int[] winners = table.calculateWinningsForPlayer();
        int amountOfWinners = 0;

        for (int i : winners){
            if (i > 0){
                amountOfWinners++;
            }
        }

        for (int i = 0, countWinners = 0; i < winners.length; i++){

            if (winners[i] != 0){
                if (countWinners < amountOfWinners-1){
                    //Corregir bug cuando hay mas de 1 ganador, no se hace bien el insert
                    insert += "("+IDPokerPlay+",'"+table.getUsernamePlayer(i)+"',"+winners[i]+"),";
                }else{
                    insert += "("+IDPokerPlay+",'"+table.getUsernamePlayer(i)+"',"+winners[i]+")";
                }
                countWinners++;
            }

        }
        return insert;
    }

    /**
     * Insert the final values in database
     * @param table Table to get info
     * @param connection Connection to execute inserts
     * @return Return True if the inserts execute correctly, False if the inserts failure
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
            assert sentence != null;
            sentence.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return inserted;
    }

}
