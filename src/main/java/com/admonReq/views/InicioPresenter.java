package com.admonReq.views;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.*;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class InicioPresenter {

    public ExpansionPanelContainer expans;
    public CharmListView<String, String> compelte;
    public CharmListView<String, String> inProg;
    public CharmListView<String, String> toDo;
    @FXML
    private View inicio;


    public void initialize() {
        inicio.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        AppManager.getInstance().getDrawer().open()));
                appBar.setTitleText("Dashboard");
                appBar.getActionItems().add(MaterialDesignIcon.PERSON.button(e ->
                        System.out.println("Person")));

                setLists();
                expans.getStyleClass().add("expansion-panel-container");

            }
        });
    }

    @FXML
    void setLists(){
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add("Tarea 1");
        items.add("cell2");
        items.add("cell3");
        compelte.setItems(items);

    }
}
