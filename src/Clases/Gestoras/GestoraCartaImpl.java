package Clases.Gestoras;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.MesaImpl;

public class GestoraCartaImpl {

    /*
     * SIGNATURA: public int calcularValorCartas(int jugador, MesaImpl mesa);
     * COMENTARIO: Calcular el valor que tienen las cartas segun la puntuacion establecida.
     * PRECONDICIONES: - El entero del jugador debe ser entre 0 y 4
     *                 - Las cartas del array de la mesa deben estar correlativas y todas las cartas por defecto deben estar detras de las que tienen valor definido.
     *                 - Las cartas del array de cartas del jugador deben estar correlativas y todas las cartas por defecto deben estar detras de las que tienen valor definido.
     * ENTRADA: - Un objeto MesaImpl
     *          - Un entero para el jugador del cual se quiere evaluar los puntos
     * SALIDA: - Un entero con la puntuacion del jugador
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la puntuacion que tienen las cartas en ese momento del jugador pasado por parametro
     */

    //TODO Desarrollar javadoc

    public int calcularValorCartas(int jugador, MesaImpl mesa){

        int puntos = 0;
        CartaImpl[] cartasAEvaluar;

        //Obtener cartas que se quieren evaluar.
        cartasAEvaluar = obtenerCartasAEvaluar(jugador,mesa);
        //TODO Ordenar cartas con compareTo para poder evaluar mas facil

        return puntos;
    }


    /*
     * SIGNATURA: public CartaImpl[] obtenerCartasAEvaluar(int jugador, MesaImpl mesa);
     * COMENTARIO: Este metodo obtiene el total de cartas que tiene el jugador junto a las disponibles en la mesa para evaluarlas.
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un objeto MesaImpl
     *          - Un entero para el jugador del cual se quiere evaluar los puntos
     * SALIDA: - Un array de CartaImpl
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un array de CartaImpl con las cartas de las que dispone el jugador para evaluar
     */

    //TODO Desarrollar javadoc

    public CartaImpl[] obtenerCartasAEvaluar(int jugador, MesaImpl mesa){
        CartaImpl[] cartasTotales;

        int cantidadCartas = 0;
        CartaImpl[] cartasMesa = mesa.getCartasMesa();
        CartaImpl[] cartasJugador = mesa.getJugadores()[jugador].getCartas();

        //Obtiene la cantidad de cartas que hay en la mesa con valor distinto al de defecto
        for (int i = 0;i<cartasMesa.length&&(cartasMesa[i].getPalo()!='D');i++){
            cantidadCartas++;
        }

        //Obtiene la cantidad de cartas que posee el jugador pasado por parametro con valor distinto al de defecto
        for (int i = 0;i<cartasJugador.length&&(cartasJugador[i].getPalo()!='D');i++){
            cantidadCartas++;
        }

        cartasTotales = new CartaImpl[cantidadCartas];

        for (int i = 0; i<cartasTotales.length;i++){
            cartasTotales[i] = new CartaImpl();
        }

        //Anhade al array de cartas totales todas las cartas distintas al valor por defecto que hay en la mesa
        for (int i = 0;i<cartasMesa.length&&(cartasMesa[i].getPalo()!='D');i++){
            cartasTotales[i] = cartasMesa[i];
        }

        //Anhade al array de cartas totales todas las cartas distintas al valor por defecto que posee el jugador
        for (int i = 0,j = 0;i<cartasTotales.length;i++){
            if (cartasTotales[i].getPalo()=='D'){
                cartasTotales[i] = cartasJugador[j];
                j++;
            }
        }
        return cartasTotales;
    }


}
