package di.portafolioud6joel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class ControladorJuego implements Initializable {

    @FXML
    private ImageView color1;
    @FXML
    private ImageView color2;
    @FXML
    private ImageView color3;
    @FXML
    private ImageView color4;
    @FXML
    private ComboBox dificultad;
    @FXML
    private Label error;
    @FXML
    private Label colorEncontrado;
    @FXML
    private Label acierto;
    @FXML
    private ImageView respuesta1;
    @FXML
    private ImageView respuesta2;
    @FXML
    private ImageView respuesta3;
    @FXML
    private ImageView respuesta4;
    private int contador1 = 0;
    private int contador2 = 0;
    private int contador3 = 0;
    private int contador4 = 0;
    private ArrayList<Integer> combinacionRes = new ArrayList<>();
    private ArrayList<Integer> combinacionColores = new ArrayList<>();
    private int errores = 0;

    public ControladorJuego() {
    }

    public ImageView getColor1() {
        return color1;
    }

    public void setColor1(ImageView color1) {
        this.color1 = color1;
    }

    public ImageView getColor2() {
        return color2;
    }

    public void setColor2(ImageView color2) {
        this.color2 = color2;
    }

    public ImageView getColor3() {
        return color3;
    }

    public void setColor3(ImageView color3) {
        this.color3 = color3;
    }

    public ImageView getColor4() {
        return color4;
    }

    public void setColor4(ImageView color4) {
        this.color4 = color4;
    }

    public ComboBox getDificultad() {
        return dificultad;
    }

    public void setDificultad(ComboBox dificultad) {
        this.dificultad = dificultad;
    }

    public Label getError() {
        return error;
    }

    public void setError(Label error) {
        this.error = error;
    }

    public Label getColorEncontrado() {
        return colorEncontrado;
    }

    public void setColorEncontrado(Label colorEncontrado) {
        this.colorEncontrado = colorEncontrado;
    }

    public Label getAcierto() {
        return acierto;
    }

    public void setAcierto(Label acierto) {
        this.acierto = acierto;
    }

    public ImageView getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(ImageView respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public ImageView getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(ImageView respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public ImageView getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(ImageView respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public ImageView getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(ImageView respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public int getContador1() {
        return contador1;
    }

    public void setContador1(int contador1) {
        this.contador1 = contador1;
    }

    public int getContador2() {
        return contador2;
    }

    public void setContador2(int contador2) {
        this.contador2 = contador2;
    }

    public int getContador3() {
        return contador3;
    }

    public void setContador3(int contador3) {
        this.contador3 = contador3;
    }

    public int getContador4() {
        return contador4;
    }

    public void setContador4(int contador4) {
        this.contador4 = contador4;
    }

    public ArrayList<Integer> getCombinacionRes() {
        return combinacionRes;
    }

    public void setCombinacionRes(ArrayList<Integer> combinacionRes) {
        this.combinacionRes = combinacionRes;
    }

    public ArrayList<Integer> getCombinacionColores() {
        return combinacionColores;
    }

    public void setCombinacionColores(ArrayList<Integer> combinacionColores) {
        this.combinacionColores = combinacionColores;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    @FXML
    public void boton1() {
        contador1++;
        if (contador1 ==9) {
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
        if (contador2 ==9) {
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
        if (contador3 ==9) {
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
        if (contador4 ==9) {
            contador4 = 1;
        }
        Image imagen = new Image(getClass().getResourceAsStream("Imagenes/" + contador4 + ".png"));
        System.out.println(contador4);
        respuesta4.setImage(imagen);
        combinacionColores.set(3, (contador4));
    }

    @FXML
    public void respuesta() {

        System.out.println(combinacionColores);
        System.out.println(combinacionRes);
        for (int i = 0; i < 4; i++) {
            if (combinacionRes.get(i) == combinacionColores.get(i)) {
                Image imagen = new Image(getClass().getResourceAsStream("Imagenes/" + combinacionColores.get(i) + ".png"));
                if (i == 0) {
                    color1.setImage(imagen);
                } else if (i == 1) {
                    color2.setImage(imagen);
                } else if (i == 2) {
                    color3.setImage(imagen);
                } else if (i == 3) {
                    color4.setImage(imagen);
                }
            } else {
                errores++;
                error.setText(String.valueOf(errores));
            }
        }
    }

    //Crea 4 numeros aleatorios entre 0 y 8 y los añade a una lista
    public void crearCombinacion() {
        Random aleatorio = new Random();
        for (int i = 0; i < 4; i++) {
            int numeroAleatorio = aleatorio.nextInt(8) + 1;
            combinacionRes.add(numeroAleatorio);
            combinacionColores.add(0);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crearCombinacion();
        dificultad.getItems().addAll("Facil","Medio","Dificil");
    }
}
