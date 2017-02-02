import java.util.Random;
/**
 * Write a description of class Jugador here.
 * 
 * @author (Nero Hornet) 
 * @version (a version number or a date)
 */
public class Jugador
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Carta[] mano;
    private int cartasDeMano;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nick)
    {
        nombre = nick;
        mano = new Carta[5];
        cartasDeMano = 0;        
    }

    /**
     * 
     */
    public void recibirCarta(Carta carta)
    {        
        if (cartasDeMano < mano.length){
            mano[cartasDeMano]= carta;
            cartasDeMano++;   
        }
        else{
            System.out.println("Mano llena");
        }

    }

    public void verMano(){
        for(int cont=0; cont < mano.length; cont++){
            if(mano[cont] != null){
                System.out.println(mano[cont]);
            }

        }
    }

    public String getNombre(){
        return nombre;
    }

    public Carta tirarCarta(String cartaRequerida){
        Carta cartaJugada = null;
        int cont =0;
        while (cont < mano.length){
            if (mano[cont] != null && cartaRequerida.equals(mano[cont].toString())){
                System.out.println(nombre + " juega el "+ cartaRequerida);
                cartaJugada=mano[cont];
                mano[cont]=null;
                cartasDeMano--;
            }  
            cont++;
        }
        return cartaJugada;
    }

    public Carta tirarCartaAleatoria(){
        Carta cartaJugada = null;
        Random aleatorio = new Random();
        if (cartasDeMano != 0){
            while (cartaJugada == null){
                int cartaAleatoria = aleatorio.nextInt(mano.length);
                if (mano[cartaAleatoria] != null){
                    cartaJugada=mano[cartaAleatoria];
                    System.out.println(nombre + " juega el "+ cartaJugada);
                    mano[cartaAleatoria]=null;
                    cartasDeMano--;
                }  
            }            
        } 
        return cartaJugada;
    }    
}
