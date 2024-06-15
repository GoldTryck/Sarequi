package com.admonReq.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;

public class InicioView {
    public View getView() {
        try {
            return FXMLLoader.load(Objects.requireNonNull(InicioView.class.getResource("inicio.fxml")));
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
