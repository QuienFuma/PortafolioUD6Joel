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
    ImageView color1;
    @FXML
    ImageView color2;
    @FXML
    ImageView color3;
    @FXML
    ImageView color4;
    @FXML
    ComboBox dificultad;
    @FXML
    Label error;
    @FXML
    Label colorEncontrado;
    @FXML
    Label acierto;
    @FXML
    ImageView respuesta1;
    @FXML
    ImageView respuesta2;
    @FXML
    ImageView respuesta3;
    @FXML
    ImageView respuesta4;
    int contador1 = 1;
    int contador2 = 1;
    int contador3 = 1;
    int contador4 = 1;
    ArrayList<Integer> combinacionRes = new ArrayList<Integer>();
    ArrayList<Integer> combinacionColores = new ArrayList<Integer>();
    int errores=0;
    public ControladorJuego() {
    }

    public ControladorJuego(ImageView color1, ImageView color2, ImageView color3, ImageView color4, ComboBox dificultad,
                            Label error, Label colorEncontrado, Label acierto, ImageView respuesta1, ImageView respuesta2,
                            ImageView respuesta3, ImageView respuesta4) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
        this.dificultad = dificultad;
        this.error = error;
        this.colorEncontrado = colorEncontrado;
        this.acierto = acierto;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
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

    @FXML
    public void boton1(){

        Image imagen = new Image(getClass().getResourceAsStream("Imagenes/"+contador1+".png"));
        respuesta1.setImage(imagen);
        if (contador1==8){
            contador1=1;
        }else {contador1++;}
        combinacionColores.add(0,contador1);
    }
    @FXML
    public void boton2(){
        Image imagen = new Image(getClass().getResourceAsStream("Imagenes/"+contador2+".png"));
        respuesta2.setImage(imagen);
        if (contador2==8){
            contador2=1;
        }else {contador2++;}
        combinacionColores.add(1,contador2);
    }
    @FXML
    public void boton3(){
        Image imagen = new Image(getClass().getResourceAsStream("Imagenes/"+contador3+".png"));
        respuesta3.setImage(imagen);
        if (contador3==8){
            contador3=1;
        }else {contador3++;}
        combinacionColores.add(2,contador3);
    }
    @FXML
    public void boton4(){
        Image imagen = new Image(getClass().getResourceAsStream("Imagenes/"+contador4+".png"));
        respuesta4.setImage(imagen);
        if (contador4==8){
            contador4=1;
        }else {contador4++;}
        combinacionColores.add(3,contador4);
    }


    @FXML
    public void respuesta(){

       for(int i =0; i<3;i++){
           if(combinacionRes.get(i) == combinacionColores.get(i)){
               Image imagen = new Image(getClass().getResourceAsStream("Imagenes/"+combinacionRes.get(i)+".png"));
               if(i==0){
               color1.setImage(imagen);} else if (i==1) {
                   color2.setImage(imagen);
               } else if (i==3) {
                   color3.setImage(imagen);
               }else{color4.setImage(imagen);}
           }else{
               errores++;
               error.setText(String.valueOf(errores));
           }
       }
    }

    public void crearCombinacion() {

        Random aleatorio = new Random();
        for(int i = 1; i<4; i++) {
            int numeroAleatorio = aleatorio.nextInt(4);
            combinacionRes.add(numeroAleatorio);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crearCombinacion();
    }
}
