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

    @Test
    public void testCalcularValorPareja4(){
        CartaImpl[] cartas = {new CartaImpl('R',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"A"), new CartaImpl('T',"K")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorPareja(cartas);
        assertEquals(valor,14);
    }

    @Test
    public void testCalcularValorDoblePareja(){
        CartaImpl[] cartas = {new CartaImpl('R',"2"), new CartaImpl('P',"2"), new CartaImpl('C',"A"), new CartaImpl('T',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorDoblePareja(cartas);
        assertEquals(valor,40);
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
        assertEquals(valor,51);
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
        assertEquals(valor,130);
    }

    @Test
    public void testCalcularValorTrio2(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('R',"4"), new CartaImpl('C',"2"), new CartaImpl('T',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorTrio(cartas);
        assertEquals(valor,118);
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
    public void testCalcularValorEscalera(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('R',"10"), new CartaImpl('C',"K"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorEscalera1(){
        CartaImpl[] cartas = {new CartaImpl('C',"7"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorEscalera2(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('R',"4"), new CartaImpl('C',"7"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9"), new CartaImpl('R',"8")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,135);
    }

    @Test
    public void testCalcularValorEscalera3(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('R',"4"), new CartaImpl('C',"3"), new CartaImpl('T',"A"), new CartaImpl('R',"5"), new CartaImpl('R',"9"), new CartaImpl('R',"8")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,131);
    }

    @Test
    public void testCalcularValorEscalera4(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('R',"10"), new CartaImpl('C',"3"), new CartaImpl('T',"A"), new CartaImpl('R',"K"), new CartaImpl('R',"Q"), new CartaImpl('R',"J")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscalera(cartas);
        assertEquals(valor,140);
    }




}