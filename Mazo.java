import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Mazo here.
 * 
 * @author (Ner Hornet) 
 * @version (a version number or a date)
 */
public class Mazo
{
    //Crear el arraylist para gusrdar las cartas en un Mazo.
    private ArrayList<Carta> mazo;

    /**
     * Constructor for objects of class Mazo
     */
    public Mazo()
    {
        // initialise instance variables
        mazo = new ArrayList<Carta>();

        int palos = 0;
        while(palos < 4 ) {
            int cartas = 1;
            while (cartas < 13){
                if (cartas != 8 && cartas != 9){
                    mazo.add(new Carta(cartas, palos));
                }
                cartas++;
            }
            palos++;
        }
    }
    public void verMazo()
    {
        for(Carta carta:mazo){
            System.out.println(carta);
        }
    }

    public void barajar(){
        for (int posicionActual = 0; posicionActual < mazo.size(); posicionActual++){
            Carta posicionGuardada = mazo.get(posicionActual);
            Random aleatorio = new Random();
            int posicionAleatoria = aleatorio.nextInt(mazo.size());
            mazo.set(posicionActual, mazo.get(posicionAleatoria));
            mazo.set(posicionAleatoria, posicionGuardada);
        }
    }
    
    public Carta sacarCarta(){
        Carta Cajon = null;
        if (mazo.size() > 0){
            Cajon = mazo.remove(0);
        }
        return Cajon;
    }

}
