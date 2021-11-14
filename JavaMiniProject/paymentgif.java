import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
public class paymentgif{
	JFrame f;
	public paymentgif(String fromV,String toV,String dateV,String timeV,String priceV,String tablename,String[] value,Object[][] snack,int k,String type) {  
		  
		JFrame f = new JFrame("                                                                                                                                                                                                                       TRAVEL YOUR WAY !                                                                                                                                                                                                        ");
    	f.setUndecorated(true);
        f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        ImageIcon img = new ImageIcon("C:\\Users\\Rahul\\OneDrive\\Pictures\\BUS.png");
        f.setIconImage(img.getImage());

        JPanel panell = new JPanel();
        panell.setBackground(java.awt.Color.white);
        f.setContentPane(panell);

        MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme());
        try {
        UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
        e.printStackTrace();
        }

        SwingUtilities.updateComponentTreeUI(f);
		Icon icon = new ImageIcon("C:\\Users\\Rahul\\OneDrive\\Pictures\\gif12.gif");
		JPanel headpanel1 = new JPanel();
		JPanel headpanel = new JPanel();
		JLabel giflabel= new JLabel(icon);
		giflabel.setPreferredSize(new Dimension(1920,150));
		JPanel labelp = new JPanel();
		JLabel label = new JLabel("Processing your payment....",JLabel.CENTER);
		label.setVerticalAlignment(JLabel.TOP);
		label.setFont( new Font(Font.SANS_SERIF, Font.PLAIN,50));
		label.setPreferredSize(new Dimension(700,200));
		labelp.add(label);
		headpanel.add(giflabel);headpanel.add(labelp);
		headpanel.setPreferredSize(new Dimension(1920,700));
		headpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel mainpanel = new JPanel();
		mainpanel.add(headpanel1);
		mainpanel.add(headpanel);
		labelp.setBackground(Color.white);
		headpanel.setBackground(Color.white);
		headpanel1.setBackground(Color.white);
		mainpanel.setLayout(new BoxLayout(mainpanel,BoxLayout.Y_AXIS));
		
		
		f.getContentPane().setBackground(Color.white);
		f.add(mainpanel);
		f.setVisible(true);
		f.setSize(1536,820); 
		JOptionPane.showMessageDialog(f,"Payment Done Successfully!");
		int daynumber = -1; 
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		  Date dt1;
		try {
			dt1 = format1.parse(dateV);
			DateFormat format2 = new SimpleDateFormat("EEEE"); 
			String finalDay = format2.format(dt1);
			switch(finalDay)
			{
			    case "Monday":
			        daynumber = 1;
			        break;
			    case "Tuesday":
			        daynumber = 2;
			        break;
			    case "Wednesday":
			        daynumber = 3;
			        break;
			    case "Thursday":
			        daynumber = 4;
			        break;
			    case "Friday":
			        daynumber = 5;
			        break;
			    case "Saturday":
			        daynumber = 6;
			        break;
			    case "Sunday":
			        daynumber = 7;
			        break;
			    default:
			        daynumber = -1;
			        break;
			}
			System.out.println(daynumber);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try    	
		{
			Connection connection;
			Statement statement;
			//ResultSet result;
			String location = "C:\\Users\\Rahul\\Downloads\\Busdetails.accdb";
			String databaseURL = "jdbc:ucanaccess://" + location;
			connection = DriverManager.getConnection(databaseURL);
			System.out.println("Connection done Successfully");
			
			String sql = "UPDATE "+tablename+" SET firstname = '"+value[0]+"', lastname = '"+value[1]+"', gender = '"+value[2]+"', age = '"+value[3]+"', dob = '"+value[4]+"', number = '"+value[5]+"', mail ='"+value[6]+"'";
			sql = sql + " WHERE seatNo = '"+value[7]+"'"+" and "+" day = '"+daynumber+"'";
			System.out.println(sql);
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			
			
            System.out.println("HIT");
			statement.close();
			connection.close();
		}
		catch(Exception e1)
		{
			
		}
		f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
		new confirmationPage(fromV,toV,dateV,timeV,priceV,tablename,value,snack,k,type);
    }  
	public static void main(String[] args)
	{
		String[] arr = {};
    	Object[][] obj= {};
    	new paymentgif("","","2021-11-19","","","",arr,obj,0,"");
	}
}