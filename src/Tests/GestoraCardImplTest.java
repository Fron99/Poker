package Tests;

import Clases.Basics.CardImpl;
import Clases.Basics.PlayerImpl;
import Clases.Basics.TableImpl;
import Clases.Managements.GestoraCartaImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestoraCardImplTest {


    @Test
    public void testCalcularValorCartaAlta(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CardImpl[] cartasP0 = {new CardImpl('R',"K"), new CardImpl('P',"9"), new CardImpl('T',"5"), new CardImpl('T',"2")};
        ges.ordenarCartas(cartasP0);
        int valor = ges.calcularValorCartaAlta(cartasP0);
        assertEquals(valor,12);

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('R',"A"), new CardImpl('P',"K"), new CardImpl('T',"A"), new CardImpl('T',"2")};
        ges.ordenarCartas(cartasP1);
        valor = ges.calcularValorCartaAlta(cartasP1);
        assertEquals(valor,13);
    }

    @Test
    public void testCalcularValorPareja(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CardImpl[] cartasP0 = {new CardImpl('R',"2"), new CardImpl('P',"7"), new CardImpl('T',"9"), new CardImpl('T',"5")};
        int valor = ges.calcularValorPareja(cartasP0);
        assertEquals(valor,0);

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('R',"A"), new CardImpl('R',"K"), new CardImpl('T',"A"), new CardImpl('T',"2")};
        valor = ges.calcularValorPareja(cartasP1);
        assertEquals(valor,26);

        //Prueba 2

        CardImpl[] cartasP2 = {new CardImpl('R',"A"), new CardImpl('P',"K"), new CardImpl('T',"A"), new CardImpl('T',"K")};
        valor = ges.calcularValorPareja(cartasP2);
        assertEquals(valor,26);

        //Prueba 3

        CardImpl[] cartasP3 = {new CardImpl('R',"2"), new CardImpl('P',"2"), new CardImpl('T',"A"), new CardImpl('T',"K")};
        valor = ges.calcularValorPareja(cartasP3);
        assertEquals(valor,14);

        //Prueba 4

        CardImpl[] cartasP4 = {new CardImpl('R',"5"), new CardImpl('P',"2"), new CardImpl('P',"2"), new CardImpl('T',"2")};
        valor = ges.calcularValorPareja(cartasP4);
        assertEquals(valor,0);

        //Prueba 5

        CardImpl[] cartasP5 = {new CardImpl('R',"5"), new CardImpl('P',"3"), new CardImpl('P',"3"), new CardImpl('T',"3"), new CardImpl('T',"2")};
        valor = ges.calcularValorPareja(cartasP5);
        assertEquals(valor,0);
    }


    @Test
    public void testCalcularValorDoblePareja(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CardImpl[] cartasP0 = {new CardImpl('R',"2"), new CardImpl('P',"2"), new CardImpl('C',"A"), new CardImpl('T',"A")};
        int valor = ges.calcularValorDoblePareja(cartasP0);
        assertEquals(valor,93);

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('P',"A"), new CardImpl('R',"A"), new CardImpl('C',"A"), new CardImpl('T',"A")};
        valor = ges.calcularValorDoblePareja(cartasP1);
        assertEquals(valor,0);

        //Prueba 2

        CardImpl[] cartasP2 = {new CardImpl('P',"A"), new CardImpl('R',"K"), new CardImpl('C',"A"), new CardImpl('T',"K")};
        valor = ges.calcularValorDoblePareja(cartasP2);
        assertEquals(valor,104);

        //Prueba 3

        CardImpl[] cartasP3 = {new CardImpl('P',"A"), new CardImpl('R',"K"), new CardImpl('C',"A"), new CardImpl('T',"K"), new CardImpl('T',"A")};
        valor = ges.calcularValorDoblePareja(cartasP3);
        assertEquals(valor,0);

        //Prueba 4

        CardImpl[] cartasP4 = {new CardImpl('P',"2"), new CardImpl('R',"3"), new CardImpl('C',"4"), new CardImpl('T',"5"), new CardImpl('T',"6")};
        valor = ges.calcularValorDoblePareja(cartasP4);
        assertEquals(valor,0);

        //Prueba 5

        CardImpl[] cartasP5 = {new CardImpl('P',"2"), new CardImpl('R',"2"), new CardImpl('C',"4"), new CardImpl('T',"5"), new CardImpl('T',"6")};
        valor = ges.calcularValorDoblePareja(cartasP5);
        assertEquals(valor,0);

        //Prueba 6

        CardImpl[] cartasP6 = {new CardImpl('P',"2"), new CardImpl('R',"2"), new CardImpl('C',"3"), new CardImpl('T',"3"), new CardImpl('T',"4"), new CardImpl('R',"4")};
        valor = ges.calcularValorDoblePareja(cartasP6);
        assertEquals(valor,29);

        //Prueba 7

        CardImpl[] cartasP7 = {new CardImpl('P',"2"), new CardImpl('R',"2"), new CardImpl('C',"2"), new CardImpl('T',"A"), new CardImpl('T',"A"), new CardImpl('R',"4")};
        valor = ges.calcularValorDoblePareja(cartasP7);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorTrio(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CardImpl[] cartasP0 = {new CardImpl('P',"A"), new CardImpl('R',"4"), new CardImpl('C',"A"), new CardImpl('T',"4")};
        int valor = ges.calcularValorTrio(cartasP0);
        assertEquals(valor,0);

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('P',"A"), new CardImpl('R',"4"), new CardImpl('C',"A"), new CardImpl('T',"A")};
        valor = ges.calcularValorTrio(cartasP1);
        assertEquals(valor,117);

        //Prueba 2

        CardImpl[] cartasP2 = {new CardImpl('P',"2"), new CardImpl('R',"4"), new CardImpl('C',"2"), new CardImpl('T',"2")};
        valor = ges.calcularValorTrio(cartasP2);
        assertEquals(valor,105);

        //Prueba 3

        CardImpl[] cartasP3 = {new CardImpl('P',"2"), new CardImpl('R',"2"), new CardImpl('C',"2"), new CardImpl('T',"2")};
        valor = ges.calcularValorTrio(cartasP3);
        assertEquals(valor,0);

        //Prueba 4

        CardImpl[] cartasP4 = {new CardImpl('P',"2"), new CardImpl('R',"2"), new CardImpl('C',"2"), new CardImpl('T',"3"), new CardImpl('T',"3"), new CardImpl('T',"3")};
        valor = ges.calcularValorTrio(cartasP4);
        assertEquals(valor,106);

        //Prueba 5

        CardImpl[] cartasP5 = {new CardImpl('P',"5"), new CardImpl('R',"3"), new CardImpl('C',"5"), new CardImpl('T',"5"), new CardImpl('T',"3"), new CardImpl('T',"3")};
        valor = ges.calcularValorTrio(cartasP5);
        assertEquals(valor,108);

        //Prueba 6

        CardImpl[] cartasP6 = {new CardImpl('P',"5"), new CardImpl('R',"3"), new CardImpl('C',"5"), new CardImpl('T',"5"), new CardImpl('T',"3"), new CardImpl('T',"3"), new CardImpl('T',"5")};
        valor = ges.calcularValorTrio(cartasP6);
        assertEquals(valor,106);
    }


    @Test
    public void testCalcularValorEscalera(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CardImpl[] cartasP0 = {new CardImpl('P',"6"), new CardImpl('R',"10"), new CardImpl('C',"K"), new CardImpl('T',"A"), new CardImpl('R',"5"), new CardImpl('R',"9")};
        int valor = ges.calcularValorEscalera(cartasP0);
        assertEquals(valor,0);

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('C',"7"), new CardImpl('T',"A"), new CardImpl('R',"5"), new CardImpl('R',"9")};
        valor = ges.calcularValorEscalera(cartasP1);
        assertEquals(valor,0);

        //Prueba 2

        CardImpl[] cartasP2 = {new CardImpl('P',"6"), new CardImpl('R',"4"), new CardImpl('C',"7"), new CardImpl('T',"A"), new CardImpl('R',"5"), new CardImpl('R',"9"), new CardImpl('R',"8")};
        valor = ges.calcularValorEscalera(cartasP2);
        assertEquals(valor,122);

        //Prueba 3

        CardImpl[] cartasP3 = {new CardImpl('P',"2"), new CardImpl('R',"4"), new CardImpl('C',"3"), new CardImpl('T',"A"), new CardImpl('R',"5"), new CardImpl('R',"9"), new CardImpl('R',"8")};
        valor = ges.calcularValorEscalera(cartasP3);
        assertEquals(valor,118);

        //Prueba 4

        CardImpl[] cartasP4 = {new CardImpl('P',"A"), new CardImpl('R',"10"), new CardImpl('C',"3"), new CardImpl('T',"A"), new CardImpl('R',"K"), new CardImpl('R',"Q"), new CardImpl('R',"J")};
        valor = ges.calcularValorEscalera(cartasP4);
        assertEquals(valor,127);

        //Prueba 5

        CardImpl[] cartasP5 = {new CardImpl('P',"A"), new CardImpl('R',"10"), new CardImpl('C',"Q"), new CardImpl('T',"A"), new CardImpl('R',"K"), new CardImpl('R',"Q"), new CardImpl('R',"J")};
        valor = ges.calcularValorEscalera(cartasP5);
        assertEquals(valor,127);

        //Prueba 6

        CardImpl[] cartasP6 = {new CardImpl('P',"A"), new CardImpl('C',"Q"), new CardImpl('T',"3"), new CardImpl('R',"K"), new CardImpl('R',"10"), new CardImpl('R',"J")};
        valor = ges.calcularValorEscalera(cartasP6);
        assertEquals(valor,127);

        //Prueba 7

        CardImpl[] cartasP7 = {new CardImpl('T',"Q"), new CardImpl('T',"A"), new CardImpl('T',"K"), new CardImpl('T',"2"), new CardImpl('T',"8"),new CardImpl('T',"J"), new CardImpl('T',"10")};
        valor = ges.calcularValorEscalera(cartasP7);
        assertEquals(valor,127);

        //Prueba 8(Escalera pero con numeros repetidos en medio)

        CardImpl[] cartasP8 = {new CardImpl('T',"4"), new CardImpl('T',"A"), new CardImpl('T',"5"), new CardImpl('T',"6"), new CardImpl('P',"5"),new CardImpl('P',"7"), new CardImpl('C',"8")};
        valor = ges.calcularValorEscalera(cartasP8);
        assertEquals(valor,121);
    }


    @Test
    public void testCalcularValorColor(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CardImpl[] cartasP0 = {new CardImpl('P',"6"), new CardImpl('P',"10"), new CardImpl('P',"K"), new CardImpl('T',"A"), new CardImpl('P',"5"), new CardImpl('P',"9")};
        int valor = ges.calcularValorColor(cartasP0);
        assertEquals(valor,139);

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('P',"6"), new CardImpl('P',"10"), new CardImpl('P',"K"), new CardImpl('P',"A"), new CardImpl('T',"9"), new CardImpl('P',"5")};
        valor = ges.calcularValorColor(cartasP1);
        assertEquals(valor,140);

        //Prueba 2

        CardImpl[] cartasP2 = {new CardImpl('P',"6"), new CardImpl('T',"10"), new CardImpl('C',"K"), new CardImpl('P',"A"), new CardImpl('T',"9"), new CardImpl('P',"5")};
        valor = ges.calcularValorColor(cartasP2);
        assertEquals(valor,0);

        //Prueba 3

        CardImpl[] cartasP3 = {new CardImpl('P',"6"), new CardImpl('P',"2"), new CardImpl('P',"3"), new CardImpl('P',"4"), new CardImpl('P',"5"), new CardImpl('P',"6")};
        valor = ges.calcularValorColor(cartasP3);
        assertEquals(valor,132);
    }


    @Test
    public void testCalcularValorFull(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CardImpl[] cartasP0 = {new CardImpl('P',"6"), new CardImpl('P',"2"), new CardImpl('P',"3"), new CardImpl('P',"4"), new CardImpl('P',"5"), new CardImpl('P',"6")};
        int valor = ges.calcularValorFull(cartasP0);
        assertEquals(valor,0);

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('P',"6"), new CardImpl('P',"2"), new CardImpl('T',"6"), new CardImpl('C',"2"), new CardImpl('P',"5"), new CardImpl('P',"6")};
        valor = ges.calcularValorFull(cartasP1);
        assertEquals(valor,189);

        //Prueba 2

        CardImpl[] cartasP2 = {new CardImpl('P',"6"), new CardImpl('P',"2"), new CardImpl('T',"6"), new CardImpl('C',"2"), new CardImpl('P',"5"), new CardImpl('T',"2")};
        valor = ges.calcularValorFull(cartasP2);
        assertEquals(valor,144);

        //Prueba 3

        CardImpl[] cartasP3 = {new CardImpl('P',"6"), new CardImpl('P',"3"), new CardImpl('T',"6"), new CardImpl('C',"3"), new CardImpl('P',"5"), new CardImpl('T',"3")};
        valor = ges.calcularValorFull(cartasP3);
        assertEquals(valor,156);

        //Prueba 4

        CardImpl[] cartasP4 = {new CardImpl('P',"6"), new CardImpl('P',"A"), new CardImpl('T',"6"), new CardImpl('C',"A"), new CardImpl('P',"5"), new CardImpl('T',"A")};
        valor = ges.calcularValorFull(cartasP4);
        assertEquals(valor,289);

        //Prueba 5

        CardImpl[] cartasP5 = {new CardImpl('P',"A"), new CardImpl('P',"A"), new CardImpl('T',"K"), new CardImpl('C',"A"), new CardImpl('P',"5"), new CardImpl('T',"K")};
        valor = ges.calcularValorFull(cartasP5);
        assertEquals(valor,296);

        //Prueba 6

        CardImpl[] cartasP6 = {new CardImpl('P',"2"), new CardImpl('P',"2"), new CardImpl('T',"3"), new CardImpl('C',"2"), new CardImpl('P',"5"), new CardImpl('T',"3")};
        valor = ges.calcularValorFull(cartasP6);
        assertEquals(valor,141);

        //Prueba 7 (prueba si hay poker)

        CardImpl[] cartasP7 = {new CardImpl('P',"2"), new CardImpl('P',"2"), new CardImpl('T',"3"), new CardImpl('C',"2"), new CardImpl('P',"2"), new CardImpl('T',"3")};
        valor = ges.calcularValorFull(cartasP7);
        assertEquals(valor,0);

        //Prueba 8 (prueba si hay full y devuelve 0 si lo hay)

        CardImpl[] cartasP8 = {new CardImpl('P',"2"), new CardImpl('P',"2"), new CardImpl('T',"3"), new CardImpl('C',"2"), new CardImpl('P',"2"), new CardImpl('T',"3"), new CardImpl('T',"3")};
        valor = ges.calcularValorFull(cartasP8);
        assertEquals(valor,0);

        //Prueba 9 (prueba cuando hay 2 trios)

        CardImpl[] cartasP9 = {new CardImpl('P',"7"), new CardImpl('P',"3"), new CardImpl('T',"7"), new CardImpl('C',"3"), new CardImpl('P',"7"), new CardImpl('T',"3")};
        valor = ges.calcularValorFull(cartasP9);
        assertEquals(valor,202);

        //Prueba 10 (prueba cuando hay 2 trios)

        CardImpl[] cartasP10 = {new CardImpl('P',"2"), new CardImpl('P',"3"), new CardImpl('T',"2"), new CardImpl('C',"2"), new CardImpl('P',"3"), new CardImpl('T',"3")};
        valor = ges.calcularValorFull(cartasP10);
        assertEquals(valor,153);

        //Prueba 11 (prueba cuando no hay trios)

        CardImpl[] cartasP11 = {new CardImpl('P',"2"), new CardImpl('C',"2"), new CardImpl('P',"3"), new CardImpl('T',"3"), new CardImpl('T',"8")};
        valor = ges.calcularValorFull(cartasP11);
        assertEquals(valor,0);
    }


    @Test
    public void testCalcularValorPoker(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CardImpl[] cartasP0 = {new CardImpl('P',"6"), new CardImpl('P',"10"), new CardImpl('P',"6"), new CardImpl('T',"A"), new CardImpl('P',"6"), new CardImpl('P',"9"), new CardImpl('P',"6")};
        int valor = ges.calcularValorPoker(cartasP0);
        assertEquals(valor,301);

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('P',"A"), new CardImpl('P',"A"), new CardImpl('P',"6"), new CardImpl('T',"A"), new CardImpl('P',"6"), new CardImpl('P',"9"), new CardImpl('P',"A")};
        valor = ges.calcularValorPoker(cartasP1);
        assertEquals(valor,309);

        //Prueba 2

        CardImpl[] cartasP2 = {new CardImpl('P',"2"), new CardImpl('P',"A"), new CardImpl('P',"2"), new CardImpl('T',"A"), new CardImpl('P',"2"), new CardImpl('P',"9"), new CardImpl('P',"2")};
        valor = ges.calcularValorPoker(cartasP2);
        assertEquals(valor,297);

    }


    @Test
    public void testCalcularValorEscaleraColor(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CardImpl[] cartasP0 = {new CardImpl('P',"3"), new CardImpl('P',"A"), new CardImpl('R',"2"), new CardImpl('T',"A"), new CardImpl('C',"2"), new CardImpl('P',"9"), new CardImpl('P',"2")};
        int valor = ges.calcularValorEscaleraColor(cartasP0);
        assertEquals(valor,0);

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('P',"3"), new CardImpl('P',"A"), new CardImpl('P',"2"), new CardImpl('T',"A"), new CardImpl('P',"4"), new CardImpl('P',"5")};
        valor = ges.calcularValorEscaleraColor(cartasP1);
        assertEquals(valor,310);

        //Prueba 2

        CardImpl[] cartasP2 = {new CardImpl('P',"K"), new CardImpl('P',"A"), new CardImpl('P',"J"), new CardImpl('T',"A"), new CardImpl('P',"Q"), new CardImpl('P',"10")};
        valor = ges.calcularValorEscaleraColor(cartasP2);
        assertEquals(valor,319);

        //Prueba 3

        CardImpl[] cartasP3 = {new CardImpl('T',"K"), new CardImpl('P',"A"), new CardImpl('P',"J"), new CardImpl('T',"A"), new CardImpl('P',"Q"), new CardImpl('P',"10")};
        valor = ges.calcularValorEscaleraColor(cartasP3);
        assertEquals(valor,0);

        //Prueba 4

        CardImpl[] cartasP4 = {new CardImpl('P',"3"), new CardImpl('P',"A"), new CardImpl('P',"2"), new CardImpl('T',"2"), new CardImpl('P',"4"), new CardImpl('P',"5")};
        valor = ges.calcularValorEscaleraColor(cartasP4);
        assertEquals(valor,310);

        //Prueba 5

        CardImpl[] cartasP5 = {new CardImpl('P',"3"), new CardImpl('P',"A"), new CardImpl('P',"2"), new CardImpl('P',"4"), new CardImpl('P',"5"), new CardImpl('R',"A")};
        valor = ges.calcularValorEscaleraColor(cartasP5);
        assertEquals(valor,310);

        //Prueba 6

        CardImpl[] cartasP6 = {new CardImpl('P',"K"), new CardImpl('P',"A"), new CardImpl('P',"Q"), new CardImpl('P',"J"), new CardImpl('P',"10"), new CardImpl('R',"A")};
        valor = ges.calcularValorEscaleraColor(cartasP6);
        assertEquals(valor,319);

        //Prueba 7

        CardImpl[] cartasP7 = {new CardImpl('P',"K"), new CardImpl('P',"A"), new CardImpl('P',"Q"), new CardImpl('P',"J"), new CardImpl('P',"10"), new CardImpl('R',"10")};
        valor = ges.calcularValorEscaleraColor(cartasP7);
        assertEquals(valor,319);

        //Prueba 8

        CardImpl[] cartasP8 = {new CardImpl('P',"K"), new CardImpl('P',"A"), new CardImpl('P',"Q"), new CardImpl('P',"J"), new CardImpl('P',"10"), new CardImpl('Z',"10"), new CardImpl('A',"10")};
        valor = ges.calcularValorEscaleraColor(cartasP8);
        assertEquals(valor,319);

        //Prueba 9

        CardImpl[] cartasP9 = {new CardImpl('P',"K"), new CardImpl('P',"A"), new CardImpl('P',"Q"), new CardImpl('P',"J"), new CardImpl('P',"10"), new CardImpl('Z',"A"), new CardImpl('A',"A")};
        valor = ges.calcularValorEscaleraColor(cartasP9);
        assertEquals(valor,319);

        //Prueba 10

        CardImpl[] cartasP10 = {new CardImpl('P',"2"), new CardImpl('P',"A"), new CardImpl('P',"3"), new CardImpl('P',"4"), new CardImpl('P',"5"), new CardImpl('Z',"A"), new CardImpl('A',"A")};
        valor = ges.calcularValorEscaleraColor(cartasP10);
        assertEquals(valor,310);

        //Prueba 11

        CardImpl[] cartasP11 = {new CardImpl('P',"2"), new CardImpl('P',"A"), new CardImpl('P',"3"), new CardImpl('P',"4"), new CardImpl('P',"5"), new CardImpl('Z',"3"), new CardImpl('A',"3")};
        valor = ges.calcularValorEscaleraColor(cartasP11);
        assertEquals(valor,310);

        //Prueba 12

        CardImpl[] cartasP12 = {new CardImpl('P',"A"), new CardImpl('P',"Q"), new CardImpl('T',"3"), new CardImpl('P',"K"), new CardImpl('P',"10"), new CardImpl('P',"J")};
        valor = ges.calcularValorEscaleraColor(cartasP12);
        assertEquals(valor,319);

        //Prueba 13

        CardImpl[] cartasP13 = {new CardImpl('P',"2"), new CardImpl('P',"A"), new CardImpl('P',"3"), new CardImpl('P',"4"), new CardImpl('P',"5"), new CardImpl('P',"6"), new CardImpl('A',"3")};
        valor = ges.calcularValorEscaleraColor(cartasP13);
        assertEquals(valor,311);

        //Prueba 14

        CardImpl[] cartasP14 = {new CardImpl('P',"2"), new CardImpl('P',"A"), new CardImpl('P',"3"), new CardImpl('P',"4"), new CardImpl('P',"5"), new CardImpl('P',"6"), new CardImpl('P',"7"), new CardImpl('P',"8"), new CardImpl('P',"9"), new CardImpl('P',"10"), new CardImpl('P',"J"), new CardImpl('P',"Q"), new CardImpl('P',"K")};
        valor = ges.calcularValorEscaleraColor(cartasP14);
        assertEquals(valor,319);


    }


    @Test
    public void testEvaluarCartas(){

        //Prueba 0

        CardImpl[] cartasP0 = {new CardImpl('P',"3"), new CardImpl('P',"4"), new CardImpl('P',"5"), new CardImpl('Z',"3"), new CardImpl('A',"3")};
        CardImpl[] cartasJugadorP0 = {new CardImpl('P',"2"), new CardImpl('P',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        TableImpl mesaP0 = new TableImpl();
        mesaP0.setJugador(0, new PlayerImpl());
        mesaP0.setCartasMesa(cartasP0);
        mesaP0.setCartasJugador(0,cartasJugadorP0);
        int valor = ges.evaluarCartas(0,mesaP0);
        assertEquals(valor,310);

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('P',"3"), new CardImpl('T',"5"), new CardImpl('P',"7"), new CardImpl('Z',"9"), new CardImpl('A',"A")};
        CardImpl[] cartasJugadorP1 = {new CardImpl('T',"2"), new CardImpl('P',"K")};
        TableImpl mesaP1 = new TableImpl();
        mesaP1.setJugador(0, new PlayerImpl());
        mesaP1.setCartasMesa(cartasP1);
        mesaP1.setCartasJugador(0,cartasJugadorP1);
        valor = ges.evaluarCartas(0,mesaP1);
        assertEquals(valor,13);

        //Prueba 2

        CardImpl[] cartasP2 = {new CardImpl(), new CardImpl(), new CardImpl(), new CardImpl(), new CardImpl()};
        CardImpl[] cartasJugadorP2 = {new CardImpl('T',"2"), new CardImpl('P',"3")};
        TableImpl mesaP2 = new TableImpl();
        mesaP2.setJugador(0, new PlayerImpl());
        mesaP2.setCartasMesa(cartasP2);
        mesaP2.setCartasJugador(0,cartasJugadorP2);
        valor = ges.evaluarCartas(0,mesaP2);
        assertEquals(valor,2);

        //Prueba 3

        CardImpl[] cartasP3 = {new CardImpl('T',"Q"), new CardImpl('T',"A"), new CardImpl('T',"K"), new CardImpl('T',"2"), new CardImpl('T',"8")};
        CardImpl[] cartasJugadorP3 = {new CardImpl('T',"J"), new CardImpl('T',"10")};
        TableImpl mesaP3 = new TableImpl();
        mesaP3.setJugador(0, new PlayerImpl());
        mesaP3.setCartasMesa(cartasP3);
        mesaP3.setCartasJugador(0,cartasJugadorP3);
        valor = ges.evaluarCartas(0,mesaP3);
        assertEquals(valor,319);

    }


    @Test
    public void testObtenerCartasAEvaluar(){

        GestoraCartaImpl ges = new GestoraCartaImpl();
        TableImpl mesa = new TableImpl();

        mesa.restaurarMesa();
        mesa.generarCartasJugadores();
        mesa.generarTresCartasMesa();
        CardImpl[] cartas = ges.obtenerCartasAEvaluar(0,mesa);
        CardImpl[] cartasObtenidas = new CardImpl[5];
        cartasObtenidas[0] = mesa.getCartaMesa(0);
        cartasObtenidas[1] = mesa.getCartaMesa(1);
        cartasObtenidas[2] = mesa.getCartaMesa(2);
        cartasObtenidas[3] = mesa.getCartaJugador(0,0);
        cartasObtenidas[4] = mesa.getCartaJugador(0,1);
        assertArrayEquals(cartas,cartasObtenidas);


        mesa.restaurarMesa();
        mesa.generarCartasJugadores();
        mesa.generarTresCartasMesa();
        cartas = ges.obtenerCartasAEvaluar(0,mesa);
        cartasObtenidas = new CardImpl[5];
        cartasObtenidas[0] = mesa.getCartaMesa(0);
        cartasObtenidas[1] = mesa.getCartaMesa(1);
        cartasObtenidas[2] = mesa.getCartaMesa(2);
        cartasObtenidas[3] = mesa.getCartaJugador(0,0);
        cartasObtenidas[4] = mesa.getCartaJugador(0,1);
        assertArrayEquals(cartas,cartasObtenidas);

        mesa.restaurarMesa();
        mesa.generarCartasJugadores();
        mesa.generarTresCartasMesa();
        cartas = ges.obtenerCartasAEvaluar(0,mesa);
        cartasObtenidas = new CardImpl[5];
        cartasObtenidas[0] = mesa.getCartaMesa(0);
        cartasObtenidas[1] = mesa.getCartaMesa(1);
        cartasObtenidas[2] = mesa.getCartaMesa(2);
        cartasObtenidas[3] = mesa.getCartaJugador(0,0);
        cartasObtenidas[4] = mesa.getCartaJugador(0,1);
        assertArrayEquals(cartas,cartasObtenidas);


    }


    @Test
    public void testOrdenarCartas() {
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 1

        CardImpl[] cartasP1 = {new CardImpl('T',"5"), new CardImpl('P',"9"), new CardImpl('T',"2"), new CardImpl('R',"K")};
        CardImpl[] cartasOrdenadas = {new CardImpl('T',"2"), new CardImpl('T',"5"), new CardImpl('P',"9"), new CardImpl('R',"K")};
        ges.ordenarCartas(cartasP1);
        assertArrayEquals(cartasP1,cartasOrdenadas);
    }


    @Test
    public void testCalcularColor(){

        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0 (Prueba con color T)

        CardImpl[] cartasP0 = {new CardImpl('T',"5"), new CardImpl('T',"9"), new CardImpl('T',"2"), new CardImpl('T',"K"), new CardImpl('T',"J")};
        char color = ges.calcularTipoColor(cartasP0);
        assertEquals('T',color);

        //Prueba 1 (Prueba con color P)

        CardImpl[] cartasP1 = {new CardImpl('P',"9"), new CardImpl('P',"2"), new CardImpl('P',"K"), new CardImpl('P',"J"), new CardImpl('P',"3")};
        color = ges.calcularTipoColor(cartasP1);
        assertEquals('P',color);

        //Prueba 2 (Prueba con color R)

        CardImpl[] cartasP2 = {new CardImpl('R',"9"), new CardImpl('R',"2"), new CardImpl('R',"K"), new CardImpl('R',"J"), new CardImpl('R',"3")};
        color = ges.calcularTipoColor(cartasP2);
        assertEquals('R',color);

        //Prueba 3 (Prueba con color C)

        CardImpl[] cartasP3 = {new CardImpl('C',"9"), new CardImpl('C',"2"), new CardImpl('C',"K"), new CardImpl('C',"J"), new CardImpl('C',"3")};
        color = ges.calcularTipoColor(cartasP3);
        assertEquals('C',color);

        //Prueba 4 (Prueba faltando cartas para color)

        CardImpl[] cartasP4 = {new CardImpl('T',"9"), new CardImpl('T',"2"), new CardImpl('T',"K"), new CardImpl('T',"J")};
        color = ges.calcularTipoColor(cartasP4);
        assertEquals('N',color);

        //Prueba 5 (Prueba sin color)

        CardImpl[] cartasP5 = {new CardImpl('R',"5"), new CardImpl('T',"9"), new CardImpl('P',"2"), new CardImpl('T',"K"), new CardImpl('T',"J")};
        color = ges.calcularTipoColor(cartasP5);
        assertEquals('N',color);

        //Prueba 6 (Prueba existiendo mas de 5 cartas del mismo color)

        CardImpl[] cartasP6 = {new CardImpl('T',"5"), new CardImpl('C',"5"), new CardImpl('T',"8"), new CardImpl('T',"9"), new CardImpl('T',"2"), new CardImpl('T',"K"), new CardImpl('T',"J")};
        color = ges.calcularTipoColor(cartasP6);
        assertEquals('T',color);

    }

}