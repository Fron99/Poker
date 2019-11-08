package Clases.Gestoras;

import Clases.Basicas.CartaImpl;
import Clases.Basicas.MesaImpl;

import java.util.ArrayList;

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

    /**
     * This method calculates the value of the cards of player passed by parameter in one table
     * @param jugador player of which we want to evaluate the cards
     * @param mesa table where the player plays
     * @return int with the value of the player's cards passed by parameter on a table
     */

    //TODO TERMINAR METODO

    public int evaluarCartas(int jugador, MesaImpl mesa){

        int puntosFinales, puntosCalculados;
        CartaImpl[] cartasAEvaluar;
        GestoraCartaImpl gesCarta = new GestoraCartaImpl();

        //Obtener cartas que se quieren evaluar.
        cartasAEvaluar = obtenerCartasAEvaluar(jugador,mesa);

        //Ordenar las cartas obtenidas
        gesCarta.ordenarCartas(cartasAEvaluar);
        gesCarta.ordenarCartas(cartasAEvaluar);

        //Va comprobando todos los valores de las distintas posibilidades que tiene el jugador y se queda con la posibilidad mas alta.
        puntosFinales = calcularValorCartaAlta(cartasAEvaluar);

        puntosCalculados = calcularValorPareja(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorDoblePareja(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorTrio(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorEscalera(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorColor(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        //puntosCalculados = calcularValorPoker(cartasAEvaluar);
        //if (puntosCalculados>puntosFinales){
            //puntosFinales = puntosCalculados;
        //}

        puntosCalculados = calcularValorPoker(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorEscaleraColor(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }
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

    /**
     * This method get the player's cards to evaluate
     * @param jugador player of which we want to evaluate the cards
     * @param mesa table where the player plays
     * @return CartaImpl[] array of CartaImpl with the player's cards passed by parameter
     */


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
     * PRECONDICIONES: - El array debe tener como minimo 2 cartas
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl
     * POSTCONDICIONES: - Modifica el array pasado por parametro ordenado las cartas que contiene de mayor a menor valor.
     */

    /**
     * This method sort the array passed by parameter
     * @param cartas Array of CartaImpl[] you want to order
     */

    public void ordenarCartas(CartaImpl[] cartas){
        CartaImpl cartaAux;
        //Para ordenar utiliza el metodo de compareTo de la clase CartaImpl
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

    /**
     * Calculate the highest card value in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorCartaAlta(CartaImpl[] cartas){
        int puntos = 0;
        if (cartas.length>1){
            puntos = cartas[cartas.length-1].getValorNumero();
        }
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

    /**
     * Calculate the highest value of the pair in the array passed by parameter
     * Returns 0 if there is no partner
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorPareja(CartaImpl[] cartas){
        int puntos = 0;
        if (cartas.length>1){
            for (int i = 0;i<cartas.length-1;i++){
                if (cartas[i].getNumero().equals(cartas[i+1].getNumero())){
                    puntos = 13+cartas[i].getValorNumero();
                }
            }
        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorDoblePareja(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la doble pareja mas alta que haya en el array pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con el valor de la doble pareja mas alta que haya
     *                  - Si no hay doble pareja devuelve 0
     */

    /**
     * Calculate the highest value of the pair in the array passed by parameter
     * Returns 0 if there is no pair
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorDoblePareja(CartaImpl[] cartas){
        int puntos = 0, cantidadParejas = 0, numPareja1, numPareja2, numPareja3, numPareja4;
        int [] valorParejas = new int[3];
        boolean trio = false;
        int [][] posibilidades = {{0,0},{1,2},{1,3},{2,3},{1,4},{2,4},{3,4},{1,5},{2,5},{3,5},{4,5},{1,6},{2,6},{3,6},{4,6},{5,6},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{1,8},{2,8},{3,8},{4,8},{5,8},{6,8},{7,8},{1,9},{2,9},{3,9},{4,9},{5,9},{6,9},{7,9},{8,9},{1,10},{2,10},{3,10},{4,10},{5,10},{6,10},{7,10},{8,10},{9,10},{1,11},{2,11},{3,11},{4,11},{5,11},{6,11},{7,11},{8,11},{9,11},{10,11},{1,12},{2,12},{3,12},{4,12},{5,12},{6,12},{7,12},{8,12},{9,12},{10,12},{11,12},{1,13},{2,13},{3,13},{4,13},{5,13},{6,13},{7,13},{8,13},{9,13},{10,13},{11,13},{12,13}};

        if (cartas.length>3){
            for (int i = 0, j = 0;i<cartas.length-1 && !trio && cantidadParejas < 3;i++){
                if (cartas[i].getNumero().equals(cartas[i+1].getNumero())){
                    //Este if se utiliza para controlar excepciones de ArrayIndexOutOfBoundsException
                    //Si i == cartas.length-3 significa que solo quedaran 2 cartas por lo cual no hay que comoprobar la tercera para ver si hay trio
                    if(i <= cartas.length-3){
                        //Esto comprueba que no haya un trio en el array. En el caso de que exista un trio devolvera 0
                        if (cartas[i].getNumero().equals(cartas[i+1].getNumero()) && cartas[i].getNumero().equals(cartas[i+2].getNumero())){
                            trio = true;
                        }else {
                            cantidadParejas++;
                            valorParejas[j] = cartas[i].getValorNumero();
                            j++;
                        }
                    }else {
                        cantidadParejas++;
                        valorParejas[j] = cartas[i].getValorNumero();
                        j++;
                    }

                }
            }
            //Solo se ejecutara cuando haya dos dobles parejas que sean diferentes y no haya trio
            if(cantidadParejas > 1 && !trio){
                //En el caso de que haya doble pareja busca el valor de la pareja mas alta
                for(int i = 0; i<valorParejas.length-1;i++){
                    for (int j = 0; j<posibilidades.length; j++){
                        if (posibilidades[j][0] == valorParejas[i]
                                && posibilidades[j][1] == valorParejas[i+1]){
                            puntos = 26 + j;
                        }
                    }
                }
            }
        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorTrio(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor del trio mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al trio mas alto del array pasado por parametro
     *                  - Si no hay ningun trio devuelve 0
     */

    /**
     * Calculate the highest value of the trio in the array passed by parameter
     * Returns 0 if there is no trio
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorTrio(CartaImpl[] cartas){
        int puntos = 0;
        boolean poker = false;
        if (cartas.length>2){
            for (int i = 0;i<cartas.length-2;i++){
                //Comprueba si hay poker
                if ( i<cartas.length-3
                        &&  (cartas[i].getNumero().equals(cartas[i+1].getNumero()))
                        && (cartas[i].getNumero().equals(cartas[i+2].getNumero()))
                        && (cartas[i].getNumero().equals(cartas[i+3].getNumero()))){

                    poker = true;

                }else{
                    //En el caso de no haber poker comprueba si hay trio
                    if ( (cartas[i].getNumero().equals(cartas[i+1].getNumero()))
                            && (cartas[i].getNumero().equals(cartas[i+2].getNumero())) ){

                        puntos = 104+cartas[i].getValorNumero();

                    }
                }
            }
            if (poker){
                puntos = 0;
            }
        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorEscalera(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la escalera mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde a la escalera mas alta del array pasado por parametro
     *                  - Si no hay ninguna escalera devuelve 0
     */

    /**
     * Calculate the highest value of the stair in the array passed by parameter
     * Returns 0 if there is no stair
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorEscalera(CartaImpl[] cartas){
        int puntos = 0;
        ArrayList<CartaImpl> cartasNoRepetidas = new ArrayList<>();
        boolean existe = false;
        //TODO Testear con valores repetidos en medio de la baraja y testear muy a fondo
        //TODO Ver si es rentable colocarlo con array normales
        if (cartas.length>4){
            cartasNoRepetidas.add(cartas[0]);
            for (int i = 0;i<cartas.length;i++){
                for (int j = 0; j<cartasNoRepetidas.size() && !existe;j++){
                    if (cartas[i].getValorNumero()==cartasNoRepetidas.get(j).getValorNumero()){
                        existe = true;
                    }
                }
                if (!existe){
                    cartasNoRepetidas.add(cartas[i]);
                }
                existe = false;
            }

            cartasNoRepetidas.sort(CartaImpl::compareTo);

            //Comprueba si la escalera de color puede ser que sea A,2,3,4,5
            //Como la carta A es la se mayor valor no se coloca delante en el array entonces hay que comprobarla estando detras
            if (cartasNoRepetidas.get(0).getValorNumero() == 1 && cartasNoRepetidas.get(cartasNoRepetidas.size() - 1).getValorNumero() == 13) {

                //Como sabemos que la primera carta sera el 2 y la ultima sera la A podemos usar posiciones absolutas para comprobar si hay escalera tipo A,2,3,4,5
                if ((cartasNoRepetidas.get(1).getValorNumero() == ((cartasNoRepetidas.get(0).getValorNumero()) + 1))
                        && (cartasNoRepetidas.get(2).getValorNumero() == ((cartasNoRepetidas.get(1).getValorNumero()) + 1))
                        && (cartasNoRepetidas.get(3).getValorNumero() == ((cartasNoRepetidas.get(2).getValorNumero()) + 1))) {

                    //En el caso de que pueda ser A,2,3,4,5,6 o incluso A,2,3,4,5,6,7 se realizara este bucle for para coger la escalera mas alta.
                    if (cartasNoRepetidas.get(4).getValorNumero() == cartasNoRepetidas.get(3).getValorNumero()) {
                        for (int i = 3, j = 0; cartasNoRepetidas.get(i + 1).getValorNumero() == cartasNoRepetidas.get(i).getValorNumero(); i++, j++) {
                            puntos = 117 + cartasNoRepetidas.get(j).getValorNumero();
                        }
                    } else {
                        //En el cado de que no haya una escalera mas grande se coloca la escalera del A,2,3,4,5
                        puntos = 117 + cartasNoRepetidas.get(0).getValorNumero();
                    }
                }

            }else{

                for (int i = 0; i < cartasNoRepetidas.size() - 4; i++) {

                    //Comprueba si hay ecalera ya que las cartas estan en orden
                    if ((cartasNoRepetidas.get(i+1).getValorNumero() == ((cartasNoRepetidas.get(i).getValorNumero()) + 1))
                            && (cartasNoRepetidas.get(i+2).getValorNumero() == ((cartasNoRepetidas.get(i+1).getValorNumero()) + 1))
                            && (cartasNoRepetidas.get(i+3).getValorNumero() == ((cartasNoRepetidas.get(i+2).getValorNumero()) + 1))
                            && (cartasNoRepetidas.get(i+4).getValorNumero() == ((cartasNoRepetidas.get(i+3).getValorNumero()) + 1))) {

                        //Se le suma 1 a la cantidad total porque el valor 131 se deja guardado para la escalera A,2,3,4,5
                        //Si no se le sumara 1 la escalera 2,3,4,5,6 tendria el mismo valor que la escalera A,2,3,4,5 por el echo de como se ordenan las cartas de mayor a menor
                        puntos = 117 + (cartasNoRepetidas.get(i).getValorNumero()+1);

                    }

                }

            }

        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorColor(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor de la carta mas alta cuando hay color
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al color mas alto del array pasado por parametro
     *                  - Si no hay color devuelve 0
     */

    /**
     * Calculate the highest value of the color in the array passed by parameter
     * Returns 0 if there is no color
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorColor(CartaImpl[] cartas){
        int puntos = 0;
        char paloColor;
        CartaImpl cartaAltaColor;

        //Calcula si hay algun 5 cartas del mismo color en el array pasado por parametro
        //Si no hay devolvera N lo cual no se ejecutara
        paloColor = calcularColor(cartas);

        if (paloColor != 'N'){

            //Carta por defecto con el valor minimo
            cartaAltaColor = new CartaImpl(paloColor,"2");

            //Este for se utiliza para sacar la carta mas alta del color
            for (CartaImpl carta: cartas){

                if (carta.getPalo() == paloColor){

                    if (carta.getValorNumero()>cartaAltaColor.getValorNumero()){
                        cartaAltaColor = carta;
                    }

                }

            }

            puntos = 127 + cartaAltaColor.getValorNumero();

        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorFull(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor del full del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponden al full mas alto del array pasado por parametro
     *                  - Si no hay full devuelve 0
     */

    //TODO Desarrollar javadoc
    //TODO REALIZAR CALCULAR EL VALOR DE FULL

    public int calcularValorFull(CartaImpl[] cartas){
        int puntos = 0;
        int cantidadTrios = 0, cantidadParejas = 0;
        int [][] posibilidades = {{0,0},{1,2},{1,3},{2,3},{1,4},{2,4},{3,4},{1,5},{2,5},{3,5},{4,5},{1,6},{2,6},{3,6},{4,6},{5,6},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{1,8},{2,8},{3,8},{4,8},{5,8},{6,8},{7,8},{1,9},{2,9},{3,9},{4,9},{5,9},{6,9},{7,9},{8,9},{1,10},{2,10},{3,10},{4,10},{5,10},{6,10},{7,10},{8,10},{9,10},{1,11},{2,11},{3,11},{4,11},{5,11},{6,11},{7,11},{8,11},{9,11},{10,11},{1,12},{2,12},{3,12},{4,12},{5,12},{6,12},{7,12},{8,12},{9,12},{10,12},{11,12},{1,13},{2,13},{3,13},{4,13},{5,13},{6,13},{7,13},{8,13},{9,13},{10,13},{11,13},{12,13}};

        if (cartas.length>4){
            for (int i = 0;i<cartas.length-2;i++){
                if (cartas[i].getNumero().equals(cartas[i+1].getNumero())){

                }
            }
        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorPoker(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor del poker del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array debe estar ordenado de menor a mayor
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al poker mas alto del array pasado por parametro
     *                  - Si no hay poker devuelve 0
     */

    /**
     * Calculate the highest value of the poker in the array passed by parameter
     * Returns 0 if there is no poker
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorPoker(CartaImpl[] cartas){
        int puntos = 0;
        if (cartas.length>3){
            //Como el array esta ordenado las 4 cartas estaran juntas en el caso de haber poker por lo cual se comprueba de esta manera
            for (int i = 0;i<cartas.length-3;i++){
                if ( (cartas[i].getNumero().equals(cartas[i+1].getNumero()))
                        && (cartas[i].getNumero().equals(cartas[i+2].getNumero()))
                        && (cartas[i].getNumero().equals(cartas[i+3].getNumero()))){

                    puntos = 219+cartas[i].getValorNumero();

                }
            }
        }
        return puntos;
    }


    /*
     * SIGNATURA: public int calcularValorEscaleraColor(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor de la escalera de color del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde a la escalera de color mas alta del array pasado por parametro
     *                  - Si no hay escalera de color devuelve 0
     */

    /**
     * Calculate the highest value of the color stair in the array passed by parameter
     * Returns 0 if there is no color stair
     * @param cartas CartaImpl[] cards you want to value
     */

    public int calcularValorEscaleraColor(CartaImpl[] cartas){

        int puntos = 0;
        char color;
        int cantidadCartas = 0;
        CartaImpl[] cartasColor;

        if (cartas.length>4) {

            //Calcula si hay 5 o mas cartas del mismo color en el array pasado por parametro
            color = calcularColor(cartas);

            if (color != 'N') {

                //Calcula la cantidad de cartas que hay del mismo color
                for (CartaImpl carta : cartas){
                    if (carta.getPalo() == color) {
                        cantidadCartas++;
                    }
                }

                cartasColor = new CartaImpl[cantidadCartas];

                //Anhade todas las cartas del mismo color en un array para comprobar de este array si hay escalera de color
                for (int i = 0, j = 0; i < cartas.length; i++) {
                    if (cartas[i].getPalo() == color) {
                        cartasColor[j] = cartas[i];
                        j++;
                    }
                }

                ordenarCartas(cartasColor);

                //Comprueba si la escalera de color puede ser que sea A,2,3,4,5
                //Como la carta A es la se mayor valor no se coloca delante en el array entonces hay que comprobarla estando detras
                if (cartasColor[0].getValorNumero() == 1 && cartas[cartas.length - 1].getValorNumero() == 13) {

                    //Como sabemos que la primera carta sera el 2 y la ultima sera la A podemos usar posiciones absolutas para comprobar si hay escalera tipo A,2,3,4,5
                    if ((cartasColor[1].getValorNumero() == ((cartasColor[0].getValorNumero()) + 1))
                            && (cartasColor[2].getValorNumero() == ((cartasColor[1].getValorNumero()) + 1))
                            && (cartasColor[3].getValorNumero() == ((cartasColor[2].getValorNumero()) + 1))) {

                        //En el caso de que pueda ser A,2,3,4,5,6 o incluso A,2,3,4,5,6,7 se realizara este bucle for para coger la escalera mas alta.
                        if (cartasColor[4].getValorNumero() == cartasColor[3].getValorNumero()) {
                            for (int i = 3, j = 0; cartasColor[i + 1].getValorNumero() == cartasColor[i].getValorNumero(); i++, j++) {
                                puntos = 132 + cartasColor[j].getValorNumero();
                            }
                        } else {
                            //En el cado de que no haya una escalera mas grande se coloca la escalera del A,2,3,4,5
                            puntos = 232 + cartasColor[0].getValorNumero();
                        }
                    }

                }else{

                    for (int i = 0; i < cartasColor.length - 4; i++) {

                        if ((cartasColor[i+1].getValorNumero() == ((cartasColor[i].getValorNumero()) + 1))
                                && (cartasColor[i+2].getValorNumero() == ((cartasColor[i+1].getValorNumero()) + 1))
                                && (cartasColor[i+3].getValorNumero() == ((cartasColor[i+2].getValorNumero()) + 1))
                                && (cartasColor[i+4].getValorNumero() == ((cartasColor[i+3].getValorNumero()) + 1))) {

                            puntos = 232 + (cartas[i].getValorNumero()) + 1;

                        }

                    }

                }
            }
        }
        return puntos;
    }


    /*
     * SIGNATURA: public char calcularColor(CartaImpl[] cartas);
     * COMENTARIO: Metodo para calcular si hay color en el array de cartas
     * PRECONDICIONES: - Nada
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un caracter
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un caracter con el tipo de color que hay en el array (T,P,C,R)
     *                  - Si no hay color se devolvera N
     */

    public char calcularColor(CartaImpl[] cartas){
        char color = 'N';
        int contadorPica = 0, contadorCorazon = 0, contadorTrevol = 0, contadorRombo = 0;

        for (CartaImpl carta : cartas) {
            if (carta.getPalo() == 'P') {
                contadorPica++;
            } else {
                if (carta.getPalo() == 'C') {
                    contadorCorazon++;
                } else {
                    if (carta.getPalo() == 'T') {
                        contadorTrevol++;
                    } else {
                        if (carta.getPalo() == 'R') {
                            contadorRombo++;
                        }
                    }
                }
            }
        }

        if (contadorPica>4 || contadorCorazon>4 ||contadorTrevol>4 || contadorRombo>4){
            if (contadorPica>4){
                color = 'P';
            }else{
                if (contadorCorazon>4){
                    color = 'C';
                }else{
                    if (contadorTrevol>4){
                        color = 'T';
                    }else{
                        color = 'R';
                    }
                }
            }
        }

        return color;
    }

}
