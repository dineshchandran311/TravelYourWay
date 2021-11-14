import java.awt.*;
import java.awt.event.*;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class Paymentpage {
	String fromV,toV,dateV,timeV,priceV,tablename,type;
	String[] value = new String[8];
	Object[][] snack;
	int k;
    JFrame f;
    Paymentpage(String fromV,String toV,String dateV,String timeV,String priceV,String tablename,String[] value,Object[][] snack,int k,String type)
    {
        System.out.println("Payment HIT");
    	this.fromV = fromV;
		this.toV = toV;
		this.dateV = dateV;
		this.timeV = timeV;
		this.priceV = priceV;
		this.tablename = tablename;
		this.k = k;
		this.type = type;
		for(int i = 0 ; i<8 ; i++)
			this.value[i] = value[i];
		this.snack = snack;
    	System.out.println(tablename);
        Border border= BorderFactory.createLineBorder(Color.BLACK, 1);
        Color c2=new Color(18, 3, 168);
        Font font=new Font("SansSerif",Font.BOLD,18);
        GridBagConstraints gc=new GridBagConstraints();
        SpringLayout layout=new SpringLayout();
        
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

        JLabel confirmation= new JLabel("CONFIRMATION:");
        confirmation.setForeground(Color.RED);
        confirmation.setFont(new Font("SansSerif",Font.BOLD,25));

        JPanel p=new JPanel();
        p.setLayout(new GridBagLayout());
        gc.insets=new Insets(10,0,0,0);

        JLabel bp=new JLabel("Boarding point:");
        bp.setFont(font);
        bp.setPreferredSize(new Dimension(150,30));
        gc.gridx=0;
        gc.gridy=0;
        p.add(bp,gc);

        JLabel bpt=new JLabel();
        bpt.setText(fromV);
        bpt.setFont(font);
        bpt.setPreferredSize(new Dimension(175,30));
        gc.gridx=1;
        gc.gridy=0;
        p.add(bpt,gc);

        JLabel dp=new JLabel("Dropping point:");
        gc.insets=new Insets(10,100,0,0);
        dp.setPreferredSize(new Dimension(150,30));
        dp.setFont(font);
        gc.gridx=2;
        gc.gridy=0;
        p.add(dp,gc);
        gc.insets=new Insets(10,0,0,0);

        JLabel dpt=new JLabel();
        dpt.setText(toV);
        dpt.setPreferredSize(new Dimension(175,30));
        dpt.setFont(font);
        gc.gridx=3;
        gc.gridy=0;
        p.add(dpt,gc);

        JLabel dof=new JLabel("Date of travel:");
        dof.setPreferredSize(new Dimension(150,30));
        dof.setFont(font);
        gc.gridx=0;
        gc.gridy=2;
        p.add(dof,gc);

        JLabel doft=new JLabel();
        doft.setText(dateV);
        doft.setPreferredSize(new Dimension(175,30));
        doft.setFont(font);
        gc.gridx=1;
        gc.gridy=2;
        p.add(doft,gc);

        JLabel time=new JLabel("Departure time:");
        time.setPreferredSize(new Dimension(150,30));
        time.setFont(font);
        gc.insets=new Insets(10,100,0,0);
        gc.gridx=2;
        gc.gridy=2;
        p.add(time,gc);
        gc.insets=new Insets(10,0,0,0);

        JLabel timet=new JLabel();
        timet.setText(timeV);
        timet.setPreferredSize(new Dimension(175,30));
        timet.setFont(font);
        gc.gridx=3;
        gc.gridy=2;
        p.add(timet,gc);

        JPanel p1=new JPanel();
        p1.setLayout(new GridBagLayout());

        JLabel fare=new JLabel("FARE:");
        fare.setPreferredSize(new Dimension(200,30));
        fare.setForeground(c2);
        fare.setFont(new Font("SansSerif",Font.BOLD,20));
        gc.gridx=0;
        gc.gridy=0;
        p1.add(fare,gc);
        

        JLabel tax=new JLabel("Tax(in INR):");
        tax.setPreferredSize(new Dimension(200,30));
        tax.setFont(font);
        gc.gridx=0;
        gc.gridy=1;
        p1.add(tax,gc);

        float taxp = Float.parseFloat(priceV);
        taxp = taxp/100*18;
        String taxp1 = String.valueOf(Math.round(taxp * 100.0) / 100.0);
        JLabel taxt=new JLabel();
        taxt.setText(taxp1);
        taxt.setFont(font);
        taxt.setPreferredSize(new Dimension(80,30));
        gc.gridx=1;
        gc.gridy=1;
        p1.add(taxt,gc);

        JLabel base=new JLabel("Base fare(in INR):");
        base.setFont(font);
        base.setPreferredSize(new Dimension(200,30));
        gc.gridx=0;
        gc.gridy=2;
        p1.add(base,gc);

        JLabel baset=new JLabel();
        baset.setText(priceV);
        baset.setPreferredSize(new Dimension(80,30));
        baset.setFont(font);
        gc.gridx=1;
        gc.gridy=2;
        p1.add(baset,gc);

        JLabel pay=new JLabel("Total Payable:");
        pay.setPreferredSize(new Dimension(200,30));
        pay.setFont(font);
        gc.gridx=0;
        gc.gridy=3;
        p1.add(pay,gc);

        float payment = Float.parseFloat(priceV);
        payment += Float.parseFloat(taxp1);
        JLabel payt=new JLabel();
        payt.setText(Float.toString(payment));
        payt.setFont(font);
        payt.setPreferredSize(new Dimension(80,30));
        gc.gridx=1;
        gc.gridy=3;
        p1.add(payt,gc);

        JLabel paymethod=new JLabel("CHOOSE PAYMENT METHOD");
        paymethod.setFont(new Font("SansSerif",Font.BOLD,25));
        paymethod.setForeground(Color.RED);
        paymethod.setPreferredSize(new Dimension(500,30));

        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(3,1,20,20));

        JRadioButton r1=new JRadioButton("Pay through UPI ID (Amazon / Paytm / PhonePe)");
        r1.setFont(font);

        JRadioButton r2=new JRadioButton("Pay through Credit Card (VISA / RuPay / MasterCard)");
        r2.setFont(font);
 
        JRadioButton r3=new JRadioButton("Pay through Debit Card (VISA / RuPay / MasterCard)");
        r3.setFont(font);

        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);bg.add(r2);bg.add(r3);

        p2.add(r1);p2.add(r2);p2.add(r3);

        JButton submit=new JButton("Submit");
        submit.setPreferredSize(new Dimension(150,30));
        submit.setBackground(Color.GREEN);
        submit.setFont(font);
        submit.setForeground(new Color(255, 255, 255));
		submit.setBackground(new Color(0, 0, 0));
        submit.setVisible(false);

        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int a = JOptionPane.showConfirmDialog(f,"Are you sure about the entered details ?","Confirmation",JOptionPane.YES_NO_OPTION);
                if (a==JOptionPane.YES_OPTION)
                {
                    f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
                    new paymentgif(fromV,toV,dateV,timeV,priceV,tablename,value,snack,k,type);
                }
            }
        });
        
        JPanel one= new JPanel();
        one.setPreferredSize(new Dimension(500,100));
        one.setBackground(Color.LIGHT_GRAY);
        one.setLayout(new GridBagLayout());
        one.setVisible(false);

        JLabel upiid=new JLabel("UPI ID:");
        upiid.setFont(font);
        upiid.setPreferredSize(new Dimension(100,30));
        gc.gridx=0;
        gc.gridy=0;
        one.add(upiid,gc);    

        JTextField upiidt=new JTextField();
        upiidt.setFont(font);
        upiidt.setBorder(border);
        upiidt.setPreferredSize(new Dimension(300,30));
        gc.gridx=1;
        gc.gridy=0;
        one.add(upiidt,gc);

        JPanel two= new JPanel();
        two.setBackground(Color.LIGHT_GRAY);
        two.setPreferredSize(new Dimension(600,200));
        two.setLayout(new GridBagLayout());
        two.setVisible(false);

        JPanel three=new JPanel();
        three.setBackground(Color.LIGHT_GRAY);
        three.setPreferredSize(new Dimension(600,200));
        three.setLayout(new GridBagLayout());
        three.setVisible(false);

        JTextField cardno=new JTextField("CREDIT CARD NUMBER");
        cardno.setPreferredSize(new Dimension(300,30));
        cardno.setBorder(border);
        cardno.addFocusListener(new FocusAdapter()
        {
            public void focusGained(FocusEvent e)
            {
            	if(cardno.getText().equals("CREDIT CARD NUMBER"))
                {
            		cardno.setText("");
                }
            }
        });
        gc.gridx=0;
        gc.gridy=0;
        two.add(cardno,gc);
        
        
        JTextField dcardno=new JTextField("DEBIT CARD NUMBER");
        dcardno.setPreferredSize(new Dimension(300,30));
        dcardno.setBorder(border);
        dcardno.addFocusListener(new FocusAdapter()
        {
            public void focusGained(FocusEvent e)
            {
            	if(dcardno.getText().equals("DEBIT CARD NUMBER"))
            	{
            		dcardno.setText("");
            	}
            }
        });
        gc.gridx=0;
        gc.gridy=0;
        three.add(dcardno,gc);

        JTextField nameoncard=new JTextField("CARD HOLDER'S NAME");
        nameoncard.setPreferredSize(new Dimension(200,30));
        nameoncard.setBorder(border);
        nameoncard.addFocusListener(new FocusAdapter()
        {
            public void focusGained(FocusEvent e)
            {
            	if(nameoncard.getText().equals("CARD HOLDER'S NAME"))
                {
            		nameoncard.setText("");
                }
            }
        });
        gc.insets=new Insets(10,50,0,0);
        gc.gridx=1;
        gc.gridy=0;
        two.add(nameoncard,gc);

        JTextField dnameoncard=new JTextField("CARD HOLDER'S NAME");
        dnameoncard.setBorder(border);
        dnameoncard.setPreferredSize(new Dimension(200,30));
        dnameoncard.addFocusListener(new FocusAdapter()
        {
            public void focusGained(FocusEvent e)
            {
            	if(dnameoncard.getText().equals("CARD HOLDER'S NAME"))
                {
            		dnameoncard.setText("");
                }
            }
        });
        gc.insets=new Insets(10,50,0,0);
        gc.gridx=1;
        gc.gridy=0;
        two.add(dnameoncard,gc);
        three.add(dnameoncard,gc);

        JLabel expiry=new JLabel("EXPIRY DATE");
        expiry.setFont(new Font("SansSerif",Font.PLAIN,16));
        expiry.setPreferredSize(new Dimension(300,30));
        gc.insets=new Insets(10,0,0,0);
        gc.gridx=0;
        gc.gridy=1;
        two.add(expiry,gc);

        JLabel dexpiry=new JLabel("EXPIRY DATE");
        dexpiry.setFont(new Font("SansSerif",Font.PLAIN,16));
        dexpiry.setPreferredSize(new Dimension(300,30));
        gc.insets=new Insets(10,0,0,0);
        gc.gridx=0;
        gc.gridy=1;
        three.add(dexpiry,gc);

        JPanel monyear=new JPanel();
        monyear.setBackground(Color.LIGHT_GRAY);
        monyear.setLayout(new GridLayout(1,2,30,0));
        monyear.setPreferredSize(new Dimension(200,30));

        String months[]=new DateFormatSymbols().getShortMonths();
        JComboBox<String> month=new JComboBox<String>(months);
        month.setFont(font);
        String years[]=new String[7];
        LocalDate now= LocalDate.now();
        for(int i=now.getYear(),j=0;j<7;i++,j++)
        {
            years[j]=String.valueOf(i);
        }
        JComboBox<String> year=new JComboBox<String>(years);
        year.setFont(font);

        monyear.add(month);monyear.add(year);

        gc.gridx=0;
        gc.gridy=2;
        two.add(monyear,gc);

        
        JComboBox<String> dyear=new JComboBox<String>(years);
        dyear.setFont(font);
        JComboBox<String> dmonth=new JComboBox<String>(months);
        dmonth.setFont(font);
       
        JPanel dmonyear=new JPanel();
        dmonyear.setBackground(Color.LIGHT_GRAY);
        dmonyear.setLayout(new GridLayout(1,2,30,0));
        dmonyear.setPreferredSize(new Dimension(200,30));
        dmonyear.add(dmonth);dmonyear.add(dyear);

        gc.gridx=0;
        gc.gridy=2;
        three.add(dmonyear,gc);

        JTextField cvv = new JTextField("CVV NUMBER");
        cvv.setPreferredSize(new Dimension(200,30));
        cvv.addFocusListener(new FocusAdapter()
        {
            public void focusGained(FocusEvent e)
            {
            	if(cvv.getText().equals("CVV NUMBER"))
            	{
            		cvv.setText("");
            	}
            }
        });
        cvv.setBorder(border);
        gc.gridx=1;
        gc.gridy=2;
        two.add(cvv,gc);

        JTextField dcvv = new JTextField("CVV NUMBER");
        dcvv.setPreferredSize(new Dimension(200,30));
        dcvv.setBorder(border);
        dcvv.addFocusListener(new FocusAdapter()
        {
            public void focusGained(FocusEvent e)
            {
            	if(dcvv.getText().equals("CVV NUMBER"))
                {
            		dcvv.setText("");
                }
            }
        });
        gc.gridx=1;
        gc.gridy=2;
        three.add(dcvv,gc);

        JCheckBox save=new JCheckBox("Save your card for future");
        save.setBackground(Color.LIGHT_GRAY);
        save.setFont(new Font("SansSerif",Font.PLAIN,14));
        save.setPreferredSize(new Dimension(300,30));
        gc.gridx=0;
        gc.gridy=3;
        two.add(save,gc);

        JCheckBox dsave=new JCheckBox("Save your card for future");
        dsave.setBackground(Color.LIGHT_GRAY);
        dsave.setFont(new Font("SansSerif",Font.PLAIN,14));
        dsave.setPreferredSize(new Dimension(300,30));
        gc.gridx=0;
        gc.gridy=3;
        three.add(dsave,gc);

        JButton b=new JButton("Proceed for payment");
        b.setFont(font);
        b.setBackground(Color.GREEN);
        b.setForeground(Color.WHITE);
        b.setPreferredSize(new Dimension(250,30));

        b.setForeground(new Color(255, 255, 255));
		b.setBackground(new Color(0, 0, 0));
        
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(r1.isSelected())
                {
                    two.setVisible(false);
                    three.setVisible(false);
                    one.setVisible(true);                 
                    submit.setVisible(true);
                }               
                if(r2.isSelected())
                {
                    one.setVisible(false);
                    three.setVisible(false);
                    two.setVisible(true);                    
                    submit.setVisible(true);
                }
                if(r3.isSelected())
                {
                    two.setVisible(false);
                    one.setVisible(false);
                    three.setVisible(true);                    
                    submit.setVisible(true);
                }
            }           
        });
                
        layout.putConstraint(SpringLayout.WEST,confirmation,50,SpringLayout.WEST,f);
        layout.putConstraint(SpringLayout.NORTH,confirmation,50,SpringLayout.NORTH,f);
        layout.putConstraint(SpringLayout.WEST,p,100,SpringLayout.WEST,f);
        layout.putConstraint(SpringLayout.NORTH,p,20,SpringLayout.SOUTH,confirmation);
        layout.putConstraint(SpringLayout.WEST,p1,100,SpringLayout.WEST,f);
        layout.putConstraint(SpringLayout.NORTH,p1,20,SpringLayout.SOUTH,p);
        layout.putConstraint(SpringLayout.WEST,paymethod,50,SpringLayout.WEST,f);
        layout.putConstraint(SpringLayout.NORTH,paymethod,30,SpringLayout.SOUTH,p1);
        layout.putConstraint(SpringLayout.WEST,p2,100,SpringLayout.WEST,f);
        layout.putConstraint(SpringLayout.NORTH,p2,20,SpringLayout.SOUTH,paymethod);
        layout.putConstraint(SpringLayout.WEST,b,100,SpringLayout.WEST,f);
        layout.putConstraint(SpringLayout.NORTH,b,50,SpringLayout.SOUTH,p2);
        layout.putConstraint(SpringLayout.WEST,one,800,SpringLayout.WEST,p2);
        layout.putConstraint(SpringLayout.NORTH,one,50,SpringLayout.SOUTH,p1);
        layout.putConstraint(SpringLayout.WEST,two,800,SpringLayout.WEST,p2);
        layout.putConstraint(SpringLayout.NORTH,two,50,SpringLayout.SOUTH,p1);
        layout.putConstraint(SpringLayout.WEST,three,800,SpringLayout.WEST,p2);
        layout.putConstraint(SpringLayout.NORTH,three,50,SpringLayout.SOUTH,p1);
        layout.putConstraint(SpringLayout.WEST,submit,1030,SpringLayout.WEST,p2);
        layout.putConstraint(SpringLayout.NORTH,submit,50,SpringLayout.SOUTH,p2);

        f.add(confirmation);
        f.add(p);
        f.add(p1);
        f.add(paymethod);
        f.add(p2);
        f.add(b);
        f.add(one);f.add(two);f.add(three);
        f.add(submit);
        f.setLayout(layout);
        f.setVisible(true);
        f.setSize(1536,820);
    }


    
    public static void main(String[] args)
    {
    	String[] arr = {};
    	Object[][] obj= {};
    	new Paymentpage("","","","","","",arr,obj,0,"");
    }
}