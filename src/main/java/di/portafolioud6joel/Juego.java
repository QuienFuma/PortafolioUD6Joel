package di.portafolioud6joel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//Clase para controlar el juego
public class Juego {
    int nivel; //establece cuantos colores tendrá combinación
    int colores; // establece cuantos colores hay
    List<Integer> combinacion; // guarda la combinación
    HashMap<Integer, List<Integer>> intentos; //Guarda los intentos
    int limite; //establecer el límite de intentos
    boolean iniciado;

    //constructor de la clase
    //@param nivel --> cantidad de elementos en la combinación
    //@param colores --> cuantos colores existen en el juego
    //@param limite --> cantidad de intentos posibles
    public Juego(int nivel, int colores, int limite) {
        this.nivel = nivel;
        this.colores = colores;
        this.combinacion = new ArrayList<>();
        crearCombinacion();
        this.intentos = new HashMap<>();
        this.limite = limite;
        this.iniciado = true;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean estado) {
        this.iniciado = estado;
    }

    public int intentoActual() {
        return this.intentos.size() + 1;
    }

    public void mostrarIntento(int intento) {
        System.out.println(this.intentos.get(intento));
    }

    @Override
    public String toString() {
        return "Juego{" +
                "nivel=" + nivel +
                ", colores=" + colores +
                ", combinacion=" + combinacion +
                ", intentos=" + intentos +
                '}';
    }

    //Métodos específicos para el juego

    //Genera una combinación teniendo en cuenta la cantidad según el nivel y entre cuantos colores puede elegir
    //La combinación no tiene colores repetidos
    private void crearCombinacion() {
        Random aleatorio = new Random(System.currentTimeMillis());
        int contador = 0;
        while (contador < this.nivel) {
            int num = aleatorio.nextInt(this.colores);
            if (!this.combinacion.contains(num)) {
                combinacion.add(num);
                contador++;
            }
        }
    }

    //Comprueba un intento introducido por el usuario, si la cantidad de colores coincide con el nivel
    //añade al mapa de intentos la combinación introducida y la manda comprobar.
    //@param recibe una lista separada por coma de los colores (números)
    public void hacerIntento(String linea) {
        List<Integer> listaIntento = new ArrayList<>();
        for (String val : linea.split(",")) {
            listaIntento.add(Integer.valueOf(val));
        }
        //comprobar que la respuesta tiene los valores adecuados en cantidad
        if (listaIntento.size() == this.nivel) {
            int intento = this.intentos.size() + 1;
            this.intentos.put(intento, listaIntento);
            comprobarCombinacion(intento);
        }
    }


    //Comprueba la combinación para un intento determinado del mapa de combinaciones
    public void comprobarCombinacion(int intento) {
        int existe = 0;
        int bien = 0;
        for (int i = 0; i < this.nivel; i++) {
            if (this.combinacion.contains(this.intentos.get(intento).get(i))) { //si esta en la combinación
                existe++; //añadimos a los que existen
                if (this.combinacion.get(i) == (this.intentos.get(intento).get(i))) {
                    bien++; //añadimos a los bien colocados
                }
            }
        }
        mostrarIntento(intento);
        System.out.println("Existen: " + existe + "  ||  Bien: " + bien);

        //Comprobar si es final juego
        //todos correctos
        if (bien == nivel) {//se ha ganado y final del juego
            System.out.println("HAS GANADO!!!");
            this.setIniciado(false);
        }
        //limite intentos
        if (this.intentoActual() == this.limite) {
            System.out.println("Has llegado al final de los intentos.");
            this.setIniciado(false);
        }
    }


}