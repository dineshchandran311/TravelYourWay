import java.sql.*;
public class tablecreator {
	tablecreator()
	{
		
		try
		{
			Connection connection;
			Statement statement;
			ResultSet result;
			String location = "C:\\Users\\Rahul\\Downloads\\Busdetails.accdb";
			String databaseURL = "jdbc:ucanaccess://" + location;
			connection = DriverManager.getConnection(databaseURL);
			System.out.println("Connection done Successfully");
			
			String sql = "SELECT * FROM busdetails" ;
			
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			while(result.next())
			{
				try
				{
					String number = result.getString(1);
					String name = result.getString(2);
					name = name.substring(0,3);
					String tablename = name+number;
					String creation = "create table "+tablename+" (day varchar(30),seatNo varchar(30),firstname varchar(30),lastname varchar(30),gender varchar(30),age varchar(30),dob varchar(30),number varchar(30),mail varchar(30))";
					statement.executeUpdate(creation);
					String seatno[] = {"W1","M2","W3","W4","M5","W6","W7","M8","W9","W10","M11","W12","W13","M14","W15"};
					for(int j = 1 ; j<=7 ; j++)
					{
						
						for(int i = 0 ; i<=14 ;i++)
						{
							String values = "\'"+String.valueOf(j)+"\'"+", "+"\'"+seatno[i]+"\'";
							String insert = "insert into "+tablename+" (day, seatNo) values("+values+")";
							statement.executeUpdate(insert);
						}
					}
				}
				catch(Exception e)
				{
					
				}
			}
            System.out.println("HIT");
			result.close();
			statement.close();
			connection.close();
		}
		catch(Exception e)
		{
			
		}
	}
	public static void main(String[] args)
	{
		new tablecreator();
	}
}