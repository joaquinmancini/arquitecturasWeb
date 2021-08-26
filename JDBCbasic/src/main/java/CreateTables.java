import persintenceConnection.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTables {

    private ConnectionDB connectionDB = new ConnectionDB();

    public CreateTables() throws SQLException {
        Connection connection = connectionDB.getInstance();
        String client = "CREATE TABLE IF NOT EXISTS client(" +
                "idClient INT," +
                "name VARCHAR(500)," +
                "email VARCHAR(150)," +
                "PRIMARY KEY(idClient))";
        connection.prepareStatement(client).execute();
        connection.commit();
        String bill = "CREATE TABLE IF NOT EXISTS bill(" +
                "idBill INT," +
                "idClient INT," +
                "PRIMARY KEY(idBill))";
        connection.prepareStatement(bill).execute();
        connection.commit();
        String product = "CREATE TABLE IF NOT EXISTS product(" +
                "idProduct INT," +
                "name VARCHAR(45)," +
                "amount FLOAT," +
                "PRIMARY KEY(idProduct))";
        connection.prepareStatement(product).execute();
        connection.commit();

        String billProduct = "CREATE TABLE IF NOT EXISTS billProduct(" +
                "idBill INT," +
                "idProduct INT," +
                "quantity INT," +
                "PRIMARY KEY(idBill, idProduct))";
        connection.prepareStatement(billProduct).execute();
        connection.commit();

        connectionDB.connectionClose();
    }
}
