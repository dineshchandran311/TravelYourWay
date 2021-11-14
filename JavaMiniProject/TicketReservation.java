import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.Border;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.LocalDate;
import java.sql.*;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.time.*;  
 

class MyDefaultMetalThemee extends DefaultMetalTheme {
    public ColorUIResource getWindowTitleInactiveBackground() {
			return new ColorUIResource(java.awt.Color.RED);
		  }
		
		  public ColorUIResource getWindowTitleBackground() {
			return new ColorUIResource(new Color(199, 245, 255));
		  }
		
		  public ColorUIResource getPrimaryControlHighlight() {
			return new ColorUIResource(java.awt.Color.PINK);
		  }
		
		  public ColorUIResource getPrimaryControlDarkShadow() {
			return new ColorUIResource(java.awt.Color.BLACK);
		  }
		
		  public ColorUIResource getPrimaryControl() {
			return new ColorUIResource(java.awt.Color.WHITE);
		  }
		
		  public ColorUIResource getControlHighlight() {
			return new ColorUIResource(java.awt.Color.WHITE);
		  }
		
		  public ColorUIResource getControlDarkShadow() {
			return new ColorUIResource(java.awt.Color.BLACK);
		  }
		
		  public ColorUIResource getControl() {
			return new ColorUIResource(java.awt.Color.WHITE);
		  }
  }
class DateLabelFormatter extends AbstractFormatter {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
     
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }
 
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
         
        return "";
    }
 
}

class Miniproj {
    String a,bb;
	Statement statement = null;
    Connection connection = null;
    ResultSet result = null ; 
    int x = -1;
    int n;
    JPanel radiopanel;
    ButtonGroup bg;
    JButton b1;
    String busno,fromm,too,price;
	JFrame f;
    Miniproj(String fromDef,String toDef,int enable,String dateSet)
    {
		Color c = new Color(199, 245, 255);

        SpringLayout layout = new SpringLayout();
        Font f1 = new Font("SansSerif", Font.BOLD, 18);
		Font f2 = new Font("SansSerif", Font.BOLD, 20);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

		f = new JFrame("                                                                                                                                                                                                                     TRAVEL YOUR WAY !                                                                                                                                                                                                        ");
    	f.setUndecorated(true);
        f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        ImageIcon img = new ImageIcon("C:\\Users\\Rahul\\OneDrive\\Pictures\\BUS.png");
        f.setIconImage(img.getImage());

        JPanel panell = new JPanel();
        panell.setBackground(java.awt.Color.white);
        f.setContentPane(panell);

        MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalThemee());
        try {
        UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
        e.printStackTrace();
        }

        SwingUtilities.updateComponentTreeUI(f);

		f.getContentPane().setBackground(c);
        JPanel panel = new JPanel();
		panel.setBackground(c);
        String from[] = {"","Coimbatore","Chennai","Madurai","Erode","Dharapuram"};
        String to[] = {"","Coimbatore","Chennai","Madurai","Erode","Dharapuram"};

        int indexfrom = findIndex(from,fromDef);
        int indexto = findIndex(to,toDef);
        //System.out.println(indexfrom+" "+indexto);
        JLabel heading = new JLabel("Buses Provided By Agency");
        heading.setFont(new Font("SansSerif", Font.BOLD, 25));
        f.add(heading);

        JLabel froml = new JLabel("From",JLabel.RIGHT);
        froml.setFont(f1);
        panel.add(froml);

        JComboBox<String> fromcb = new JComboBox<String>(from);
		fromcb.setBackground(new Color(255, 255, 255));
        fromcb.setSelectedIndex(indexfrom);
        //fromcb.setBorder(border);
        fromcb.setFont(f1);
        panel.add(fromcb);

        JLabel tol = new JLabel("To",JLabel.RIGHT);
        tol.setFont(f1);
        panel.add(tol);

        JComboBox<String> tocb = new JComboBox<String>(to);
		tocb.setBackground(new Color(255, 255, 255));
        tocb.setSelectedIndex(indexto);
        tocb.setFont(f1);
        //tocb.setBorder(border);
        tocb.setPreferredSize(new Dimension(150,30));
        panel.add(tocb);

        JLabel dojl = new JLabel("DOJ",JLabel.RIGHT);
        dojl.setFont(f1);
        panel.add(dojl);

        LocalDate d1 = LocalDate.now();
        UtilDateModel model = new UtilDateModel();
		// DayOfWeek day = DayOfWeek.from(d1); 
		// System.out.println(day.getValue());  
		// System.out.println(d1.getDayOfWeek());
        if(dateSet.trim().length()==0)
        {
        	model.setDate(d1.getYear(), d1.getMonthValue() - 1 , d1.getDayOfMonth());
        }
        else
        {
        	String[] d2 = dateSet.split("-");
        	model.setDate(Integer.parseInt(d2[0]), Integer.parseInt(d2[1])-1, Integer.parseInt(d2[2])); 	
        }
        model.setSelected(true);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.getComponent(0).setPreferredSize(new Dimension(150,33));
        datePicker.getComponent(1).setPreferredSize(new Dimension(30,33));
        datePicker.getComponent(0).setFont(f1);
		datePicker.getComponent(0).setBackground(new Color(255, 255, 255));
        datePanel.setPreferredSize(new Dimension(300,180));
        datePanel.setFont(f1);
		datePanel.setBackground(new Color(255, 255, 255));
        //datePicker.setBorder(border);
        panel.add(datePicker);


        JButton b = new JButton("Submit");  
		b.setForeground(new Color(255, 255, 255));
		b.setBackground(new Color(0, 0, 0));
		b.setFont(new Font("SansSerif",Font.BOLD,20));  
		b.setPreferredSize(new Dimension(150,50));
		f.add(b);
        
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	if(fromcb.getSelectedIndex()!=0 && tocb.getSelectedIndex()!=0 && fromcb.getSelectedIndex()!=tocb.getSelectedIndex())
            	{
					x = -1;
            		System.out.println("Action performing!!");
	                a = (String) fromcb.getSelectedItem();
	                bb = (String) tocb.getSelectedItem();
	                int i = 0;
	                try {
	                    String location = "C:\\Users\\Rahul\\Downloads\\Busdetails.accdb";
	                    String databaseURL = "jdbc:ucanaccess://" + location;
	                    connection = DriverManager.getConnection(databaseURL);
	                    System.out.println("Connection done Successfully");
	        
	                    String sql = "SELECT * FROM busdetails where Fromm = \'"+a+"\' and Too = \'"+bb+"\'" ;
	                     
	                    statement = connection.createStatement();
	                    result = statement.executeQuery(sql);
	                }
	                catch (Exception e11) {
	
	                }
	
	
	                JLabel table = new JLabel();
	                JPanel tablepanel = new JPanel();
	                tablepanel.setBackground(c);
	                
	                table = new JLabel("Bus Number");
	                table.setPreferredSize(new Dimension(150,30));
	                table.setFont(f2);
	                tablepanel.add(table);
	
	                table = new JLabel("Bus Name");
	                table.setPreferredSize(new Dimension(150,30));
	                table.setFont(f2);
	                tablepanel.add(table);
	
	                table = new JLabel("From");
	                table.setPreferredSize(new Dimension(150,30));
	                table.setFont(f2);
	                tablepanel.add(table);
	
	                table = new JLabel("To");
	                table.setPreferredSize(new Dimension(150,30));
	                table.setFont(f2);
	
	                tablepanel.add(table);
	
	                table = new JLabel("Time");
	                table.setPreferredSize(new Dimension(150,30));
	                table.setFont(f2);
	                tablepanel.add(table);
	
	                table = new JLabel("Max seats");
	                table.setPreferredSize(new Dimension(150,30));
	                table.setFont(f2);
	                tablepanel.add(table);
	
	                table = new JLabel("Class");
	                table.setPreferredSize(new Dimension(150,30));
	                table.setFont(f2);
	                tablepanel.add(table);
	                
	                table = new JLabel("Price");
	                table.setPreferredSize(new Dimension(150,30));
	                table.setFont(f2);
	                tablepanel.add(table);
	
	                tablepanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
	                layout.putConstraint(SpringLayout.WEST, tablepanel, 150, SpringLayout.WEST, f);
	                layout.putConstraint(SpringLayout.NORTH, tablepanel, 150, SpringLayout.SOUTH, panel);
	                f.add(tablepanel);
	                
	                try{
	                    while(result.next())
	                    {
	                        JPanel tablespanel = new JPanel();
							tablespanel.setBackground(c);
	                        JLabel lb1 = new JLabel(result.getString(1));
	                        lb1.setPreferredSize(new Dimension(150,30));
	                        lb1.setFont(f1);
	                        JLabel lb2 = new JLabel(result.getString(2));
	                        lb2.setPreferredSize(new Dimension(150,30));
	                        lb2.setFont(f1);
	                        JLabel lb3 = new JLabel(result.getString(3));
	                        lb3.setPreferredSize(new Dimension(150,30));
	                        lb3.setFont(f1);
	                        JLabel lb4 = new JLabel(result.getString(4));
	                        lb4.setPreferredSize(new Dimension(150,30));
	                        lb4.setFont(f1);
	                        JLabel lb5 = new JLabel(result.getString(5));
	                        lb5.setPreferredSize(new Dimension(150,30));
	                        lb5.setFont(f1);
	                        JLabel lb6 = new JLabel(result.getString(6));
	                        lb6.setPreferredSize(new Dimension(150,30));
	                        lb6.setFont(f1);
	                        JLabel lb7 = new JLabel(result.getString(7));
	                        lb7.setPreferredSize(new Dimension(150,30));
	                        lb7.setFont(f1);
	                        JLabel lb8 = new JLabel(result.getString(8));
	                        lb8.setPreferredSize(new Dimension(150,30));
	                        lb8.setFont(f1);
	                        tablespanel.add(lb1);
	                        tablespanel.add(lb2);
	                        tablespanel.add(lb3);
	                        tablespanel.add(lb4);
	                        tablespanel.add(lb5);
	                        tablespanel.add(lb6);
	                        tablespanel.add(lb7);
	                        tablespanel.add(lb8);
	                        tablespanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
	                        layout.putConstraint(SpringLayout.WEST, tablespanel, 150, SpringLayout.WEST, f);
	                        layout.putConstraint(SpringLayout.NORTH, tablespanel, 210 + (50*(i+1)), SpringLayout.NORTH, panel);
	                        f.add(tablespanel);
	                        f.setVisible(true);
	                        i++;
	                    }
	                    
	                }
	                catch(Exception eee)
	                {
	
	                }
	
	                n = 0;
	                
	                try{
	                    String sql = "SELECT * FROM busdetails where Fromm = \'"+a+"\' and Too = \'"+bb+"\'" ;
	                     
	                    statement = connection.createStatement();
	                    ResultSet result1 = statement.executeQuery(sql);
	                    while(result1.next())
	                    {
	                        n++;
	                    }
	                }
	                catch(Exception eeee)
	                {
	                    eeee.printStackTrace();
	                }
	
	                JRadioButton[] radios = new JRadioButton[n];
	                bg = new ButtonGroup();
	                for(int ii = 0; ii < n; ii++)
	                {
	                    radios[ii] = new JRadioButton();
						radios[ii].setBackground(c);
						radios[ii].setBorder(border);
	                    layout.putConstraint(SpringLayout.WEST, radios[ii], 100, SpringLayout.WEST, f);
	                    layout.putConstraint(SpringLayout.NORTH, radios[ii], 207+(50*(ii+1)), SpringLayout.SOUTH, panel);
	                    bg.add(radios[ii]);
	                    f.add(radios[ii]);
	                    f.setVisible(true);
	                }
	                
                    b1 = new JButton("Submit");  
					b1.setForeground(new Color(255, 255, 255));
        			b1.setBackground(new Color(0, 0, 0));
                    b1.setFont(new Font("SansSerif",Font.BOLD,20));  
                    b1.setPreferredSize(new Dimension(150,50));
                    f.add(b1);
                    layout.putConstraint(SpringLayout.WEST, b1, 730, SpringLayout.WEST, f);
                    layout.putConstraint(SpringLayout.NORTH, b1, 570, SpringLayout.SOUTH, panel);
                    f.setVisible(true);

                                
                    b1.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            for(int jj = 0; jj < n; jj++)
                            {
                                if(radios[jj].isSelected())
                                {
                                    x = jj;
                                }
                            }
                            if(x!=-1)
                            {
                            	try
	                            {
	                                String sql = "SELECT * FROM busdetails where Fromm = \'"+a+"\' and Too = \'"+bb+"\'" ;
	                                int xx = 0;
	                                statement = connection.createStatement();
	                                ResultSet result2 = statement.executeQuery(sql);
	                                while(result2.next())
	                                {
	                                    if(x == xx)
	                                    {
	                                        busno = result2.getString(1);
	                                        fromm = result2.getString(3);
	                                        too = result2.getString(4);
	                                        price = result2.getString(7);
	                                        System.out.println(result2.getString(1)+" "+result2.getString(2)+" "+result2.getString(3)+" "+result2.getString(4)+" "+result2.getString(5)+" "+result2.getString(6)+" "+result2.getString(7));
	                                    }
	                                    xx++;
	                                }
	                                connection.close();
	                            }
	                            catch(Exception eeee)
	                            {
	                                eeee.printStackTrace();
								}
	
	
	                            System.out.println("Bus number : "+busno);
	                            System.out.println("From : "+fromm);
	                            System.out.println("To  : "+too);
	                            String date = datePicker.getJFormattedTextField().getText();
								System.out.println(date);
	                            f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
	                            new busDetails(busno,fromm,too,date);
                            }
                            else
                            {
                            	JOptionPane.showMessageDialog(f,"Select valid bus.");
                            }
                        }
                     });
            	}
	            else
	            {
	            	JOptionPane.showMessageDialog(f,"Please Select valid From and To");
	            }
            }
         });
                    //System.out.println(x);
        if(enable == 1)
        {
        	b.doClick();
        	System.out.println("clicked1");
        }        
        panel.setLayout(new GridLayout(1,6,20,20));
        f.add(panel);
        layout.putConstraint(SpringLayout.WEST, heading, 640, SpringLayout.WEST, f);
        layout.putConstraint(SpringLayout.NORTH, heading, 30, SpringLayout.NORTH, f);
        layout.putConstraint(SpringLayout.WEST, panel, 100, SpringLayout.WEST, f);
        layout.putConstraint(SpringLayout.NORTH, panel, 100, SpringLayout.NORTH, f);
        layout.putConstraint(SpringLayout.WEST, b, 725, SpringLayout.WEST, f);
        layout.putConstraint(SpringLayout.NORTH, b, 50, SpringLayout.SOUTH, panel);
        f.setLayout(layout);
        f.setSize(1536,820);
        f.setVisible(true);

    }
    public static int findIndex(String arr[], String t)
    {
 
        // if array is Null
        if (arr == null) 
        {
            return -1;
        }
 
        int len = arr.length;
        int i = 0;
 

        while (i < len) 
        {

            if (arr[i].equals(t)) 
            {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
}










//-----------------------------------------------------------------------------------------------------------------------------------------
public class TicketReservation {
	public static void main(String args[])
	{
		//new adminstratorlogin();
		new Miniproj("","",0,"");
	}
}