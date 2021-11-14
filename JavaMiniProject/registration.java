import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class registration {
    registration(String busno,String busname,String from,String to,String time,String type,String seatno,String price,String date)
    {
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
        Border border= BorderFactory.createLineBorder(Color.BLACK, 2);
        SpringLayout layout=new SpringLayout();
        GridBagConstraints gc=new GridBagConstraints();
        gc.insets=new Insets(10,0,0,0);
        GridBagConstraints g=new GridBagConstraints();
        g.insets=new Insets(10,0,0,0);
        GridBagConstraints g1=new GridBagConstraints();
        g1.insets=new Insets(10,0,0,0);
        GridBagConstraints g2=new GridBagConstraints();
        g2.insets=new Insets(15,0,0,0);

        JPanel p1=new JPanel();
        p1.setLayout(new GridBagLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new GridBagLayout());
        JPanel p3=new JPanel();
        p3.setLayout(new GridBagLayout());
        JPanel p4=new JPanel();
        p4.setLayout(new GridBagLayout());
        JPanel p6=new JPanel();
        p6.setLayout(new GridBagLayout());
        JPanel p7=new JPanel();
        p7.setLayout(new GridBagLayout());

        JLabel l=new JLabel("BUS TICKET BOOKING");
        l.setFont(new Font("SansSerif",Font.BOLD,28));       
        f.getContentPane();

        JLabel l3=new JLabel(" PERSONAL DETAILS 📝 ");
        l3.setFont(new Font("SansSerif",Font.BOLD,18));
        l3.setForeground(Color.RED);
        l3.setPreferredSize(new Dimension(250,35));
        gc.gridx=0;
        gc.gridy=0;
        p1.add(l3,gc);

        JLabel l1=new JLabel(" FIRST NAME: ");
        l1.setFont(new Font("SansSerif",Font.BOLD,18));
        l1.setPreferredSize(new Dimension(200,35));
        gc.gridx=0;
        gc.gridy=1;
        p1.add(l1,gc);

        JTextField t1=new JTextField();
        t1.setFont(new Font("SansSerif",Font.BOLD,18));
        t1.setBorder(border);
        t1.setPreferredSize(new Dimension(350,35));
        gc.gridx=1;
        gc.gridy=1;
        p1.add(t1,gc);

        JLabel l2=new JLabel(" LAST NAME: ");
        l2.setFont(new Font("SansSerif",Font.BOLD,18));
        l2.setPreferredSize(new Dimension(200,35));
        gc.gridx=0;
        gc.gridy=2;
        p1.add(l2,gc);

        JTextField t2=new JTextField();
        t2.setFont(new Font("SansSerif",Font.BOLD,18));
        t2.setBorder(border);
        t2.setPreferredSize(new Dimension(350,35));
        gc.gridx=1;
        gc.gridy=2;
        p1.add(t2,gc);
        
        JLabel l11=new JLabel(" GENDER: ");
        l11.setFont(new Font("SansSerif",Font.BOLD,18));
        l11.setPreferredSize(new Dimension(200,35));
        gc.gridx=0;
        gc.gridy=3;
        p1.add(l11,gc);

        JRadioButton r1=new JRadioButton("MALE");
        r1.setActionCommand("Male");
        r1.setFont(new Font("SansSerif",Font.BOLD,18));
       
        JRadioButton r2=new JRadioButton("FEMALE");
        r2.setActionCommand("Female");
        r2.setFont(new Font("SansSerif",Font.BOLD,18));
       
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);bg.add(r2);
        p3.add(r1);p3.add(r2);
        p3.setLayout(new GridLayout(1,2,10,0));
        gc.gridx=1;
        gc.gridy=3;
        p1.add(p3,gc);

        JLabel l4=new JLabel(" AGE: ");
        l4.setFont(new Font("SansSerif",Font.BOLD,18));
        l4.setPreferredSize(new Dimension(200,35));
        gc.gridx=0;
        gc.gridy=4;
        p1.add(l4,gc);

        JTextField t4=new JTextField();
        t4.setFont(new Font("SansSerif",Font.BOLD,18));
        t4.setBorder(border);
        t4.setPreferredSize(new Dimension(350,35));
        gc.gridx=1;
        gc.gridy=4;
        p1.add(t4,gc);

        JLabel l6=new JLabel(" DATE OF BIRTH: ");
        l6.setFont(new Font("SansSerif",Font.BOLD,18));
        l6.setPreferredSize(new Dimension(200,30));
        gc.gridx=0;
        gc.gridy=5;
        p1.add(l6,gc);

        String dates[]=new String[32];
        dates[0]="";
        for(int i=2;i<=32;i++)
        {
            dates[i-1]=String.valueOf(i-1);
        }
        JComboBox<String> cb=new JComboBox<String>(dates);
        cb.setFont(new Font("SansSerif", Font.BOLD, 16));      
        cb.setBorder(border);  
        
        String months[]={" ","JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"} ; 
        JComboBox<String> cb1=new JComboBox<String>(months);    
        cb1.setBorder(border);  
        cb1.setFont(new Font("SansSerif", Font.BOLD, 16));      
        
        String years[]=new String[83];
        years[0]="";
        for(int i=2021,j=0;j<82;i--,j++)
        {
            years[j+1]=String.valueOf(i);
        }
        JComboBox<String> cb2=new JComboBox<String>(years);
        cb2.setBorder(border); 
        cb2.setFont(new Font("SansSerif", Font.BOLD, 16));      
        
        cb.setPreferredSize(new Dimension(70,30));
        
        g1.gridx=0;
        g1.gridy=0;
        p6.add(cb,g1);

        cb1.setPreferredSize(new Dimension(165,30));
        g1.insets=new Insets(10,10,0,0);
        g1.gridx=1;
        g1.gridy=0;
        p6.add(cb1,g1);

        cb2.setPreferredSize(new Dimension(100,30));
        g1.gridx=2;
        g1.gridy=0;
        p6.add(cb2,g1);
        
        gc.gridx=1;
        gc.gridy=5;
        p1.add(p6,gc);

        JLabel l8=new JLabel("");
        l8.setFont(new Font("SansSerif",Font.BOLD,18));
        l8.setPreferredSize(new Dimension(250,35));
        gc.gridx=0;
        gc.gridy=6;
        p1.add(l8,gc);

        JLabel l7=new JLabel(" CONTACT DETAILS 📞📲 ");
        l7.setFont(new Font("SansSerif",Font.BOLD,18));
        l7.setForeground(Color.RED);
        l7.setPreferredSize(new Dimension(250,35));
        gc.gridx=0;
        gc.gridy=7;
        p1.add(l7,gc);

        JLabel l5=new JLabel(" MOBILE NUMBER: ");
        l5.setFont(new Font("SansSerif",Font.BOLD,18));
        l5.setPreferredSize(new Dimension(200,35));
        gc.gridx=0;
        gc.gridy=8;
        p1.add(l5,gc);

        String NUM[]={" ","+91","+62","+98","+964","+93","+243","+506","+53","+357","+4205"} ;        
        final JComboBox<String> n=new JComboBox<String>(NUM);    
        n.setBorder(border);  
        n.setFont(new Font("SansSerif", Font.BOLD, 16));        
        n.setPreferredSize(new Dimension(70,35));
        g.gridx=0;
        g.gridy=0;
        p4.add(n,g);
        JTextField t5=new JTextField();
        t5.setFont(new Font("SansSerif",Font.BOLD,18));
        t5.setBorder(border);
        t5.setPreferredSize(new Dimension(268,35));
        g.insets =new Insets(10,10,0,0);
        g.gridx=1;
        g.gridy=0;
        p4.add(t5,g);
        gc.gridx=1;
        gc.gridy=8;
        p1.add(p4,gc);

        JLabel l12=new JLabel(" E-MAIL: ");
        l12.setFont(new Font("SansSerif",Font.BOLD,18));
        l12.setPreferredSize(new Dimension(200,35));
        gc.gridx=0;
        gc.gridy=9;
        p1.add(l12,gc);

        JTextField t12=new JTextField();
        t12.setFont(new Font("SansSerif",Font.BOLD,18));
        t12.setBorder(border);
        t12.setPreferredSize(new Dimension(350,35));
        gc.gridx=1;
        gc.gridy=9;
        p1.add(t12,gc);
        
        JLabel d2=new JLabel(" BUS DETAILS 🚍");
        d2.setForeground(Color.RED);
        d2.setFont(new Font("SansSerif",Font.BOLD,18));
        d2.setPreferredSize(new Dimension(200,35));
        g2.gridx=0;
        g2.gridy=0;
        p7.add(d2,g2);

        JLabel l13=new JLabel(" BUS Number: ");
        l13.setFont(new Font("SansSerif",Font.BOLD,18));
        l13.setPreferredSize(new Dimension(200,35));
        g2.gridx=0;
        g2.gridy=1;
        p7.add(l13,g2);

        JLabel t13=new JLabel();
        t13.setText(busno);
        t13.setFont(new Font("SansSerif",Font.BOLD,18));
        //t13.setBorder(border);
        t13.setPreferredSize(new Dimension(365,35));
        g2.gridx=1;
        g2.gridy=1;
        p7.add(t13,g2);

        JLabel l14=new JLabel(" SEAT NUMBER: ");
        l14.setFont(new Font("SansSerif",Font.BOLD,18));
        l14.setPreferredSize(new Dimension(200,35));
        g2.gridx=0;
        g2.gridy=2;
        p7.add(l14,g2);

        JLabel t14=new JLabel();
        t14.setText(seatno);
        t14.setFont(new Font("SansSerif",Font.BOLD,18));
        //t14.setBorder(border);
        t14.setPreferredSize(new Dimension(365,35));
        g2.gridx=1;
        g2.gridy=2;
        p7.add(t14,g2);

        JLabel l15=new JLabel(" CLASS: ");
        l15.setFont(new Font("SansSerif",Font.BOLD,18));
        l15.setPreferredSize(new Dimension(200,35));
        g2.gridx=0;
        g2.gridy=3;
        p7.add(l15,g2);

        JLabel t15=new JLabel();
        t15.setText(type);
        t15.setFont(new Font("SansSerif",Font.BOLD,18));
        //t15.setBorder(border);
        t15.setPreferredSize(new Dimension(365,35));
        g2.gridx=1;
        g2.gridy=3;
        p7.add(t15,g2);

        JLabel l16=new JLabel(" FROM: ");
        l16.setFont(new Font("SansSerif",Font.BOLD,18));
        l16.setPreferredSize(new Dimension(200,35));
        g2.gridx=0;
        g2.gridy=4;
        p7.add(l16,g2);

        JLabel t16=new JLabel();
        t16.setText(from);
        t16.setFont(new Font("SansSerif",Font.BOLD,18));
       // t16.setBorder(border);
        t16.setPreferredSize(new Dimension(365,35));
        g2.gridx=1;
        g2.gridy=4;
        p7.add(t16,g2);

        JLabel l17=new JLabel(" TO: ");
        l17.setFont(new Font("SansSerif",Font.BOLD,18));
        l17.setPreferredSize(new Dimension(200,35));
        g2.gridx=0;
        g2.gridy=5;
        p7.add(l17,g2);

        JLabel t17=new JLabel();
        t17.setText(to);
        t17.setFont(new Font("SansSerif",Font.BOLD,18));
        //t17.setBorder(border);
        t17.setPreferredSize(new Dimension(365,35));
        g2.gridx=1;
        g2.gridy=5;
        p7.add(t17,g2);

        JLabel l18=new JLabel(" DATE: ");
        l18.setFont(new Font("SansSerif",Font.BOLD,18));
        l18.setPreferredSize(new Dimension(200,35));
        g2.gridx=0;
        g2.gridy=6;
        p7.add(l18,g2);

        JLabel t18=new JLabel();
        t18.setText(date);
        t18.setFont(new Font("SansSerif",Font.BOLD,18));
        //t18.setBorder(border);
        t18.setPreferredSize(new Dimension(365,35));
        g2.gridx=1;
        g2.gridy=6;
        p7.add(t18,g2);

        JLabel l19=new JLabel(" TIME: ");
        l19.setFont(new Font("SansSerif",Font.BOLD,18));
        l19.setPreferredSize(new Dimension(200,35));
        g2.gridx=0;
        g2.gridy=7;
        p7.add(l19,g2);

        JLabel t19=new JLabel();
        t19.setText(time);
        t19.setFont(new Font("SansSerif",Font.BOLD,18));
        //t19.setBorder(border);
        t19.setPreferredSize(new Dimension(365,35));
        g2.gridx=1;
        g2.gridy=7;
        p7.add(t19,g2);

        JLabel l20=new JLabel(" FARE: ");
        l20.setFont(new Font("SansSerif",Font.BOLD,18));
        l20.setPreferredSize(new Dimension(200,35));
        g2.gridx=0;
        g2.gridy=8;
        p7.add(l20,g2);

        JLabel t20=new JLabel();
        t20.setText(price);
        t20.setFont(new Font("SansSerif",Font.BOLD,18));
        //t20.setBorder(border);
        t20.setPreferredSize(new Dimension(365,35));
        g2.gridx=1;
        g2.gridy=8;
        p7.add(t20,g2);

        JButton bon=new JButton("PROCEED TO PAYMENT");          
        bon.setFont(new Font("SansSerif",Font.BOLD,18));  

        bon.setForeground(new Color(255, 255, 255));
		bon.setBackground(Color.RED);
		
        bon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if(cb.getSelectedIndex()!=0 && cb1.getSelectedIndex()!=0 && cb2.getSelectedIndex()!=0 && n.getSelectedIndex()!=0 && bg.getSelection()!=null && t1.getText().trim().length()!=0 && t2.getText().trim().length()!=0 && isValidAge(t4.getText()) && isValidNumber(t5.getText()) && isValidMail(t12.getText()))
            	{
	                JOptionPane.showMessageDialog(f,"Details entered successfully. Proceeding to Payment Page...","Registration Status",JOptionPane.PLAIN_MESSAGE);
	                f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
	                String value[] = new String[8];
	               	value[0] = t1.getText();
	                value[1] = t2.getText();
	                value[2] = bg.getSelection().getActionCommand();
	                value[3] = t4.getText();
	                String age = dates[cb.getSelectedIndex()]+" "+months[cb1.getSelectedIndex()]+" "+years[cb2.getSelectedIndex()]; 
	                value[4] = age;
	                String number = NUM[n.getSelectedIndex()]+" "+t5.getText();
	                value[5] = number;
	                value[6] = t12.getText();
	                value[7] = seatno;
	                String tablename = busname.substring(0,3)+busno; 
	                new billing(from,to,date,time,price,tablename,value,type);
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(f,"Please Enter valid detail.");
            	}
            }
        });
        f.setLayout(layout);
        f.add(p1);f.add(l);f.add(p7);f.add(bon);

        layout.putConstraint(SpringLayout.WEST,l,625,SpringLayout.WEST,f);
        layout.putConstraint(SpringLayout.NORTH,l,20,SpringLayout.NORTH,f);
        layout.putConstraint(SpringLayout.WEST,p1,100,SpringLayout.WEST,f);
        layout.putConstraint(SpringLayout.NORTH,p1,50,SpringLayout.SOUTH,l);
        layout.putConstraint(SpringLayout.NORTH,p7,50,SpringLayout.SOUTH,l);
        layout.putConstraint(SpringLayout.WEST,p7,950,SpringLayout.WEST,f);
        layout.putConstraint(SpringLayout.WEST,bon,625,SpringLayout.WEST,f);
        layout.putConstraint(SpringLayout.NORTH,bon,650,SpringLayout.NORTH,f);
        f.setSize(1536,820);
        f.setVisible(true); 
    }
    public static boolean isValidMail(String email)
    {
        String emailRegex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        System.out.println("email "+pat.matcher(email).matches()+" "+email);
        return pat.matcher(email).matches();
    }
    public static boolean isValidNumber(String s)
    {
    	Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
        System.out.println("number "+(m.matches()));
        return (m.matches());
    }
    public static boolean isValidAge(String s)
    {
    	Pattern p = Pattern.compile("/100|[1-9]\\d|[1-9]/");
        Matcher m = p.matcher(s);
        System.out.println("age "+m.matches());
        return (m.matches());
    }
    public static void main(String args[])
    {
    	new registration("","","","","","","","","");
    }
}