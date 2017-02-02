
/**
 * Write a description of class Baza here.
 * 
 * @author (Nero Hornet) 
 * @version (a version number or a date)
 */
public class Baza
{
    // Numero De Cartas que se han jugado en la baza;
    private int cartasJugadas;
    // palo que pinta en la partida;
    private int triunfo;
    //Numero de jugadores que estan jugando la baza;
    private int numeroJugadores;
    //Array de los nombres de los jugadores que juegan.
    private String [] nombreDeJugadores;
    //Array de cartas de la baza.
    private Carta[] baza;
    // Numerod e bazas jugadas en la partida.
    private int bazasJugadas;

    private Carta cartaQueGana;
    
    private String jugadorQueVaGanando;

    /**
     * Constructor for objects of class Baza
     */
    public Baza(int numeroJugadores, int palotriunfo)
    {
        // 
        cartasJugadas = 0;
        triunfo = palotriunfo;
        baza = new Carta[numeroJugadores];
        bazasJugadas=0;
        nombreDeJugadores =new String [numeroJugadores];
        cartaQueGana = null;
        jugadorQueVaGanando="";
    }

    /**
     * 
     */
    public void addCarta(Carta cartaJugada, String nombreJugador)
    {
        if (cartasJugadas < baza.length){
            baza[cartasJugadas]=cartaJugada;

            if (cartaQueGana == null){
                cartaQueGana=cartaJugada;
                jugadorQueVaGanando= nombreJugador;
            }
            else{
                if (!cartaQueGana.ganaA(baza[cartasJugadas],triunfo)){
                    cartaQueGana=baza[cartasJugadas];
                    jugadorQueVaGanando= nombreJugador;
                }
            }

            nombreDeJugadores[cartasJugadas]=nombreJugador;
            cartasJugadas++;
        }
    }

    public int  getPaloPrimeraCartaDeLaBaza(){
        int paloPrimeraCarta = -1;
        if (baza[0]!= null){
            paloPrimeraCarta= baza[0].getPalo();
        }
        return paloPrimeraCarta;
    }

    public Carta cartaQueVaGanandoLaBaza(){
        return cartaQueGana;
    }
    public String nombreJugadorQueVaGanandoLaBaza(){
        return jugadorQueVaGanando;
    }
}
