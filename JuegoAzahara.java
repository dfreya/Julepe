public class Juego
{
    //Array que guarda los jugadores
    private Jugador[] jugadores;
    //crear baraja llamando a la clase Mazo;
    private Mazo mazo;
    //Ultima carta que se reparte
    private Carta paloQuePinta;
   
    /**
     * Constructor for objects of class Juego
     */
    public Juego(int numeroJugadores)
    {
        //se crea un objeto de tipo de mazo. la variable mazo hace una referencia al objeto.
        mazo = new Mazo();
        
        //guarda en el array el número de jugadores metido por parámetro.
        jugadores = new Jugador [numeroJugadores];
        
        //ArrayList que guarda los posibles nombres.Metemos nombre en el ArraList
        ArrayList<String> posiblesNombres = new ArrayList<String>();
        posiblesNombres.add ("María");
        posiblesNombres.add ("Alberto");
        posiblesNombres.add ("Laura");
        posiblesNombres.add ("Pepe");
        posiblesNombres.add ("Lorena");
        posiblesNombres.add ("Manuel");
        posiblesNombres.add ("Sonia");
        posiblesNombres.add ("Omar");
        
        //creación de variable de tipo Random;
        Random aleatorio = new Random();
        
        //Bucle que se repite tantas veces como número de jugadores.
        for(int i = 0; i < numeroJugadores; i++){
            /**
             * numero aleatorio entre 0 y el numero de elementos del arraylist.
             * Al borrar un nombre se debe cambiar la posicion para que no quede un lugar vacio
             */
            int posicionNombreElegido = aleatorio.nextInt(posiblesNombres.size());
            //variable que guarde el nombre de aleatorio
            String nombreAleatorio = posiblesNombres.get(posicionNombreElegido);
            //eliminamos el nombre del ArrayList para que no se repitan.
            posiblesNombres.remove(posicionNombreElegido);
            //Variable local de tipo jugador
            
            Jugador jugador = new Jugador(nombreAleatorio);
            //guarda los jugadores en el array
            jugadores [i] = jugador;
        }
    }
}