package Tests;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.JugadorImpl;
import Clases.Basicas.MesaImpl;
import Clases.Gestoras.GestoraCartaImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestoraCartaImplTest {


    @Test
    public void testOrdenarCartas1() {

        CartaImpl[] cartas = {new CartaImpl('T',"5"), new CartaImpl('P',"9"), new CartaImpl('T',"2"), new CartaImpl('R',"K")};
        CartaImpl[] cartasDesordenadas = {new CartaImpl('R',"K"), new CartaImpl('P',"9"), new CartaImpl('T',"2"), new CartaImpl('T',"5")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        assertNotEquals(cartas,cartasDesordenadas);

    }

    @Test
    public void testOrdenarCartas2() {

        CartaImpl[] cartas = {new CartaImpl('T',"5"), new CartaImpl('P',"9"), new CartaImpl('T',"2"), new CartaImpl('R',"K")};
        CartaImpl[] cartasOrdenadas = {new CartaImpl('T',"2"), new CartaImpl('T',"5"), new CartaImpl('P',"9"), new CartaImpl('R',"K")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        assertArrayEquals(cartas,cartasOrdenadas);

    }

    @Test
    public void testCalcularValorCartaAlta1(){
        CartaImpl[] cartas = {new CartaImpl('R',"K"), new CartaImpl('P',"9"), new CartaImpl('T',"5"), new CartaImpl('T',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorCartaAlta(cartas);
        assertEquals(valor,12);
    }


    @Test
    public void testCalcularValorCartaAlta2(){
        CartaImpl[] cartas = {new CartaImpl('R',"A"), new CartaImpl('P',"K"), new CartaImpl('T',"A"), new CartaImpl('T',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorCartaAlta(cartas);
        assertEquals(valor,13);
    }

    @Test
    public void testCalcularValorPareja1(){
        CartaImpl[] cartas = {new CartaImpl('R',"2"), new CartaImpl('P',"7"), new CartaImpl('T',"9"), new CartaImpl('T',"5")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorPareja(cartas);
        assertEquals(valor,0);
    }


    @Test
    public void testCalcularValorPareja2(){
        CartaImpl[] cartas = {new CartaImpl('R',"A"), new CartaImpl('R',"K"), new CartaImpl('T',"A"), new CartaImpl('T',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorPareja(cartas);
        assertEquals(valor,26);
    }

    @Test
    public void testCalcularValorPareja3(){
        CartaImpl[] cartas = {new CartaImpl('R',"A"), new CartaImpl('P',"K"), new CartaImpl('T',"A"), new CartaImpl('T',"K")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorPareja(cartas);
        assertEquals(valor,26);
    }

    @Test
    public void testCalcularValorPareja4(){
        CartaImpl[] cartas = {new CartaImpl('R',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"A"), new CartaImpl('T',"K")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorPareja(cartas);
        assertEquals(valor,14);
    }

    @Test
    public void testCalcularValorPareja5(){
        CartaImpl[] cartas = {new CartaImpl('R',"5"), new CartaImpl('P',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorPareja(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorPareja6(){
        CartaImpl[] cartas = {new CartaImpl('R',"5"), new CartaImpl('P',"3"), new CartaImpl('P',"3"), new CartaImpl('T',"3"), new CartaImpl('T',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorPareja(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorDoblePareja(){
        CartaImpl[] cartas = {new CartaImpl('R',"2"), new CartaImpl('P',"2"), new CartaImpl('C',"A"), new CartaImpl('T',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorDoblePareja(cartas);
        assertEquals(valor,93);
    }

    @Test
    public void testCalcularValorDoblePareja1(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('R',"A"), new CartaImpl('C',"A"), new CartaImpl('T',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorDoblePareja(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorDoblePareja2(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('R',"K"), new CartaImpl('C',"A"), new CartaImpl('T',"K")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorDoblePareja(cartas);
        assertEquals(valor,104);
    }

    @Test
    public void testCalcularValorDoblePareja3(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('R',"K"), new CartaImpl('C',"A"), new CartaImpl('T',"K"), new CartaImpl('T',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorDoblePareja(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorDoblePareja4(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('R',"3"), new CartaImpl('C',"4"), new CartaImpl('T',"5"), new CartaImpl('T',"6")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorDoblePareja(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorDoblePareja5(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('R',"2"), new CartaImpl('C',"4"), new CartaImpl('T',"5"), new CartaImpl('T',"6")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorDoblePareja(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorDoblePareja6(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('R',"2"), new CartaImpl('C',"3"), new CartaImpl('T',"3"), new CartaImpl('T',"4"), new CartaImpl('R',"4")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorDoblePareja(cartas);
        assertEquals(valor,29);
    }

    @Test
    public void testCalcularValorDoblePareja7(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('R',"2"), new CartaImpl('C',"2"), new CartaImpl('T',"A"), new CartaImpl('T',"A"), new CartaImpl('R',"4")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorDoblePareja(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorTrio(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('R',"4"), new CartaImpl('C',"A"), new CartaImpl('T',"4")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorTrio(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorTrio1(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('R',"4"), new CartaImpl('C',"A"), new CartaImpl('T',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorTrio(cartas);
        assertEquals(valor,117);
    }

    @Test
    public void testCalcularValorTrio2(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('R',"4"), new CartaImpl('C',"2"), new CartaImpl('T',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorTrio(cartas);
        assertEquals(valor,105);
    }

    @Test
    public void testCalcularValorTrio3(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('R',"2"), new CartaImpl('C',"2"), new CartaImpl('T',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorTrio(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorTrio4(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('R',"2"), new CartaImpl('C',"2"), new CartaImpl('T',"3"), new CartaImpl('T',"3"), new CartaImpl('T',"3")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorTrio(cartas);
        assertEquals(valor,106);
    }

    @Test
    public void testCalcularValorTrio5(){
        CartaImpl[] cartas = {new CartaImpl('P',"5"), new CartaImpl('R',"3"), new CartaImpl('C',"5"), new CartaImpl('T',"5"), new CartaImpl('T',"3"), new CartaImpl('T',"3")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorTrio(cartas);
        assertEquals(valor,108);
    }

    @Test
    public void testCalcularValorTrio6(){
        CartaImpl[] cartas = {new CartaImpl('P',"5"), new CartaImpl('R',"3"), new CartaImpl('C',"5"), new CartaImpl('T',"5"), new CartaImpl('T',"3"), new CartaImpl('T',"3"), new CartaImpl('T',"5")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorTrio(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorEscalera(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('R',"10"), new CartaImpl('C',"K"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorEscalera1(){
        CartaImpl[] cartas = {new CartaImpl('C',"7"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorEscalera2(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('R',"4"), new CartaImpl('C',"7"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9"), new CartaImpl('R',"8")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,122);
    }

    @Test
    public void testCalcularValorEscalera3(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('R',"4"), new CartaImpl('C',"3"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9"), new CartaImpl('R',"8")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,118);
    }

    @Test
    public void testCalcularValorEscalera4(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('R',"10"), new CartaImpl('C',"3"), new CartaImpl('T',"A"), new CartaImpl('R',"K"), new CartaImpl('R',"Q"), new CartaImpl('R',"J")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,127);
    }

    @Test
    public void testCalcularValorEscalera5(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('R',"10"), new CartaImpl('C',"Q"), new CartaImpl('T',"A"), new CartaImpl('R',"K"), new CartaImpl('R',"Q"), new CartaImpl('R',"J")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,127);
    }

    @Test
    public void testCalcularValorEscalera6(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('C',"Q"), new CartaImpl('T',"3"), new CartaImpl('R',"K"), new CartaImpl('R',"10"), new CartaImpl('R',"J")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,127);
    }

    @Test
    public void testCalcularValorEscalera7(){
        CartaImpl[] cartas = {new CartaImpl('T',"Q"), new CartaImpl('T',"A"), new CartaImpl('T',"K"), new CartaImpl('T',"2"), new CartaImpl('T',"8"),new CartaImpl('T',"J"), new CartaImpl('T',"10")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,127);
    }

    @Test
    public void testCalcularValorColor(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('P',"10"), new CartaImpl('P',"K"), new CartaImpl('T',"A"), new CartaImpl('P',"5"), new CartaImpl('P',"9")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorColor(cartas);
        assertEquals(valor,139);
    }

    @Test
    public void testCalcularValorColor1(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('P',"10"), new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('T',"9"), new CartaImpl('P',"5")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorColor(cartas);
        assertEquals(valor,140);
    }

    @Test
    public void testCalcularValorColor2(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('T',"10"), new CartaImpl('C',"K"), new CartaImpl('P',"A"), new CartaImpl('T',"9"), new CartaImpl('P',"5")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorColor(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorColor3(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('P',"2"), new CartaImpl('P',"3"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('P',"6")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorColor(cartas);
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

        CartaImpl[] cartasP3 = {new CartaImpl('P',"6"), new CartaImpl('P',"3"), new CartaImpl('T',"6"), new CartaImpl('C',"3"), new CartaImpl('P',"5"), new CartaImpl('T',"3")};
        ges.ordenarCartas(cartasP3);
        valor = ges.calcularValorFull(cartasP3);
        assertEquals(valor,156);

        CartaImpl[] cartasP4 = {new CartaImpl('P',"6"), new CartaImpl('P',"A"), new CartaImpl('T',"6"), new CartaImpl('C',"A"), new CartaImpl('P',"5"), new CartaImpl('T',"A")};
        ges.ordenarCartas(cartasP4);
        valor = ges.calcularValorFull(cartasP4);
        assertEquals(valor,289);

        CartaImpl[] cartasP5 = {new CartaImpl('P',"A"), new CartaImpl('P',"A"), new CartaImpl('T',"K"), new CartaImpl('C',"A"), new CartaImpl('P',"5"), new CartaImpl('T',"K")};
        ges.ordenarCartas(cartasP5);
        valor = ges.calcularValorFull(cartasP5);
        assertEquals(valor,296);

        CartaImpl[] cartasP6 = {new CartaImpl('P',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"3"), new CartaImpl('C',"2"), new CartaImpl('P',"5"), new CartaImpl('T',"3")};
        ges.ordenarCartas(cartasP6);
        valor = ges.calcularValorFull(cartasP6);
        assertEquals(valor,141);
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
        mesaP0.anhadirJugador(0, new JugadorImpl());
        mesaP0.setCartasMesa(cartasP0);
        mesaP0.anhadirCartasJugador(0,cartasJugadorP0);
        int valor = ges.evaluarCartas(0,mesaP0);
        assertEquals(valor,310);

        //Prueba 1

        CartaImpl[] cartasP1 = {new CartaImpl('P',"3"), new CartaImpl('T',"5"), new CartaImpl('P',"7"), new CartaImpl('Z',"9"), new CartaImpl('A',"A")};
        CartaImpl[] cartasJugadorP1 = {new CartaImpl('T',"2"), new CartaImpl('P',"K")};
        MesaImpl mesaP1 = new MesaImpl();
        mesaP1.anhadirJugador(0, new JugadorImpl());
        mesaP1.setCartasMesa(cartasP1);
        mesaP1.anhadirCartasJugador(0,cartasJugadorP1);
        valor = ges.evaluarCartas(0,mesaP1);
        assertEquals(valor,13);

        //Prueba 2

        CartaImpl[] cartasP2 = {new CartaImpl(), new CartaImpl(), new CartaImpl(), new CartaImpl(), new CartaImpl()};
        CartaImpl[] cartasJugadorP2 = {new CartaImpl('T',"2"), new CartaImpl('P',"3")};
        MesaImpl mesaP2 = new MesaImpl();
        mesaP2.anhadirJugador(0, new JugadorImpl());
        mesaP2.setCartasMesa(cartasP2);
        mesaP2.anhadirCartasJugador(0,cartasJugadorP2);
        valor = ges.evaluarCartas(0,mesaP2);
        assertEquals(valor,2);

        //Prueba 3

        CartaImpl[] cartasP3 = {new CartaImpl('T',"Q"), new CartaImpl('T',"A"), new CartaImpl('T',"K"), new CartaImpl('T',"2"), new CartaImpl('T',"8")};
        CartaImpl[] cartasJugadorP3 = {new CartaImpl('T',"J"), new CartaImpl('T',"10")};
        MesaImpl mesaP3 = new MesaImpl();
        mesaP3.anhadirJugador(0, new JugadorImpl());
        mesaP3.setCartasMesa(cartasP3);
        mesaP3.anhadirCartasJugador(0,cartasJugadorP3);
        valor = ges.evaluarCartas(0,mesaP3);
        assertEquals(valor,319);

    }



}