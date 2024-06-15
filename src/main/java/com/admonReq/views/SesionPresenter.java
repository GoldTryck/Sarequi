package com.admonReq.views;

import com.admonReq.sarequi;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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

    private void onLoginButtonClicked() {
        AppManager.getInstance().switchView(sarequi.SESION_VIEW);
    }
}
