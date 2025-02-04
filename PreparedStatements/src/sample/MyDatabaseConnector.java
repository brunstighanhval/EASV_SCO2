package sample;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class MyDatabaseConnector {
    private static final String PROP_FILE = "config/database.settings";
    private SQLServertaSource ds;

    public MyDatabaseConnector() throws IOException {


        Properties databaseProperties = new Properties();
        databaseProperties.load(new FileInputStream(new File(PROP_FILE)));

        String server = databaseProperties.getProperty("10.176.111.31");
        String database = databaseProperties.getProperty("SQLInjectionDB");
        String user = databaseProperties.getProperty("CSe2022A_25");
        String password = databaseProperties.getProperty("CSe2022A_25");

        ds = new SQLServerDataSource();
        ds.setServerName(server);
        ds.setDatabaseName(database);
        ds.setUser(user);
        ds.setPassword(password);
        ds.setTrustServerCertificate(true);
    }

    public Connection getConnection() throws SQLServerException {
        return ds.getConnection();
    }

}
