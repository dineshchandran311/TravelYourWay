import java.sql.*;
public class ClearTable {
	ClearTable()
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
					String seatno[] = {"W1","M2","W3","W4","M5","W6","W7","M8","W9","W10","M11","W12","W13","M14","W15"};
					for(int i = 0 ; i<=14 ; i++)
					{
                        String clear = "update "+tablename+" set firstname = null, lastname = null, gender = null, age = null, dob = null, number = null, mail = null where seatNo = "+"\'"+seatno[i]+"\'";
                        statement.executeUpdate(clear);
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
		new ClearTable();
	}
}