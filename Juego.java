import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Juego here.
 * 
 * @author (Nero Hornet) 
 * @version (a version number or a date)
 */
public class Juego
{
    // instance variables - replace the example below with your own
    private Jugador[] numeroDeJugador;
    private Mazo barajaDeJuego;
    private int palotriunfo;

    /**
     * Constructor for objects of class Juego
     */
    public Juego(int numJugadores, String Nick)
    {
        numeroDeJugador = new Jugador[numJugadores];
        barajaDeJuego = new Mazo();
        Jugador jugadorUsuario= new Jugador(Nick);
        numeroDeJugador[0]= jugadorUsuario;

        ArrayList<String> nombreDelBoot = new ArrayList<String>();
        nombreDelBoot.add ("María");
        nombreDelBoot.add ("Alberto");
        nombreDelBoot.add ("Laura");
        nombreDelBoot.add ("Pepe");
        nombreDelBoot.add ("Lorena");
        nombreDelBoot.add ("Manuel");
        nombreDelBoot.add ("Sonia");
        nombreDelBoot.add ("Omar");

        Random aleatorio= new Random();
        for (int contDeJugadoresCreados = 1; contDeJugadoresCreados < numeroDeJugador.length; contDeJugadoresCreados++){
            int posicionBootElegido = aleatorio.nextInt(nombreDelBoot.size());
            String nombreBootElegido = nombreDelBoot.get(posicionBootElegido);
            nombreDelBoot.remove(posicionBootElegido);

            Jugador boot = new Jugador(nombreBootElegido);
            numeroDeJugador[contDeJugadoresCreados] = boot;     
        }
        
        String mensageInicial ="Hola Jugadores :";      
        for(Jugador botPlayer : numeroDeJugador){
            mensageInicial= mensageInicial + botPlayer.getNombre()+ ", ";
        }        
        System.out.println(mensageInicial); 
    }

    public void repartir(){
        barajaDeJuego.barajar();
        Carta cartaARepartir=null;
        for(int manosRepartidas = 0; manosRepartidas < 5 ;manosRepartidas++ ){
            for(Jugador botPlayer : numeroDeJugador){
                cartaARepartir = barajaDeJuego.sacarCarta();
                botPlayer.recibirCarta(cartaARepartir);
            }
        }
        palotriunfo = cartaARepartir.getPalo();
    }

    public void verManoJugador(String jugadorBuscado){
        int cont = 0;
        while(cont < numeroDeJugador.length){
            if (jugadorBuscado == numeroDeJugador[cont].getNombre()){
                numeroDeJugador[cont].verMano();
            }

        }

    }

    public void verJugadores(){
        for(Jugador botPlayer : numeroDeJugador){
            System.out.println(botPlayer.getNombre());
        }
    }
    
    
}

