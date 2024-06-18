package com.admonReq.views;

import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Objects;

public class ConsultaView {

    public View getView() {
        try {
            return FXMLLoader.load(Objects.requireNonNull(InicioView.class.getResource("Consulta.fxml")));
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}

