package com.admonReq.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class OtraVistaView {
    
    public View getView() {
        try {
            View view = FXMLLoader.load(OtraVistaView.class.getResource("otravista.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
