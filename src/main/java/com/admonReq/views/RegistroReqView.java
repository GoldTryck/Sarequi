package com.admonReq.views;

import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class RegistroReqView {
    public View getView() {
        try {
            View view = FXMLLoader.load(OtraVistaView.class.getResource("registroReq.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
