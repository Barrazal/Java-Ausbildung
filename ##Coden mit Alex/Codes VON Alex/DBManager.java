import java.sql.*;

public class DBManager
{
    String dbName;
    Connection connection;

    public DBManager(String dbName)
    {
        try
        {
            final String DB_URL = "jdbc:derby:"+dbName+";create=true";

            // Create a connection to the database.
            this.connection = DriverManager.getConnection(DB_URL);

        } catch (Exception e)
        {
            System.out.println("Error Creating the Database!");
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public String executeStatement(String sql) {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet result = stmt.getResultSet();
            StringBuilder resultString = new StringBuilder();
            if (result != null) {
                ResultSetMetaData metaData = result.getMetaData();
                int maxCol = metaData.getColumnCount();
                for (int i=1; i <= maxCol; i++) {
                    resultString.append(metaData.getColumnName(i) + "; ");
                }
                resultString.append("\n");
                while(result.next()) {
                    for (int i=1; i <= maxCol; i++) {
                        resultString.append(result.getString(metaData.getColumnName(i)) + "; ");
                    }
                    resultString.append("\n");
                }
                return resultString.toString();
            } else
                return "Statement executed.";

        } catch (SQLException ex) {
            return "ERROR: " + ex.getMessage();
        }
    }
}
