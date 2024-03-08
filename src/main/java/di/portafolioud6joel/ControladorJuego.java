package di.portafolioud6joel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ControladorJuego implements Initializable {

    @FXML
    private ImageView color1, color2, color3, color4, encuentro1, encuentro2, encuentro3, encuentro4;
    @FXML
    private ComboBox dificultad;
    @FXML
    private Label error, acierto, juego;
    @FXML
    private ImageView respuesta1, respuesta2, respuesta3, respuesta4;
    @FXML
    private Button boton1, boton2, boton3, boton4, botonReinicio, botonRespuesta;
    private int contador1 = 0;
    private int contador2 = 0;
    private int contador3 = 0;
    private int contador4 = 0;
    private ArrayList<Integer> combinacionRes = new ArrayList<>();
    private ArrayList<Integer> combinacionColores = new ArrayList<>();
    private int errores = 0;

    public ControladorJuego() {
    }

    @FXML
    public void boton1() {
        contador1++;
        if (contador1 == 9) {
            contador1 = 1;
        }
        Image imagen = new Image(getClass().getResourceAsStream("Imagenes/" + contador1 + ".png"));
        System.out.println(contador1);
        respuesta1.setImage(imagen);
        combinacionColores.set(0, (contador1));
    }

    @FXML
    public void boton2() {
        contador2++;
        if (contador2 == 9) {
            contador2 = 1;
        }
        Image imagen = new Image(getClass().getResourceAsStream("Imagenes/" + contador2 + ".png"));
        System.out.println(contador2);
        respuesta2.setImage(imagen);
        combinacionColores.set(1, (contador2));
    }

    @FXML
    public void boton3() {
        contador3++;
        if (contador3 == 9) {
            contador3 = 1;
        }
        Image imagen = new Image(getClass().getResourceAsStream("Imagenes/" + contador3 + ".png"));
        System.out.println(contador3);
        respuesta3.setImage(imagen);
        combinacionColores.set(2, (contador3));
    }

    @FXML
    public void boton4() {
        contador4++;
        if (contador4 == 9) {
            contador4 = 1;
        }
        Image imagen = new Image(getClass().getResourceAsStream("Imagenes/" + contador4 + ".png"));
        System.out.println(contador4);
        respuesta4.setImage(imagen);
        combinacionColores.set(3, (contador4));
    }

    @FXML
    public void respuesta() {
        dificultad.setDisable(true);
        int sumaColores = 0;
        int encontrados = 0;
        List<Integer> colEcontrados=new ArrayList<>();
        System.out.println(combinacionColores);
        System.out.println(combinacionRes);
        for (int i = 0; i < 4; i++) {
            if (combinacionRes.get(i) == combinacionColores.get(i)) {
                Image imagen = new Image(getClass().getResourceAsStream("Imagenes/" + combinacionColores.get(i) + ".png"));
                switch (i) {
                    case 0:
                        color1.setImage(imagen);
                        sumaColores++;
                        boton1.setDisable(true);
                        break;
                    case 1:
                        color2.setImage(imagen);
                        sumaColores++;
                        boton2.setDisable(true);
                        break;
                    case 2:
                        color3.setImage(imagen);
                        sumaColores++;
                        boton3.setDisable(true);
                        break;
                    case 3:
                        color4.setImage(imagen);
                        sumaColores++;
                        boton4.setDisable(true);
                        break;

                }
            } else if (combinacionRes.contains(combinacionColores.get(i))) {
                ArrayList<Integer> coloresEncontrados = new ArrayList<>();
                    coloresEncontrados.add(combinacionColores.get(i));
                    encontrados++;
                    Image imagen = new Image(getClass().getResourceAsStream("Imagenes/" + combinacionColores.get(i) + ".png"));

                    switch (encontrados) {
                        case 1:
                            if (!coloresEncontrados.contains(combinacionColores.get(i))) {
                            encuentro1.setImage(imagen);}
                            break;
                        case 2:
                            if (!coloresEncontrados.contains(combinacionColores.get(i))) {
                                encuentro2.setImage(imagen);}
                            break;
                        case 3:
                            if (!coloresEncontrados.contains(combinacionColores.get(i))) {
                                encuentro3.setImage(imagen);}
                            break;
                        case 4:
                            if (!coloresEncontrados.contains(combinacionColores.get(i))) {
                                encuentro4.setImage(imagen);}
                            break;
                    }
            }
            /* else if (combinacionRes.contains(combinacionColores.get(i)) && !coloresCantidadEnc.contains(i)) {
                Image imagen = new Image(getClass().getResourceAsStream("Imagenes/" + combinacionColores.get(i) + ".png"));
                coloresEncontrados++;
                if (coloresEncontrados==1){
                    encuentro1.setImage(imagen);
                } else if (coloresEncontrados==2) {
                    encuentro2.setImage(imagen);
                } else if (coloresEncontrados==3) {
                    encuentro3.setImage(imagen);
                } else if (coloresEncontrados==4) {
                    encuentro4.setImage(imagen);
                }
                coloresCantidadEnc.add(i);
            }*/


        }
        errores++;
        error.setText(String.valueOf(errores));
        acierto.setText(String.valueOf(sumaColores));
        finJuego();
    }

    public void finJuego() {
        String nivel = (String) dificultad.getValue();
        switch (nivel) {
            case "Fácil":
                if (errores >= 12) {
                    juego.setText("FIN DEL JUEGO");
                    reiniciarBotones();
                }
                break;
            case "Medio":
                if (errores >= 10) {
                    juego.setText("FIN DEL JUEGO");
                    reiniciarBotones();
                }
                break;
            case "Dificil":
                if (errores >= 7) {
                    juego.setText("FIN DEL JUEGO");
                    reiniciarBotones();
                }
                break;
        }
        System.out.println(acierto.getText());
        if (Integer.parseInt(acierto.getText()) == 4) {
            juego.setText("Enhorabuena has ganado!!");
            botonReinicio.setVisible(true);
            dificultad.setDisable(true);
            botonRespuesta.setDisable(true);
        }
    }


    private void reiniciarBotones() {
        botonReinicio.setDisable(false);
        botonReinicio.setVisible(true);
        boton1.setDisable(true);
        boton2.setDisable(true);
        boton3.setDisable(true);
        boton4.setDisable(true);
        dificultad.setDisable(true);
        botonRespuesta.setDisable(true);
    }

    //Crea 4 numeros aleatorios diferentes entre 0 y 8 y los añade a una lista
    public void crearCombinacion() {
        Random aleatorio = new Random();
        int contador = 0;
        while (contador < 4) {
            int numeroAleatorio = aleatorio.nextInt(8) + 1;
            if (!combinacionRes.contains(numeroAleatorio)) {
                combinacionRes.add(numeroAleatorio);
                combinacionColores.add(0);
                contador++;
            }
        }
    }

    public void reiniciar() {
        combinacionRes.clear();
        combinacionColores.clear();
        crearCombinacion();
        Image imagen = new Image(getClass().getResourceAsStream("Interrogante.PNG"));
        Image imagen2 = new Image(getClass().getResourceAsStream("Imagenes/Click.png"));
        boton1.setDisable(false);
        boton2.setDisable(false);
        boton3.setDisable(false);
        boton4.setDisable(false);
        dificultad.setDisable(false);
        botonRespuesta.setDisable(false);
        acierto.setText("0");
        error.setText("0");
        errores = 0;
        color1.setImage(imagen);
        color2.setImage(imagen);
        color3.setImage(imagen);
        color4.setImage(imagen);
        respuesta1.setImage(imagen2);
        respuesta2.setImage(imagen2);
        respuesta3.setImage(imagen2);
        respuesta4.setImage(imagen2);
        botonReinicio.setVisible(false);
        encuentro1.setImage(null);
        encuentro2.setImage(null);
        encuentro3.setImage(null);
        encuentro4.setImage(null);
        dificultad.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crearCombinacion();
        dificultad.getItems().addAll("Fácil", "Medio", "Dificil");
        dificultad.setValue(String.valueOf("Fácil"));
    }
}
