package Tests;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;
import Clases.Gestoras.GestoraCartaImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestoraCartaImplTest {


    @Test
    public void testCalcularValorCartaAlta(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('R',"K"), new CartaImpl('P',"9"), new CartaImpl('T',"5"), new CartaImpl('T',"2")};
        ges.ordenarCartas(cartasP0);
        int valor = ges.calcularValorCartaAlta(cartasP0);
        assertEquals(valor,12);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('R',"A"), new CartaImpl('P',"K"), new CartaImpl('T',"A"), new CartaImpl('T',"2")};
        ges.ordenarCartas(cartasP1);
        valor = ges.calcularValorCartaAlta(cartasP1);
        assertEquals(valor,13);
    }

    @Test
    public void testCalcularValorPareja(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('R',"2"), new CartaImpl('P',"7"), new CartaImpl('T',"9"), new CartaImpl('T',"5")};
        ges.ordenarCartas(cartasP0);
        int valor = ges.calcularValorPareja(cartasP0);
        assertEquals(valor,0);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('R',"A"), new CartaImpl('R',"K"), new CartaImpl('T',"A"), new CartaImpl('T',"2")};
        ges.ordenarCartas(cartasP1);
        valor = ges.calcularValorPareja(cartasP1);
        assertEquals(valor,26);

        //Prueba 2

        CartaImpl[] cartasP2 = {new CartaImpl('R',"A"), new CartaImpl('P',"K"), new CartaImpl('T',"A"), new CartaImpl('T',"K")};
        ges.ordenarCartas(cartasP2);
        valor = ges.calcularValorPareja(cartasP2);
        assertEquals(valor,26);

        //Prueba 3

        CartaImpl[] cartasP3 = {new CartaImpl('R',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"A"), new CartaImpl('T',"K")};
        ges.ordenarCartas(cartasP3);
        valor = ges.calcularValorPareja(cartasP3);
        assertEquals(valor,14);

        //Prueba 4

        CartaImpl[] cartasP4 = {new CartaImpl('R',"5"), new CartaImpl('P',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"2")};
        ges.ordenarCartas(cartasP4);
        valor = ges.calcularValorPareja(cartasP4);
        assertEquals(valor,0);

        //Prueba 5

        CartaImpl[] cartasP5 = {new CartaImpl('R',"5"), new CartaImpl('P',"3"), new CartaImpl('P',"3"), new CartaImpl('T',"3"), new CartaImpl('T',"2")};
        ges.ordenarCartas(cartasP5);
        valor = ges.calcularValorPareja(cartasP5);
        assertEquals(valor,0);
    }


    @Test
    public void testCalcularValorDoblePareja(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('R',"2"), new CartaImpl('P',"2"), new CartaImpl('C',"A"), new CartaImpl('T',"A")};
        ges.ordenarCartas(cartasP0);
        int valor = ges.calcularValorDoblePareja(cartasP0);
        assertEquals(valor,93);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('P',"A"), new CartaImpl('R',"A"), new CartaImpl('C',"A"), new CartaImpl('T',"A")};
        ges.ordenarCartas(cartasP1);
        valor = ges.calcularValorDoblePareja(cartasP1);
        assertEquals(valor,0);

        //Prueba 2

        CartaImpl[] cartasP2 = {new CartaImpl('P',"A"), new CartaImpl('R',"K"), new CartaImpl('C',"A"), new CartaImpl('T',"K")};
        ges.ordenarCartas(cartasP2);
        valor = ges.calcularValorDoblePareja(cartasP2);
        assertEquals(valor,104);

        //Prueba 3

        CartaImpl[] cartasP3 = {new CartaImpl('P',"A"), new CartaImpl('R',"K"), new CartaImpl('C',"A"), new CartaImpl('T',"K"), new CartaImpl('T',"A")};
        ges.ordenarCartas(cartasP3);
        valor = ges.calcularValorDoblePareja(cartasP3);
        assertEquals(valor,0);

        //Prueba 4

        CartaImpl[] cartasP4 = {new CartaImpl('P',"2"), new CartaImpl('R',"3"), new CartaImpl('C',"4"), new CartaImpl('T',"5"), new CartaImpl('T',"6")};
        ges.ordenarCartas(cartasP4);
        valor = ges.calcularValorDoblePareja(cartasP4);
        assertEquals(valor,0);

        //Prueba 5

        CartaImpl[] cartasP5 = {new CartaImpl('P',"2"), new CartaImpl('R',"2"), new CartaImpl('C',"4"), new CartaImpl('T',"5"), new CartaImpl('T',"6")};
        ges.ordenarCartas(cartasP5);
        valor = ges.calcularValorDoblePareja(cartasP5);
        assertEquals(valor,0);

        //Prueba 6

        CartaImpl[] cartasP6 = {new CartaImpl('P',"2"), new CartaImpl('R',"2"), new CartaImpl('C',"3"), new CartaImpl('T',"3"), new CartaImpl('T',"4"), new CartaImpl('R',"4")};
        ges.ordenarCartas(cartasP6);
        valor = ges.calcularValorDoblePareja(cartasP6);
        assertEquals(valor,29);

        //Prueba 7

        CartaImpl[] cartasP7 = {new CartaImpl('P',"2"), new CartaImpl('R',"2"), new CartaImpl('C',"2"), new CartaImpl('T',"A"), new CartaImpl('T',"A"), new CartaImpl('R',"4")};
        ges.ordenarCartas(cartasP7);
        valor = ges.calcularValorDoblePareja(cartasP7);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorTrio(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('P',"A"), new CartaImpl('R',"4"), new CartaImpl('C',"A"), new CartaImpl('T',"4")};
        ges.ordenarCartas(cartasP0);
        int valor = ges.calcularValorTrio(cartasP0);
        assertEquals(valor,0);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('P',"A"), new CartaImpl('R',"4"), new CartaImpl('C',"A"), new CartaImpl('T',"A")};
        ges.ordenarCartas(cartasP1);
        valor = ges.calcularValorTrio(cartasP1);
        assertEquals(valor,117);

        //Prueba 2

        CartaImpl[] cartasP2 = {new CartaImpl('P',"2"), new CartaImpl('R',"4"), new CartaImpl('C',"2"), new CartaImpl('T',"2")};
        ges.ordenarCartas(cartasP2);
        valor = ges.calcularValorTrio(cartasP2);
        assertEquals(valor,105);

        //Prueba 3

        CartaImpl[] cartasP3 = {new CartaImpl('P',"2"), new CartaImpl('R',"2"), new CartaImpl('C',"2"), new CartaImpl('T',"2")};
        ges.ordenarCartas(cartasP3);
        valor = ges.calcularValorTrio(cartasP3);
        assertEquals(valor,0);

        //Prueba 4

        CartaImpl[] cartasP4 = {new CartaImpl('P',"2"), new CartaImpl('R',"2"), new CartaImpl('C',"2"), new CartaImpl('T',"3"), new CartaImpl('T',"3"), new CartaImpl('T',"3")};
        ges.ordenarCartas(cartasP4);
        valor = ges.calcularValorTrio(cartasP4);
        assertEquals(valor,106);

        //Prueba 5

        CartaImpl[] cartasP5 = {new CartaImpl('P',"5"), new CartaImpl('R',"3"), new CartaImpl('C',"5"), new CartaImpl('T',"5"), new CartaImpl('T',"3"), new CartaImpl('T',"3")};
        ges.ordenarCartas(cartasP5);
        valor = ges.calcularValorTrio(cartasP5);
        assertEquals(valor,108);

        //Prueba 6

        CartaImpl[] cartasP6 = {new CartaImpl('P',"5"), new CartaImpl('R',"3"), new CartaImpl('C',"5"), new CartaImpl('T',"5"), new CartaImpl('T',"3"), new CartaImpl('T',"3"), new CartaImpl('T',"5")};
        ges.ordenarCartas(cartasP6);
        valor = ges.calcularValorTrio(cartasP6);
        assertEquals(valor,106);
    }


    @Test
    public void testCalcularValorEscalera(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('P',"6"), new CartaImpl('R',"10"), new CartaImpl('C',"K"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9")};
        int valor = ges.calcularValorEscalera(cartasP0);
        assertEquals(valor,0);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('C',"7"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9")};
        valor = ges.calcularValorEscalera(cartasP1);
        assertEquals(valor,0);

        //Prueba 2

        CartaImpl[] cartasP2 = {new CartaImpl('P',"6"), new CartaImpl('R',"4"), new CartaImpl('C',"7"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9"), new CartaImpl('R',"8")};
        valor = ges.calcularValorEscalera(cartasP2);
        assertEquals(valor,122);

        //Prueba 3

        CartaImpl[] cartasP3 = {new CartaImpl('P',"2"), new CartaImpl('R',"4"), new CartaImpl('C',"3"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9"), new CartaImpl('R',"8")};
        valor = ges.calcularValorEscalera(cartasP3);
        assertEquals(valor,118);

        //Prueba 4

        CartaImpl[] cartasP4 = {new CartaImpl('P',"A"), new CartaImpl('R',"10"), new CartaImpl('C',"3"), new CartaImpl('T',"A"), new CartaImpl('R',"K"), new CartaImpl('R',"Q"), new CartaImpl('R',"J")};
        valor = ges.calcularValorEscalera(cartasP4);
        assertEquals(valor,127);

        //Prueba 5

        CartaImpl[] cartasP5 = {new CartaImpl('P',"A"), new CartaImpl('R',"10"), new CartaImpl('C',"Q"), new CartaImpl('T',"A"), new CartaImpl('R',"K"), new CartaImpl('R',"Q"), new CartaImpl('R',"J")};
        valor = ges.calcularValorEscalera(cartasP5);
        assertEquals(valor,127);

        //Prueba 6

        CartaImpl[] cartasP6 = {new CartaImpl('P',"A"), new CartaImpl('C',"Q"), new CartaImpl('T',"3"), new CartaImpl('R',"K"), new CartaImpl('R',"10"), new CartaImpl('R',"J")};
        valor = ges.calcularValorEscalera(cartasP6);
        assertEquals(valor,127);

        //Prueba 7

        CartaImpl[] cartasP7 = {new CartaImpl('T',"Q"), new CartaImpl('T',"A"), new CartaImpl('T',"K"), new CartaImpl('T',"2"), new CartaImpl('T',"8"),new CartaImpl('T',"J"), new CartaImpl('T',"10")};
        valor = ges.calcularValorEscalera(cartasP7);
        assertEquals(valor,127);
    }


    @Test
    public void testCalcularValorColor(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('P',"6"), new CartaImpl('P',"10"), new CartaImpl('P',"K"), new CartaImpl('T',"A"), new CartaImpl('P',"5"), new CartaImpl('P',"9")};
        int valor = ges.calcularValorColor(cartasP0);
        assertEquals(valor,139);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('P',"6"), new CartaImpl('P',"10"), new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('T',"9"), new CartaImpl('P',"5")};
        valor = ges.calcularValorColor(cartasP1);
        assertEquals(valor,140);

        //Prueba 2

        CartaImpl[] cartasP2 = {new CartaImpl('P',"6"), new CartaImpl('T',"10"), new CartaImpl('C',"K"), new CartaImpl('P',"A"), new CartaImpl('T',"9"), new CartaImpl('P',"5")};
        valor = ges.calcularValorColor(cartasP2);
        assertEquals(valor,0);

        //Prueba 3

        CartaImpl[] cartasP3 = {new CartaImpl('P',"6"), new CartaImpl('P',"2"), new CartaImpl('P',"3"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('P',"6")};
        valor = ges.calcularValorColor(cartasP3);
        assertEquals(valor,132);
    }


    @Test
    public void testCalcularValorFull(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('P',"6"), new CartaImpl('P',"2"), new CartaImpl('P',"3"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('P',"6")};
        ges.ordenarCartas(cartasP0);
        int valor = ges.calcularValorFull(cartasP0);
        assertEquals(valor,0);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('P',"6"), new CartaImpl('P',"2"), new CartaImpl('T',"6"), new CartaImpl('C',"2"), new CartaImpl('P',"5"), new CartaImpl('P',"6")};
        ges.ordenarCartas(cartasP1);
        valor = ges.calcularValorFull(cartasP1);
        assertEquals(valor,189);

        //Prueba 2

        CartaImpl[] cartasP2 = {new CartaImpl('P',"6"), new CartaImpl('P',"2"), new CartaImpl('T',"6"), new CartaImpl('C',"2"), new CartaImpl('P',"5"), new CartaImpl('T',"2")};
        ges.ordenarCartas(cartasP2);
        valor = ges.calcularValorFull(cartasP2);
        assertEquals(valor,144);

        //Prueba 3

        CartaImpl[] cartasP3 = {new CartaImpl('P',"6"), new CartaImpl('P',"3"), new CartaImpl('T',"6"), new CartaImpl('C',"3"), new CartaImpl('P',"5"), new CartaImpl('T',"3")};
        ges.ordenarCartas(cartasP3);
        valor = ges.calcularValorFull(cartasP3);
        assertEquals(valor,156);

        //Prueba 4

        CartaImpl[] cartasP4 = {new CartaImpl('P',"6"), new CartaImpl('P',"A"), new CartaImpl('T',"6"), new CartaImpl('C',"A"), new CartaImpl('P',"5"), new CartaImpl('T',"A")};
        ges.ordenarCartas(cartasP4);
        valor = ges.calcularValorFull(cartasP4);
        assertEquals(valor,289);

        //Prueba 5

        CartaImpl[] cartasP5 = {new CartaImpl('P',"A"), new CartaImpl('P',"A"), new CartaImpl('T',"K"), new CartaImpl('C',"A"), new CartaImpl('P',"5"), new CartaImpl('T',"K")};
        ges.ordenarCartas(cartasP5);
        valor = ges.calcularValorFull(cartasP5);
        assertEquals(valor,296);

        //Prueba 6

        CartaImpl[] cartasP6 = {new CartaImpl('P',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"3"), new CartaImpl('C',"2"), new CartaImpl('P',"5"), new CartaImpl('T',"3")};
        ges.ordenarCartas(cartasP6);
        valor = ges.calcularValorFull(cartasP6);
        assertEquals(valor,141);

        //Prueba 7 (prueba si hay poker)

        CartaImpl[] cartasP7 = {new CartaImpl('P',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"3"), new CartaImpl('C',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"3")};
        ges.ordenarCartas(cartasP7);
        valor = ges.calcularValorFull(cartasP7);
        assertEquals(valor,0);

        //Prueba 8 (prueba si hay full y devuelve 0 si lo hay)

        CartaImpl[] cartasP8 = {new CartaImpl('P',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"3"), new CartaImpl('C',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"3"), new CartaImpl('T',"3")};
        ges.ordenarCartas(cartasP8);
        valor = ges.calcularValorFull(cartasP8);
        assertEquals(valor,0);

        //Prueba 9 (prueba cuando hay 2 trios)

        CartaImpl[] cartasP9 = {new CartaImpl('P',"7"), new CartaImpl('P',"3"), new CartaImpl('T',"7"), new CartaImpl('C',"3"), new CartaImpl('P',"7"), new CartaImpl('T',"3")};
        ges.ordenarCartas(cartasP9);
        valor = ges.calcularValorFull(cartasP9);
        assertEquals(valor,202);

        //Prueba 10 (prueba cuando hay 2 trios)

        CartaImpl[] cartasP10 = {new CartaImpl('P',"2"), new CartaImpl('P',"3"), new CartaImpl('T',"2"), new CartaImpl('C',"2"), new CartaImpl('P',"3"), new CartaImpl('T',"3")};
        ges.ordenarCartas(cartasP10);
        valor = ges.calcularValorFull(cartasP10);
        assertEquals(valor,153);

        //Prueba 11 (prueba cuando no hay trios)

        CartaImpl[] cartasP11 = {new CartaImpl('P',"2"), new CartaImpl('C',"2"), new CartaImpl('P',"3"), new CartaImpl('T',"3"), new CartaImpl('T',"8")};
        ges.ordenarCartas(cartasP11);
        valor = ges.calcularValorFull(cartasP11);
        assertEquals(valor,0);
    }


    @Test
    public void testCalcularValorPoker(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('P',"6"), new CartaImpl('P',"10"), new CartaImpl('P',"6"), new CartaImpl('T',"A"), new CartaImpl('P',"6"), new CartaImpl('P',"9"), new CartaImpl('P',"6")};
        ges.ordenarCartas(cartasP0);
        int valor = ges.calcularValorPoker(cartasP0);
        assertEquals(valor,301);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('P',"A"), new CartaImpl('P',"A"), new CartaImpl('P',"6"), new CartaImpl('T',"A"), new CartaImpl('P',"6"), new CartaImpl('P',"9"), new CartaImpl('P',"A")};
        ges.ordenarCartas(cartasP1);
        valor = ges.calcularValorPoker(cartasP1);
        assertEquals(valor,309);

        //Prueba 2

        CartaImpl[] cartasP2 = {new CartaImpl('P',"2"), new CartaImpl('P',"A"), new CartaImpl('P',"2"), new CartaImpl('T',"A"), new CartaImpl('P',"2"), new CartaImpl('P',"9"), new CartaImpl('P',"2")};
        ges.ordenarCartas(cartasP2);
        valor = ges.calcularValorPoker(cartasP2);
        assertEquals(valor,297);

    }


    @Test
    public void testCalcularValorEscaleraColor(){
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('P',"3"), new CartaImpl('P',"A"), new CartaImpl('R',"2"), new CartaImpl('T',"A"), new CartaImpl('C',"2"), new CartaImpl('P',"9"), new CartaImpl('P',"2")};
        ges.ordenarCartas(cartasP0);
        int valor = ges.calcularValorEscaleraColor(cartasP0);
        assertEquals(valor,0);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('P',"3"), new CartaImpl('P',"A"), new CartaImpl('P',"2"), new CartaImpl('T',"A"), new CartaImpl('P',"4"), new CartaImpl('P',"5")};
        ges.ordenarCartas(cartasP1);
        valor = ges.calcularValorEscaleraColor(cartasP1);
        assertEquals(valor,310);

        //Prueba 2

        CartaImpl[] cartasP2 = {new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"J"), new CartaImpl('T',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"10")};
        ges.ordenarCartas(cartasP2);
        valor = ges.calcularValorEscaleraColor(cartasP2);
        assertEquals(valor,319);

        //Prueba 3

        CartaImpl[] cartasP3 = {new CartaImpl('T',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"J"), new CartaImpl('T',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"10")};
        ges.ordenarCartas(cartasP3);
        valor = ges.calcularValorEscaleraColor(cartasP3);
        assertEquals(valor,0);

        //Prueba 4

        CartaImpl[] cartasP4 = {new CartaImpl('P',"3"), new CartaImpl('P',"A"), new CartaImpl('P',"2"), new CartaImpl('T',"2"), new CartaImpl('P',"4"), new CartaImpl('P',"5")};
        ges.ordenarCartas(cartasP4);
        valor = ges.calcularValorEscaleraColor(cartasP4);
        assertEquals(valor,310);

        //Prueba 5

        CartaImpl[] cartasP5 = {new CartaImpl('P',"3"), new CartaImpl('P',"A"), new CartaImpl('P',"2"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('R',"A")};
        ges.ordenarCartas(cartasP5);
        valor = ges.calcularValorEscaleraColor(cartasP5);
        assertEquals(valor,310);

        //Prueba 6

        CartaImpl[] cartasP6 = {new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"J"), new CartaImpl('P',"10"), new CartaImpl('R',"A")};
        ges.ordenarCartas(cartasP6);
        valor = ges.calcularValorEscaleraColor(cartasP6);
        assertEquals(valor,319);

        //Prueba 7

        CartaImpl[] cartasP7 = {new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"J"), new CartaImpl('P',"10"), new CartaImpl('R',"10")};
        ges.ordenarCartas(cartasP7);
        valor = ges.calcularValorEscaleraColor(cartasP7);
        assertEquals(valor,319);

        //Prueba 8

        CartaImpl[] cartasP8 = {new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"J"), new CartaImpl('P',"10"), new CartaImpl('Z',"10"), new CartaImpl('A',"10")};
        ges.ordenarCartas(cartasP8);
        valor = ges.calcularValorEscaleraColor(cartasP8);
        assertEquals(valor,319);

        //Prueba 9

        CartaImpl[] cartasP9 = {new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"J"), new CartaImpl('P',"10"), new CartaImpl('Z',"A"), new CartaImpl('A',"A")};
        ges.ordenarCartas(cartasP9);
        valor = ges.calcularValorEscaleraColor(cartasP9);
        assertEquals(valor,319);

        //Prueba 10

        CartaImpl[] cartasP10 = {new CartaImpl('P',"2"), new CartaImpl('P',"A"), new CartaImpl('P',"3"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('Z',"A"), new CartaImpl('A',"A")};
        ges.ordenarCartas(cartasP10);
        valor = ges.calcularValorEscaleraColor(cartasP10);
        assertEquals(valor,310);

        //Prueba 11

        CartaImpl[] cartasP11 = {new CartaImpl('P',"2"), new CartaImpl('P',"A"), new CartaImpl('P',"3"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('Z',"3"), new CartaImpl('A',"3")};
        ges.ordenarCartas(cartasP11);
        valor = ges.calcularValorEscaleraColor(cartasP11);
        assertEquals(valor,310);

        //Prueba 12

        CartaImpl[] cartasP12 = {new CartaImpl('P',"A"), new CartaImpl('P',"Q"), new CartaImpl('T',"3"), new CartaImpl('P',"K"), new CartaImpl('P',"10"), new CartaImpl('P',"J")};
        ges.ordenarCartas(cartasP12);
        valor = ges.calcularValorEscaleraColor(cartasP12);
        assertEquals(valor,319);

    }


    @Test
    public void testEvaluarCartas(){

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('P',"3"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('Z',"3"), new CartaImpl('A',"3")};
        CartaImpl[] cartasJugadorP0 = {new CartaImpl('P',"2"), new CartaImpl('P',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        MesaImpl mesaP0 = new MesaImpl();
        //mesaP0.anhadirJugador(0, new JugadorImpl());
        //mesaP0.setCartasMesa(cartasP0);
        //mesaP0.anhadirCartasJugador(0,cartasJugadorP0);
        int valor = ges.evaluarCartas(0,mesaP0);
        assertEquals(valor,310);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('P',"3"), new CartaImpl('T',"5"), new CartaImpl('P',"7"), new CartaImpl('Z',"9"), new CartaImpl('A',"A")};
        CartaImpl[] cartasJugadorP1 = {new CartaImpl('T',"2"), new CartaImpl('P',"K")};
        MesaImpl mesaP1 = new MesaImpl();
        //mesaP1.anhadirJugador(0, new JugadorImpl());
        //mesaP1.setCartasMesa(cartasP1);
        //mesaP1.anhadirCartasJugador(0,cartasJugadorP1);
        valor = ges.evaluarCartas(0,mesaP1);
        assertEquals(valor,13);

        //Prueba 2

        CartaImpl[] cartasP2 = {new CartaImpl(), new CartaImpl(), new CartaImpl(), new CartaImpl(), new CartaImpl()};
        CartaImpl[] cartasJugadorP2 = {new CartaImpl('T',"2"), new CartaImpl('P',"3")};
        MesaImpl mesaP2 = new MesaImpl();
        //mesaP2.anhadirJugador(0, new JugadorImpl());
        //mesaP2.setCartasMesa(cartasP2);
        //mesaP2.anhadirCartasJugador(0,cartasJugadorP2);
        valor = ges.evaluarCartas(0,mesaP2);
        assertEquals(valor,2);

        //Prueba 3

        CartaImpl[] cartasP3 = {new CartaImpl('T',"Q"), new CartaImpl('T',"A"), new CartaImpl('T',"K"), new CartaImpl('T',"2"), new CartaImpl('T',"8")};
        CartaImpl[] cartasJugadorP3 = {new CartaImpl('T',"J"), new CartaImpl('T',"10")};
        MesaImpl mesaP3 = new MesaImpl();
        //mesaP3.anhadirJugador(0, new JugadorImpl());
        //mesaP3.setCartasMesa(cartasP3);
        //mesaP3.anhadirCartasJugador(0,cartasJugadorP3);
        valor = ges.evaluarCartas(0,mesaP3);
        assertEquals(valor,319);

    }


    @Test
    public void testObtenerCartasAEvaluar(){

        GestoraCartaImpl ges = new GestoraCartaImpl();
        MesaImpl mesa = new MesaImpl();
        mesa.restaurarMesa();
        mesa.generarCartasJugadores();
        mesa.generarTresCartasMesa();
        CartaImpl[] cartas = ges.obtenerCartasAEvaluar(0,mesa);
        CartaImpl[] cartasObtenidas = new CartaImpl[5];
        cartasObtenidas[0] = mesa.getCartasMesa()[0];
        cartasObtenidas[1] = mesa.getCartasMesa()[1];
        cartasObtenidas[2] = mesa.getCartasMesa()[2];
        cartasObtenidas[3] = mesa.getCartaJugador(0,0);
        cartasObtenidas[4] = mesa.getCartaJugador(0,1);
        assertArrayEquals(cartas,cartasObtenidas);


        mesa.restaurarMesa();
        mesa.generarCartasJugadores();
        mesa.generarTresCartasMesa();
        cartas = ges.obtenerCartasAEvaluar(0,mesa);
        cartasObtenidas = new CartaImpl[5];
        cartasObtenidas[0] = mesa.getCartasMesa()[0];
        cartasObtenidas[1] = mesa.getCartasMesa()[1];
        cartasObtenidas[2] = mesa.getCartasMesa()[2];
        cartasObtenidas[3] = mesa.getCartaJugador(0,0);
        cartasObtenidas[4] = mesa.getCartaJugador(0,1);
        assertArrayEquals(cartas,cartasObtenidas);


    }


    @Test
    public void testOrdenarCartas() {
        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0

        CartaImpl[] cartasP0 = {new CartaImpl('T',"5"), new CartaImpl('P',"9"), new CartaImpl('T',"2"), new CartaImpl('R',"K")};
        CartaImpl[] cartasDesordenadas = {new CartaImpl('R',"K"), new CartaImpl('P',"9"), new CartaImpl('T',"2"), new CartaImpl('T',"5")};
        ges.ordenarCartas(cartasP0);
        assertNotEquals(cartasP0,cartasDesordenadas);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('T',"5"), new CartaImpl('P',"9"), new CartaImpl('T',"2"), new CartaImpl('R',"K")};
        CartaImpl[] cartasOrdenadas = {new CartaImpl('T',"2"), new CartaImpl('T',"5"), new CartaImpl('P',"9"), new CartaImpl('R',"K")};
        ges.ordenarCartas(cartasP1);
        assertArrayEquals(cartasP1,cartasOrdenadas);
    }


    @Test
    public void testCalcularColor(){

        GestoraCartaImpl ges = new GestoraCartaImpl();

        //Prueba 0 (Prueba con color T)

        CartaImpl[] cartasP0 = {new CartaImpl('T',"5"), new CartaImpl('T',"9"), new CartaImpl('T',"2"), new CartaImpl('T',"K"), new CartaImpl('T',"J")};
        char color = ges.calcularColor(cartasP0);
        assertEquals('T',color);

        //Prueba 1 (Prueba con color P)

        CartaImpl[] cartasP1 = {new CartaImpl('P',"9"), new CartaImpl('P',"2"), new CartaImpl('P',"K"), new CartaImpl('P',"J"), new CartaImpl('P',"3")};
        color = ges.calcularColor(cartasP1);
        assertEquals('P',color);

        //Prueba 2 (Prueba con color R)

        CartaImpl[] cartasP2 = {new CartaImpl('R',"9"), new CartaImpl('R',"2"), new CartaImpl('R',"K"), new CartaImpl('R',"J"), new CartaImpl('R',"3")};
        color = ges.calcularColor(cartasP2);
        assertEquals('R',color);

        //Prueba 3 (Prueba con color C)

        CartaImpl[] cartasP3 = {new CartaImpl('C',"9"), new CartaImpl('C',"2"), new CartaImpl('C',"K"), new CartaImpl('C',"J"), new CartaImpl('C',"3")};
        color = ges.calcularColor(cartasP3);
        assertEquals('C',color);

        //Prueba 4 (Prueba faltando cartas para color)

        CartaImpl[] cartasP4 = {new CartaImpl('T',"9"), new CartaImpl('T',"2"), new CartaImpl('T',"K"), new CartaImpl('T',"J")};
        color = ges.calcularColor(cartasP4);
        assertEquals('N',color);

        //Prueba 5 (Prueba sin color)

        CartaImpl[] cartasP5 = {new CartaImpl('R',"5"), new CartaImpl('T',"9"), new CartaImpl('P',"2"), new CartaImpl('T',"K"), new CartaImpl('T',"J")};
        color = ges.calcularColor(cartasP5);
        assertEquals('N',color);

        //Prueba 6 (Prueba existiendo mas de 5 cartas del mismo color)

        CartaImpl[] cartasP6 = {new CartaImpl('T',"5"), new CartaImpl('C',"5"), new CartaImpl('T',"8"), new CartaImpl('T',"9"), new CartaImpl('T',"2"), new CartaImpl('T',"K"), new CartaImpl('T',"J")};
        color = ges.calcularColor(cartasP6);
        assertEquals('T',color);

    }

}