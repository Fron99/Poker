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
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('P',"2"), new CartaImpl('P',"3"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('P',"6")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorFull(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorFull1(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('P',"2"), new CartaImpl('T',"6"), new CartaImpl('C',"2"), new CartaImpl('P',"5"), new CartaImpl('P',"6")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorFull(cartas);
        assertEquals(valor,189);
    }

    @Test
    public void testCalcularValorFull2(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('P',"2"), new CartaImpl('T',"6"), new CartaImpl('C',"2"), new CartaImpl('P',"5"), new CartaImpl('T',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorFull(cartas);
        assertEquals(valor,144);
    }

    @Test
    public void testCalcularValorFull3(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('P',"3"), new CartaImpl('T',"6"), new CartaImpl('C',"3"), new CartaImpl('P',"5"), new CartaImpl('T',"3")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorFull(cartas);
        assertEquals(valor,156);
    }

    @Test
    public void testCalcularValorFull4(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('P',"A"), new CartaImpl('T',"6"), new CartaImpl('C',"A"), new CartaImpl('P',"5"), new CartaImpl('T',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorFull(cartas);
        assertEquals(valor,289);
    }

    @Test
    public void testCalcularValorFull5(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('P',"A"), new CartaImpl('T',"K"), new CartaImpl('C',"A"), new CartaImpl('P',"5"), new CartaImpl('T',"K")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorFull(cartas);
        assertEquals(valor,296);
    }

    @Test
    public void testCalcularValorFull6(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('P',"2"), new CartaImpl('T',"3"), new CartaImpl('C',"2"), new CartaImpl('P',"5"), new CartaImpl('T',"3")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorFull(cartas);
        assertEquals(valor,141);
    }

    @Test
    public void testCalcularValorPoker(){
        CartaImpl[] cartas = {new CartaImpl('P',"6"), new CartaImpl('P',"10"), new CartaImpl('P',"6"), new CartaImpl('T',"A"), new CartaImpl('P',"6"), new CartaImpl('P',"9"), new CartaImpl('P',"6")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorPoker(cartas);
        assertEquals(valor,301);
    }

    @Test
    public void testCalcularValorPoker1(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('P',"A"), new CartaImpl('P',"6"), new CartaImpl('T',"A"), new CartaImpl('P',"6"), new CartaImpl('P',"9"), new CartaImpl('P',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorPoker(cartas);
        assertEquals(valor,309);
    }

    @Test
    public void testCalcularValorPoker2(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('P',"A"), new CartaImpl('P',"2"), new CartaImpl('T',"A"), new CartaImpl('P',"2"), new CartaImpl('P',"9"), new CartaImpl('P',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorPoker(cartas);
        assertEquals(valor,297);
    }

    @Test
    public void testCalcularValorEscaleraColor(){
        CartaImpl[] cartas = {new CartaImpl('P',"3"), new CartaImpl('P',"A"), new CartaImpl('R',"2"), new CartaImpl('T',"A"), new CartaImpl('C',"2"), new CartaImpl('P',"9"), new CartaImpl('P',"2")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorEscaleraColor1(){
        CartaImpl[] cartas = {new CartaImpl('P',"3"), new CartaImpl('P',"A"), new CartaImpl('P',"2"), new CartaImpl('T',"A"), new CartaImpl('P',"4"), new CartaImpl('P',"5")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,310);
    }

    @Test
    public void testCalcularValorEscaleraColor2(){
        CartaImpl[] cartas = {new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"J"), new CartaImpl('T',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"10")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,319);
    }

    @Test
    public void testCalcularValorEscaleraColor3(){
        CartaImpl[] cartas = {new CartaImpl('T',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"J"), new CartaImpl('T',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"10")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,0);
    }

    @Test
    public void testCalcularValorEscaleraColor4(){
        CartaImpl[] cartas = {new CartaImpl('P',"3"), new CartaImpl('P',"A"), new CartaImpl('P',"2"), new CartaImpl('T',"2"), new CartaImpl('P',"4"), new CartaImpl('P',"5")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,310);
    }

    @Test
    public void testCalcularValorEscaleraColor5(){
        CartaImpl[] cartas = {new CartaImpl('P',"3"), new CartaImpl('P',"A"), new CartaImpl('P',"2"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('R',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,310);
    }

    @Test
    public void testCalcularValorEscaleraColor6(){
        CartaImpl[] cartas = {new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"J"), new CartaImpl('P',"10"), new CartaImpl('R',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,319);
    }

    @Test
    public void testCalcularValorEscaleraColor7(){
        CartaImpl[] cartas = {new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"J"), new CartaImpl('P',"10"), new CartaImpl('R',"10")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,319);
    }

    @Test
    public void testCalcularValorEscaleraColor8(){
        CartaImpl[] cartas = {new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"J"), new CartaImpl('P',"10"), new CartaImpl('Z',"10"), new CartaImpl('A',"10")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,319);
    }

    @Test
    public void testCalcularValorEscaleraColor9(){
        CartaImpl[] cartas = {new CartaImpl('P',"K"), new CartaImpl('P',"A"), new CartaImpl('P',"Q"), new CartaImpl('P',"J"), new CartaImpl('P',"10"), new CartaImpl('Z',"A"), new CartaImpl('A',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,319);
    }

    @Test
    public void testCalcularValorEscaleraColor10(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('P',"A"), new CartaImpl('P',"3"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('Z',"A"), new CartaImpl('A',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,310);
    }

    @Test
    public void testCalcularValorEscaleraColor11(){
        CartaImpl[] cartas = {new CartaImpl('P',"2"), new CartaImpl('P',"A"), new CartaImpl('P',"3"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('Z',"3"), new CartaImpl('A',"3")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        ges.ordenarCartas(cartas);
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,310);
    }

    @Test
    public void testCalcularValorEscaleracolor12(){
        CartaImpl[] cartas = {new CartaImpl('P',"A"), new CartaImpl('P',"Q"), new CartaImpl('T',"3"), new CartaImpl('P',"K"), new CartaImpl('P',"10"), new CartaImpl('P',"J")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        int valor = ges.calcularValorEscaleraColor(cartas);
        assertEquals(valor,319);
    }

    @Test
    public void testEvaluarCartas(){
        CartaImpl[] cartas = {new CartaImpl('P',"3"), new CartaImpl('P',"4"), new CartaImpl('P',"5"), new CartaImpl('Z',"3"), new CartaImpl('A',"3")};
        CartaImpl[] cartasJugador = {new CartaImpl('P',"2"), new CartaImpl('P',"A")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        MesaImpl mesa = new MesaImpl();
        mesa.anhadirJugador(0, new JugadorImpl());
        mesa.setCartasMesa(cartas);
        mesa.anhadirCartasJugador(0,cartasJugador);
        int valor = ges.evaluarCartas(0,mesa);
        assertEquals(valor,310);
    }

    @Test
    public void testEvaluarCartas1(){
        CartaImpl[] cartas = {new CartaImpl('P',"3"), new CartaImpl('T',"5"), new CartaImpl('P',"7"), new CartaImpl('Z',"9"), new CartaImpl('A',"A")};
        CartaImpl[] cartasJugador = {new CartaImpl('T',"2"), new CartaImpl('P',"K")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        MesaImpl mesa = new MesaImpl();
        mesa.anhadirJugador(0, new JugadorImpl());
        mesa.setCartasMesa(cartas);
        mesa.anhadirCartasJugador(0,cartasJugador);
        int valor = ges.evaluarCartas(0,mesa);
        assertEquals(valor,13);
    }

    @Test
    public void testEvaluarCartas2(){
        CartaImpl[] cartas = {new CartaImpl(), new CartaImpl(), new CartaImpl(), new CartaImpl(), new CartaImpl()};
        CartaImpl[] cartasJugador = {new CartaImpl('T',"2"), new CartaImpl('P',"3")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        MesaImpl mesa = new MesaImpl();
        mesa.anhadirJugador(0, new JugadorImpl());
        mesa.setCartasMesa(cartas);
        mesa.anhadirCartasJugador(0,cartasJugador);
        int valor = ges.evaluarCartas(0,mesa);
        assertEquals(valor,2);
    }

    @Test
    public void testEvaluarCartas3(){
        CartaImpl[] cartas = {new CartaImpl('T',"Q"), new CartaImpl('T',"A"), new CartaImpl('T',"K"), new CartaImpl('T',"2"), new CartaImpl('T',"8")};
        CartaImpl[] cartasJugador = {new CartaImpl('T',"J"), new CartaImpl('T',"10")};
        GestoraCartaImpl ges = new GestoraCartaImpl();
        MesaImpl mesa = new MesaImpl();
        mesa.anhadirJugador(0, new JugadorImpl());
        mesa.setCartasMesa(cartas);
        mesa.anhadirCartasJugador(0,cartasJugador);
        int valor = ges.evaluarCartas(0,mesa);
        assertEquals(valor,319);
    }

}