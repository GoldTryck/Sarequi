package com.admonReq.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class SesionView {

    public View getView() {
        try {
            return FXMLLoader.load(SesionView.class.getResource("InicioSesion.fxml"));
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
