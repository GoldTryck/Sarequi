package com.admonReq.views;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InicioPresenter {

    @FXML
    private View inicio;

    @FXML
    private Label label;

    public void initialize() {
        inicio.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        AppManager.getInstance().getDrawer().open()));
                appBar.setTitleText("Inicio");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
                        System.out.println("Search")));
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e ->
                        System.out.println("Favorite")));
                appBar.getActionItems().add(MaterialDesignIcon.PERSON.button(e ->
                        System.out.println("Person")));
                NavigationDrawer drawer = AppManager.getInstance().getDrawer();
                drawer.getItems().add(new NavigationDrawer.Item("Abrir archivo", MaterialDesignIcon.ARCHIVE.graphic()));
                drawer.setFooter(new Label("Version 1.0"));
            }
        });
    }
    
    @FXML
    void buttonClick() {
        label.setText("Hello JavaFX Universe!");
    }
    
}
