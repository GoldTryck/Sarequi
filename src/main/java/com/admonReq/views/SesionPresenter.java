package com.admonReq.views;

import com.admonReq.sarequi;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SesionPresenter {

    @FXML
    public Button loginButton;
    @FXML
    public View inicioSesion;

    @FXML
    public void initialize() {
        inicioSesion.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                loginButton.setOnAction(actionEvent -> {
                    onLoginButtonClicked();
                });
            }
        });
    }

    @FXML
    private void onLoginButtonClicked() {
        AppManager.getInstance().switchView(sarequi.INICIO_VIEW);
    }
}
