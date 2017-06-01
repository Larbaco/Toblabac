/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.AWTException;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.BM3;
import model.Macros;
import model.KeyboardHook;
import view.TabsController;

/**
 *
 * @author Desk
 */
public class TobLaba extends Application {

    private static TobLaba main;
    public static boolean gema;

    public static void atualizaBM3(String text) {
        bm3.setComandos(text);
    }

    public static void tooglePot() {
        pot.setRun(!pot.getRun());
        System.out.println(pot.getRun());
    }

    private TabsController abas;
    private Stage primaryStage;
    private VBox rootLayout;
    private AnchorPane tabs;
    private AnchorPane teleportes;
    private AnchorPane abaBot;
    private AnchorPane macros;
    public static BM3 macroB3;
    public static Macros pot;
    public static Macros bm2;
    public static Macros bm3;
    public static Macros bot;
    public static Macros custom;
    private static KeyboardHook hook;

    @Override
    public void start(Stage primaryStage) {

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                KeyboardHook.executa = false;
                System.out.println("Fechando...");
            }
        });
        hook = new KeyboardHook();
        hook.start();
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("TobLabac");
        primaryStage.setOnCloseRequest((WindowEvent event) -> {
            hook.panic();
            Platform.exit();
            System.exit(0);
        });
        //System.out.println(eixos.toString());
        initRootLayout();
    }

    public TobLaba() {

    }

    /**
     * @param args the command line arguments
     * @throws java.awt.AWTException
     */
    public static void main(String[] args) throws AWTException {
        bm2 = new Macros(1);
        bm2.start();
        bm3 = new Macros(3);
        bm3.start();
        custom = new Macros(3);
        custom.start();
        pot = new Macros(5);
        pot.start();
        bot = new Macros(4);
        bot.start();
        launch(args);
    }

    /**
     * * Inicializa o root layout **
     */
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/RootLayout.fxml"));
            rootLayout = (VBox) loader.load();
            // Mostra a scene (cena) contendo oroot layout.
            this.showTabs();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Mostra os teleportes na aba de teleports.
     */
    public void showTabs() {
        try {
            // Carrega a person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TobLaba.class.getResource("/view/Tabs.fxml"));
            tabs = (AnchorPane) loader.load();
            rootLayout.getChildren().add(tabs);
            // Dá ao controlador acesso à the main app.

            TabsController controller = loader.getController();
            controller.setMainApp(this);
            abas = controller;
            //controller.criaCoord();
        } catch (IOException e) {
        }
    }

    public static void carregaOpcoes() {

    }

    public static void toogleBM2() {
        bm2.setRun(!bm2.getRun());
        System.out.println(bm2.getRun());
    }

    public static void toogleBM3() {
        bm3.setRun(!bm3.getRun());
        System.out.println(bm3.getRun());
    }

    public static void toogleCustom() {
        custom.setRun(!custom.getRun());
        System.out.println(custom.getRun());
    }

    public static void atualizaCustom(String cmd) {
        custom.setComandos(cmd);
    }

    public static void fechar() {
        hook.panic();
        Platform.exit();
        System.exit(0);
    }

    public static void toogleBot() {
        bot.setRun(!bot.getRun());
        System.out.println(bot.getRun());
    }
    
    public static void Panic(){
        pot.setRun(false);
        bot.setRun(false);
        bm2.setRun(false);
        bm3.setRun(false);
        custom.setRun(false);   
        
    }
}
