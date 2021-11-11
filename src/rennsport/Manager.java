package rennsport;

import java.sql.Connection;


public class Manager {
	public static Connection connection;

	public static void main(String[] args) {
		connection = DataBase.initAndConnect();
		Weather weather = new Weather(2.5, 2.5, "dry");
		
		DataBase.addWeather(connection, weather);
		DataBase.close(connection);
	}
	
	
}
