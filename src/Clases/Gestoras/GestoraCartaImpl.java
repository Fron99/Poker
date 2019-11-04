package Clases.Gestoras;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.MesaImpl;

public class GestoraCartaImpl {

    /*
     * SIGNATURA: public int evaluarCartas(int jugador, MesaImpl mesa);
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

    public int evaluarCartas(int jugador, MesaImpl mesa){

        int puntosFinales = 0;
        int puntosCartaAlta = 0,puntosPareja = 0,puntosDoblePareja = 0,puntosTrio = 0,puntosEscalera = 0;
        int puntosColor = 0,puntosFull = 0,puntosPoker = 0,puntosEscaleraColor = 0;
        CartaImpl[] cartasAEvaluar;
        GestoraCartaImpl gesCarta = new GestoraCartaImpl();

        //Obtener cartas que se quieren evaluar.
        cartasAEvaluar = obtenerCartasAEvaluar(jugador,mesa);

        //Ordenar las cartas obtenidas
        gesCarta.ordenarCartas(cartasAEvaluar);

        puntosCartaAlta = calcularValorCartaAlta(cartasAEvaluar);
        puntosPareja = calcularValorPareja(cartasAEvaluar);
        puntosDoblePareja = calcularValorCartaAlta(cartasAEvaluar);
        puntosTrio = calcularValorCartaAlta(cartasAEvaluar);
        puntosEscalera = calcularValorCartaAlta(cartasAEvaluar);
        puntosColor = calcularValorCartaAlta(cartasAEvaluar);
        puntosFull = calcularValorCartaAlta(cartasAEvaluar);
        puntosPoker = calcularValorCartaAlta(cartasAEvaluar);
        puntosEscaleraColor = calcularValorCartaAlta(cartasAEvaluar);


        return puntosFinales;
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


    /*
     * SIGNATURA: public void ordenarCartas(CartaImpl[] cartas);
     * COMENTARIO: Ordena las cartas de un array de cartas.
     * PRECONDICIONES: - Nada
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl
     * POSTCONDICIONES: - Modifica el array pasado por parametro ordenado las cartas que contiene de mayor a menor valor.
     */

    //TODO Desarrollar javadoc


    public void ordenarCartas(CartaImpl[] cartas){
        CartaImpl cartaAux;
        for(int i = 0; i < cartas.length - 1; i++){
            for(int j = 0; j < cartas.length - 1; j++){
                if (cartas[j].compareTo(cartas[j + 1]) == 1){
                    cartaAux = cartas[j+1];
                    cartas[j+1] = cartas[j];
                    cartas[j] = cartaAux;
                }
            }
        }
    }


    /*
     * SIGNATURA: public int calcularValorCartaAlta(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la carta mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Devuelve asociado al nombre un entero con la cantidad de puntos que tiene la carta mas alta del array pasado por parametro
     */

    //TODO Desarrollar javadoc

    public int calcularValorCartaAlta(CartaImpl[] cartas){
        int puntos = 0;
        puntos = cartas[cartas.length-1].getValorNumero();
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorPareja(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la pareja mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que tiene la pareja mas alta del array pasado por parametro
     *                  - Si no hay ninguna pareja devuelve 0
     */

    //TODO Desarrollar javadoc

    public int calcularValorPareja(CartaImpl[] cartas){
        int puntos = 0;
        for (int i = 0;i<cartas.length-1;i++){
            if (cartas[i].getNumero().equals(cartas[i+1].getNumero())){
                puntos = 13+cartas[i].getValorNumero();
            }
        }
        return puntos;
    }




}
