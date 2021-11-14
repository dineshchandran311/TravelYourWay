import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.sql.*;

class confirmationPage {
    String busidd;
    JLabel label;
    JLabel label2;
    confirmationPage(String fromV,String toV,String dateV,String timeV,String priceV,String tablename,String[] value,Object[][] snack,int k,String type)
    {
		
        JFrame f = new JFrame("                                                                                                                                                                                                                   TRAVEL YOUR WAY !                                                                                                                                                                                                        ");
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
        
        int n = k;
        
        // JPanel pheading = new JPanel();
        // JPanel pcenter = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        
        //JPanel pbottom = new JPanel();
        JLabel l=new JLabel("TRAVEL YOUR WAY");
        l.setFont(new Font("SansSerif",Font.BOLD,28));       
        //pheading.add(l);

        JLabel l1=new JLabel(" FIRST NAME: ");
        l1.setFont(new Font("SansSerif",Font.BOLD,18));
        p1.add(l1);
        
        JLabel fname=new JLabel(value[0]);
        fname.setFont(new Font("SansSerif",Font.PLAIN,18));
        p1.add(fname);

        JLabel l2=new JLabel(" LAST NAME: ");
        l2.setFont(new Font("SansSerif",Font.BOLD,18));
        p1.add(l2);

        JLabel lname=new JLabel(value[1]);
        lname.setFont(new Font("SansSerif",Font.PLAIN,18));
        lname.setPreferredSize(new Dimension(150,50));
        p1.add(lname);
        
        JLabel l11=new JLabel(" GENDER: ");
        l11.setFont(new Font("SansSerif",Font.BOLD,18));
        p1.add(l11);

        JLabel gender=new JLabel(value[2]);
        gender.setFont(new Font("SansSerif",Font.PLAIN,18));
        p1.add(gender);

        JLabel l4=new JLabel(" AGE: ");
        l4.setFont(new Font("SansSerif",Font.BOLD,18));
        p1.add(l4);

        JLabel age=new JLabel(value[3]);
        age.setFont(new Font("SansSerif",Font.PLAIN,18));
        p1.add(age);

        JLabel l6=new JLabel(" DATE OF BIRTH: ");
        l6.setFont(new Font("SansSerif",Font.BOLD,18));
        p1.add(l6);

        JLabel dob=new JLabel(value[4]);
        dob.setFont(new Font("SansSerif",Font.PLAIN,18));
        p1.add(dob);


        JLabel l5=new JLabel(" MOBILE NUMBER: ");
        l5.setFont(new Font("SansSerif",Font.BOLD,18));
        p1.add(l5);

        JLabel mobile=new JLabel(value[5]);
        mobile.setFont(new Font("SansSerif",Font.PLAIN,18));
        p1.add(mobile);

        JLabel l12=new JLabel(" E-MAIL: ");
        l12.setFont(new Font("SansSerif",Font.BOLD,18));
        p1.add(l12);

        JLabel email=new JLabel(value[6]);
        email.setFont(new Font("SansSerif",Font.PLAIN,18));
        p1.add(email);

        JLabel l13=new JLabel(" BUS: ");
        l13.setFont(new Font("SansSerif",Font.BOLD,18));
        p2.add(l13);

        JLabel busid=new JLabel(tablename.substring(0,3)+" Travels "+tablename.substring(3,tablename.length()));
        busidd = tablename.substring(0,3)+" Travels "+tablename.substring(3,tablename.length());
        
        busid.setFont(new Font("SansSerif",Font.PLAIN,18));
        busid.setPreferredSize(new Dimension(150,50));
        p2.add(busid);

        JLabel l14=new JLabel(" SEAT NUMBER: ");
        l14.setFont(new Font("SansSerif",Font.BOLD,18));
        p2.add(l14);

        JLabel seatno=new JLabel(value[7]);
        seatno.setFont(new Font("SansSerif",Font.PLAIN,18));
        p2.add(seatno);

        JLabel l15=new JLabel(" CLASS: ");
        l15.setFont(new Font("SansSerif",Font.BOLD,18));
        p2.add(l15);

        JLabel bclass=new JLabel(type);
        bclass.setFont(new Font("SansSerif",Font.PLAIN,18));
        p2.add(bclass);

        JLabel l16=new JLabel(" FROM: ");
        l16.setFont(new Font("SansSerif",Font.BOLD,18));
        p2.add(l16);

        JLabel from=new JLabel(fromV);
        from.setFont(new Font("SansSerif",Font.PLAIN,18));
        p2.add(from);

        JLabel l17=new JLabel(" TO: ");
        l17.setFont(new Font("SansSerif",Font.BOLD,18));
        p2.add(l17);

        JLabel to=new JLabel(toV);
        to.setFont(new Font("SansSerif",Font.PLAIN,18));
        p2.add(to);

        JLabel l18=new JLabel(" DOJ: ");
        l18.setFont(new Font("SansSerif",Font.BOLD,18));
        p2.add(l18);

        JLabel date=new JLabel(dateV+" "+timeV);
        date.setFont(new Font("SansSerif",Font.PLAIN,18));
        p2.add(date);

        JLabel l20=new JLabel(" FARE: ");
        l20.setFont(new Font("SansSerif",Font.BOLD,18));
        p2.add(l20);

        JLabel fare=new JLabel(priceV);
        fare.setFont(new Font("SansSerif",Font.PLAIN,18));
        p2.add(fare);
                
        JButton bon=new JButton("PRINT");          
        bon.setFont(new Font("SansSerif",Font.BOLD,18));
        bon.setPreferredSize(new Dimension(150,50));
        bon.setForeground(new Color(255, 255, 255));
		bon.setBackground(new Color(0, 0, 0));;
        //pbottom.add(bon);

        if(n==0)
        {
            f.setLayout(new GridBagLayout());
            GridBagConstraints gc = new GridBagConstraints();
    
            gc.gridx = 1;
            gc.gridy = 0;
            gc.insets = new Insets(0,0,30,0);
            f.add(l,gc);
            gc.gridx = 0;
            gc.gridy = 1;
            gc.insets = new Insets(25,0,0,0);
            f.add(p1,gc);
            gc.gridx = 2;
            gc.gridy = 1;
            gc.insets = new Insets(25,0,0,0);
            f.add(p2,gc);
            gc.gridx = 1;
            gc.gridy = 2;
            gc.insets = new Insets(50,0,0,0);
            f.add(bon,gc);
        }
        else
        {
            f.setLayout(new GridBagLayout());
            GridBagConstraints gc = new GridBagConstraints();


            p3.setPreferredSize(new Dimension(400,500));
            p1.setPreferredSize(new Dimension(400,500));
            p2.setPreferredSize(new Dimension(400,500));
        	p3.setLayout(new GridBagLayout());
            GridBagConstraints gc1 = new GridBagConstraints();

            for(int i = 0 ; i<n ;i++)
            {
                
                label = new JLabel(String.valueOf(snack[i][0]));
                label.setFont(new Font("SansSerif",Font.BOLD,18));
                label.setPreferredSize(new Dimension(150,50));
                
                label2 = new JLabel(String.valueOf(snack[i][2]));
                label2.setFont(new Font("SansSerif",Font.PLAIN,18));
                gc1.gridx = 0;
                gc1.gridy = i;
                p3.add(label,gc1);
                gc1.gridx = 1;
                gc1.gridy = i;
                p3.add(label2,gc1);
    
            }

            gc.gridx = 1;
            gc.gridy = 0;
            gc.insets = new Insets(0,0,30,0);
            f.add(l,gc);
            gc.gridx = 0;
            gc.gridy = 1;
            gc.insets = new Insets(25,0,0,0);
            f.add(p1,gc);
            gc.gridx = 1;
            gc.gridy = 1;
            gc.insets = new Insets(25,0,0,0);
            f.add(p2,gc);
            gc.gridx = 2;
            gc.gridy = 1;
            gc.insets = new Insets(25,0,0,0);
            f.add(p3,gc);
            gc.gridx = 1;
            gc.gridy = 2;
            gc.insets = new Insets(50,0,0,0);
            f.add(bon,gc);
        }
       
        // pheading.setPreferredSize(new Dimension(200,100));
        
        p1.setLayout(new GridLayout(7,2,10,20));
        p2.setLayout(new GridLayout(7,2,10,20));

        // pcenter.add(p1);pcenter.add(p2);pcenter.add(p3);

        // pcenter.setPreferredSize(new Dimension(600,600));
        // pcenter.setLayout(new FlowLayout(FlowLayout.CENTER,100,30));
        
        // pbottom.setPreferredSize(new Dimension(200,200));
        
        //p1.setBackground(new Color(187, 219, 240));
        f.getContentPane().setBackground(new Color(187, 219, 240));
        // pheading.setBackground(new Color(187, 219, 240));
        // pcenter.setBackground(new Color(187, 219, 240));
        //p3.setBackground(new Color(187, 219, 240));
        // pbottom.setBackground(new Color(187, 219, 240));
        
        try
        {
        	Connection connection;
			String location = "C:\\Users\\Rahul\\Downloads\\Busdetails.accdb";
			String databaseURL = "jdbc:ucanaccess://" + location;
			connection = DriverManager.getConnection(databaseURL);
			System.out.println("Connection done Successfully");
        	PreparedStatement ps = connection.prepareStatement("insert into passengerdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");			
            ps.setString(1,value[0]);
            ps.setString(2,value[1]);
            ps.setString(3,value[2]);
            ps.setString(4,value[3]);
            ps.setString(5,value[4]);
            ps.setString(6,value[5]);
            ps.setString(7,value[6]);
            ps.setString(8,busidd);
            ps.setString(9,value[7]);
            ps.setString(10,type);
            ps.setString(11,fromV);
            ps.setString(12,toV);
            ps.setString(13,dateV+" "+timeV);
            ps.setString(14,priceV);
            String[] snackname = {"Kurkure","Lays","Purified Water","Black bourbon","Hide and Seek","Jim Jam","7up 500ml","Pepsi 500ml","Mirinda 500ml","Coca Cola 500ml"};
            int s = 0 ;
            for(int it = 0 ; it<10 ; it++)
            {
            	
            	if(s<n && String.valueOf(snack[s][0]).equals(snackname[it])){
            		ps.setString(15+it,String.valueOf(snack[s][2]));
            		s++;
            	}
            	else{
            		ps.setString(15+it,null);
            	}
            }
            ps.executeUpdate();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        Color c= new Color(187, 219, 240);
        p1.setBackground(c);
        p2.setBackground(c);
        p3.setBackground(c);
        f.setSize(1536,820);
        f.setVisible(true);
        
        bon.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		PrinterJob job = PrinterJob.getPrinterJob();
        		job.setJobName("Travel Your Way Bill");
        		job.setPrintable(new Printable() 
        		{
	        		public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)throws PrinterException
	        		{
		        		if (pageIndex >= 1) 
		        		{
		        			return Printable.NO_SUCH_PAGE;
		        		} 
		        		else 
		        		{
		        			((Graphics2D)graphics).translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		        			System.out.println(pageFormat.getImageableX()+" "+pageFormat.getImageableY());
		        			((Graphics2D)graphics).scale(0.3,0.3);
		        			f.getContentPane().print(graphics);
		        			
		        			return Printable.PAGE_EXISTS;
		        		}
	        		}
        		});
        		try
        		{
        			job.print();
        			JOptionPane.showMessageDialog(f, "Print out is taken successfully! Thank you");
        			
        		}
        		catch (PrinterException ex)
        		{
        			ex.printStackTrace();
        		}
        		f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
        		new FrontPage();
        		}
        });
       
 
    }
    confirmationPage(String name,String mobilenumber)
    {
    	
    	JFrame f = new JFrame("Confirmation page");
    	int n = 0;
    	try
    	{
    		Connection connection;
			String location = "C:\\Users\\Rahul\\Downloads\\Busdetails.accdb";
			String databaseURL = "jdbc:ucanaccess://" + location;
			connection = DriverManager.getConnection(databaseURL);
			Statement s = connection.createStatement();
			String sql = "SELECT * FROM passengerdetails "+"WHERE firstname = \""+name+"\" and number = \""+mobilenumber+"\"";
			ResultSet st = s.executeQuery(sql);
			System.out.println(sql);
            int hit = -1;
			while(st.next())
			{
                hit = 0;
		        JPanel p1 = new JPanel();
		        JPanel p2 = new JPanel();
		        JPanel p3 = new JPanel();

		        JLabel l=new JLabel("TRAVEL YOUR WAY");
		        l.setFont(new Font("SansSerif",Font.BOLD,28));       

		        JLabel l1=new JLabel(" FIRST NAME: ");
		        l1.setFont(new Font("SansSerif",Font.BOLD,18));
		        p1.add(l1);
		        
		        JLabel fname=new JLabel(st.getString(1));
		        fname.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p1.add(fname);

		        JLabel l2=new JLabel(" LAST NAME: ");
		        l2.setFont(new Font("SansSerif",Font.BOLD,18));
		        p1.add(l2);

		        JLabel lname=new JLabel(st.getString(2));
		        lname.setFont(new Font("SansSerif",Font.PLAIN,18));
		        lname.setPreferredSize(new Dimension(150,50));
		        p1.add(lname);
		        
		        JLabel l11=new JLabel(" GENDER: ");
		        l11.setFont(new Font("SansSerif",Font.BOLD,18));
		        p1.add(l11);

		        JLabel gender=new JLabel(st.getString(3));
		        gender.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p1.add(gender);

		        JLabel l4=new JLabel(" AGE: ");
		        l4.setFont(new Font("SansSerif",Font.BOLD,18));
		        p1.add(l4);

		        JLabel age=new JLabel(st.getString(4));
		        age.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p1.add(age);

		        JLabel l6=new JLabel(" DATE OF BIRTH: ");
		        l6.setFont(new Font("SansSerif",Font.BOLD,18));
		        p1.add(l6);

		        JLabel dob=new JLabel(st.getString(5));
		        dob.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p1.add(dob);


		        JLabel l5=new JLabel(" MOBILE NUMBER: ");
		        l5.setFont(new Font("SansSerif",Font.BOLD,18));
		        p1.add(l5);

		        JLabel mobile=new JLabel(st.getString(6));
		        mobile.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p1.add(mobile);

		        JLabel l12=new JLabel(" E-MAIL: ");
		        l12.setFont(new Font("SansSerif",Font.BOLD,18));
		        p1.add(l12);

		        JLabel email=new JLabel(st.getString(7));
		        email.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p1.add(email);

		        JLabel l13=new JLabel(" BUS: ");
		        l13.setFont(new Font("SansSerif",Font.BOLD,18));
		        p2.add(l13);

		        JLabel busid=new JLabel(st.getString(8));
		        
		        busid.setFont(new Font("SansSerif",Font.PLAIN,18));
		        busid.setPreferredSize(new Dimension(150,50));
		        p2.add(busid);

		        JLabel l14=new JLabel(" SEAT NUMBER: ");
		        l14.setFont(new Font("SansSerif",Font.BOLD,18));
		        p2.add(l14);

		        JLabel seatno=new JLabel(st.getString(9));
		        seatno.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p2.add(seatno);

		        JLabel l15=new JLabel(" CLASS: ");
		        l15.setFont(new Font("SansSerif",Font.BOLD,18));
		        p2.add(l15);

		        JLabel bclass=new JLabel(st.getString(10));
		        bclass.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p2.add(bclass);

		        JLabel l16=new JLabel(" FROM: ");
		        l16.setFont(new Font("SansSerif",Font.BOLD,18));
		        p2.add(l16);

		        JLabel from=new JLabel(st.getString(11));
		        from.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p2.add(from);

		        JLabel l17=new JLabel(" TO: ");
		        l17.setFont(new Font("SansSerif",Font.BOLD,18));
		        p2.add(l17);

		        JLabel to=new JLabel(st.getString(12));
		        to.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p2.add(to);

		        JLabel l18=new JLabel(" DOJ: ");
		        l18.setFont(new Font("SansSerif",Font.BOLD,18));
		        p2.add(l18);

		        JLabel date=new JLabel(st.getString(13));
		        date.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p2.add(date);

		        JLabel l20=new JLabel(" FARE: ");
		        l20.setFont(new Font("SansSerif",Font.BOLD,18));
		        p2.add(l20);

		        JLabel fare=new JLabel(st.getString(14));
		        fare.setFont(new Font("SansSerif",Font.PLAIN,18));
		        p2.add(fare);
                
		        JButton bon=new JButton("PRINT");          
                bon.setFont(new Font("SansSerif",Font.BOLD,18));
                bon.setPreferredSize(new Dimension(150,50));
                bon.setForeground(new Color(255, 255, 255));
                bon.setBackground(new Color(0, 0, 0));;

        
            f.setLayout(new GridBagLayout());
            GridBagConstraints gc = new GridBagConstraints();

            p3.setPreferredSize(new Dimension(400,500));
            p1.setPreferredSize(new Dimension(400,500));
            p2.setPreferredSize(new Dimension(400,500));
        	p3.setLayout(new GridBagLayout());
            GridBagConstraints gc1 = new GridBagConstraints();

            String[] snackname = {"Kurkure","Lays","Purified Water","Black bourbon","Hide and Seek","Jim Jam","7up 500ml","Pepsi 500ml","Mirinda 500ml","Coca Cola 500ml"};

            for(int i = 0 ; i<10 ;i++)
            {
                if(st.getString(15+i)!=null)
                {	
                    n++;
                    JLabel label = new JLabel(snackname[i]);
                    label.setFont(new Font("SansSerif",Font.BOLD,18));
                    label.setPreferredSize(new Dimension(150,50));

                    JLabel label2 = new JLabel(String.valueOf(st.getString(15+i)));
                    label2.setFont(new Font("SansSerif",Font.PLAIN,18));
                    gc1.gridx = 0;
                    gc1.gridy = i;
                    gc1.insets = new Insets(0,0,0,30);
                    p3.add(label,gc1);
                    gc1.gridx = 1;
                    gc1.gridy = i;
                    gc1.insets = new Insets(0,0,0,0);
                    p3.add(label2,gc1);
                }
            }

        if(n==0)
        {
            gc.gridx = 1;
            gc.gridy = 0;
            gc.insets = new Insets(0,0,30,0);
            f.add(l,gc);
            gc.gridx = 0;
            gc.gridy = 1;
            gc.insets = new Insets(25,0,0,0);
            f.add(p1,gc);
            gc.gridx = 2;
            gc.gridy = 1;
            gc.insets = new Insets(25,0,0,0);
            f.add(p2,gc);
            gc.gridx = 1;
            gc.gridy = 2;
            gc.insets = new Insets(50,0,0,0);
            f.add(bon,gc);
        }
        else
        {
            gc.gridx = 1;
            gc.gridy = 0;
            gc.insets = new Insets(0,30,30,0);
            f.add(l,gc);
            gc.gridx = 0;
            gc.gridy = 1;
            gc.insets = new Insets(25,0,0,0);
            f.add(p1,gc);
            gc.gridx = 1;
            gc.gridy = 1;
            gc.insets = new Insets(25,80,0,0);
            f.add(p2,gc);
            gc.gridx = 2;
            gc.gridy = 1;
            gc.insets = new Insets(25,0,0,0);
            f.add(p3,gc);
            gc.gridx = 1;
            gc.gridy = 2;
            gc.insets = new Insets(50,0,0,0);
            f.add(bon,gc);
        }
       
        // pheading.setPreferredSize(new Dimension(200,100));
        
        p1.setLayout(new GridLayout(7,2,10,20));
        p2.setLayout(new GridLayout(7,2,10,20));

        Color c= new Color(187, 219, 240);
        p1.setBackground(c);
        p2.setBackground(c);
        p3.setBackground(c);
        f.getContentPane().setBackground(c);
        f.setSize(1536,820);
        f.setVisible(true);

        bon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setJobName("Travel Your Way Bill");
                job.setPrintable(new Printable() 
                {
                    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)throws PrinterException
                    {
                        if (pageIndex >= 1) 
                            {
                                return Printable.NO_SUCH_PAGE;
                            } 
                        else 
                            {
                                ((Graphics2D)graphics).translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                                System.out.println(pageFormat.getImageableX()+" "+pageFormat.getImageableY());
                                ((Graphics2D)graphics).scale(0.3,0.3);
                                f.getContentPane().print(graphics);
                                
                                return Printable.PAGE_EXISTS;
                            }
                        }
                    });
                    try
                    {
                        
                        job.print();
                        JOptionPane.showMessageDialog(f, "Print out is taken successfully! Thank you");
                        
                    }
                    catch (PrinterException ex)
                    {
                        ex.printStackTrace();
                    }

                        f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
                        new FrontPage();
                    } 
                });
            }
            if(hit==-1)
            {
                JOptionPane.showMessageDialog(f,"Invalid Input");
                f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
                new FrontPage();
            }
            System.out.println("#");
        }
        catch(Exception e){
            
        }
    }
    public static void main(String args[])
    {
        new confirmationPage("", "");
    	// String[] arr = {"","","","","","","",""};
    	// Object[][] obj= {};
        // // obj[0][0] = "Miranda 500ml";
        // // obj[1][0] = "Miranda 500ml";
        // // obj[2][0] = "Miranda 500ml";
        // // obj[3][0] = "Miranda 500ml";
        // // obj[4][0] = "Miranda 500ml";
        // // obj[5][0] = "Miranda 500ml";
        // // obj[6][0] = "Miranda 500ml";
        // // obj[7][0] = "Miranda 500ml";
        // // obj[8][0] = "Miranda 500ml";
        // // obj[9][0] = "Miranda 500ml";
        // // obj[0][2] = "10";
        // // obj[1][2] = "10";
        // // obj[2][2] = "10";
        // // obj[3][2] = "10";
        // // obj[4][2] = "10";
        // // obj[5][2] = "10";
        // // obj[6][2] = "10";
        // // obj[7][2] = "10";
        // // obj[8][2] = "10";
        // // obj[9][2] = "10";
    	// new confirmationPage("","","","","","12345",arr,obj,0,"");
    }
}