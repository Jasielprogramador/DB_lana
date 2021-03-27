package ehu.isad.controller.ui;

import ehu.isad.EurovisionEIB;
import ehu.isad.controller.db.AdminTBDB;
import ehu.isad.controller.db.HerrialdeaBozkatuDBKud;
import ehu.isad.partaideak.AdminTabla;
import ehu.isad.partaideak.Partaidea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.sql.SQLException;
import java.util.List;

public class AdminTBKud {

    @FXML
    private TableView<AdminTabla> tblTaula;

    @FXML
    private TableColumn<AdminTabla, String> Herrialdea;

    @FXML
    private TableColumn<AdminTabla, Integer> Puntuak;

    @FXML
    private Button btnOK;

    private EurovisionEIB main;

    public void setMainApp(EurovisionEIB main) {
        this.main = main;
    }

    public void partaideakKargatu(){
        List<AdminTabla> kargatzekoa = AdminTBDB.getInstance().herrialdeakEtaPuntuakKargatu();
        ObservableList<AdminTabla> Tabla = FXCollections.observableArrayList(kargatzekoa);

        //add your data to the table here.
        tblTaula.setItems(Tabla);
        tblTaula.setEditable(true);


        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class

        Herrialdea.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        Puntuak.setCellValueFactory(new PropertyValueFactory<>("Puntuak"));
        Puntuak.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        this.puntuakEditatu();
        this.puntuakCommit();
    }

    public void puntuakEditatu(){
        Callback<TableColumn<AdminTabla, Integer>, TableCell<AdminTabla, Integer>> defaultTextFieldCellFactory
                = TextFieldTableCell.forTableColumn(new IntegerStringConverter());

        Puntuak.setCellFactory(col -> {
            TableCell<AdminTabla, Integer> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                cell.setEditable(true);
            });

            return cell ;
        });
    }



    public void puntuakCommit(){
        Puntuak.setOnEditCommit(
                t -> {
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setPuntuak(t.getNewValue());
                });
    }

    @FXML
    void OnClick(ActionEvent event) throws SQLException {

        int size = tblTaula.getItems().size();
        for (int i = 0; i < size; i++) {
            if (Puntuak.getCellObservableValue(i).getValue() > 0) {
                AdminTBDB.getInstance().datuBaseanDatuZaharrakAktualizatu(Puntuak.getCellObservableValue(i).getValue(), Herrialdea.getCellObservableValue(i).getValue());
            }
        }
        this.main.hasieraErakutsi();
    }
}
