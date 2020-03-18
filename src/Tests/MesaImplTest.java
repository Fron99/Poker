package Tests;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class MesaImplTest {

    @Test
    public void testGetBaraja() {

        CartaImpl[] baraja = new CartaImpl[52];
        for (int i = 0;i<baraja.length;i++){
            baraja[i] = new CartaImpl('Q',"14");
        }

        JugadorImpl[] jugadores = new JugadorImpl[5];
        for (int i = 0;i<jugadores.length;i++){
            jugadores[i] = new JugadorImpl();
        }

        CartaImpl[] cartasMesa = new CartaImpl[5];
        for (int i = 0;i<cartasMesa.length;i++){
            cartasMesa[i] = new CartaImpl();
        }

        MesaImpl mesa = new MesaImpl(baraja,jugadores,cartasMesa);

        assertArrayEquals(mesa.getBaraja(),baraja);

    }

    @Test
    public void testGetCartaBaraja() {

        CartaImpl[] baraja = new CartaImpl[52];
        for (int i = 0;i<baraja.length;i++){
            baraja[i] = new CartaImpl('Q',"14");
        }

        JugadorImpl[] jugadores = new JugadorImpl[5];
        for (int i = 0;i<jugadores.length;i++){
            jugadores[i] = new JugadorImpl();
        }

        CartaImpl[] cartasMesa = new CartaImpl[5];
        for (int i = 0;i<cartasMesa.length;i++){
            cartasMesa[i] = new CartaImpl();
        }

        MesaImpl mesa = new MesaImpl(baraja,jugadores,cartasMesa);

        assertEquals(mesa.getCartaBaraja(0),baraja[0]);

    }

    @Test
    public void testSetBaraja() {

        CartaImpl[] baraja = new CartaImpl[52];
        for (int i = 0;i<baraja.length;i++){
            baraja[i] = new CartaImpl('Q',"14");
        }

        MesaImpl mesa = new MesaImpl();

        mesa.setBaraja(baraja);

        assertArrayEquals(mesa.getBaraja(),baraja);

    }

    @Test
    public void testSetCartaBaraja() {

        MesaImpl mesa = new MesaImpl();

        mesa.setCartaBaraja(new CartaImpl('3',"r"),5);

        assertEquals(mesa.getCartaBaraja(5),(new CartaImpl('3',"r")));

    }

    @Test
    public void testGetJugadores() {

        CartaImpl[] baraja = new CartaImpl[52];
        for (int i = 0;i<baraja.length;i++){
            baraja[i] = new CartaImpl('Q',"14");
        }

        JugadorImpl[] jugadores = new JugadorImpl[5];
        for (int i = 0;i<jugadores.length;i++){
            jugadores[i] = new JugadorImpl();
        }

        CartaImpl[] cartasMesa = new CartaImpl[5];
        for (int i = 0;i<cartasMesa.length;i++){
            cartasMesa[i] = new CartaImpl();
        }

        MesaImpl mesa = new MesaImpl(baraja,jugadores,cartasMesa);

        assertArrayEquals(mesa.getJugadores(),jugadores);

    }

    @Test
    public void testGetJugador() {
    }

    @Test
    public void testGetCartaJugador() {
    }

    @Test
    public void testSetCartaJugador() {
    }

    @Test
    public void testSetJugador() {
    }

    @Test
    public void testGetCartasMesa() {
    }

    @Test
    public void testObtenerCartaMesa() {
    }

    @Test
    public void testSetCartasMesa() {
    }

    @Test
    public void testSetCartaMesa() {
    }

    @Test
    public void testGetApuestasJugadores() {
    }

    @Test
    public void testGetApuestaJugador() {
    }

    @Test
    public void testSetApuestaJugador() {
    }

    @Test
    public void testGetTotalApuestas() {
    }

    @Test
    public void testObtenerSaldoJugador() {
    }

    @Test
    public void testRestaurarMesa() {
    }

    @Test
    public void testIngresarSaldoGanadores() {
    }

    @Test
    public void testGenerarCartasJugadores() {
    }

    @Test
    public void testGenerarCartaMesa() {
    }

    @Test
    public void testCargarBots() {
    }

    @Test
    public void testAnhadirCartaMesa() {
    }

    @Test
    public void testLimpiarCartasMesa() {
    }

    @Test
    public void testRestaurarBaraja() {

        MesaImpl mesa = new MesaImpl();

        CartaImpl[] barajaTest = new CartaImpl[52];
        barajaTest[0] = new CartaImpl('P', "A");
        barajaTest[1] = new CartaImpl('P', "2");
        barajaTest[2] = new CartaImpl('P', "3");
        barajaTest[3] = new CartaImpl('P', "4");
        barajaTest[4] = new CartaImpl('P', "5");
        barajaTest[5] = new CartaImpl('P', "6");
        barajaTest[6] = new CartaImpl('P', "7");
        barajaTest[7] = new CartaImpl('P', "8");
        barajaTest[8] = new CartaImpl('P', "9");
        barajaTest[9] = new CartaImpl('P', "10");
        barajaTest[10] = new CartaImpl('P', "J");
        barajaTest[11] = new CartaImpl('P', "Q");
        barajaTest[12] = new CartaImpl('P', "K");

        barajaTest[13] = new CartaImpl('C', "A");
        barajaTest[14] = new CartaImpl('C', "2");
        barajaTest[15] = new CartaImpl('C', "3");
        barajaTest[16] = new CartaImpl('C', "4");
        barajaTest[17] = new CartaImpl('C', "5");
        barajaTest[18] = new CartaImpl('C', "6");
        barajaTest[19] = new CartaImpl('C', "7");
        barajaTest[20] = new CartaImpl('C', "8");
        barajaTest[21] = new CartaImpl('C', "9");
        barajaTest[22] = new CartaImpl('C', "10");
        barajaTest[23] = new CartaImpl('C', "J");
        barajaTest[24] = new CartaImpl('C', "Q");
        barajaTest[25] = new CartaImpl('C', "K");

        barajaTest[26] = new CartaImpl('R', "A");
        barajaTest[27] = new CartaImpl('R', "2");
        barajaTest[28] = new CartaImpl('R', "3");
        barajaTest[29] = new CartaImpl('R', "4");
        barajaTest[30] = new CartaImpl('R', "5");
        barajaTest[31] = new CartaImpl('R', "6");
        barajaTest[32] = new CartaImpl('R', "7");
        barajaTest[33] = new CartaImpl('R', "8");
        barajaTest[34] = new CartaImpl('R', "9");
        barajaTest[35] = new CartaImpl('R', "10");
        barajaTest[36] = new CartaImpl('R', "J");
        barajaTest[37] = new CartaImpl('R', "Q");
        barajaTest[38] = new CartaImpl('R', "K");

        barajaTest[39] = new CartaImpl('T', "A");
        barajaTest[40] = new CartaImpl('T', "2");
        barajaTest[41] = new CartaImpl('T', "3");
        barajaTest[42] = new CartaImpl('T', "4");
        barajaTest[43] = new CartaImpl('T', "5");
        barajaTest[44] = new CartaImpl('T', "6");
        barajaTest[45] = new CartaImpl('T', "7");
        barajaTest[46] = new CartaImpl('T', "8");
        barajaTest[47] = new CartaImpl('T', "9");
        barajaTest[48] = new CartaImpl('T', "10");
        barajaTest[49] = new CartaImpl('T', "J");
        barajaTest[50] = new CartaImpl('T', "Q");
        barajaTest[51] = new CartaImpl('T', "K");

        mesa.restaurarBaraja();

        assertArrayEquals(mesa.getBaraja(),barajaTest);

    }

    @Test
    public void testLimpiarMesa() {
        MesaImpl mesa = new MesaImpl();
        mesa.limpiarCartasMesa();
        mesa.anhadirApuesta(0,4,50);
        mesa.anhadirCartaMesa(2,new CartaImpl('P',"5"));
        boolean mesaA0 = true, cartasDefecto = true;
        for (int i = 0; i < mesa.getApuestasJugadores().length; i++) {
            for (int j = 0; j < mesa.getApuestasJugadores().length; j++) {
                if (mesa.getApuestaJugador(i,j) != 0){
                    mesaA0 = false;
                }
            }
        }
        for (int i = 0; i < mesa.getCartasMesa().length; i++) {
            if (mesa.getCartasMesa()[i].getPalo() != 'D'){
                cartasDefecto = false;
            }
        }
        assertFalse(mesaA0);
        assertFalse(cartasDefecto);
    }

    @Test
    public void testGenerarTresCartasMesa() {
    }

    @Test
    public void testRealizarApuestas() {
    }

    @Test
    public void testObtenerGanadores() {
    }

    @Test
    public void testIngresarDineroGanador() {
    }

    @Test
    public void testIncrementarTurno() {
    }

    @Test
    public void testMostrarPanelJuego() {
    }

    @Test
    public void testObtenerJugador() {
    }

    @Test
    public void testAhadirJugador() {
    }

    @Test
    public void testAnhadirApuesta() {
    }

    @Test
    public void testAnhadirCartasJugador() {
    }

    @Test
    public void testObtenerApuesta() {
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