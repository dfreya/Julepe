
/**
 * Write a description of class Carta here.
 * 
 * @author (Nero Hornet) 
 * @version (a version number or a date)
 */
public class Carta
{
    //alamcena el numero de la carta 1 al 7 y del 10 al 12
    private int numeroDeCarta;
    //alamcena el palo de la carta ( 0=oro; 1=copas; 2=espadas; 3=bastos)
    private int paloDeCarta;

    /**
     * Constructor for objects of class Carta
     */
    public Carta(int numeroDeLaCarta, int paloDeLaCarta)
    {
        numeroDeCarta = numeroDeLaCarta;
        paloDeCarta = paloDeLaCarta;
    }

    public String toString(){
        String nombreDelPalo = "";
        switch (paloDeCarta){
            case 0:
            nombreDelPalo = "oros";
            break;
            case 1:
            nombreDelPalo = "copas";
            break;
            case 2:
            nombreDelPalo = "espadas";
            break;
            case 3:
            nombreDelPalo = "bastos";
            break;
        }

        String textoADevolver = "";
        switch (numeroDeCarta){
            case 1:
            textoADevolver = "as" + " de " + nombreDelPalo;
            break;
            case 10:
            textoADevolver = "sota" + " de " + nombreDelPalo;
            break;
            case 11:
            textoADevolver = "caballo" + " de " + nombreDelPalo;
            break;
            case 12:
            textoADevolver = "rey" + " de " + nombreDelPalo;
            break;
            default:
            textoADevolver = numeroDeCarta + " de " + nombreDelPalo;
        }

        return textoADevolver;
    }

    public int getPalo(){
        return paloDeCarta;        
    }

    public int getEscala(){
        return numeroDeCarta;
    }

    public boolean ganaA(Carta cartaEnMesa, int triunfo){
        boolean gana=false;

        if (paloDeCarta == cartaEnMesa.getPalo()){
            if (getPosicionEscalaTute() > cartaEnMesa.getPosicionEscalaTute()){
                gana=true;
            }
        }
        else {
            if(getPalo() == triunfo){
                gana=true;
            }
        }
        return gana;
    }

    public int getPosicionEscalaTute() 
    {
        int posicion = numeroDeCarta;
        if (numeroDeCarta == 3) {
            posicion = 13;
        }
        else if (numeroDeCarta == 1) {
            posicion = 14;
        }
        return posicion;    
    }
}
