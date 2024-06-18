package com.admonReq;

import com.gluonhq.attach.lifecycle.LifecycleService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.attach.util.Services;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.application.ViewStackPolicy;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.control.NavigationDrawer.ViewItem;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.image.Image;

import static com.admonReq.sarequi.*;

public class DrawerManager {

    public static void buildDrawer(AppManager app) {
        NavigationDrawer drawer = app.getDrawer();
        
        NavigationDrawer.Header header = new NavigationDrawer.Header("Sarequi",
                "Prototipo de la aplicación Sarqui",
                new Avatar(21, new Image(DrawerManager.class.getResourceAsStream("/user.png"))));
        drawer.setHeader(header);
        
        final Item inicioItem = new ViewItem("Dashboard", MaterialDesignIcon.HOME.graphic(), INICIO_VIEW, ViewStackPolicy.SKIP);
        final Item otravistaItem = new ViewItem("Registrar Requerimiento", MaterialDesignIcon.DASHBOARD.graphic(), REGISTRO_VIEW);
        final Item consultar = new ViewItem("Consultar Requisitos", MaterialDesignIcon.SEARCH.graphic(), CONSULTA_VIEW);
        final Item exportar = new Item("Exportar proyecto", MaterialDesignIcon.IMPORT_EXPORT.graphic());
        final Item importar = new Item("Importar Proyecto", MaterialDesignIcon.ADD.graphic());
        final Item version = new Item("Versión 1.0.0", MaterialDesignIcon.INFO.graphic());

        drawer.getItems().addAll(inicioItem, otravistaItem, exportar, importar, consultar);

        drawer.setFooter(version);
        
        if (Platform.isDesktop()) {
            final Item quitItem = new Item("Salir", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
    }
}