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
        
        final Item inicioItem = new ViewItem("Inicio", MaterialDesignIcon.HOME.graphic(), INICIO_VIEW, ViewStackPolicy.SKIP);
        final Item otravistaItem = new ViewItem("OtraVista", MaterialDesignIcon.DASHBOARD.graphic(), OTRAVISTA_VIEW);
        final Item item = new Item("Item", MaterialDesignIcon.STAR.graphic());
        drawer.getItems().addAll(inicioItem, otravistaItem, item);
        
        if (Platform.isDesktop()) {
            final Item quitItem = new Item("Quit", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
    }
}