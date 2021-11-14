import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// class MyDefaultMetalThemes extends DefaultMetalTheme {
//     // public ColorUIResource getWindowTitleInactiveBackground() {
//     //   return new ColorUIResource(java.awt.Color.WHITE);
//     // }
  
//     public ColorUIResource getWindowTitleBackground() {
//       return new ColorUIResource(new Color(199, 245, 255));
//     }
  
//     // public ColorUIResource getPrimaryControlHighlight() {
//     //   return new ColorUIResource(java.awt.Color.PINK);
//     // }
  
//     public ColorUIResource getPrimaryControlDarkShadow() {
//       return new ColorUIResource(java.awt.Color.BLACK);
//     }
  
//     public ColorUIResource getPrimaryControl() {
//       return new ColorUIResource(java.awt.Color.WHITE);
//     }
  
//     // public ColorUIResource getControlHighlight() {
//     //   return new ColorUIResource(java.awt.Color.WHITE);
//     // }
  
//     // public ColorUIResource getControlDarkShadow() {
//     //   return new ColorUIResource(java.awt.Color.BLACK);
//     // }
  
//     // public ColorUIResource getControl() {
//     //   return new ColorUIResource(java.awt.Color.WHITE);
//     // }
//   }
public class busDetails implements ActionListener {

	String busno,busname,from,to,time,seats,type,price,date;
	JFrame f;
	JButton back;
    //JButton next;
    JButton buttonarr[] = new JButton[15];
    Connection connection;
	Statement statement;
	ResultSet result;
	busDetails(String bno,String fromm,String too,String dt)
	{
		Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 33);
        //Font  f3  = new Font(Font.SANS_SERIF,  Font.PLAIN, 18);
        Font  f4  = new Font(Font.SANS_SERIF, Font.PLAIN,22);
        //Font  f5  = new Font(Font.SANS_SERIF, Font.PLAIN,16);
        
        date = dt;
        
        try
		{
			
			String location = "C:\\Users\\Rahul\\Downloads\\Busdetails.accdb";
            String databaseURL = "jdbc:ucanaccess://" + location;
            connection = DriverManager.getConnection(databaseURL);
            System.out.println("Connection done Successfully");

            String sql = "SELECT * FROM busdetails" ;
             
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next())
            {
            	
            	if(bno.equals(result.getString(1)))
            	{
            		busno = result.getString(1);
            		busname = result.getString(2);
            		from = result.getString(3);
            		to = result.getString(4);
            		time = result.getString(5);
            		seats = result.getString(6);
            		type = result.getString(7);
            		price = result.getString(8);
            		//System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
            		
            	}
            }
		}
		catch(Exception e)
		{
			
		}
        
		f = new JFrame("                                                                                                                                                                                                                       TRAVEL YOUR WAY !                                                                                                                                                                                                        ");
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

		JPanel mainPanel = new JPanel();
		
		JPanel panelTop = new JPanel();
		
		JLabel lbheading = new JLabel("Vacancies");
		lbheading.setFont(f2);
		panelTop.add(lbheading);
		
		JPanel panelTop2 = new JPanel();
		JPanel panelleft1 = new JPanel();
		JLabel lbleftBus = new JLabel("Bus Details",JLabel.CENTER);
		lbleftBus.setFont(f2); //
		panelleft1.add(lbleftBus);
		JPanel panelright1 = new JPanel();
		JLabel lbrightBus = new JLabel("Seats",JLabel.CENTER);
		lbrightBus.setFont(f2);
		panelright1.add(lbrightBus);
		panelTop2.add(lbleftBus);
		panelTop2.add(lbrightBus);
		
		JPanel panelTop3 = new JPanel();
		
		JPanel panelleft2 = new JPanel();
		
		JLabel lbBusNumber = new  JLabel("Bus Number:");
		lbBusNumber.setBackground(new Color(173, 231, 237));
		JLabel lbBusNumberD = new JLabel(busno);
		lbBusNumberD.setBackground(new Color(173, 231, 237));
		lbBusNumber.setFont(f4);
		lbBusNumberD.setFont(f4);
		panelleft2.add(lbBusNumber);
		panelleft2.add(lbBusNumberD);
		
		JLabel lbBusName = new  JLabel("Bus Name:");
		lbBusName.setBackground(new Color(173, 231, 237));
		JLabel lbBusNameD = new JLabel(busname);
		lbBusNameD.setBackground(new Color(173, 231, 237));
		lbBusName.setFont(f4);
		lbBusNameD.setFont(f4);
		panelleft2.add(lbBusName);
		panelleft2.add(lbBusNameD);
		
		JLabel lbSeats = new JLabel("No of Seats:");
		lbSeats.setBackground(new Color(173, 231, 237));
		JLabel lbSeatsD = new JLabel(seats);
		lbSeatsD.setBackground(new Color(173, 231, 237));
		lbSeats.setFont(f4);
		lbSeatsD.setFont(f4);
		panelleft2.add(lbSeats);
		panelleft2.add(lbSeatsD);
		
		JLabel lbFrom = new JLabel("From:");
		lbFrom.setBackground(new Color(173, 231, 237));
		JLabel lbFromD = new JLabel(from);
		lbFromD.setBackground(new Color(173, 231, 237));
		lbFrom.setFont(f4);
		lbFromD.setFont(f4);
		panelleft2.add(lbFrom);
		panelleft2.add(lbFromD);
		
		
		JLabel lbTo = new JLabel("To:");
		lbTo.setBackground(new Color(173, 231, 237));
		JLabel lbToD = new JLabel(to);
		lbToD.setBackground(new Color(173, 231, 237));
		lbTo.setFont(f4);
		lbToD.setFont(f4);
		panelleft2.add(lbTo);
		panelleft2.add(lbToD);
		
		JLabel lbPrice = new JLabel("Price:");
		lbPrice.setBackground(new Color(173, 231, 237));
		JLabel lbPriceD = new JLabel(price);
		lbPriceD.setBackground(new Color(173, 231, 237));
		lbPrice.setFont(f4);
		lbPriceD.setFont(f4);
		panelleft2.add(lbPrice);
		panelleft2.add(lbPriceD);
		
		JLabel lbClass = new JLabel("Type:");
		lbClass.setBackground(new Color(173, 231, 237));
		JLabel lbClassD = new JLabel(type);
		lbClassD.setBackground(new Color(173, 231, 237));
		lbClass.setFont(f4);
		lbClassD.setFont(f4);
		panelleft2.add(lbClass);
		panelleft2.add(lbClassD);
		
		JLabel lbDOJ = new JLabel("DOJ:");
		lbDOJ.setBackground(new Color(173, 231, 237));
		JLabel lbDOJD = new JLabel(date+" "+time+" PM");
		lbDOJD.setBackground(new Color(173, 231, 237));
		lbDOJ.setFont(f4);
		lbDOJD.setFont(f4);
		panelleft2.add(lbDOJ);
		panelleft2.add(lbDOJD);
		
		
		panelTop3.add(panelleft2);
		
		JPanel panelTop4 = new JPanel();
		
		back = new JButton("Back");
		back.setFont(f4);
		back.setPreferredSize(new Dimension(150,50));
		back.setBackground(new Color(0, 0, 0));
		back.setForeground(new Color(255,255,255));
		//next = new JButton("Next");
		//next.setFont(f4);
		//next.setPreferredSize(new Dimension(200,70));
		panelTop4.add(back);
		//panelTop4.add(next);
		panelTop4.setLayout(new FlowLayout(FlowLayout.CENTER,40,40));
		back.addActionListener(this);
		//next.addActionListener(this);
		
		
		
		JPanel buttonpanel = new JPanel();
        for(int i = 1; i < 16; i++)
        {
            if((i-1) == 1 || (i-1) == 4 || (i-1) == 7 || (i-1) == 10 || (i-1) == 13)
            {
                buttonarr[i - 1] = new JButton("M" + i);
            }
            else
            {
                buttonarr[i - 1] = new JButton("W" + i);
            }
            buttonarr[i-1].setForeground(Color.BLACK);
            buttonarr[i-1].setBackground(new Color(38, 240, 52));
            buttonarr[i-1].setPreferredSize(new Dimension(100,50));
            buttonarr[i-1].setFont(new Font("SansSerif", Font.BOLD, 18));
            buttonpanel.add(buttonarr[i-1]);
        }

        for(int i = 0 ; i< 15 ; i++)
        {
        	buttonarr[i].addActionListener(this);
        }

		int daynumber = -1; 
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		  Date dt1;
		try {
			dt1 = format1.parse(date);
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
			String number = busno;
			String name = busname;
			String tablename = name.substring(0,3)+number;
			String sql = "select * from "+tablename+" WHERE day = \'"+daynumber+"\'";
			ResultSet result2 = statement.executeQuery(sql);
			int disable = 0;
			while(result2.next())
			{
				if(result2.getString(3)!=null)
				{
					buttonarr[disable].setBackground(new Color(247, 146, 146));
					buttonarr[disable].setEnabled(false);
				}
				disable++;
			}
        }
        catch(Exception e)
        {
        	
        }
        panelTop3.add(buttonpanel);
        
		
		panelTop.setBackground(new Color(173, 231, 237));
		
		panelTop2.setBackground(new Color(173, 231, 237));
		panelTop3.setBackground(new Color(173, 231, 237));
		panelTop4.setBackground(new Color(173, 231, 237));
		mainPanel.setBackground(new Color(173, 231, 237));
		buttonpanel.setBackground(new Color(173, 231, 237));
		panelleft2.setBackground(new Color(173, 231, 237));
		
		lbBusName.setOpaque(true);
		lbBusNameD.setOpaque(true);
		lbClass.setOpaque(true);
		lbClassD.setOpaque(true);
		lbDOJ.setOpaque(true);
		lbDOJD.setOpaque(true);
		lbFrom.setOpaque(true);
		lbFromD.setOpaque(true);
		lbSeats.setOpaque(true);
		lbSeatsD.setOpaque(true);
		lbTo.setOpaque(true);
		lbToD.setOpaque(true);

		buttonpanel.setLayout(new GridLayout(5,3,20,20));
		panelleft2.setLayout(new GridLayout(8,2,30,20));
		panelTop.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		panelTop3.setLayout(new FlowLayout(FlowLayout.CENTER,365,0));
		panelTop2.setLayout(new FlowLayout(FlowLayout.CENTER,600,40));
		panelTop.setPreferredSize(new Dimension(70,70));
		panelTop2.setPreferredSize(new Dimension(150,80));
		f.add(panelTop);
		f.add(panelTop2);
		f.add(panelTop3);
		f.add(panelTop4);
		f.getContentPane().setLayout(new BoxLayout(f.getContentPane(),BoxLayout.Y_AXIS));
		//mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		
		//f.add(mainPanel);
		f.setSize(1536,830);
		f.setVisible(true);

		
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == back)
		{
			System.out.println("Back");
			f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
			new Miniproj(from,to,1,date);
			
		}
		else
		{
			for(int i =0 ; i<15 ; i++)
			{
				if(e.getSource() == buttonarr[i])
				{
					buttonarr[i].setBackground(new Color(77, 135, 227));
					System.out.println(buttonarr[i].getText());
					int a = JOptionPane.showConfirmDialog(f, "Are you sure want to continue?");
					if(a == 0)
					{
						f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
						new registration(busno, busname, from, to, time+" PM", type, buttonarr[i].getText(),price,date);
					}
					else
					{
						buttonarr[i].setBackground(new Color(38, 240, 52));
					}
				}
			}
		}
	}
	public static void main(String[] args)
	{
		new busDetails("","","","");
	}
}