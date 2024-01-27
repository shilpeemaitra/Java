// download the mysql connector - https://dev.mysql.com/downloads/connector/j/
// add the jar file to the libraries
// open xampp
// and start apache and mysql
// create the database using phpmyadmin

public class DatabaseConnection {

    private static final String DB_NAME = "java_login_register_db";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
     
    private Connection connection;
    
    public DatabaseConnection(){
        
        try
        {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // create a connection to the database
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            
            if(connection != null)
            {
                System.out.println("Connected");
            }
            
        }catch(ClassNotFoundException ex){
            
            System.out.println("JDBC Driver Not Found");
            
        }catch(SQLException ex){
            
            System.err.println("Failed to Connect - " + ex.getMessage());
            
        }
        
    }
    
    
    // method to get the connection
    public Connection getConnection()
    {
        return connection;
    }
    
}


