import java.sql.*;
public class tablecreator2 {
	tablecreator2()
	{
		
		try
		{
			Connection connection;
			Statement statement;
			String location = "C:\\Users\\Rahul\\Downloads\\Busdetails.accdb";
			String databaseURL = "jdbc:ucanaccess://" + location;
			connection = DriverManager.getConnection(databaseURL);
			//System.out.println("Connection done Successfully");
			
			//String sql = "SELECT * FROM KPF7" ;
			System.out.println("HIT");
			statement = connection.createStatement();
			statement.executeUpdate("drop table passengerdetails");
			String table = "CREATE TABLE passengerdetails(";
			String f1 = "firstname varchar(30), lastname varchar(30), gender varchar(30), age varchar(30), dob varchar(30), number varchar(30), mail varchar(30), ";
			String f2 = "bus varchar(30), seatno varchar(30), class varchar(30), fromm varchar(30), too varchar(30), doj varchar(30), fare varchar(30), ";
			String f3 = "kurkure varchar(30), lays varchar(30), water varchar(30), blackbourbon varchar(30), hideAndSeek varchar(30), jimjam varchar(30), sevenup varchar(30), pepsi varchar(30), mirinda varchar(30), cocacola varchar(30))";
			String sql = table+f1+f2+f3;
			System.out.println(sql);
			statement.executeUpdate(sql);		
            System.out.println("HIT");
			statement.close();
			connection.close();
			System.out.println(table+f1+f2+f3);
		}
		catch(Exception e)
		{
			System.out.println("ERROR occured");
		}
	}
	public static void main(String[] args)
	{
		new tablecreator2();
	}
}