package managements;

import basicsClasses.CardImpl;
import basicsClasses.TableImpl;

import java.util.ArrayList;

public class ManagementCardImpl {

    
    /*
     * SIGNATURA: public int calcularValorCartaAlta(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la carta mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: Devuelve asociado al nombre un entero con la cantidad de puntos que tiene la carta mas alta del array pasado por parametro
     */

    /**
     * Calculate the highest card value in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return returns the value of the highest card
     */

    public int calcularValorCartaAlta(CardImpl[] cartas){
        CardImpl[] cartasOrdenadas = new CardImpl[cartas.length];
        System.arraycopy(cartas,0,cartasOrdenadas,0,cartas.length);
        ordenarCartas(cartasOrdenadas);
        int puntos = 0;
        if (cartasOrdenadas.length>1){
            puntos = cartasOrdenadas[cartasOrdenadas.length-1].getValueNumber();
        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorPareja(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la pareja mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que tiene la pareja mas alta del array pasado por parametro
     *                  - Si no hay ninguna pareja devuelve 0
     */

    /**
     * Calculate the highest value of the pair in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return Returns 0 if not exist pair in array. Returns the value of pair if exist pair in array.
     */

    public int calcularValorPareja(CardImpl[] cartas){
        CardImpl[] cartasOrdenadas = new CardImpl[cartas.length];
        System.arraycopy(cartas,0,cartasOrdenadas,0,cartas.length);
        ordenarCartas(cartasOrdenadas);
        int puntos = 0;
        if (cartasOrdenadas.length>1){
            for (int i = 0; i < cartasOrdenadas.length-1; i++){
                if (i == 0 && cartasOrdenadas.length == 2){
                    if (cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i+1].getValueNumber()){
                        puntos = 13 + cartasOrdenadas[i].getValueNumber();
                    }
                }else{
                    if (i == 0){
                        if (cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i+1].getValueNumber()
                            && cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i+2].getValueNumber()){
                            puntos = 13 + cartasOrdenadas[i].getValueNumber();
                        }
                    }else{
                        if (i < cartasOrdenadas.length - 3){
                            if (cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i-1].getValueNumber()
                                && cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i+1].getValueNumber()
                                && cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i+2].getValueNumber()){
                                puntos = 13 + cartasOrdenadas[i].getValueNumber();
                            }
                        }else{
                            if (i == cartasOrdenadas.length - 2){
                                if (cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i-1].getValueNumber()
                                    && cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i+1].getValueNumber()){
                                    puntos = 13 + cartasOrdenadas[i].getValueNumber();
                                }
                            }
                        }
                    }
                }
            }
        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorDoblePareja(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la doble pareja mas alta que haya en el array pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con el valor de la doble pareja mas alta que haya
     *                  - Si no hay doble pareja devuelve 0
     */

    /**
     * Calculate the highest value of the pair in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return Returns 0 if not exist double pair in array. Returns the value of double pair if exist double pair in array.
     */

    public int calcularValorDoblePareja(CardImpl[] cartas){
        int puntos = 0;
        CardImpl[] cartasOrdenadas = new CardImpl[cartas.length];
        System.arraycopy(cartas,0,cartasOrdenadas,0,cartas.length);
        ordenarCartas(cartasOrdenadas);
        ArrayList<Integer> parejas = new ArrayList<>();
        int [][] posibilidades = new int[78][2];
        //Se crean todas las posibilidades que hay de doble pareja
        for (int i = 0, contadorParcial = 1, contadorTotal = 2;i<posibilidades.length;i++,contadorParcial++){
            if (contadorParcial == 14){
                contadorTotal++;
                contadorParcial = 1;
            }
            if (contadorTotal == contadorParcial){
                contadorTotal++;
                contadorParcial = 1;
            }
            posibilidades[i][1] = contadorTotal;
            posibilidades[i][0] = contadorParcial;
        }

        //Si no hay minimo 4 cartas no se puede calcular la doble pareja
        if (cartasOrdenadas.length>3){
            //Recorremos el array en busca de las doble pareja
            for (int i = 0;i<cartasOrdenadas.length-1;i++){
                //Se ejecuta cuando el indice esta al principio de la baraja
                if (i == 0){
                    //Comprueba que el valor de la siguiente carta a las cartas de la pareja sea distinta
                    if (cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i+1].getValueNumber()
                        && cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i+2].getValueNumber()) {
                        parejas.add(cartasOrdenadas[i].getValueNumber());
                    }
                }else{
                    //Se ejecuta cuando el indice esta en medio de la baraja
                    if (i < cartasOrdenadas.length-2){
                        //Comprueba que el valor de la siguiente carta y la anterior a las cartas de la pareja sea distinta
                        if (cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i-1].getValueNumber()
                            && cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i+1].getValueNumber()
                            && cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i+2].getValueNumber()) {
                            parejas.add(cartasOrdenadas[i].getValueNumber());
                        }
                    }else{
                        //Se ejecuta cuando el indice esta al final de la baraja
                        if (i == cartasOrdenadas.length-2){
                            //Comprueba que el valor de la anterior a las cartas de la pareja sea distinta
                            if (cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i-1].getValueNumber()
                                && cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i+1].getValueNumber()) {
                                parejas.add(cartasOrdenadas[i].getValueNumber());
                            }
                        }
                    }
                }
            }

            //En el caso de que haya mas de 1 pareja buscamos el valor de la carta
            if (parejas.size()>1){
                //Recorre el array buscando la combinacion
                for (int j = 0; j<posibilidades.length; j++){
                    //Utilizamos .size()-X porque asi cogemos las dos ultimas parejas que son las de mayor valor
                    if (posibilidades[j][0] == parejas.get(parejas.size()-2)
                        && posibilidades[j][1] == parejas.get(parejas.size()-1)){
                        puntos = 26 + (j+1);
                    }
                }
            }
        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorTrio(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor del trio mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * Salida: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al trio mas alto del array pasado por parametro
     *                  - Si no hay ningun trio devuelve 0
     */

    /**
     * Calculate the highest value of the trio in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return Returns 0 if not exists trio in array passed by parameter. Retunrs the value of the trio if exists trio in array passed by parameter
     */

    public int calcularValorTrio(CardImpl[] cartas){
        int puntos = 0;
        CardImpl[] cartasOrdenadas = new CardImpl[cartas.length];
        System.arraycopy(cartas,0,cartasOrdenadas,0,cartas.length);
        ordenarCartas(cartasOrdenadas);
        if (cartasOrdenadas.length>2) {
            //Recorremos el array para buscar trios
            for (int i = 0; i < cartasOrdenadas.length - 2; i++) {
                //Comprobar si hay trio cuando el indice esta al principio del array
                if (i == 0 && cartasOrdenadas.length > 3) {
                    //Comprueba que haya trio y que la siguiente carta al trio sea distinta
                    if (cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 1].getValueNumber()
                        && cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 2].getValueNumber()
                        && cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i + 3].getValueNumber()) {

                        puntos = 104 + cartasOrdenadas[i].getValueNumber();

                    }
                } else {
                    //No hace falta comprobar que es menor que 4 porque arriba esta comprobado > 3 y si entra aqui es porque no se ha cumplido
                    if (i == 0) {
                        //Comprueba que haya trio
                        if (cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 1].getValueNumber()
                                && cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 2].getValueNumber()) {

                            puntos = 104 + cartasOrdenadas[i].getValueNumber();

                        }
                    } else {
                        //No hace falta que compruebe i != 0 porque esta comprobado en los casos anteriores
                        //Comprueba cuando el indice esta en medio
                        if (i < cartasOrdenadas.length - 4) {
                            //Comprueba que la carta anterior y posterior a las cartas que forman el trio sean de distinto valor a la del trio
                            if (cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i - 1].getValueNumber()
                                    && cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 1].getValueNumber()
                                    && cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 2].getValueNumber()
                                    && cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i + 3].getValueNumber()) {

                                puntos = 104 + cartasOrdenadas[i].getValueNumber();

                            }
                        } else {
                            //Comprueba cuando el indice ya es el ultimo posible a evaluar
                            if (i == cartasOrdenadas.length - 3) {
                                //Comprueba que la carta posterior a las cartas que forman el trio sean de distinto valor a la del trio
                                if (cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i - 1].getValueNumber()
                                        && cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 1].getValueNumber()
                                        && cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 2].getValueNumber()) {

                                    puntos = 104 + cartasOrdenadas[i].getValueNumber();

                                }
                            }
                        }
                    }
                }
            }
        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorEscalera(CartaImpl[] cartas);
     * COMENTARIO: Calcular el valor de la escalera mas alta del array de cartas pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde a la escalera mas alta del array pasado por parametro
     *                  - Si no hay ninguna escalera devuelve 0
     */

    /**
     * Calculate the highest value of the stair in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return Returns 0 if there is no stair. Returns the value of stair if exist in array.
     */

    public int calcularValorEscalera(CardImpl[] cartas){
        int puntos = 0;
        ArrayList<CardImpl> cartasNoRepetidas = new ArrayList<>();
        boolean existe = false;
        if (cartas.length>4){

            //Array para guardar las cartas sin que esten repetidas
            cartasNoRepetidas.add(cartas[0]);

            //Recorremos las cartas para guardar en el ArrayList cartasNoRepetidas las cartas sin repetir
            for (CardImpl carta: cartas){

                //Recorre el array comprobando que esa carta no este añadida ya
                for (int j = 0; j<cartasNoRepetidas.size() && !existe;j++){
                    if (carta.getValueNumber()==cartasNoRepetidas.get(j).getValueNumber()){
                        existe = true;
                    }
                }

                //Si no existe la añade
                if (!existe){
                    cartasNoRepetidas.add(carta);
                }
                existe = false;
            }

            //Orderna el array para porder evaluarlo
            cartasNoRepetidas.sort(CardImpl::compareTo);

            //Comprueba si la escalera de color puede ser que sea A,2,3,4,5
            //Como la carta A es la se mayor valor no se coloca delante en el array entonces hay que comprobarla estando detras
            if (cartasNoRepetidas.get(0).getValueNumber() == 1 && cartasNoRepetidas.get(cartasNoRepetidas.size() - 1).getValueNumber() == 13) {

                //Como sabemos que la primera carta sera el 2 y la ultima sera la A podemos usar posiciones absolutas para comprobar si hay escalera tipo A,2,3,4,5
                if ((cartasNoRepetidas.get(1).getValueNumber() == ((cartasNoRepetidas.get(0).getValueNumber()) + 1))
                        && (cartasNoRepetidas.get(2).getValueNumber() == ((cartasNoRepetidas.get(1).getValueNumber()) + 1))
                        && (cartasNoRepetidas.get(3).getValueNumber() == ((cartasNoRepetidas.get(2).getValueNumber()) + 1))) {

                    //En el caso de que pueda ser A,2,3,4,5,6 o incluso A,2,3,4,5,6,7 se realizara este bucle for para coger la escalera mas alta.
                    if (cartasNoRepetidas.get(4).getValueNumber() == cartasNoRepetidas.get(3).getValueNumber()) {
                        for (int i = 3, j = 0; cartasNoRepetidas.get(i + 1).getValueNumber() == cartasNoRepetidas.get(i).getValueNumber(); i++, j++) {
                            puntos = 117 + cartasNoRepetidas.get(j).getValueNumber();
                        }
                    } else {
                        //En el cado de que no haya una escalera mas grande se coloca la escalera del A,2,3,4,5
                        puntos = 117 + cartasNoRepetidas.get(0).getValueNumber();
                    }
                }

            }

            for (int i = 0; i < cartasNoRepetidas.size() - 4; i++) {

                //Comprueba si hay ecalera ya que las cartas estan en orden
                if ((cartasNoRepetidas.get(i+1).getValueNumber() == ((cartasNoRepetidas.get(i).getValueNumber()) + 1))
                        && (cartasNoRepetidas.get(i+2).getValueNumber() == ((cartasNoRepetidas.get(i+1).getValueNumber()) + 1))
                        && (cartasNoRepetidas.get(i+3).getValueNumber() == ((cartasNoRepetidas.get(i+2).getValueNumber()) + 1))
                        && (cartasNoRepetidas.get(i+4).getValueNumber() == ((cartasNoRepetidas.get(i+3).getValueNumber()) + 1))) {

                    //Se le suma 1 a la cantidad total porque el valor 131 se deja guardado para la escalera A,2,3,4,5
                    //Si no se le sumara 1 la escalera 2,3,4,5,6 tendria el mismo valor que la escalera A,2,3,4,5 por el echo de como se ordenan las cartas de mayor a menor
                    puntos = 117 + (cartasNoRepetidas.get(i).getValueNumber()+1);

                }

            }

        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorColor(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor de la carta mas alta cuando hay color
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al color mas alto del array pasado por parametro
     *                  - Si no hay color devuelve 0
     */

    /**
     * Calculate the highest value of the color in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return Returns 0 if there is no color. Returns the value of color if exist color in array.
     */

    public int calcularValorColor(CardImpl[] cartas){
        int puntos = 0;
        char paloColor;
        CardImpl cartaAltaColor;

        //Calcula si hay 5 cartas del mismo color en el array pasado por parametro
        //Si no hay devolvera N lo cual no se ejecutara
        paloColor = calcularTipoColor(cartas);

        if (paloColor != 'N'){

            //Carta por defecto con el valor minimo
            cartaAltaColor = new CardImpl(paloColor,"2");

            //Este for se utiliza para sacar la carta mas alta del color
            for (CardImpl carta: cartas){
                if (carta.getSuit() == paloColor){
                    if (carta.getValueNumber()>cartaAltaColor.getValueNumber()){
                        cartaAltaColor = carta;
                    }
                }
            }
            //El valor del color depende de la carta mas alta del color.
            puntos = 127 + cartaAltaColor.getValueNumber();
        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorFull(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor del full del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponden al full mas alto del array pasado por parametro
     *                  - Si no hay full devuelve 0
     */

    /**
     * Calculate the value of the "Full" in deck of cards.
     * @param cartas CartaImpl[] cards you want to value
     * @return int with value of the "Full" in poker. If not exist "Full" in the deck of cards, returns 0
     */

    public int calcularValorFull(CardImpl[] cartas){
        CardImpl[] cartasOrdenadas = new CardImpl[cartas.length];
        System.arraycopy(cartas,0,cartasOrdenadas,0,cartas.length);
        ordenarCartas(cartasOrdenadas);
        int puntos = 0;
        int cantidadTrios = 0, cantidadParejas = 0;
        int valorTrio = 0, valorPareja = 0;
        int [][] posibilidades = new int[156][2];
        //For para colocar todas las posibilidades de full
        for (int i = 0, contadorParcial = 1, contadorTotal = 1;i<posibilidades.length;i++,contadorParcial++){
            if (contadorParcial == 14){
                contadorTotal++;
                contadorParcial = 1;
            }
            if (contadorTotal == contadorParcial){
                contadorParcial++;
            }
            posibilidades[i][0] = contadorTotal;
            posibilidades[i][1] = contadorParcial;
        }

        if (cartasOrdenadas.length>=5){
            //Recorre el array contando cuantos trios existen el la baraja y obteniendo su valor
            for (int i = 0;i<cartasOrdenadas.length-2;i++){
                //Con estos ifs se controla que no haya poker
                //Comprueba si hay trio al principio del array
                if (i == 0){
                    //Comprueba que el valor de la siguente carta a las tres del trio sea distinto, ya que si no habria poker
                    if (cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+1].getNumber())
                        && cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+2].getNumber())
                        && !(cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+3].getNumber()))){
                        valorTrio = cartasOrdenadas[i].getValueNumber();
                        cantidadTrios++;
                    }
                }else{
                    //Comprueba si hay trio en medio del array
                    if (i <= cartasOrdenadas.length-4){
                        //Comprueba que el valor de la siguiente carta y la anterior a las tres del trio sea distinto, ya que si no habria poker
                        if (!(cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i-1].getNumber()))
                            && cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+1].getNumber())
                            && cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+2].getNumber())
                            && !(cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+3].getNumber()))){
                            valorTrio = cartasOrdenadas[i].getValueNumber();
                            cantidadTrios++;
                        }
                    }else{
                        //Comprueba si hay trio al final del array
                        if (i == cartasOrdenadas.length-3){
                            //Comprueba que el valor de la anterior carta a las tres del trio sea distinto, ya que si no habria poker
                            if (!(cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i-1].getNumber()))
                                && cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+1].getNumber())
                                && cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+2].getNumber())){
                                valorTrio = cartasOrdenadas[i].getValueNumber();
                                cantidadTrios++;
                            }
                        }
                    }
                }
            }

            //Si hay un trio comprueba si hay parejas
            if (cantidadTrios > 0){
                for (int i = 0; i < cartasOrdenadas.length-1; i++) {
                    //En el caso de que el valor de la carta sea igual que la del trio no se evalua
                    if (cartasOrdenadas[i].getValueNumber() != valorTrio){
                        //No hace falta comprobar que i se pase de rango por arriba porque ya esta controlado en un if de arriba
                        //Comprueba si hay pareja al principio del array
                        if (i == 0){
                            //Comprueba que el valor de la siguiente carta a las dos de la pareja sea distinto, ya que si no habria trio
                            if (cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 1].getValueNumber()
                                && cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i + 2].getValueNumber()) {
                                valorPareja = cartasOrdenadas[i].getValueNumber();
                                cantidadParejas++;
                            }
                        }else{
                            //Comprueba si hay pareja en medio del array
                            if (i <= cartasOrdenadas.length-3){
                                //Comprueba que el valor de la siguiente carta y la anterior a las dos de la pareja sea distinto, ya que si no habria trio
                                if (cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 1].getValueNumber()
                                    && cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i + 2].getValueNumber()
                                    && cartasOrdenadas[i].getValueNumber() != cartasOrdenadas[i - 1].getValueNumber()) {
                                    valorPareja = cartasOrdenadas[i].getValueNumber();
                                    cantidadParejas++;
                                }
                            }else{
                                //Comprueba si hay pareja al final del array
                                if (i == cartasOrdenadas.length-2){
                                    //Comprueba que el valor de la anterior carta a las dos de la pareja sea distinto, ya que si no habria trio
                                    if (cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i + 1].getValueNumber()
                                        && !(cartasOrdenadas[i].getValueNumber() == cartasOrdenadas[i - 1].getValueNumber())) {
                                        valorPareja = cartasOrdenadas[i].getValueNumber();
                                        cantidadParejas++;
                                    }
                                }
                            }
                        }
                    }
                }

                //En el caso de no haber una pareja y haber 2 trios o mas se podra usar el 2 trio mas alto como pareja
                if (cantidadParejas == 0 && cantidadTrios > 1){
                    //Recorre el array contando cuantos trios existen el la baraja
                    for (int i = 0;i<cartasOrdenadas.length-2;i++){
                        //Este if se usa para que no se evalue el trio elegido arriba (asi se coge el segundo trio mas valorado y no se coge el primero por lo cual no se repite)
                        if (cartasOrdenadas[i].getValueNumber() != valorTrio) {
                            //Comprueba si hay trio al principio del array
                            if (i == 0){
                                //Comprueba que el valor de la siguente carta a las tres del trio sea distinto, ya que si no habria full
                                if (cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+1].getNumber())
                                    && cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+2].getNumber())
                                    && !cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+3].getNumber())){
                                    //Se guarda en la variable de pareja porque se usa el segundo trio mas alto como pareja al no haber pareja y si mas de 1 trio
                                    valorPareja = cartasOrdenadas[i].getValueNumber();
                                    cantidadParejas++;
                                }
                            }else{
                                //Comprueba si hay trio en medio del array
                                if (i <= cartasOrdenadas.length-4){
                                    //Comprueba que el valor de la siguiente carta y la anterior a las tres del trio sea distinto, ya que si no habria full
                                    if (!cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i-1].getNumber())
                                        && cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+1].getNumber())
                                        && cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+2].getNumber())
                                        && !cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+3].getNumber())){
                                        //Se guarda en la variable de pareja porque se usa el segundo trio mas alto como pareja al no haber pareja y si mas de 1 trio
                                        valorPareja = cartasOrdenadas[i].getValueNumber();
                                        cantidadParejas++;
                                    }
                                }else{
                                    //Comprueba si hay trio al final del array
                                    if (i == cartasOrdenadas.length-3){
                                        //Comprueba que el valor de la anterior carta a las tres del trio sea distinto, ya que si no habria full
                                        if (!cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i-1].getNumber())
                                            && cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+1].getNumber())
                                            && cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+2].getNumber())){
                                            //Se guarda en la variable de pareja porque se usa el segundo trio mas alto como pareja al no haber pareja y si mas de 1 trio
                                            valorPareja = cartasOrdenadas[i].getValueNumber();
                                            cantidadParejas++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            //No hace falta comprobar que la cantidad de trios sea superior a 0 porque si la cantidad de parejas es superior a 0 significa que se ha entrado en la condifion del if (cantidadTrios > 0)
            //Se comprueba antes que la cantidad de trios sea superior a 0 porque asi nos evitamos buscar parejas si no hay minimo 1 trio
            if (cantidadParejas > 0){
                //Recorre el array buscando cual es el valor del full
                for (int i = 0; i<posibilidades.length && puntos==0; i++){
                    if (posibilidades[i][0] == valorTrio && posibilidades[i][1] == valorPareja){
                        //Se le suma 1 a i ya que el array empieza por 0 y entonces la muestra un punto menos en todas las combinaciones posibles
                        puntos = 140 + (i+1);
                    }
                }
            }
        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorPoker(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor del poker del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la cantidad de puntos que corresponde al poker mas alto del array pasado por parametro
     *                  - Si no hay poker devuelve 0
     */

    /**
     * Calculate the highest value of the poker in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return int Returns 0 if not exist poker. Returns the value of poker if exist poker.
     */

    public int calcularValorPoker(CardImpl[] cartas){
        CardImpl[] cartasOrdenadas = new CardImpl[cartas.length];
        System.arraycopy(cartas,0,cartasOrdenadas,0,cartas.length);
        ordenarCartas(cartasOrdenadas);
        int puntos = 0;
        if (cartasOrdenadas.length>3){
            //Como el array esta ordenado las 4 cartas estaran juntas en el caso de haber poker por lo cual se comprueba de esta manera
            //Recorre el array buscando si hay poker.
            for (int i = 0;i<cartasOrdenadas.length-3;i++){
                if ( (cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+1].getNumber()))
                        && (cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+2].getNumber()))
                        && (cartasOrdenadas[i].getNumber().equals(cartasOrdenadas[i+3].getNumber()))){

                    puntos = 296+cartasOrdenadas[i].getValueNumber();

                }
            }
        }
        return puntos;
    }

    /*
     * SIGNATURA: public int calcularValorEscaleraColor(CartaImpl[] cartas);
     * COMENTARIO: Calcula el valor de la escalera de color del array de CartasImpl pasado por parametro
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un entero
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un entero con la puntuacion que corresponde a la escalera de color mas alta del array pasado por parametro
     *                  - Si no hay escalera de color devuelve 0
     */

    /**
     * Calculate the highest value of the color stair in the array passed by parameter
     * @param cartas CartaImpl[] cards you want to value
     * @return Returns 0 if there is no color stair. Returns value of stair of color if exists
     */

    public int calcularValorEscaleraColor(CardImpl[] cartas){
        int puntos = 0;
        char color;
        int cantidadCartas = 0;
        CardImpl[] cartasColor;
        boolean escaleraTipo1 = false;

        //Calcula si hay color. N si no hay o el caracter del color que exista
        color = calcularTipoColor(cartas);

        //if (cartas.length > 4 && color != 'N') {      cartas.length sobra porque si hay color significa que hay 5 cartas o mas
        if (color != 'N') {

            //Calcula la cantidad de cartas que hay del color que se ha calculado el cual hay color
            for (CardImpl carta : cartas){
                if (carta.getSuit() == color) {
                    cantidadCartas++;
                }
            }

            //Array para meter las cartas del mismo color
            cartasColor = new CardImpl[cantidadCartas];

            //Anhade todas las cartas del color obtenido en el array creado
            for (int i = 0, j = 0; i < cartas.length; i++) {
                if (cartas[i].getSuit() == color) {
                    cartasColor[j] = cartas[i];
                    j++;
                }
            }

            ordenarCartas(cartasColor);

            //Comprueba si la escalera de color puede ser que sea A,2,3,4,5
            //Como la carta A es la se mayor valor no se coloca delante en el array entonces hay que comprobarla estando detras
            if (cartasColor[0].getValueNumber() == 1 && cartasColor[cartasColor.length - 1].getValueNumber() == 13) {

                //Esta controlado que no haya numeros repetidos ya que no puede haber numeros repetidos en un palo

                //Como sabemos que la primera carta sera el 2 y la ultima sera la A podemos usar posiciones absolutas para comprobar si hay escalera de color tipo A,2,3,4,5
                if ((cartasColor[1].getValueNumber() == ((cartasColor[0].getValueNumber()) + 1))
                     && (cartasColor[2].getValueNumber() == ((cartasColor[1].getValueNumber()) + 1))
                     && (cartasColor[3].getValueNumber() == ((cartasColor[2].getValueNumber()) + 1))) {

                    //If para comprobar si la carta siguiente 4 es un numero mayor a la carta 3 lo cual significaria que habra escalera mas alta que A,2,3,4,5
                    if (cartasColor[4].getValueNumber() == cartasColor[3].getValueNumber() + 1) {
                        //En el caso de que pueda ser A,2,3,4,5,6 o incluso A,2,3,4,5,6,7 se realizara este bucle for para coger la escalera de color mas alta.
                        for (int i = 3, j = 0; cartasColor[i + 1].getValueNumber() == cartasColor[i].getValueNumber() + 1 && i<cartasColor.length-2; i++, j++) {
                            puntos = 309 + cartasColor[j].getValueNumber();
                        }
                    } else {
                        //En el cado de que no haya una escalera mas grande se coloca la escalera de color del A,2,3,4,5
                        puntos = 309 + cartasColor[0].getValueNumber();
                        escaleraTipo1 = true;
                    }
                }
            }

            //En el caso de que haya escalera tipo A,2,3,4,5 o algo mayor no se ejecutara
            if (!escaleraTipo1){
                //Recorre el array para comprobar si hay escalera de color
                for (int i = 0; i < cartasColor.length - 4; i++) {

                    if ((cartasColor[i+1].getValueNumber() == ((cartasColor[i].getValueNumber()) + 1))
                         && (cartasColor[i+2].getValueNumber() == ((cartasColor[i+1].getValueNumber()) + 1))
                         && (cartasColor[i+3].getValueNumber() == ((cartasColor[i+2].getValueNumber()) + 1))
                         && (cartasColor[i+4].getValueNumber() == ((cartasColor[i+3].getValueNumber()) + 1))) {

                        puntos = 309 + (cartasColor[i].getValueNumber()+1);

                    }

                }
            }

        }
        return puntos;
    }

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

    public int evaluarCartas(int jugador, TableImpl mesa){

        int puntosFinales, puntosCalculados;
        CardImpl[] cartasAEvaluar;
        ManagementCardImpl gesCarta = new ManagementCardImpl();

        //Obtener cartas que se quieren evaluar.
        cartasAEvaluar = obtenerCartasAEvaluar(jugador,mesa);

        //Ordenar las cartas obtenidas
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

        puntosCalculados = calcularValorPoker(cartasAEvaluar);
        if (puntosCalculados>puntosFinales){
            puntosFinales = puntosCalculados;
        }

        puntosCalculados = calcularValorFull(cartasAEvaluar);
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

    public CardImpl[] obtenerCartasAEvaluar(int jugador, TableImpl mesa){
        CardImpl[] cartasTotales;

        int cantidadCartas = 0;
        CardImpl[] cartasMesa = mesa.getCardsOfTable();
        CardImpl[] cartasJugador = mesa.setCardsPlayer(jugador);

        //Obtiene la cantidad de cartas que hay en la mesa con valor distinto al de defecto
        for (int i = 0; i<cartasMesa.length&&(cartasMesa[i].getSuit()!='D'); i++){
            cantidadCartas++;
        }

        //Obtiene la cantidad de cartas que posee el jugador pasado por parametro con valor distinto al de defecto
        for (int i = 0; i<cartasJugador.length&&(cartasJugador[i].getSuit()!='D'); i++){
            cantidadCartas++;
        }

        cartasTotales = new CardImpl[cantidadCartas];

        //Inicializar el array para no tener errores de null
        for (int i = 0; i<cartasTotales.length;i++){
            cartasTotales[i] = new CardImpl();
        }

        //Anhade al array de cartas totales todas las cartas distintas al valor por defecto que hay en la mesa
        for (int i = 0; i<cartasMesa.length&&(cartasMesa[i].getSuit()!='D'); i++){
            cartasTotales[i] = cartasMesa[i].clone();
        }

        //Anhade al array de cartas totales todas las cartas distintas al valor por defecto que posee el jugador
        for (int i = 0,j = 0;i<cartasTotales.length;i++){
            if (cartasTotales[i].getSuit()=='D'){
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
     *                 - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Nada
     * SALIDA: - Nada
     * ENTRADA/SALIDA: - Un array de CartaImpl
     * POSTCONDICIONES: - Modifica el array pasado por parametro ordenado las cartas que contiene de mayor a menor valor.
     */

    /**
     * This method sort the array passed by parameter
     * @param cartas Array of CartaImpl[] you want to order
     */

    public void ordenarCartas(CardImpl[] cartas){
        CardImpl cartaAux;
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
     * SIGNATURA: public char calcularTipoColor(CartaImpl[] cartas);
     * COMENTARIO: Metodo para calcular si hay color en el array de cartas
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un caracter
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre un caracter con el tipo de color que hay en el array (T,P,C,R)
     *                  - Si no hay color se devolvera N
     */

    /**
     * Method to calculate if there is color in the card array
     * @param cartas Array of cards you want to check
     * @return char with the color that exist in array of cards. Return N if not exist color.
     */

    public char calcularTipoColor(CardImpl[] cartas){
        char color = 'N';
        int contadorPica = 0, contadorCorazon = 0, contadorTrevol = 0, contadorRombo = 0;

        //Se calcula cuantas cartas hay de cada palo
        for (CardImpl carta : cartas) {
            if (carta.getSuit() == 'P') {
                contadorPica++;
            } else {
                if (carta.getSuit() == 'C') {
                    contadorCorazon++;
                } else {
                    if (carta.getSuit() == 'T') {
                        contadorTrevol++;
                    } else {
                        if (carta.getSuit() == 'R') {
                            contadorRombo++;
                        }
                    }
                }
            }
        }

        //Con este if se comprueba de que palo es el color que hay en la baraja si hay algun color
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

    /*
     * SIGNATURA: public boolean unaParaEscalera(CartaImpl[] cartas);
     * COMENTARIO: Metodo para calcular si queda una carta para que haya escalera
     * PRECONDICIONES: - El array de cartas pasado por parametro no puede contener cartas por defecto
     * ENTRADA: - Un array de CartaImpl
     * SALIDA: - Un boolean
     * ENTRADA/SALIDA: - Nada
     * POSTCONDICIONES: - Devuelve asociado al nombre true si falta una carta para escalera
     *                  - Devuelve asociado al nombre false si no falta una carta para escalera
     */

    /**
     * @param cartas
     * @return
     */

    //TODO Mejorar este metodo

    public boolean unaParaEscalera(CardImpl[] cartas){
        boolean unaParaEscalera = false;
        CardImpl[] cartasAEvaluar = new CardImpl[cartas.length];
        System.arraycopy(cartas,0,cartasAEvaluar,0,cartas.length);
        ordenarCartas(cartasAEvaluar);

        if (cartas[0].getValueNumber()+1 != cartas[1].getValueNumber()
            && cartas[1].getValueNumber()+1 == cartas[2].getValueNumber()
            && cartas[2].getValueNumber()+1 == cartas[3].getValueNumber()
            && cartas[3].getValueNumber()+1 == cartas[4].getValueNumber()){
                unaParaEscalera = true;
        }else{
            if (cartas[0].getValueNumber()+1 != cartas[1].getValueNumber()
                && cartas[1].getValueNumber()+1 != cartas[2].getValueNumber()
                && cartas[2].getValueNumber()+1 == cartas[3].getValueNumber()
                && cartas[3].getValueNumber()+1 == cartas[4].getValueNumber()){
                    unaParaEscalera = true;
            }else{
                if (cartas[0].getValueNumber()+1 == cartas[1].getValueNumber()
                    && cartas[1].getValueNumber()+1 != cartas[2].getValueNumber()
                    && cartas[2].getValueNumber()+1 != cartas[3].getValueNumber()
                    && cartas[3].getValueNumber()+1 == cartas[4].getValueNumber()){
                        unaParaEscalera = true;
                }else{
                    if (cartas[0].getValueNumber()+1 == cartas[1].getValueNumber()
                        && cartas[1].getValueNumber()+1 == cartas[2].getValueNumber()
                        && cartas[2].getValueNumber()+1 != cartas[3].getValueNumber()
                        && cartas[3].getValueNumber()+1 != cartas[4].getValueNumber()){
                            unaParaEscalera = true;
                    }else{
                        if (cartas[0].getValueNumber()+1 == cartas[1].getValueNumber()
                            && cartas[1].getValueNumber()+1 == cartas[2].getValueNumber()
                            && cartas[2].getValueNumber()+1 == cartas[3].getValueNumber()
                            && cartas[3].getValueNumber()+1 != cartas[4].getValueNumber()){
                                unaParaEscalera = true;
                        }
                    }
                }
            }
        }

        return unaParaEscalera;
    }

}
