package ehu.isad.controller.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDBKud {

    private static final AdminDBKud instance = new AdminDBKud();

    public static AdminDBKud getInstance() {
        return instance;
    }

    public boolean logInCorrect(String erabiltzailea, String pasahitza) {
        String query = "select erabiltzailea,pasahitza from admin where erabiltzailea='" + erabiltzailea + "' and pasahitza='" + pasahitza + "'";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        boolean emaitza = false;

        try {
            if (rs.next() == true) {
                emaitza = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return emaitza;
    }
}
