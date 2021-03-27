package ehu.isad.controller.db;

import ehu.isad.partaideak.AdminTabla;
import ehu.isad.partaideak.Partaidea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminTBDB {

    private static final AdminTBDB instance = new AdminTBDB();

    public static AdminTBDB getInstance() {
        return instance;
    }

    public List<AdminTabla> herrialdeakEtaPuntuakKargatu(){

        String query = "select bozkatuaIzanDa,puntuak from Bozkaketa";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<AdminTabla> emaitza = new ArrayList<>();

        try {
            while (rs.next()) {

                String herrialdea = rs.getString("bozkatuaIzanDa");
                Integer puntuak = rs.getInt("puntuak");
                AdminTabla adminTabla = new AdminTabla(herrialdea,puntuak);
                emaitza.add(adminTabla);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }

    public void datuBaseanDatuZaharrakAktualizatu(int puntuak,String herrialdea){
        String query = "update Bozkaketa set puntuak = "+puntuak+" where (bozkatuaIzanDa='"+herrialdea+"');";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        dbKudeatzaile.execSQL(query);
    }
}
