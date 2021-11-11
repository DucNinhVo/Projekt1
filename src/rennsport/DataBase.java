package rennsport;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class DataBase {
//Diese Klasse erschaft Verbindung zwischen java und sql
//Ich habe versuch mit mysql aber kommt irgendwie ClassNotFoundException, habe noch keine Lösung dafür
	
//	private static final String JDBC_DRIVER = "com.mysql.jdbc.Drive";
//	private static final String DB_URL = "jdbc:mysql://localhost:3306/rennsport";
	
	private static final String JDBC_DRIVER = "org.sqlite.JDBC";
	private static String DB_URL = "jdbc:sqlite:C:\\Users\\Vo Duc Ninh\\eclipse-workspace\\Projekt1\\rennsport.db";
//	private static String DB_URL = "jdbc:sqlite:C:\\Users\\Vo Duc Ninh\\Downloads\\SQLiteStudio\\rennsport";
	
//	private static String USER_NAME = "root";
//	private static String PASSWORD = null;
	private static Connection connection;

	
	public static Connection initAndConnect()
    {
		initDriver();	
				
		try 
		{
			connection = DriverManager.getConnection(DB_URL);//bei mysql: getConnection(DB_URL,USER_NAME,PASSWORD)
			System.out.println("Connected.");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return connection;
	}
    
    public static void initDriver()
    {
		try 
		{
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC  driver  " + JDBC_DRIVER + "  not  found!");
			e.printStackTrace();
			System.exit(1);
		}	
	}  
   
    public static void close(Connection connection) 
    {
		try 
		{
			connection.close();
			System.out.println("Disconnected.");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
    
    public static void addWeather(Connection connection, Weather weather) {	
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("INSERT INTO weather (date,time,airTemparatur,trackTemparatur,trackVerhaeltnis) VALUES (?,?,?,?,?)");
			stm.setString(1, weather.addDate.toString());
			DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");			
			stm.setString(2, weather.addTime.format(tf));
			stm.setDouble(3, weather.getAirTemparatur());
			stm.setDouble(4, weather.getTrackTemparatur());
			stm.setString(5, weather.getTrackVerhaeltnis());
			stm.execute();
			System.out.println("Added.");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
	}


}
