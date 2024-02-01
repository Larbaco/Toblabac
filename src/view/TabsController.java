/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.TobLaba;
import java.time.LocalDate;
import java.time.Month;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.BM3;
import model.Teleport;

public class TabsController {

    /**
     * * Variaveis de interface **
     */
    @FXML
    private ComboBox<Integer> x0;
    @FXML
    private ComboBox<Integer> x1;
    @FXML
    private ComboBox<Integer> x2;
    @FXML
    private ComboBox<Integer> x3;
    @FXML
    private ComboBox<Integer> y0;
    @FXML
    private ComboBox<Integer> y1;
    @FXML
    private ComboBox<Integer> y2;
    @FXML
    private ComboBox<Integer> y3;
    @FXML
    private ComboBox<Integer> quantFatal;
    @FXML
    private CheckBox tp0;
    @FXML
    private CheckBox tp1;
    @FXML
    private CheckBox tp2;
    @FXML
    private TextField t0;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextArea customMacro;
    @FXML
    private TextArea customMacro1;
    @FXML
    private TextArea customMacro2;
    @FXML
    private TextArea customMacro3;
    @FXML
    private TextArea customMacro4;
    @FXML
    private TextArea customMacro6;
    @FXML
    private TextArea customMacro5;
    @FXML
    private Button oktp;
    @FXML
    private Button okbot;
    @FXML
    private Button applyMacro;
    @FXML
    private Button inicia;
    @FXML
    private RadioButton gema;
    @FXML
    private RadioButton item;
    @FXML
    private RadioButton aabaX3;
    @FXML
    private RadioButton aabaX2;
    @FXML
    private RadioButton aabaX1;
    @FXML
    private RadioButton abaaX3;
    @FXML
    private RadioButton abaaX2;
    @FXML
    private RadioButton abaaX1;
    @FXML
    private RadioButton baabX3;
    @FXML
    private RadioButton baabX2;
    @FXML
    private RadioButton baabX1;
    @FXML
    private RadioButton bbabX3;
    @FXML
    private RadioButton bbabX2;
    @FXML
    private RadioButton bbabX1;
    @FXML
    private CheckBox entraDungeon;
    @FXML
    private CheckBox saiDungeon;
    @FXML
    private CheckBox usaMacro;
    @FXML
    private CheckBox usaPot;
    @FXML
    private CheckBox bm2Macro;
    @FXML
    private CheckBox bm3Macro;
    @FXML
    private CheckBox aaba;
    @FXML
    private CheckBox abaa;
    @FXML
    private CheckBox baab;
    @FXML
    private CheckBox bbab;
    @FXML
    private TextField tempoGungeon;
    @FXML
    private ComboBox bm2Style;
    @FXML
    public static Circle bm2Status = new Circle();
    @FXML
    public static Circle bm3Status;
    @FXML
    public static Circle macroStatus;
    @FXML
    public static Circle customStatus;
    @FXML
    public static Circle potStatus;

    /**
     * * **
     */
    private final ObservableList<Integer> eixos = FXCollections.observableArrayList();
    private final ObservableList<String> battleStyles = FXCollections.observableArrayList(
            "WA", "BL", "FS", "FB", "WI", "GL", "FA"
    );
    private final ObservableList<Integer> fatais = FXCollections.observableArrayList();
    private TobLaba mainApp;
    private int aabaCount = 0;
    private int abaaCount = 0;
    private int baabCount = 0;
    private int bbabCount = 0;
    private String battleStyle;
    private Teleport tele0;
    private Teleport tele1;
    private Teleport tele2;
    private Teleport tele3;

    /**
     * O construtor. O construtor é chamado antes do método inicialize().
     */
    /**
     * Inicializa a classe controller. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    private void initialize() {

        TobLaba.atualizaCustom("1.2.3.4.5.6.7.8.9.0. .z.{wait0050}");
        
        //System.out.println(mainApp.eixos.toString());
        tele0 = new Teleport(0, 0, 9999);
        tele1 = new Teleport(0, 0, 9999);
        tele2 = new Teleport(0, 0, 9999);
        tele3 = new Teleport(0, 0, 9999);
        bm2Style.setItems(battleStyles);
        quantFatal.setItems(fatais);
        quantFatal.setValue(0);
        x0.setItems(FXCollections.observableArrayList(eixos));
        x1.setItems(FXCollections.observableArrayList(eixos));
        x2.setItems(FXCollections.observableArrayList(eixos));
        x3.setItems(FXCollections.observableArrayList(eixos));
        y0.setItems(FXCollections.observableArrayList(eixos));
        y1.setItems(FXCollections.observableArrayList(eixos));
        y2.setItems(FXCollections.observableArrayList(eixos));
        y3.setItems(FXCollections.observableArrayList(eixos));
        x0.setValue(100);
        x1.setValue(100);
        x2.setValue(100);
        x3.setValue(100);
        y0.setValue(100);
        y1.setValue(100);
        y2.setValue(100);
        y3.setValue(100);
        x0.setOnAction((ActionEvent e) -> {
            if (x0.getValue() != null) {
                tele0.setX(x0.getValue());
            } else {
                System.out.println("Deu pau na criação do TP0");
            }
        });
        x1.setOnAction((ActionEvent e) -> {
            if (x1.getValue() != null) {
                tele1.setX(x1.getValue());
            } else {
                System.out.println("Deu pau na criação do TP1");
            }
        });
        x2.setOnAction((ActionEvent e) -> {
            if (x2.getValue() != null) {
                tele2.setX(x2.getValue());
            } else {
                System.out.println("Deu pau na criação do TP2");
            }
        });
        x3.setOnAction((ActionEvent e) -> {
            if (x3.getValue() != null) {
                tele3.setX(x3.getValue());
            } else {
                System.out.println("Deu pau na criação do TP3");
            }
        });
        y0.setOnAction((ActionEvent e) -> {
            if (y0.getValue() != null) {
                tele0.setY(y0.getValue());
            } else {
                System.out.println("Deu pau na criação do TP0");
            }
        });
        y1.setOnAction((ActionEvent e) -> {
            if (y1.getValue() != null) {
                tele1.setY(y1.getValue());
            } else {
                System.out.println("Deu pau na criação do TP1");
            }
        });
        y2.setOnAction((ActionEvent e) -> {
            if (y2.getValue() != null) {
                tele2.setY(y2.getValue());
            } else {
                System.out.println("Deu pau na criação do TP2");
            }
        });
        y3.setOnAction((ActionEvent e) -> {
            if (y3.getValue() != null) {
                tele3.setY(y3.getValue());
            } else {
                System.out.println("Deu pau na criação do TP3");
            }
        });
        oktp.setOnAction(this::apply);
        okbot.setOnAction(this::apply);
        //okmacro.setOnAction(this::apply);
        inicia.setOnAction(this::startBot);
        gema.setOnAction(this::tipoEntrada);
        item.setOnAction(this::tipoEntrada);
        bm2Macro.setOnAction(this::checkBm2);
        bm3Macro.setOnAction(this::checkBm3);
        aaba.setOnAction(this::checkAABA);
        abaa.setOnAction(this::checkABAA);
        baab.setOnAction(this::checkBAAB);
        bbab.setOnAction(this::checkBBAB);
        aabaX1.setOnAction(this::checkAABARadio);
        aabaX2.setOnAction(this::checkAABARadio);
        aabaX3.setOnAction(this::checkAABARadio);
        abaaX1.setOnAction(this::checkABAARadio);
        abaaX2.setOnAction(this::checkABAARadio);
        abaaX3.setOnAction(this::checkABAARadio);
        baabX1.setOnAction(this::checkBAABRadio);
        baabX2.setOnAction(this::checkBAABRadio);
        baabX3.setOnAction(this::checkBAABRadio);
        bbabX1.setOnAction(this::checkBBABRadio);
        bbabX2.setOnAction(this::checkBBABRadio);
        bbabX3.setOnAction(this::checkBBABRadio);
        bm2Style.setOnAction(this::battleStyleListener);
        applyMacro.setOnAction(this::applyMacro);

        LocalDate hoje = LocalDate.now();
        boolean auxtmp = hoje.isBefore(LocalDate.of(2025, Month.JUNE, 30));
        System.out.println(auxtmp);
        if (!auxtmp) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Time Expired");
            alert.setHeaderText(null);
            alert.setContentText("Expired Use!");
            alert.showAndWait();
            Platform.exit();
            System.exit(0);
        }
    }

    private void checkBm2(ActionEvent evnt) {
        //System.out.println("AperteiBM2");

    }

    private void applyMacro(ActionEvent evnt) {
        
        int classe = getBm2Style();
        if(classe == -1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Class error");
            alert.setHeaderText(null);
            alert.setContentText("Choose one class!");
            alert.showAndWait();
        }
        TobLaba.macroB3 = new BM3(classe, aabaCount, abaaCount, baabCount, bbabCount);
        //System.out.println(">>>>>"+classe+ aabaCount+ abaaCount+ baabCount+ bbabCount+"\n"+quantFatal.getValue());
        System.out.println("BM3 >> "+TobLaba.macroB3.getBM3(quantFatal.getValue()));
        TobLaba.atualizaBM3(TobLaba.macroB3.getBM3(quantFatal.getValue()));
        System.out.println("Custom1 >> "+customMacro1.getText());
        TobLaba.atualizaCustom(customMacro1.getText());
    }

    private void checkBm3(ActionEvent evnt) {
        //System.out.println("apertei bm3");
        baab.setDisable(!bm3Macro.isSelected());
        aaba.setDisable(!bm3Macro.isSelected());
        abaa.setDisable(!bm3Macro.isSelected());
        bbab.setDisable(!bm3Macro.isSelected());
        if (bm3Macro.isSelected()) {
            aabaX1.setDisable(!aaba.isSelected());
            aabaX2.setDisable(!aaba.isSelected());
            aabaX3.setDisable(!aaba.isSelected());
            abaaX1.setDisable(!abaa.isSelected());
            abaaX2.setDisable(!abaa.isSelected());
            abaaX3.setDisable(!abaa.isSelected());
            baabX1.setDisable(!baab.isSelected());
            baabX2.setDisable(!baab.isSelected());
            baabX3.setDisable(!baab.isSelected());
            bbabX1.setDisable(!bbab.isSelected());
            bbabX2.setDisable(!bbab.isSelected());
            bbabX3.setDisable(!bbab.isSelected());
        } else {
            aabaX1.setDisable(true);
            aabaX2.setDisable(true);
            aabaX3.setDisable(true);
            abaaX1.setDisable(true);
            abaaX2.setDisable(true);
            abaaX3.setDisable(true);
            baabX1.setDisable(true);
            baabX2.setDisable(true);
            baabX3.setDisable(true);
            bbabX1.setDisable(true);
            bbabX2.setDisable(true);
            bbabX3.setDisable(true);

        }
    }

    private boolean contaSinergias() {
        //System.out.println("aaba:" + aabaCount + " abaa:" + abaaCount + " baab:" + baabCount + " bbab:" + bbabCount);
        if (aabaCount + abaaCount + baabCount + bbabCount > 3) {
            System.out.println("Limite de sinergias");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Synergy Limit");
            alert.setHeaderText(null);
            alert.setContentText("Only 3 synergys supported!");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    private void checkAABA(ActionEvent evnt) {
        if (aaba.isSelected() && checkAABARadio(evnt)) {
            aabaX1.setDisable(!aaba.isSelected());
            aabaX2.setDisable(!aaba.isSelected());
            aabaX3.setDisable(!aaba.isSelected());
        } else {
            aabaX1.setSelected(true);
            aabaX1.setDisable(true);
            aabaX2.setDisable(true);
            aabaX3.setDisable(true);
            aaba.setSelected(false);
            aabaCount = 0;
        }
    }

    private void checkABAA(ActionEvent evnt) {
        if (abaa.isSelected() && checkABAARadio(evnt)) {
            abaaX1.setDisable(!abaa.isSelected());
            abaaX2.setDisable(!abaa.isSelected());
            abaaX3.setDisable(!abaa.isSelected());
        } else {
            abaaX1.setSelected(true);
            abaaX1.setDisable(true);
            abaaX2.setDisable(true);
            abaaX3.setDisable(true);
            abaa.setSelected(false);
            abaaCount = 0;
        }
    }

    private void checkBAAB(ActionEvent evnt) {
        if (baab.isSelected() && checkBAABRadio(evnt)) {
            baabX1.setDisable(!baab.isSelected());
            baabX2.setDisable(!baab.isSelected());
            baabX3.setDisable(!baab.isSelected());
        } else {
            baabX1.setSelected(true);
            baabX1.setDisable(true);
            baabX2.setDisable(true);
            baabX3.setDisable(true);
            baab.setSelected(false);
            baabCount = 0;
        }
    }

    private void checkBBAB(ActionEvent evnt) {
        if (bbab.isSelected() && checkBBABRadio(evnt)) {
            bbabX1.setDisable(!bbab.isSelected());
            bbabX2.setDisable(!bbab.isSelected());
            bbabX3.setDisable(!bbab.isSelected());
        } else {
            bbabX1.setSelected(true);
            bbabX1.setDisable(true);
            bbabX2.setDisable(true);
            bbabX3.setDisable(true);
            bbab.setSelected(false);
            bbabCount = 0;
        }
    }

    private boolean checkAABARadio(ActionEvent evnt) {
        if (aaba.isSelected()) {
            if (aabaX1.isSelected()) {
                aabaCount = 1;
            } else if (aabaX2.isSelected()) {
                aabaCount = 2;
            } else {
                aabaCount = 3;
            }
            if (contaSinergias()) {
                return true;
            } else {
                aabaX1.setSelected(true);
                aabaCount = 1;
                return false;
            }
        }
        return true;
    }

    private boolean checkABAARadio(ActionEvent evnt) {
        if (abaa.isSelected()) {
            if (abaaX1.isSelected()) {
                abaaCount = 1;
            } else if (abaaX2.isSelected()) {
                abaaCount = 2;
            } else {
                abaaCount = 3;
            }
            if (contaSinergias()) {
                return true;
            } else {
                abaaX1.setSelected(true);
                abaaCount = 1;
                return false;
            }
        }
        return true;
    }

    private boolean checkBAABRadio(ActionEvent evnt) {
        if (baab.isSelected()) {
            if (baabX1.isSelected()) {
                baabCount = 1;
            } else if (baabX2.isSelected()) {
                baabCount = 2;
            } else {
                baabCount = 3;
            }
            if (contaSinergias()) {
                return true;
            } else {
                baabX1.setSelected(true);
                baabCount = 1;
                return false;
            }
        }
        return true;
    }

    private boolean checkBBABRadio(ActionEvent evnt) {
        if (bbab.isSelected()) {
            if (bbabX1.isSelected()) {
                bbabCount = 1;
            } else if (bbabX2.isSelected()) {
                bbabCount = 2;
            } else {
                bbabCount = 3;
            }
            if (contaSinergias()) {
                return true;
            } else {
                bbabX1.setSelected(true);
                bbabCount = 1;
                return false;
            }
        }
        return true;
    }

    private void battleStyleListener(Event evnt) {
        battleStyle = (String) bm2Style.getValue();
        System.out.println(battleStyle);
    }

    public TabsController() {
        for (int i = 0; i < 350; i++) {
            eixos.add(i);
        }
        for (int i = 0; i < 4; i++) {
            fatais.add(i);
        }
    }

    /**
     * É chamado pela aplicação principal para dar uma referência de volta a si
     * mesmo.
     *
     * @param mainApp
     */
    public void setMainApp(TobLaba mainApp) {
        this.mainApp = mainApp;
    }

    public int getCoord(ComboBox<Integer> self) {
        System.out.println(self.getValue());
        return self.getValue();
    }

    private void apply(ActionEvent evnt) {
        // Button was clicked, do something...

    }

    private void startBot(ActionEvent evnt) {
        // Button was clicked, do something...
        TobLaba.bot.tempo = Integer.parseInt(getTempoDungeon());
        TobLaba.bot.setRun(true);
    }

    private void tipoEntrada(ActionEvent evnt) {
        // Button was clicked, do something...
        TobLaba.bot.gema=(gema.isSelected());
    }

    public String getT0() {
        return t0.getText();
    }

    public String getT1() {
        return t1.getText();
    }

    public String getT2() {
        return t2.getText();
    }

    public String getT3() {
        return t3.getText();
    }

    public String getCustomMacro() {
        return customMacro.getText();
    }

    public String getTempoDungeon() {
        return tempoGungeon.getText();
    }

    public int getBm2Style() {
        
        if (null != battleStyle) {
            switch (battleStyle) {
                case "WI":
                    return 1;
                case "BL":
                    return 2;
                case "FB":
                    return 3;
                case "WA":
                    return 4;
                case "FA":
                    return 5;
                case "FS":
                    return 6;
                case "GL":
                    return 7;
                default:
                    return -1;
            }
        }
        return -1;
    }

    public void setBM2Status(boolean b) {
        if (b) {
            bm2Status.setFill(Color.GREEN);
        } else {
            bm2Status.setFill(Color.RED);
        }
    }

    public void setBM3Status(boolean b) {
        if (b) {
            bm3Status.setFill(Color.GREEN);
        } else {
            bm3Status.setFill(Color.RED);
        }
    }

    public void setCustomStatus(boolean b) {
        if (b) {
            customStatus.setFill(Color.GREEN);
        } else {
            customStatus.setFill(Color.RED);
        }
    }

    public void setMacroStatus(boolean b) {
        if (b) {
            macroStatus.setFill(Color.GREEN);
        } else {
            macroStatus.setFill(Color.RED);
        }
    }

    public void setPotStatus(boolean b) {
        if (b) {
            potStatus.setFill(Color.GREEN);
        } else {
            potStatus.setFill(Color.RED);
        }
    }

    public void atualizaStatus() {
        System.out.println(TobLaba.bm2.getRun());
        setPotStatus(TobLaba.pot.getRun());
        setMacroStatus(TobLaba.custom.getRun());
        setCustomStatus(TobLaba.custom.getRun());
        setBM2Status(TobLaba.bm2.getRun());
        setBM3Status(TobLaba.bm3.getRun());
    }
}
