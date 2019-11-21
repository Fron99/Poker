package Tests;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestoraMesaImplTest {


    @Test
    public void testLimpiarMesa() {
        MesaImpl mesa = new MesaImpl();
        mesa.limpiarCartasMesa();
        mesa.anhadirApuesta(0,4,50);
        mesa.anhadirCartaMesa(2,new CartaImpl('P',"5"));
        boolean mesaA0 = true, cartasDefecto = true;
        for (int i = 0; i < mesa.getApuestasJugadores().length; i++) {
            for (int j = 0; j < mesa.getApuestasJugadores().length; j++) {
                if (mesa.getApuestasJugadores()[i][j] != 0){
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

}