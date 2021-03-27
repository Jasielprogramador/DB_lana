package ehu.isad.controller.ui;

import ehu.isad.EurovisionEIB;
import ehu.isad.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import ehu.isad.utils.Utils;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;

public class HasieraKud implements Initializable {

    private EurovisionEIB main;

    public void setMainApp(EurovisionEIB main) {
        this.main = main;
    }

    @FXML
    private Button btn_bozkatu;

    @FXML
    private Button btnAdmin;

    @FXML
    private ImageView imgIrudia;

    @FXML
    void OnClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        if(btn.equals(btn_bozkatu)) {
            main.herrialdeakHautatuErakutsi();
        }
        else if(btn.equals(btnAdmin)){
            main.adminErakutsi();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
