package mensajesApp.Utils;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    public java.sql.Connection get_connection() {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje_app"
                    ,"root"
                    , "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

}
