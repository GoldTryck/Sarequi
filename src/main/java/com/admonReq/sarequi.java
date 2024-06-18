package com.admonReq;

import com.admonReq.views.ConsultaView;
import com.admonReq.views.RegistroReqView;
import com.admonReq.views.SesionView;
import com.admonReq.views.InicioView;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static com.gluonhq.charm.glisten.application.AppManager.HOME_VIEW;

public class sarequi extends Application {

    public static final String SESION_VIEW = HOME_VIEW;
    public static final String REGISTRO_VIEW = "OtraVista View";
    public static final String INICIO_VIEW = "Inicio View";
    public static final String CONSULTA_VIEW = "Consulta View";

    private final AppManager appManager = AppManager.initialize(this::postInit);

    @Override
    public void init() {
        appManager.addViewFactory(SESION_VIEW, () -> new SesionView().getView());
        appManager.addViewFactory(REGISTRO_VIEW, () -> new RegistroReqView().getView());
        appManager.addViewFactory(INICIO_VIEW, () -> new InicioView().getView());
        appManager.addViewFactory(CONSULTA_VIEW, () -> new ConsultaView().getView());

        DrawerManager.buildDrawer(appManager);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(1100);
        primaryStage.setHeight(800);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(500);
        appManager.start(primaryStage);
    }

    private void postInit(Scene scene) {
        Swatch.DEEP_PURPLE.assignTo(scene);
        scene.getStylesheets().add(sarequi.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(sarequi.class.getResourceAsStream("/icon.png")));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
