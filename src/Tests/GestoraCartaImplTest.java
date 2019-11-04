package Tests;

import Clases.Basicas.CartaImpl;
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
        CartaImpl[] cartas = {new CartaImpl('R',"A"), new CartaImpl('P',"K"), new CartaImpl('T',"A"), new CartaImpl('T',"2")};
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


}