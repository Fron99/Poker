package tests;

import basicsClasses.CardImpl;
import basicsClasses.PlayerImpl;
import basicsClasses.TableImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableImplTest {

    @Test
    public void testGetBaraja() {

        CardImpl[] baraja = new CardImpl[52];
        for (int i = 0;i<baraja.length;i++){
            baraja[i] = new CardImpl('P',"K");
        }

        PlayerImpl[] jugadores = new PlayerImpl[5];
        for (int i = 0;i<jugadores.length;i++){
            jugadores[i] = new PlayerImpl();
        }

        CardImpl[] cartasMesa = new CardImpl[5];
        for (int i = 0;i<cartasMesa.length;i++){
            cartasMesa[i] = new CardImpl();
        }

        TableImpl mesa = new TableImpl(baraja,jugadores,cartasMesa);

        assertArrayEquals(mesa.getDeckOfCards(),baraja);

        CardImpl[] barajacopia = mesa.getDeckOfCards();
        barajacopia[5] = new CardImpl('P',"A");
        assertNotEquals(barajacopia[5],mesa.getDeckOfCards()[5]);


    }

    @Test
    public void testGetCartaBaraja() {

        CardImpl[] baraja = new CardImpl[52];
        for (int i = 0;i<baraja.length;i++){
            baraja[i] = new CardImpl('Q',"14");
        }

        PlayerImpl[] jugadores = new PlayerImpl[5];
        for (int i = 0;i<jugadores.length;i++){
            jugadores[i] = new PlayerImpl();
        }

        CardImpl[] cartasMesa = new CardImpl[5];
        for (int i = 0;i<cartasMesa.length;i++){
            cartasMesa[i] = new CardImpl();
        }

        TableImpl mesa = new TableImpl(baraja,jugadores,cartasMesa);

        assertEquals(mesa.getCardOfDeskOfCards(0),baraja[0]);

    }


    @Test
    public void testGetJugadores() {

        CardImpl[] baraja = new CardImpl[52];
        for (int i = 0;i<baraja.length;i++){
            baraja[i] = new CardImpl('Q',"14");
        }

        PlayerImpl[] jugadores = new PlayerImpl[5];
        for (int i = 0;i<jugadores.length;i++){
            jugadores[i] = new PlayerImpl();
        }

        CardImpl[] cartasMesa = new CardImpl[5];
        for (int i = 0;i<cartasMesa.length;i++){
            cartasMesa[i] = new CardImpl();
        }

        TableImpl mesa = new TableImpl(baraja,jugadores,cartasMesa);

        assertArrayEquals(mesa.getPlayers(),jugadores);

    }


    @Test
    public void testRestaurarBaraja() {

        TableImpl mesa = new TableImpl();

        CardImpl[] barajaTest = new CardImpl[52];
        barajaTest[0] = new CardImpl('P', "A");
        barajaTest[1] = new CardImpl('P', "2");
        barajaTest[2] = new CardImpl('P', "3");
        barajaTest[3] = new CardImpl('P', "4");
        barajaTest[4] = new CardImpl('P', "5");
        barajaTest[5] = new CardImpl('P', "6");
        barajaTest[6] = new CardImpl('P', "7");
        barajaTest[7] = new CardImpl('P', "8");
        barajaTest[8] = new CardImpl('P', "9");
        barajaTest[9] = new CardImpl('P', "10");
        barajaTest[10] = new CardImpl('P', "J");
        barajaTest[11] = new CardImpl('P', "Q");
        barajaTest[12] = new CardImpl('P', "K");

        barajaTest[13] = new CardImpl('C', "A");
        barajaTest[14] = new CardImpl('C', "2");
        barajaTest[15] = new CardImpl('C', "3");
        barajaTest[16] = new CardImpl('C', "4");
        barajaTest[17] = new CardImpl('C', "5");
        barajaTest[18] = new CardImpl('C', "6");
        barajaTest[19] = new CardImpl('C', "7");
        barajaTest[20] = new CardImpl('C', "8");
        barajaTest[21] = new CardImpl('C', "9");
        barajaTest[22] = new CardImpl('C', "10");
        barajaTest[23] = new CardImpl('C', "J");
        barajaTest[24] = new CardImpl('C', "Q");
        barajaTest[25] = new CardImpl('C', "K");

        barajaTest[26] = new CardImpl('R', "A");
        barajaTest[27] = new CardImpl('R', "2");
        barajaTest[28] = new CardImpl('R', "3");
        barajaTest[29] = new CardImpl('R', "4");
        barajaTest[30] = new CardImpl('R', "5");
        barajaTest[31] = new CardImpl('R', "6");
        barajaTest[32] = new CardImpl('R', "7");
        barajaTest[33] = new CardImpl('R', "8");
        barajaTest[34] = new CardImpl('R', "9");
        barajaTest[35] = new CardImpl('R', "10");
        barajaTest[36] = new CardImpl('R', "J");
        barajaTest[37] = new CardImpl('R', "Q");
        barajaTest[38] = new CardImpl('R', "K");

        barajaTest[39] = new CardImpl('T', "A");
        barajaTest[40] = new CardImpl('T', "2");
        barajaTest[41] = new CardImpl('T', "3");
        barajaTest[42] = new CardImpl('T', "4");
        barajaTest[43] = new CardImpl('T', "5");
        barajaTest[44] = new CardImpl('T', "6");
        barajaTest[45] = new CardImpl('T', "7");
        barajaTest[46] = new CardImpl('T', "8");
        barajaTest[47] = new CardImpl('T', "9");
        barajaTest[48] = new CardImpl('T', "10");
        barajaTest[49] = new CardImpl('T', "J");
        barajaTest[50] = new CardImpl('T', "Q");
        barajaTest[51] = new CardImpl('T', "K");

        mesa.restoreDeskOfCards();

        assertArrayEquals(mesa.getDeckOfCards(),barajaTest);

    }

    @Test
    public void getDeckOfCards() {
    }

    @Test
    public void getCardOfDeskOfCards() {
    }

    @Test
    public void getNumberOfCardOfDesk() {
    }

    @Test
    public void getSuitOfCardOfDesk() {
    }

    @Test
    public void getPlayers() {
    }

    @Test
    public void getPlayer() {
    }

    @Test
    public void setPlayer() {
    }

    @Test
    public void getUsernamePlayer() {
    }

    @Test
    public void setUsernamePlayer() {
    }

    @Test
    public void getPasswordPlayer() {
    }

    @Test
    public void setPasswordPlayer() {
    }

    @Test
    public void getNamePlayer() {
    }

    @Test
    public void setNamePlayer() {
    }

    @Test
    public void getSurnamePlayer() {
    }

    @Test
    public void setSurnamePlayer() {
    }

    @Test
    public void getGenderPlayer() {
    }

    @Test
    public void setGenderPlayer() {
    }

    @Test
    public void getEmailPlayer() {
    }

    @Test
    public void setEmailPlayer() {
    }

    @Test
    public void getIBANPlayer() {
    }

    @Test
    public void setIBANPlayer() {
    }

    @Test
    public void getBirthdayPlayer() {
    }

    @Test
    public void getBalancePlayer() {
    }

    @Test
    public void setBalancePlayer() {
    }

    @Test
    public void setCardsPlayer() {
    }

    @Test
    public void testSetCardsPlayer() {
    }

    @Test
    public void getCardPlayer() {
    }

    @Test
    public void getSuitCardPlayer() {
    }

    @Test
    public void getNumberCardPlayer() {
    }

    @Test
    public void getActivePlayer() {
    }

    @Test
    public void getCardsOfTable() {
    }

    @Test
    public void setCardsOfTable() {
    }

    @Test
    public void getCardTable() {
    }

    @Test
    public void getNumberCardTable() {
    }

    @Test
    public void getSuitCardTable() {
    }

    @Test
    public void getBetsPlayers() {
    }

    @Test
    public void getBetsPlayer() {
    }

    @Test
    public void getBetPlayer() {
    }

    @Test
    public void getTotalAllBets() {
    }

    @Test
    public void getRound() {
    }

    @Test
    public void restoreTable() {
    }

    @Test
    public void restoreCardsTable() {
    }

    @Test
    public void restoreDeskOfCards() {
    }

    @Test
    public void restoreBets() {
    }

    @Test
    public void generateBots() {
    }

    @Test
    public void generateThreeCardsToTable() {
    }

    @Test
    public void generateCardsPlayers() {
    }

    @Test
    public void generateCardTable() {
    }

    @Test
    public void depositBalanceWinnerAndShowWinner() {
    }

    @Test
    public void increaseTurn() {
    }

    @Test
    public void showPanelPlay() {
    }

    @Test
    public void doBet() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testClone() {
    }
}