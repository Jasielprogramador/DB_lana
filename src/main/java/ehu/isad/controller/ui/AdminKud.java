package ehu.isad.controller.ui;

import ehu.isad.EurovisionEIB;
import ehu.isad.controller.db.AdminDBKud;
import ehu.isad.controller.db.HerrialdeaBozkatuDBKud;
import ehu.isad.partaideak.Partaidea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminKud implements Initializable {

    @FXML
    private TextField tfErabiltzailea;

    @FXML
    private TextField tfPasahitza;

    @FXML
    private Button btnOK;

    @FXML
    private Label lblLabel;

    @FXML
    private PasswordField pfPasahitza;

    private EurovisionEIB main;

    public void setMainApp(EurovisionEIB main) {
        this.main = main;
    }

    @FXML
    void OnClick(ActionEvent event) {
        if(tfErabiltzailea.getText().equals("") || pfPasahitza.getText().equals("")){
            lblLabel.setText("Mesedez sar itzazu erabiltzailea eta pasahitza");
        }
        else{
            if(AdminDBKud.getInstance().logInCorrect(tfErabiltzailea.getText(),pfPasahitza.getText())){
                main.getAdminTBKud().partaideakKargatu();
                main.adminTBErakutsi();
            }
            else{
                lblLabel.setText("Erabiltzailea edo pasahitza okerrak dira");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
