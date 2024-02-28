package di.portafolioud6joel;

import java.util.Scanner;
//Aplicación principal del juego
public class AppMain {
    public static void main(String[] args) {
        Juego juego=new Juego(4,6,6);  //creamos el juego con sus parámetros nivel, colore, limite intentos
        System.out.println(juego);
        Scanner sc=new Scanner(System.in);
        //mientras el juego no termina hacemos intentos
        while(juego.isIniciado()){
            System.out.println("Intento " + juego.intentoActual());
            String linea=sc.nextLine(); //Pedimos la secuencia a probar (n,n,n,n,...)
            juego.hacerIntento(linea);
        }
    }
}
